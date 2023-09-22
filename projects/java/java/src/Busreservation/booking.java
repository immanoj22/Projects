package Busreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class booking {
    String passenger;

    int age;
    Date date;
    String from;
    String to;
    int busno;
    int booked = 0;

    public void dbooking() {
        Scanner object = new Scanner(System.in);
        System.out.print("Enter your name : ");
        passenger = object.next();
        System.out.print("\n");

        //age
        System.out.print("Enter your age : ");
        age = object.nextInt();
        System.out.print("\n");

        //from
        System.out.print("From : ");
        from = object.next();
        System.out.print("\n");
        //to
        System.out.print("To : ");
        to = object.next();
        System.out.print("\n");

        //date
        System.out.print("Enter the date of the journey : (dd/mm/yyyy) ");
        String dat = object.next();
        SimpleDateFormat sc = new SimpleDateFormat("dd/MM/yyyy");
        boolean val = false;
        try {
            date = sc.parse(dat);
        } catch (ParseException e) {
            System.err.print("in valid input please try again : ");
            val = true;
            while (val) {
                dat = object.next();
                try {
                    date = sc.parse(dat);
                    val = false;
                } catch (ParseException f) {
                    System.err.print("in valid input please try again : ");
                    val = true;
                }
            }
        }
        System.out.print("\n");

        //busno
        System.out.print("Enter the bus number : ");
        busno = object.nextInt();
        System.out.print("\n");
    }

    public boolean isAvailable(ArrayList<booking> Booking, ArrayList<buscap> Buses) {
        int capacity = 0;
        for (buscap bus : Buses) {
            if (bus.getBusnumber() == busno) {
                capacity = bus.getBuscapacity();
            }
        }


        for (booking reserve : Booking) {
            if (reserve.busno == busno && reserve.date.equals(date)) {

                booked++;
            }
        }
        return capacity > booked ? true : false;
    }


}
