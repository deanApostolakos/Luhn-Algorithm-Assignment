import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

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
	String StringreversedcreditCardindexs = "";
	int sum = 0;
	int sum1 = 0;
	int sum2 = 0;
	    
	int len = creditCard.length();
        for (int i = (len - 1); i >= 0; i--) {
            creditCard = creditCard + (creditCard.charAt(i));
        }
        String reversedcreditCard = creditCard.substring(len, (len*2));
		
        int len2 = reversedcreditCard.length();
        for (int j = 0 ; j <= (len2 - 1); j++) {
            StringreversedcreditCardindexs = reversedcreditCard.substring(j, j + 1);
            int IntegerreversedcreditCardindexs = Integer.parseInt(StringreversedcreditCardindexs);
            if (j == 0 || j %2 == 0) {
            	sum1 = sum1 + IntegerreversedcreditCardindexs;
            }
            else if (j == 1|| j %2 == 1) {
            	IntegerreversedcreditCardindexs = IntegerreversedcreditCardindexs * 2;
            	if (IntegerreversedcreditCardindexs > 9) {
            		sum2 = sum2 + ((IntegerreversedcreditCardindexs %10) + 1);
            		
            	}
            	else if (IntegerreversedcreditCardindexs <= 9) {
            		sum2 = sum2 + IntegerreversedcreditCardindexs;
            	}
            }
        }
        sum = sum1 + sum2;
        if (sum %10 == 0) {
        	return true;
        }
        else if (sum %10 != 0) {
        	System.out.println("This credit card number is invalid, please enter customer information again.");
		return false;
        }
	else {
		System.out.println("This credit card number is invalid, please enter customer information again.");
		return false;
	}
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
        String userIDValue = "1";

        if (infoConfirmation.equals("y")){

            System.out.println("");
            System.out.println("Create new file?");
            System.out.println("y: Create new File");
            System.out.println("n: Use Existing File");
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
                
                File outFile = new File(fileName);
                if (outFile.exists()){
                    System.out.println("This file already exists, please choose a different file name.");
                }
                else{
                    PrintWriter out = new PrintWriter(outFile);

                    // Prints info header
                    out.println("Customer ID|First Name|Last Name|City|Postal Code|Credit Card|");
                    // Prints values to file
                    out.println(userIDValue+"|"+firstNameOutput+"|"+lastNameOutput+"|"+cityOutput+"|"+postalCodeOutput+"|"+creditCardOutput+"*");
                
                    System.out.print("");
                    System.out.println("Done");
                    System.out.print("Access File here: ");
                    System.out.println("Working Directory = " + System.getProperty("user.dir"));
                    System.out.print("");
                    out.close();
                    reader.close();
                }
            }
            else if (newFileChoice.equals("n")){
                System.out.println("");
                System.out.println("Add to existing file");
                System.out.println("To choose an existing file, ");
                System.out.println("Either:");
                System.out.println("Type the file name in the format - 'filename.filetpye'");
                System.out.println("or,");
                System.out.println("Drag and drop the chosen file from this list - " + System.getProperty("user.dir") + " - on the input line.");
                System.out.print(": ");
                String fileName = reader.nextLine();
                userIDValue = generateCustomerIDValue(userIDValue, fileName);

                File file = new File(fileName);

                try{
                    if(!file.exists()){
                        System.out.println("This file does not exist.");
                        System.out.println("Choose an existing file or create a new file");
                    }

                    FileWriter fileWriter = new FileWriter(file, true);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(userIDValue+"|"+firstNameOutput+"|"+lastNameOutput+"|"+cityOutput+"|"+postalCodeOutput+"|"+creditCardOutput+"*");
                    bufferedWriter.newLine();
                    bufferedWriter.close();

                    System.out.println("Done");
                } 
                catch(IOException e) {
                    System.out.println("Error!");
                }
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
    
    public static String generateCustomerIDValue(String NewIDString, String fileName){
        try {
            File Files = new File(fileName);
            Scanner reader = new Scanner(Files);
            String data = "";
            int lineCounter = 0;
            while (reader.hasNextLine()) {
                data = reader.nextLine();
                int len = data.length();
                for (int i = 0; i < len; i++){
                    if (data.charAt(i) == '*'){
                        lineCounter += 1;
                    }
                    else{
                        lineCounter += 0;
                    }
                }
            }
            int line = lineCounter;
            line += 1;
            NewIDString = Integer.toString(line);
            
            reader.close();
            
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return NewIDString;
    }
}
