import java.util.*;
public class Flight {
    static int id=0;
    int FlightID;
    int price;
    int tickets;
    ArrayList<String> PassengerDetails;
    ArrayList<Integer> PassengerIDs;
    ArrayList<Integer> BookedTicketsPerPassenger;
    ArrayList<Integer> PassengerCost;

    public Flight(){

        this.price=5000;
        this.tickets=50;
        id=id+1;
        FlightID=id;
        PassengerDetails=new ArrayList<String>();
        PassengerIDs=new ArrayList<Integer>();
        BookedTicketsPerPassenger=new ArrayList<Integer>();
        PassengerCost=new ArrayList<Integer>();


    }
      void addPassengerDetails(String PassengerDetail,int numOfTicket,int passengerID){
        PassengerDetails.add(PassengerDetail);
        PassengerIDs.add(passengerID);
        PassengerCost.add(price*numOfTicket);
        BookedTicketsPerPassenger.add(numOfTicket);
        price+=200*numOfTicket;
        tickets-=numOfTicket;
        System.out.print("Booked Successfully");


    }
      void cancelTicket(int PassengerID){
        int indextoremove=PassengerIDs.indexOf(PassengerID);

        if(indextoremove<0){
            System.out.println("PASSENGER ID NOT FOUND");
            return;

        }
        int TicketsToCancel=BookedTicketsPerPassenger.get(indextoremove);
        tickets+=TicketsToCancel;
        price-=200*TicketsToCancel;

        System.out.println("REFUND AMOUNT"+PassengerCost.get(indextoremove));

        PassengerDetails.remove(indextoremove);
        PassengerIDs.remove(Integer.valueOf(PassengerID));
        PassengerCost.remove(indextoremove);
        BookedTicketsPerPassenger.remove(indextoremove);

        System.out.print("CANCELLED TICKETS SUCCESSFULLY");

    }

    public void printsummary(){
        System.out.println("FLIGHT ID :"+FlightID+" REMAINING TICKETS TO BE BOOKED :  "+ tickets+"PRICE OF THE TICKET:  "+price);
    }
    public  void printdetails(){
        System.out.print("Flight ID:  "+FlightID+"->");
        for(String d:PassengerDetails){
            System.out.println(d);
        }
    }

}
