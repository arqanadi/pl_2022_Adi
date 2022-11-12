import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String answer;
        boolean loop;
        System.out.println("-----This is a Palindrome Checker-----");

        //do-while loop for program repetition
        do {
            System.out.print("\nEnter word/phrase: ");

            String input = s.nextLine();
            String temp = input;
            String reverse = "";
            //ignores spaces and special characters
            temp = temp.replaceAll("[^a-zA-Z0-9]", "");
            //ignores case-sensitive
            temp = temp.toLowerCase();

            //reverses String input
            for (int i = temp.length() - 1; i >= 0; i--) {
                reverse += temp.charAt(i);
            }

            //compares String input to reversed String input
            boolean palindrome = true;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) != reverse.charAt(i)) {
                    palindrome = false;
                }
            }

            //print result
            if (palindrome) {
                System.out.println(input + " is a palindrome\n");
            } else {
                System.out.println(input + " is NOT a palindrome\n");
            }

            System.out.print("Do you want to check another word/phrase? Type 'Yes' or 'No'\n" +
                    "Type your answer: ");

            //loop user prompt to allow repetition
            do {
                answer = s.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    loop = false;
                } else if (answer.equalsIgnoreCase("no")) {
                    System.out.print("\n-----End-----");
                    loop = false;
                } else {
                    System.out.print("\nInvalid input, please try again: ");
                    loop = true;
                }

            } while (loop == true);
        } while (answer.equalsIgnoreCase("yes"));

    }
}//end