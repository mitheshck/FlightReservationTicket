import java.util.*;
public class BookTicket {
    public static void book(Flight currentflight, int ticket, int passengerID) {

        String PassengerDetails = "";
        PassengerDetails = "PASSENGER ID :" + passengerID + "  " + " NUMBER OF TICKETS BOOKED :" + ticket + "COST OF TICKETS :" + currentflight.price * ticket;

        currentflight.addPassengerDetails(PassengerDetails,ticket,passengerID);

        currentflight.printsummary();
        currentflight.printdetails();


    }

    public static void cancel(Flight currentflight, int pasID) {
        currentflight.cancelTicket(pasID);
        currentflight.printsummary();
        currentflight.printdetails();

    }

    public static void print(Flight f) {
        f.printdetails();
    }


    public static void main(String[] args) {

        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < 2; i++) {
            flights.add(new Flight());
        }
        int PassengerID = 1;

        while (true) {
            System.out.println("1.BOOK   2.CANCEL   3.PRINT");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice > 3) {
                System.out.println("Invalid Choice");
                break;
            }
            switch (choice)
            {
                case 1: {
                    System.out.println("Enter the FlightID to book");
                    int fID = sc.nextInt();

                    if (fID > flights.size()) {
                        System.out.println("INVALID FLIGHT ID");
                        break;
                    }
                    Flight currentflight = null;

                    for (Flight f : flights) {
                        if (f.FlightID == fID) {
                            currentflight = f;
                            f.printsummary();
                            break;

                        }
                    }

                    System.out.println("ENTER THE NUMBERS OF TICKETS TO BOOK");
                    int tic = sc.nextInt();

                    if (tic > currentflight.tickets) {
                        System.out.println("NOT ENOUGH TICKETS TO BOOK");
                        break;
                    }
                    book(currentflight, tic, PassengerID);


                    PassengerID = PassengerID + 1;
                    break;
                }
                //cancel
                case 2: {
                    System.out.print("ENter the Flight ID to cancel:");
                    int fid = sc.nextInt();
                    if (fid > flights.size()) {
                        System.out.print("INVALID FLIGHT ID ");
                        break;
                    }
                    Flight currentflight = null;
                    for (Flight f : flights) {
                        if (f.FlightID == fid) {
                            currentflight = f;


                        }
                    }
                    int pasID = sc.nextInt();
                    cancel(currentflight, pasID);
                    break;
                }
                case 3: {

                    for (Flight f : flights) {

                        if (f.PassengerDetails.size() == 0) {
                            System.out.println("NO PASSENGER DETAILS FOR FLIGHT :" + f.FlightID);
                        } else {
                            print(f);
                        }
                    }
                }
                default: {
                    break;
                }
            }
        }
    }
}





















