import java.util.TreeMap;

/**
 * Created by Harsha on 1/10/16.
 */
public class DroneDelivery {


    public static class LinkedListNode {
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value){
            val = node_value;
            next = null;
        }
    }

    public static LinkedListNode insert_node_into_singlylinkedList(LinkedListNode head, String val){
        if(head == null){
            head = new LinkedListNode(val);
        } else {
            LinkedListNode end = head; // insert the value at the end
            while (end.next != null){
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }


    public static LinkedListNode updateRoute(LinkedListNode head, String[] citiesToSkip){

        if(head == null){
            return null;
        }

        TreeMap<String, String> skipCities = new TreeMap<String, String>();
        for(int i=0 ; i< citiesToSkip.length ; i++){
            skipCities.put(citiesToSkip[i], citiesToSkip[i]);
        }

        LinkedListNode current = head;
        LinkedListNode previous = null;

        while(current != null){
            String val = current.val;
            System.out.println("val : " + val);

            if(!skipCities.containsKey(val)){
                previous = insert_node_into_singlylinkedList(previous, val);
            }
            current = current.next;
        }
        return previous;

    }


    public static LinkedListNode updateRoute1(LinkedListNode head, String[] citiesToSkip){

        if(head == null){
            return null;
        }

        TreeMap<String, String> skipCities = new TreeMap<String, String>();
        for(int i=0 ; i< citiesToSkip.length ; i++){
            skipCities.put(citiesToSkip[i], citiesToSkip[i]);
        }

        System.out.println(skipCities.toString());

        LinkedListNode current = head;

        while(current != null){
            String val = current.val;
            System.out.println("val : " + val);

            if(skipCities.containsKey(val)) {
                if(current.next != null){
                    current.val = current.next.val;
                    current.next = current.next.next;
                    continue;
                }
            }
            current = current.next;
        }
        return head;

    }


//    public static LinkedListNode updateRoute4(LinkedListNode head, String[] citiesToSkip){
//
//        if(head == null){
//            return null;
//        }
//
//        TreeMap<String, String> skipCities = new TreeMap<String, String>();
//        for(int i=0 ; i< citiesToSkip.length ; i++){
//            skipCities.put(citiesToSkip[i], citiesToSkip[i]);
//        }
//
//        System.out.println(skipCities.toString());
//
//        LinkedListNode current = head;
//        LinkedListNode previous = null;
//
//        while(current != null){
//            String val = current.val;
//            System.out.println("val : " + val);
//
//            if(skipCities.containsKey(val)) {
//                if(current.next != null){
//                    current.val = current.next.val;
//                    current.next = current.next.next;
//                    previous = current;
//                    continue;
//                }else {
//                    previous.next = null;
//                    current = null;
//                    continue;
//                }
//            }
//            if(current != null)
//                previous = current;
//                current = current.next;
//        }
//        return head;
//
//    }


    public static void main(String[] args){

        LinkedListNode allCities = new LinkedListNode("Seattle");
        allCities = insert_node_into_singlylinkedList(allCities, "Tacoma");
        allCities = insert_node_into_singlylinkedList(allCities, "Portland");
        allCities = insert_node_into_singlylinkedList(allCities, "Los Angeles");
        allCities = insert_node_into_singlylinkedList(allCities, "Dallas");
        allCities = insert_node_into_singlylinkedList(allCities, "Austin");

        String[] citiesToSkip = {"Seattle", "Portland", "Los Angeles", "Austin", "Dallas"};

        LinkedListNode updatedRoute = updateRoute1(allCities,citiesToSkip);

        LinkedListNode current = updatedRoute;

        while(current != null){
            System.out.println("result: " + current.val);
            current = current.next;
        }



    }

}
