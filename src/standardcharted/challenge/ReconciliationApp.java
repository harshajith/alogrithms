package standardcharted.challenge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Basic assumption : AccountId is unique per transaction.
 */
public class ReconciliationApp {

    private List<Transaction> xRecords = new ArrayList<Transaction>();

    private List<Transaction> yRecords = new ArrayList<Transaction>();

    private Map<String, Map<Date, Map<Double, LinkedList<Transaction>>>> parsedYTransactions = new LinkedHashMap<>();

    private Set<String> matchingYTransactionIds = new HashSet<String>();

    private Set<String> allYTransactionIds = new HashSet<>();

    private StringJoiner exactMatches = new StringJoiner(", ");

    private StringJoiner weakMatches = new StringJoiner(", ");

    private StringJoiner xBreaks = new StringJoiner(", ");


    /**
     * Read transactions from both file x and y. and parsed y file into Map.
     * This method runs in total O(n) for sufficiently large n.
     */
    public void reconcile(String[] args){

        FileReader fileReader = new FileReader();
        xRecords = fileReader.readFileX(args);
        yRecords = fileReader.readFileY(args);

        populateTransactionMap(yRecords); // O(n)

        xRecords.stream().forEach(  // O(n)
            currentXTransaction -> {
                String accountId = currentXTransaction.getAccountId();
                Date postingDate = currentXTransaction.getPostingDate();
                List<Date> validPreviousDates = DateTimeHelper.getValidPreviousDates(postingDate);
                List<Date> validNextDates = DateTimeHelper.getValidNextDates(postingDate);
                Double amount = currentXTransaction.getAmount();

                Map<Date, Map<Double, LinkedList<Transaction>>> dateTxMap = parsedYTransactions.get(accountId); // match AccountId : O(1)
                if(dateTxMap != null){
                    Map<Double, LinkedList<Transaction>> amountTxMap = dateTxMap.get(postingDate); // match date : O(1)
                    if(amountTxMap != null){
                        boolean matchingBranch = true;
                        findMatches(currentXTransaction, amountTxMap, amount, matchingBranch);
                    }else {
                        boolean matchingBranch = false;
                        validPreviousDates.stream().forEach(previousDate -> {
                            Map<Double, LinkedList<Transaction>> amountTxMap1 = dateTxMap.get(previousDate);
                            findMatches(currentXTransaction, amountTxMap1, amount, matchingBranch);
                        });

                        validNextDates.stream().forEach(nextDate -> {
                            Map<Double, LinkedList<Transaction>> amountTxMap1 = dateTxMap.get(nextDate);
                            findMatches(currentXTransaction, amountTxMap1, amount, matchingBranch);
                        });
                    }
                }else {
                    xBreaks.add(currentXTransaction.getTransactionId());
                }
        });

        System.out.println("# XY exact matches \n" + exactMatches.toString());
        System.out.println("\n");
        System.out.println("# XY weak matches \n" + weakMatches.toString());
        System.out.println("\n");
        System.out.println("# X breaks \n" + xBreaks.toString());
        System.out.println("\n");

        allYTransactionIds.removeAll(matchingYTransactionIds); // O(n) in the worst case. as we operate on HashSet internally this is doing containsKey(matchingTransactions) and then remove(i) both are O(1) in the set.
        if(!allYTransactionIds.isEmpty()){
            String yBreaks = allYTransactionIds.stream().map(
                    i -> i.toString()).collect(Collectors.joining(", "));

            System.out.println("# Y breaks \n" + yBreaks);
        }
    }


    /**
     * This runs in O(1) time
     * @param currentXTransaction
     * @param amountTxMap
     * @param amount
     * @param matchingBranch
     */
    private void findMatches(Transaction currentXTransaction, Map<Double, LinkedList<Transaction>> amountTxMap, Double amount, boolean matchingBranch){
        Double validLowerAmount = amount - 0.01;
        Double validUpperAmount = amount + 0.01;
        if(amountTxMap != null){
            LinkedList<Transaction> txs = amountTxMap.get(amount); // match amount : O(1)
            if(txs != null && !txs.isEmpty()){ // O(1)
                Transaction matchingTxn =  txs.removeFirst(); // O(1)
                if(matchingBranch){ // exact match found
                    exactMatches.add(currentXTransaction.getTransactionId() + matchingTxn.getTransactionId());
                }else {
                    weakMatches.add(currentXTransaction.getTransactionId() + matchingTxn.getTransactionId());
                }
                matchingYTransactionIds.add(matchingTxn.getTransactionId());
            }else {
                boolean matchFound = false;
                LinkedList<Transaction> weakLowerMatches = amountTxMap.get(validLowerAmount); // O(1)
                if(weakLowerMatches != null && !weakLowerMatches.isEmpty()){ // O(1)
                    Transaction matchingTxn =  weakLowerMatches.removeFirst();
                    weakMatches.add(currentXTransaction.getTransactionId() + matchingTxn.getTransactionId());
                    matchingYTransactionIds.add(matchingTxn.getTransactionId());
                    matchFound = true;
                } else {
                    LinkedList<Transaction> weakUpperMatches = amountTxMap.get(validUpperAmount); // O(1)
                    if(weakUpperMatches != null && !weakUpperMatches.isEmpty()){ // O(1)
                        Transaction matchingTxn =  weakUpperMatches.removeFirst();
                        weakMatches.add(currentXTransaction.getTransactionId() + matchingTxn.getTransactionId());
                        matchingYTransactionIds.add(matchingTxn.getTransactionId());
                        matchFound = true;
                    }
                }
                if(!matchFound){
                    xBreaks.add(currentXTransaction.getTransactionId());
                }
            }
        }
    }


    /**
     * Create the master map of Y transactions to ease
     * the matches in O(1) time.
     * @param yList
     */
    private void populateTransactionMap(List<Transaction> yList){

        parsedYTransactions = new LinkedHashMap<>();
        yList.stream().forEach(
            transaction->{
                String accountId = transaction.getAccountId();
                Date date = transaction.getPostingDate();
                Double amount = transaction.getAmount();
                allYTransactionIds.add(transaction.getTransactionId()); // O(1)

                if(parsedYTransactions.get(accountId) != null) { // this accountId already exists in the map

                    Map<Date, Map<Double, LinkedList<Transaction>>> dateTransactionMap = parsedYTransactions.get(accountId);
                    if(dateTransactionMap.get(date) != null){ // same date exists in the dateTxMap

                        Map<Double, LinkedList<Transaction>> amountTransactionMap =  dateTransactionMap.get(date); // get amountTxMap
                        if(amountTransactionMap.get(amount) != null){ // same amount present in the amountTxMap
                            amountTransactionMap.get(amount).add(transaction);
                        }else { // same amount is not present in the amountTxMap
                            LinkedList<Transaction> txList = new LinkedList<Transaction>();
                            txList.add(transaction);
                            amountTransactionMap.put(amount, txList);
                        }

                    }else { // same date does not exist
                        Map<Double, LinkedList<Transaction>> amountTransactionMap = new LinkedHashMap<Double, LinkedList<Transaction>>(); // amount-transaction
                        LinkedList<Transaction> txList = new LinkedList<Transaction>();
                        txList.add(transaction);
                        amountTransactionMap.put(amount, txList);
                        dateTransactionMap.put(date, amountTransactionMap);
                    }

                }else { // same AccountId is not present in the map, fresh record from y file.

                    Map<Double, LinkedList<Transaction>> amountTransactionMap = new LinkedHashMap<Double, LinkedList<Transaction>>(); // amount-transaction
                    LinkedList<Transaction> txList = new LinkedList<Transaction>();
                    txList.add(transaction);
                    amountTransactionMap.put(amount, txList);

                    Map<Date, Map<Double, LinkedList<Transaction>>> dateTransactionMap = new LinkedHashMap<Date, Map<Double, LinkedList<Transaction>>>();
                    dateTransactionMap.put(date, amountTransactionMap);

                    parsedYTransactions.put(accountId, dateTransactionMap);
                }
        });

    }


    public static void main(String[] args) {
        ReconciliationApp reconciliationApp = new ReconciliationApp();
        reconciliationApp.reconcile(args);
        System.out.println("Completed !");
    }


}
