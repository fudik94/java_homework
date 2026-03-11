package challenge1;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args){

//Write a program, which takes in an int variable with a year and tells a user if it’s a
//leap year or not. Can make it a method, if you feel comfortable doing so.
//You may find the full leap year calculation algorithm on this Wikipedia page:
//https://en.wikipedia.org/wiki/Leap_year

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter a year : ");
        int year = userInput.nextInt();
        userInput.close();

        System.out.println("Your year : "+ year);

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a leap year");
                } else {
                    System.out.println(year + " is NOT a leap year");
                }
            } else {
                System.out.println(year + " is a leap year");
            }
        } else {
            System.out.println(year + " is NOT a leap year");
        }













    }
}
