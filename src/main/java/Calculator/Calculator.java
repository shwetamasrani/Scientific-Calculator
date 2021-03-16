package Calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public static void main(String[] args) throws IOException {

        Calculator obj = new Calculator();
        System.out.println("Calculator!");
        System.out.println("Please select one of the operations:");
        System.out.println("1. Press 1 for Square root");
        System.out.println("2. Press 2 for Factorial");
        System.out.println("3. Press 3 for Natural Logarithm");
        System.out.println("4. Press 4 for Power ");
        System.out.println("Press 5 to exit!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int choice = Integer.parseInt(br.readLine());
            switch (choice){
                case 1: {
                    System.out.println("Enter the number for calculating square root:");
                    double num = Double.parseDouble(br.readLine());
                    double result = obj.squareRoot(num);
                    break;
                }
                case 2: {
                    System.out.println("Enter the number for calculating factorial:");
                    double fact = Double.parseDouble(br.readLine());
                    double result = obj.factorial(fact);
                    break;
                }
                case 3:{
                    System.out.println("Enter the number for calculating natural log:");
                    double log = Double.parseDouble(br.readLine());
                    double result = obj.naturalLog(log);
                    break;
                }
                case 4: {
                    System.out.println("Enter the base number for calculating power:");
                    double pow1 = Double.parseDouble(br.readLine());
                    System.out.println("Enter the exponent for calculating power:");
                    double pow2 = Double.parseDouble(br.readLine());
                    double result = obj.power(pow1, pow2);
                    break;
                }
                default: {
                    System.out.println("Exiting....");
                    return;
                }
            }

        }

        }
    public double power(double pow1, double pow2) {
        double result = 0;
        try{
            logger.info("Base and exponent are :["+ pow1+" ,"+pow2+"]");

            if(pow2 == 0)
                result = 1;
            else{
                result = Math.pow(pow1, pow2);
            }
            System.out.println("Power of the"+ pow1 +"raised to "+pow2+" is: "+ result);

        } catch(IllegalArgumentException e){
            logger.error("Base should be positive integer :["+ pow1+", "+pow2+"]");
        }
        return result;
    }

    public double factorial(double fact) {
        logger.info("Number entered is :["+ fact+"]");
        Double result = 1.0;
        try {
            while(fact > 0){
                result *= fact;
                fact--;
            }

            System.out.println("Factorial of the entered number is: "+ result);
        } catch(IllegalArgumentException e){
            logger.error("Factorial of negative numbers is not possible in catch :["+fact+"]");
        }
        return result;
    }

    public double naturalLog(double log) {
        double result = 0;
        try{
            logger.info("Base and exponent are :["+ 10+" ,"+log+"]");


            result = Math.log(log);

            System.out.println("Natural Log of the entered number is: "+ result);

        } catch(IllegalArgumentException e){
            logger.error("Log of negatives is not defined :["+log+"]");
        }
        return result;
    }

    public double squareRoot(double num) {
        double result = 0;
        try {
            logger.info("Number for square root :[" + num+"]");

            //throw new ArithmeticException("Number is either 0 or less than 0");


            result = Math.sqrt(num);
            System.out.println("Square root of the entered number is: " + result);


        } catch (IllegalArgumentException e) {
            logger.error("Square root can't be negative or 0 :["+num+"]");
        }
        return result;
    }
}

