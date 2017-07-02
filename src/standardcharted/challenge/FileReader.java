package standardcharted.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Harsha on 8/5/17.
 */
public class FileReader {

    public List<Transaction> readFileX(String[] args){
        String xFilePath;
        if(args.length > 0){
            xFilePath = args[0];
        }else {
            System.out.println("No arguments given, reading from the current location : ../x.txt");
            xFilePath = "./x.txt";  // Assume the file is in current directory if no argument given.
        }

        return populateTransactions(xFilePath);

    }


    public List<Transaction> readFileY(String[] args){
        String yFilePath; // Assume the file is in current directory
        if(args.length > 1){
            yFilePath = args[1];
        }else {
            yFilePath = "./y.txt";
        }
        return populateTransactions(yFilePath);
    }



    private List<Transaction> populateTransactions(String filePath){
        List<Transaction> transactions = new ArrayList<Transaction>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            transactions = lines.map(
               line -> {
                    String[] tmpArray = line.split(";");
                    return populateTransaction(tmpArray);
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }



    private Transaction populateTransaction(String[] fileDataArray) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(fileDataArray[0].trim());
        transaction.setAccountId(fileDataArray[1].trim());
        transaction.setPostingDate(DateTimeHelper.convertStringToDate(fileDataArray[2]));
        transaction.setAmount(Double.valueOf(fileDataArray[3]));

        return transaction;

    }



}
