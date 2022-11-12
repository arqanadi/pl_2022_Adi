import java.util.Scanner;

public class DeterministicFiniteAutomata {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String answer;
        boolean loop;

        System.out.println("-----Welcome to Deterministic Finite Automata!-----\n" +
                "*This is an Automaton that only accepts strings ending with ‘01’ over input alphabets ∑ = {0, 1}*");

        //do-while loop to allow user repetition
        do {
            System.out.print("\nPlease Enter String: ");
            String state = "q0";
            String input = s.nextLine();
            System.out.print("Result: ");
            //DFA Code
            for(int x = 0; x < input.length(); x++){
                if(state.equals("q0") && input.charAt(x) == '0'  ){

                    state = "q1";
                }else if(state.equals("q0") && input.charAt(x) == '1'  ){

                    state = "q0";
                }else if(state.equals("q1") && input.charAt(x) == '0'  ){

                    state = "q1";
                }else if(state.equals("q1") && input.charAt(x) == '1'  ){

                    state = "q2";
                }else if(state.equals("q2") && input.charAt(x) == '0'  ){

                    state = "q1";
                }else if(state.equals("q2") && input.charAt(x) == '1'  ){

                    state = "q0";
                }else{
                    System.out.print("Invalid input, ");
                    x = input.length() + 1;
                }

            }
            //check if state is final state
            if(state.equals("q2")){
                System.out.println("String accepted");
            }else{
                System.out.println("String not accepted");
            }

            System.out.print("\nDo you want to enter another String? Type 'Yes' or 'No'\n" +
                    "Type your answer: ");

            //loops user prompt
            do {
                answer = s.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    loop = false;
                } else if (answer.equalsIgnoreCase("no")) {
                    System.out.print("\n-----Exiting automaton-----");
                    loop = false;
                } else {
                    System.out.print("\nInvalid input, please try again: ");
                    loop = true;
                }

            } while (loop == true);
        } while (answer.equalsIgnoreCase("yes"));

    }
}
