
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
// More packages may be imported in the space below

class CustomerSystem{
    public static void main(String[] args) throws FileNotFoundException{
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below
        String firstName = "firstName";
        String lastName = "lastName";
        String city = "city"; 
        String postalCode = "postalCode";
        String creditCard = "creditCard";


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                
                // Assigned variables for all inputs of the enter customer info method
                //String firstName = "firstName";
                //String lastName = "lastName";
                //String city = "city"; 
                //String postalCode = "postalCode";
                //String creditCard = "creditCard";
                
                // Call method for each individual input
                firstName = enterCustomerInfo(firstName);
                lastName = enterCustomerInfo(lastName);
                city = enterCustomerInfo(city);
                postalCode = enterCustomerInfo(postalCode);
                creditCard = enterCustomerInfo(creditCard);
              
                boolean creditCardValidate = false;
                creditCardValidate = validateCreditCard(creditCard);
                
                // Empty line for spacing between the menus
                System.out.println("");

            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile(firstName, lastName, city, postalCode, creditCard);
                System.out.println("");
            }
            else{
                // Added extra condition to check if the user inputted 9.
                // If they input 9 it exits the loop and ends the program,
                // where without it it would say 9 isn't valid and then exit
                // This is just a small thing
                if (userInput.equals(exitCondition)){
                }
                else{
                    System.out.println("Please type in a valid option (A number from 1-9)");
                }
            }
            

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static String enterCustomerInfo(String variable) {
        // Initialize scanner
        Scanner reader = new Scanner(System.in);

        // Customer first name input
        if (variable.equals("firstName")){
            System.out.print("Customer First Name        : ");
            String fName = reader.nextLine();
            variable = fName;
        }
        // Customer last name input
        else if (variable.equals("lastName")){
            System.out.print("Customer Last Name         : ");
            String lName = reader.nextLine();
            variable = lName;
        }
        // Customer city input
        else if (variable.equals("city")){
            System.out.print("Customer City              : ");
            String cty = reader.nextLine();
            variable = cty;
        }
        // Customer postal code input
        else if (variable.equals("postalCode")){
            System.out.print("Customer Postal Code       : ");
            String pCode = reader.nextLine();
            variable = pCode;
        }
        // Customer Credit card input
        else if (variable.equals("creditCard")){
            System.out.print("Customer Credit Card Number: ");
            String card = reader.nextLine();
            variable = card;
        }
        
        // The method doesn't work if the reader is closed. I don't know why. 
        // I will leave it commented out though.
        //reader.close();

        // Return input to main
        return variable;
    }

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(){
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */

    public static boolean validateCreditCard(String creditCard){
        int sum1 = 0;
        String reversedcreditCardindexs = "";
        
	int len = creditCard.length();
        for (int i = (len - 1); i >= 0; i--) {
            creditCard = creditCard + (creditCard.charAt(i));
        }
        String reversedcreditCard = creditCard.substring(9, 18);

        int len2 = reversedcreditCard.length();
        for(int j = 0; j <= len2; j += 2){
            reversedcreditCardindexs = reversedcreditCard.substring(j, j + 1);
            int reversedcreditCardoddsum = Integer.parseInt(reversedcreditCardindexs);
            sum1 = sum1 + reversedcreditCardoddsum;
        }
	return true;
    }   


    public static void generateCustomerDataFile(String firstNameOutput, String lastNameOutput, String cityOutput, String postalCodeOutput, String creditCardOutput) throws FileNotFoundException{
    
        Scanner reader = new Scanner(System.in);
    
        System.out.println("");
        System.out.println("Confirm Correct Information: ");
        System.out.println("");
        System.out.println("First Name  : " + firstNameOutput);
        System.out.println("Last Name   : " + lastNameOutput);
        System.out.println("City        : " + cityOutput);
        System.out.println("Postal Code : " + postalCodeOutput);
        System.out.println("Credit Card : " + creditCardOutput);
        System.out.println("");
        System.out.print("y/n: ");
        String infoConfirmation = reader.nextLine();

        // Assign user ID value
        int userIDValue = 1;

        if (infoConfirmation.equals("y")){

            System.out.println("");
            System.out.println("Create new file?");
            System.out.print("y/n: ");
            String newFileChoice = reader.nextLine();
            
            if (newFileChoice.equals("y")){
                System.out.println("");
                System.out.println("What type of file are you outputting? ");
                System.out.println(".txt     or    .csv");
                System.out.print("-");
                String fileType = reader.nextLine();
            
                System.out.println("");
                System.out.print("Enter File Name: ");
                String enterFileName = reader.nextLine();
                System.out.print("");
                
                String fileName = enterFileName + fileType;
                //int userIDValue = generateCustomerIDValue(userIDValue);
                
                File outFile = new File(fileName);
                PrintWriter out = new PrintWriter(outFile);
                
                // Prints info header
                out.println("Customer ID|First Name|Last Name|City|Postal Code|Credit Card|");
                // Prints values to file
                out.println(userIDValue+"|"+firstNameOutput+"|"+lastNameOutput+"|"+cityOutput+"|"+postalCodeOutput+"|"+postalCodeOutput+"|"+creditCardOutput);
            
                System.out.print("");
                System.out.println("Done");
                out.close();
                reader.close();
            }
            else if (newFileChoice.equals("n")){
                System.out.println("");
                System.out.println("Add to existing file");
                System.out.println("Choose existing file: ");

            }
            
        }

        else if (infoConfirmation.equals("n")){
            //Takes user back to input print menu
            System.out.println("Information is now deemed incorrect.");
            System.out.println("Please re-input customer information");
            System.out.println("");
        }

      }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
    public static void generateCustomerIDValue(){
    }
}
