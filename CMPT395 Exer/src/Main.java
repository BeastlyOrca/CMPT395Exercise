import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        //String word = fizzBuzz();
        //System.out.println(word);
        password();
    }


    public static String fizzBuzz(){
        Scanner myScan = new Scanner(System.in); //Create Scan
        System.out.print("Enter a number ");

        try {
            int input = myScan.nextInt();
            if (input % 3 == 0 && input % 5 == 0) {
                return "FizzBuzz";

            } else if (input % 3 == 0) {
                return "Fizz";
            } else if (input % 5 == 0) {
                return "Buzz";
            } else {
                return "Number not a multiple of 3 or 5";
            }
        } catch (Exception e) {
            return "Not a number of undefined character";
        }

    }

    public static void password(){

        Scanner myScan = new Scanner(System.in); //Create Scan
        System.out.print("Enter password: ");
        String input = myScan.nextLine();

        lengthCheck(input);
        numCheck(input);
        capCheck(input);
        specialCheck(input);


    }
    public static void lengthCheck(String pass) {
        if (pass.length() < 8) {
            System.out.println("Password must be at least 8 characters");
        }
    }


    public static void numCheck(String pass){
        char ch;
        int count = 0;

        for(int i=0;i < pass.length();i++) {
            ch = pass.charAt(i);

            if (Character.isDigit(ch)) {
                count++;
            }
        }

        if(count < 2) {
            System.out.println("password must contain at least two numbers");
        }
    }


    public static void capCheck(String pass){
        char ch;
        boolean capitalFlag = false;

        for(int i=0;i < pass.length();i++) {
            ch = pass.charAt(i);

            if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            }
        }

        if(!capitalFlag) {
            System.out.println("password must contain at least one capital letter");
        }
    }

    public static void specialCheck(String pass){
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(pass);
        boolean check = m.find();

        if (!check) {
            System.out.println("password must contain at least one special character");
        }
    }

}