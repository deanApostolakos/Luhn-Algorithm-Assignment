import java.util.Scanner;
// More packages may be imported in the space below
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

class CustomerSystem{
    public static void main(String[] args) throws FileNotFoundException{
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below
        // Declares all customer input variables
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
                
                // Call method for each individual input
                firstName = enterCustomerInfo(firstName);
                lastName = enterCustomerInfo(lastName);
                city = enterCustomerInfo(city);
                postalCode = enterCustomerInfo(postalCode);
                creditCard = enterCustomerInfo(creditCard);

                validatePostalCode(postalCode);

                validateCreditCard(creditCard);
                
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
                // This is just a little thing
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
    public static void validatePostalCode(String postalCode){
        try {
            File postalCodeFile = new File("postal_codes.csv");
            Scanner reader = new Scanner(postalCodeFile);
            String data = "";
            String firstThree = "";
            postalCode = postalCode.substring(0, 3);
            while (reader.hasNextLine()) {
                data = reader.nextLine();
                firstThree = data.substring(0, 3);
                if (postalCode.equals(firstThree)){
                    break;
                }
            }
            if (!postalCode.equals(firstThree)){
                System.out.println("This postal code is invalid, please enter customer information again.");
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validateCreditCard(String creditCard){
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
        }
        else if (sum %10 != 0) {
            System.out.println("This credit card number is invalid, please enter customer information again.");
        }
        else{
            System.out.println("This credit card number is invalid, please enter customer information again.");
        }
    } 
	
    public static void generateCustomerDataFile(String firstNameOutput, String lastNameOutput, String cityOutput, String postalCodeOutput, String creditCardOutput) throws FileNotFoundException{
        // Initialize Scanner
        Scanner reader = new Scanner(System.in);
    
        System.out.println("");
        // Allow user to confirm that the information they entered is all correct
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

        // If the user says the information is correct
        if (infoConfirmation.equals("y")){

            System.out.println("");
            // Ask user whether to create a new file (for first customer inputs)
            // or to use an exiting file to add new customer info to
            System.out.println("Create new file?");
            System.out.println("y: Create new File");
            System.out.println("n: Use Existing File");
            System.out.print("y/n: ");
            String newFileChoice = reader.nextLine();
            
            // iF user chooses to create a new file
            if (newFileChoice.equals("y")){
                System.out.println("");
                // Asks what type of file to create
                // Options are only .txt and .csv to keep it simple
                System.out.println("What type of file are you outputting? ");
                System.out.println(".txt     or    .csv");
                System.out.print("-");
                String fileType = reader.nextLine();
            
                System.out.println("");
                // Asks user to enter just the file name
                System.out.print("Enter File Name: ");
                String enterFileName = reader.nextLine();
                System.out.print("");
                
                // Adds the file name and file type to create a variable that holds the entire file name
                String fileName = enterFileName + fileType;
                
                // Create new file
                File outFile = new File(fileName);
                // If a file with that name already exists
                if (outFile.exists()){
                    System.out.println("This file already exists, please choose a different file name.");
                }
                else{
                    // New PrintWriter which will print to the file
                    PrintWriter out = new PrintWriter(outFile);

                    // Prints info header
                    out.println("Customer ID|First Name|Last Name|City|Postal Code|Credit Card|");
                    // Prints values to file
                    // userIDValue is automatically 1 because the user chose to create a new file
                    // Takes the rest of the inputs and prints them next to eachother with a | delimiter 
                    out.println(userIDValue+"|"+firstNameOutput+"|"+lastNameOutput+"|"+cityOutput+"|"+postalCodeOutput+"|"+creditCardOutput+"*");
                
                    System.out.print("");
                    // States when the file has been created
                    System.out.println("Done");
                    // Produces link where user can click to find where the file is located
                    System.out.print("Access File here: ");
                    System.out.println("Working Directory = " + System.getProperty("user.dir"));
                    System.out.print("");
                    out.close();
                    reader.close();
                }
            }
            // If user chose to use an existing file
            else if (newFileChoice.equals("n")){
                System.out.println("");
                System.out.println("Add to existing file");
                System.out.println("To choose an existing file, ");
                // Gives user option of how to choose file
                System.out.println("Either:");
                // The user can either type in the file name directly into the terminal
                System.out.println("Type the file name in the format - 'filename.filetpye'");
                System.out.println("or,");
                // or they can click the directory link and drag and drop a file into the terminal
                System.out.println("Drag and drop the chosen file from this list - " + System.getProperty("user.dir") + " - on the input line.");
                System.out.print(": ");
                String fileName = reader.nextLine();
                
                // Calls method which determines the user ID value
                userIDValue = generateCustomerIDValue(userIDValue, fileName);

                // Creates file variable
                File file = new File(fileName);

                try{
                    // If the file doesn't exist
                    if(!file.exists()){
                        System.out.println("This file does not exist.");
                        System.out.println("Choose an existing file or create a new file");
                    }
                    // Initialize FileWriter, which allows you to write to a file without overwriting the contents
                    FileWriter fileWriter = new FileWriter(file, true);

                    // Initialize BufferedWriter, which allows you to write to a file without overwriting the contents
                    // This is the only way I found that was able to do this
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    // Takes new user ID value
                    // with all the customer info, seperated by a | delimiter
                    // prints the string to the file, creating a new line for this data.
                    bufferedWriter.write(userIDValue+"|"+firstNameOutput+"|"+lastNameOutput+"|"+cityOutput+"|"+postalCodeOutput+"|"+creditCardOutput+"*");
                    bufferedWriter.newLine();
                    bufferedWriter.close();

                    System.out.println("");
                    // States when the file has been updated
                    System.out.println("Done");
                } 
                // If there is an error in the code
                catch(IOException e) {
                    System.out.println("");
                    System.out.println("Error!");
                }
            }
        }

        // If user says information is incorrect
        else if (infoConfirmation.equals("n")){
            //Takes user back to input print menu
            System.out.println("");
            System.out.println("Information is now deemed invalid.");
            System.out.println("Please re-input customer information");
            System.out.println("");
        }
    }

    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         * 
    *******************************************************************/
    
    // Assigns new customer a new ID value
    public static String generateCustomerIDValue(String NewIDString, String fileName){
        try {
            // Creates file variable with chosen file
            File Files = new File(fileName);
            // Initializes scanner for the file
            Scanner reader = new Scanner(Files);
            // Initialize variabe "data", which will hold the string data from the file
            String data = "";
            // Initialize variable "lineCounter", which will keep track of how many lines have passed
            int lineCounter = 0;
            // Creates loop where it repeats while there are lines to go through
            while (reader.hasNextLine()) {
                // Variable "data" takes the data from the current line
                data = reader.nextLine();
                // Finds the length of the line
                int len = data.length();
                // For loop where i begins at 0 and increases by 1 until it reaches the length of the line
                for (int i = 0; i < len; i++){
                    // Checks if each character is a *
                    // * represents the end of one customers information and is located at the end of the line
                    // Using this I can count how many of these there are which will tell me how many customers
                    // are in the file, which also nicely helps decide what the next ID value is.
                    if (data.charAt(i) == '*'){
                        // Increases lineCounter by 1
                        lineCounter += 1;
                    }
                    else{
                    }
                }
            }
            int line = lineCounter;
            line += 1;
            // Changes the int line into a string, in the variable NewIDString
            NewIDString = Integer.toString(line);
            
            // Close Reader
            reader.close();
        }
        // If file is not found
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        // Returns new customer ID value
        return NewIDString;
    }
}