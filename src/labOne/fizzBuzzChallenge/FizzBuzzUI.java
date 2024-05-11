package labOne.fizzBuzzChallenge;

import java.util.Scanner;

public class FizzBuzzUI {
    private final Scanner scanner;
    private final FizzBuzz fizzBuzz;

    public FizzBuzzUI() {
        scanner = new Scanner(System.in);
        fizzBuzz = new FizzBuzz();
    }

    public void run(){
        try {
            printBanner();
            int number = getInput();
            String result = fizzBuzz.playFizzBuzz(number);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private int getInput() {
        try {
            System.out.println("Number: ");
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.next();
            return getInput();
        }
    }

    public void printBanner() {
        String banner = """
                ######################
                # FizzBuzz Challenge #
                ######################""";
        System.out.println(banner);
    }

    static class FizzBuzz{
        public String playFizzBuzz(int number){
            if(number % 5 == 0 && number % 3 == 0){
                return "FizzBuzz";
            }else if(number % 5 == 0){
                return "Fizz";
            }else if(number % 3 == 0){
                return "Buzz";
            }else{
                return "No FizzBuzz, Fizz, or Buzz on this input";
            }
        }
    }
}
