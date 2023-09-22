package Busreservation;

import java.util.ArrayList;
import java.util.Scanner;

public class bus_main {
    public static void main (String args[])  {
        Scanner object=new Scanner(System.in);
        ArrayList<booking>Booking=new ArrayList<>();
        ArrayList<buscap>Buses=new ArrayList<>();

        int capacity=2;
        boolean ac=true;
        int booked=0;
        Buses.add(new buscap(1,capacity,ac));
        Buses.add(new buscap(2,4,true));
        Buses.add(new buscap(3,4,true));

        boolean loop=true;
        while(loop){
            System.out.print("Enter 1 to book,2 to Cancel,0 to end : ");
            int n= object.nextInt();
            System.out.print("\n");
            if(n==1){
                booking boking=new booking();
                boking.dbooking();
                if(boking.isAvailable(Booking,Buses)){
                    Booking.add(boking);
                    System.out.println("                              Passenger details"                        );
                    System.out.println("  Name : "+ boking.passenger);
                    System.out.println("  Age : "+ boking.age);
                    System.out.println("  Bus No : "+ boking.busno);
                    System.out.println("  From : "+ boking.from + " To : "+ boking.to);
                    System.out.println("  Ticket status : Confrimed");
                    System.out.println("  Happy journey ! ");
                    System.out.print("\n");
                    booked++;
                    capacity=capacity-booked;
                }
                else{
                    System.out.print("\n");
                    System.err.println("Sorry There is no seat available,please try another bus or different date");
                    System.out.print("\n");
                }
                loop=true;
            }
            else if (n==2) {
                Cancellation cancel=new Cancellation();
                if(cancel.cancellation(Booking,Buses)){
                    Booking.remove(cancel);
                    System.out.println("                              Cancellation details"                        );
                    System.out.println("  Name : "+cancel .name);
                    System.out.println("  Age : "+ cancel.age);
                    System.out.println("  Bus No : "+ cancel.busn);
                    System.out.println("  From : "+ cancel.from + " To : "+ cancel.to);
                    System.out.println("  Ticket status : Cancelled");
                    System.out.println();
                    booked--;
                    capacity=capacity+1;
                }
                else{
                    System.err.println("Invalid details try agin");
                }

            }
            else if (n==0){
                loop=false;
                System.out.print("Thank you.");
            }
            else{
                System.out.println("Invalid input,try again");
                System.out.println();
            }
        }
    }
}
