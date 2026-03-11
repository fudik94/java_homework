package challenge1;

import java.util.Scanner;

public class EstonianId {

//Write a program, which takes in a String variable with an Estonian ID code and tells a user,
//if this ID code is correct or not. Can make it a method, if you feel comfortable doing so.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean valid = false; // переменная для повторного ввода

        while (!valid) {





            System.out.println("Enter Estonian ID code : ");

            String idCode = scanner.nextLine();

            System.out.println("You entered :"+ idCode);
            System.out.println("Checking your code in three steps: : ");

            //we are checking 11 dig
            int idLen = idCode.length();
            if (idLen == 11) {
                System.out.println("1st step ok");
            } else {
                System.out.println("1st step ERROR! Estonian id code must be 11 digits!");
                continue; // повторяем ввод
            }

            //we are checking all characters is numbers
            boolean allDigits = true;

            for (int i = 0; i < idCode.length(); i++) {

                if (!Character.isDigit(idCode.charAt(i))) {
                    allDigits = false;
                    break;
                }
            }

            if (allDigits) {
                System.out.println("2st step ok");
            } else {
                System.out.println("2st step ERROR! Estonian id code must contain only digits!");
                continue; // повторяем ввод
            }

            //we are checking control numbers
            //we make dig to massiv
            int[] digits = new int[11];
            for (int i = 0; i < 11; i++) {
                digits[i] = idCode.charAt(i) - '0';
            }

            //first checking loop
            int[] weights1 = {1,2,3,4,5,6,7,8,9,1};
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += digits[i] * weights1[i];
            }
            int remainder = sum % 11;

            //if % equal 10 we make second checking
            if (remainder == 10) {
                int[] weights2 = {3,4,5,6,7,8,9,1,2,3};
                sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += digits[i] * weights2[i];
                }
                remainder = sum % 11;
                if (remainder == 10) {
                    remainder = 0;
                }
            }

            //compore result with our number
            if (remainder == digits[10]) {
                System.out.println("3st step ok");
            } else {
                System.out.println("3st step ERROR! Estonian id code is NOT valid!");
                continue; // повторяем ввод
            }

            //if all 3 steps grad we print this message
            valid = true;
            System.out.println("All checks passed! Your Estonian id code is valid.");





        }

        scanner.close();







    }
}
