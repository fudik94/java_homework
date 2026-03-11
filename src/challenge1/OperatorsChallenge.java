package challenge1;

public class OperatorsChallenge {
    public static void main(String[] args){

        //Step 1: create a double variable with a value of 20.00.
        //Step 2: create a second variable of type double with a value 80.00.

        double firstVer = 20.00;
        double secondVer = 80.00;

        System.out.println(" Step 1 : "+ firstVer);
        System.out.println(" Step 2 : "+ secondVer);

        //Step 3:  add both numbers together, then multiply by 100.00.

        double firstResult = ( firstVer + secondVer )* 100;

        System.out.println(" Step 3 : "+ firstResult);

        //Step 4: use the remainder operator, to figure out what the remainder from the result of
        //the operation in step three, and 40.00, will be.

        double secondResult = firstResult % 40.00;

        System.out.println(" Step 4 : "+ secondResult);

        //Step 5: create a boolean variable that assigns the value true, if the remainder in step
        //four is 0.00, or false if it's not zero.

        boolean booVer = secondResult == 0;

        //Step 6: output the boolean variable just to see what the result is.

        System.out.println(" Step 5 : "+ booVer);

        //Step 7: write an if-then statement that displays a message, 'got some remainder', if the
        //boolean in step five is not true.

        if(booVer == false){
            System.out.println("got some remainder");

        }












    }
}
