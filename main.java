// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray


import java.util.Scanner;
// More packages may be imported in the space below

class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                
                // Assign variables for all inputs of the enter customer info method
                String firstName = "firstName";
                String lastName = "lastName";
                String city = "city"; 
                String postalCode = "postalCode";
                String creditCard = "creditCard";
                
                // Call method for each individual input
                firstName = enterCustomerInfo(firstName);
                lastName = enterCustomerInfo(lastName);
                city = enterCustomerInfo(city);
                postalCode = enterCustomerInfo(postalCode);
                creditCard = enterCustomerInfo(creditCard);

            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile();
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
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
    public static void validateCreditCard(){
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(){
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}
