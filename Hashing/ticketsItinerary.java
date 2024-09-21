import java.util.*;
public class ticketsItinerary {

    public static String getStart(HashMap<String,String>tickets){
        HashMap<String,String>revHashMap=new HashMap<>();
        for (String ticket : tickets.keySet()) {
            revHashMap.put(tickets.get(ticket), ticket);
        }

        for (String ticket : tickets.keySet()) {
            if(!revHashMap.containsKey(ticket)){
                return ticket;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String>tickets=new HashMap<>();
        tickets.put("Chennai", "Bangaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start=getStart(tickets);
        System.out.print(start);
        for (String ticket : tickets.keySet()) {
            System.out.print("->"+tickets.get(start));
            start=tickets.get(start);
        }

    }
}
