
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static ArrayList allResults = new ArrayList(); 
    public static int lastResult; 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice; 
        
        try {
            do {
                System.out.println("\n++++++++++++++++++++[ Calculator Menu ]++++++++++++++++++++\n");
                System.out.println("--|[ Enter 1 to addition (+) the numbers");
                System.out.println("--|[ Enter 2 to subtraction (-) the numbers");
                System.out.println("--|[ Enter 3 to multiplication(*) the numbers");
                System.out.println("--|[ Enter 4 to division (/) the numbers");
                System.out.println("--|[ Enter 5 to modulus (%) the numbers");
                System.out.println("--|[ Enter 6 to find minimum number");
                System.out.println("--|[ Enter 7 to find maximum number");
                System.out.println("--|[ Enter 8 to find the average of numbers");
                System.out.println("--|[ Enter 9 to print the last result in calculator");
                System.out.println("--|[ Enter 10 to print the list of all results in calculator");
                System.out.println("--|[ Enter 11 to exit\n");
                System.out.print("Enter your choice: ");
                choice = input.nextInt(); 
                
                if(choice >= 1 && choice <=8){
                    System.out.print("Enter first number: ");
                    int fisrtNumber = input.nextInt(); 
    
                    System.out.print("Enter first number: ");
                    int secondNumber = input.nextInt();
                    try {
                        
                        switch (choice) {
                            case 1:
                                lastResult = addition(fisrtNumber, secondNumber); 
                                break;
                            
                            case 2: 
                                lastResult = subtraction(fisrtNumber, secondNumber); 
                                break; 
                            
                            case 3: 
                                lastResult = multiplication(fisrtNumber, secondNumber);
                                break; 
        
                            case 4: 
                                lastResult = division(fisrtNumber, secondNumber);
                                break; 
        
                            case 5: 
                                lastResult = modulus(fisrtNumber, secondNumber); 
                                break;
        
                            case 6: 
                                lastResult = average(fisrtNumber, secondNumber); 
                                break; 
        
                            case 7: 
                                lastResult = minimum(fisrtNumber, secondNumber); 
                                break; 
        
                            case 8: 
                                lastResult = maximum(fisrtNumber, secondNumber); 
                                break; 
                        }
        
                    } catch (ArithmeticException e) {
                        System.out.println("Error " + e.getMessage());
                        continue; 
                    }
                    allResults.add(lastResult); 
                    System.out.println("Result: " + lastResult);
                }else if (choice == 9){
                    System.out.println("Last Result = " + lastResult);
                }else if (choice == 10){
                    System.out.println("All Results = " + allResults);
                }else if (choice  != 11){
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 11);
            System.out.println("See you later!");
            
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");
        }

    }


// ============================> METHODS <============================ // 


    public static int addition(int firstNumber, int secondNumber){
        return firstNumber + secondNumber; 
    }

    public static int subtraction(int firstNumber, int secondNumber){
        return firstNumber - secondNumber; 
    }


    public static int multiplication(int firstNumber, int secondNumber){
        return firstNumber * secondNumber; 
    }



    public static int division(int firstNumber, int secondNumber){
        return firstNumber / secondNumber; 
    }


    public static int modulus(int firstNumber, int secondNumber){
        return firstNumber % secondNumber; 
    }


    public static int minimum(int firstNumber, int secondNumber){
        return (firstNumber < secondNumber) ? firstNumber : secondNumber; 
    }


    public static int maximum(int firstNumber, int secondNumber){
        return (firstNumber > secondNumber) ? firstNumber : secondNumber; 
    }


    public static int average(int firstNumber, int secondNumber){
        return (firstNumber + secondNumber) / 2; 
    }
}

