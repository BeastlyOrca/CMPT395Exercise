import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String word = fizzBuzz();
        System.out.println(word);
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

        int checkLen;
        int checkNum;
        int checkCap;
        int checkSpec;
        checkLen = lengthCheck(input);
        checkNum =numCheck(input);
        checkCap = capCheck(input);
        checkSpec =specialCheck(input);

        if (checkLen == 1 && checkNum == 1 && checkCap == 1 && checkSpec == 1) {System.out.println("Valid Password");}


    }
    public static int lengthCheck(String pass) {
        if (pass.length() < 8) {
            System.out.println("Password must be at least 8 characters");
            return 0;
        }
        return 1;
    }


    public static int numCheck(String pass){
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
            return 0;
        }
        return 1;
    }


    public static int capCheck(String pass){
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
            return 0;
        }
        return 1;
    }

    public static int specialCheck(String pass){

        // Pattern and Matcher and Regex found on https://stackoverflow.com/questions/1795402/check-if-a-string-contains-a-special-character
        // and the structure is used to handle special characters
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(pass);
        boolean check = m.find();

        if (!check) {
            System.out.println("password must contain at least one special character");
            return 0;
        }
        return 1;
    }

}