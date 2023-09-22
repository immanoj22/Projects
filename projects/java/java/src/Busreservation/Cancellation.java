package Busreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cancellation {
    String name;
    int age;
    Date date;
    int busn;
    String from;
    String to;
    Cancellation(){

        Scanner object = new Scanner(System.in);
        System.out.print("Enter your name : ");
        name=object.next();
        System.out.println();
        System.out.print("Enter your age : ");
        age= object.nextInt();
        System.out.println();
        System.out.print("From : ");
        from=object.next();
        System.out.println();
        System.out.print("To : ");
        to=object.next();
        System.out.println();
        System.out.print("Enter the bus number : ");
        busn= object.nextInt();
        System.out.println();
        System.out.print("Enter the date of your ticket booked(dd/MM/YYYY) : ");
        String datt=object.next();
        SimpleDateFormat dc=new SimpleDateFormat("dd/MM/yyyy");
        try {
            date=dc.parse(datt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

    }
    public boolean cancellation(ArrayList<booking> Booking,ArrayList<buscap>Buses){

        boolean val=false;
        for(booking bok:Booking){
            if(bok.busno==busn && bok.passenger.equals(name)  && bok.age==this.age && bok.from.equals(from) && bok.to.equals(to)){
                if(bok.date.compareTo(date)==0){
                    val=true;
                }
            }
        }
        if(val){
            for(buscap bus:Buses){
                if(bus.getBusnumber()==busn){
                    bus.buscapacity++;
                }
            }
        }
        return val;

    }
}
