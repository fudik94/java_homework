package challenge3;

public class PhoneticAlphabet {

    public static void main(String[] args) {

        char letter = 'C';

        switch (letter) {

            case 'A':
                System.out.println("A = Alfa");
                break;

            case 'B':
                System.out.println("B = Bravo");
                break;

            case 'C':
                System.out.println("C = Charlie");
                break;

            case 'D':
                System.out.println("D = Delta");
                break;

            case 'E':
                System.out.println("E = Echo");
                break;

            default:
                System.out.println(letter + " not found");
        }
    }
}