import java.util.InputMismatchException;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Task3 {

    private static boolean MainMenu = true;
    private static boolean SubMenu = true;



    static ArrayList<passenger> passengerArrayList = new ArrayList<passenger>();
    static cabin[] cruise = new cabin[12];

    public static void main(String[] args) throws IOException {
        initialise();

        Scanner input = new Scanner(System.in);


        for (int i = 0; i < cruise.length; i++) {
            cruise[i] = new cabin();

        }

        int roomNum = 0;
        int next_number = 0;

        while (MainMenu) {
            while (SubMenu) {

            System.out.println("A: Book A New Cabin.");

            System.out.println("E: Display Empty cruise.");

            System.out.println("V: View all cruise.");

            System.out.println("D: Delete customer from a Cabin.");

            System.out.println("F: Find Cabin from customer name.");

            System.out.println("S: Store program data in to file.");

            System.out.println("L: Load program data from file.");

            System.out.println("O: View cruise Ordered alphabetically by name.");

            System.out.println("T: View Passenger expenses");

            String Selection = input.next();
            Selection = Selection.toUpperCase();
            switch (Selection) {
                case "A":
                    Que();

                    break;
                case "E":
                    CheckIfEmpty(cruise);
                    break;
                case "V":
                    ViewAllcruise(cruise);
                    break;
                case "D":
                    DeleteCustomerFromcabin(cruise, roomNum, next_number);
                    break;
                case "F":
                    FindcabinFromCustomerName(cruise);
                    break;
                case "S":
                    StoreProgramDataInToFile(cruise);
                    break;
                case "L":
                    LoadProgramDataFromFile(cruise);
                    break;
                case "O":
                    // ViewRoomsOrderedAlphabeticallyByName(cruise);
                    break;
                case "T":
                    Viewexpenses(cruise);
                    break;

                default:
                    System.out.println("Invalid Selection");
                    break;
            }

                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");

                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;

            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");

            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("Have a nice day!!");
                System.exit(0);

            }


        }

    }

    private static void CheckIfEmpty(cabin[] cruise) {


        for (int x = 0; x < cruise.length; x++) {

            String passenger1_data = cruise[x].getPassenger1().getPassenegerFirstName();
            String passenger2_data = cruise[x].getPassenger2().getPassenegerFirstName();
            String passenger3_data = cruise[x].getPassenger3().getPassenegerFirstName();

            if (passenger1_data != "empty") {
                System.out.println("occupied1");
            } else {
                System.out.println("(Passenger 1) Not occupied In cabin No." + (x + 1) );

            }
            if (passenger2_data != "empty") {
                System.out.println("occupied2");

            } else {
                System.out.println("(Passenger 2) Not occupied In cabin No." + (x + 1) );


            }
            if (passenger3_data != "empty") {
                System.out.println("occupied3");
            } else {
                System.out.println("(Passenger 3) Not occupied In cabin No." + (x + 1) );


            }

        }
    }

    public static void Que() {

        String First_name;
        String Second_name;
        int Que_Expenses;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the First name");
        First_name = input.next();

        System.out.println("Enter the second name");
        Second_name = input.next();

        System.out.println("Enter Expenses");
        Que_Expenses = input.nextInt();

        passenger passengerx = new passenger();
        passengerx.setPassenegerFirstName(First_name);
        passengerx.setPassengerSecondName(Second_name);
        passengerx.setexpenses(Que_Expenses);
        passengerArrayList.add(passengerx);

        process();

    }

    public static void process() {
        for (int x = 0; x < cruise.length; x++) {
            if (passengerArrayList.size()==0){
                break;
            }
            String passenger1_data = cruise[x].getPassenger1().getPassenegerFirstName();
            String passenger2_data = cruise[x].getPassenger2().getPassenegerFirstName();
            String passenger3_data = cruise[x].getPassenger3().getPassenegerFirstName();

            if (passenger1_data == "empty") {

                cruise[x].setPassenger1(passengerArrayList.get(0));
                passengerArrayList.remove(0);

            } else if (passenger2_data == "empty") {
                cruise[x].setPassenger2(passengerArrayList.get(0));
                passengerArrayList.remove(0);


            } else if (passenger3_data == "empty") {
                cruise[x].setPassenger3(passengerArrayList.get(0));
                passengerArrayList.remove(0);

            }

        }

    }

    private static void BookAcabin(int next_number, int roomNum, cabin[] cruise) {


        try{

            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number (1-12):");
            roomNum = input.nextInt() - 1;

            System.out.println("Which slot you want to book  (select from 1-3):");
            next_number = input.nextInt() - 1;

            if (next_number == 0) {
                System.out.println("first name");
                cruise[next_number].getPassenger1().setPassenegerFirstName(input.next());
                System.out.println("second name");
                cruise[next_number].getPassenger1().setPassengerSecondName(input.next());
                System.out.println("enter expenses");
                cruise[next_number].getPassenger1().setexpenses(input.nextInt());

            } else if (next_number == 1) {
                System.out.println("first name");
                cruise[next_number].getPassenger2().setPassenegerFirstName(input.next());
                System.out.println("second name");
                cruise[next_number].getPassenger2().setPassengerSecondName(input.next());
                System.out.println("enter expenses");
                cruise[next_number].getPassenger2().setexpenses(input.nextInt());
            } else if (next_number == 2) {
                System.out.println("first name");
                cruise[next_number].getPassenger3().setPassenegerFirstName(input.next());
                System.out.println("second name");
                cruise[next_number].getPassenger3().setPassengerSecondName(input.next());
                System.out.println("enter expenses");
                cruise[next_number].getPassenger3().setexpenses(input.nextInt());
            }


        }catch(InputMismatchException e){
            System.out.println("Input Mismatch Exception has occurred. "+e);

        }



    }




    private static void ViewAllcruise(cabin[] cruise) {

        for (int x = 0; x < cruise.length; x++) {

            String passenger1_data = cruise[x].getPassenger1().getPassenegerFirstName();
            String passenger2_data = cruise[x].getPassenger2().getPassenegerFirstName();
            String passenger3_data = cruise[x].getPassenger3().getPassenegerFirstName();

            if (passenger1_data != "empty") {
                String NextPassenger1 = cruise[x].getPassenger1().getPassenegerFirstName();

                System.out.println(NextPassenger1 + " is the 1st passenger in cabin " + (x + 1));

            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 1 is Empty");

            }
            if (passenger2_data != "empty") {
                String NextPassenger2 = cruise[x].getPassenger2().getPassenegerFirstName();

                System.out.println(NextPassenger2 + " is the 2nd passenger in cabin " + (x + 1));

            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 2 is Empty");

            }
            if (passenger3_data != "empty") {
                String NextPassenger3 = cruise[x].getPassenger3().getPassenegerFirstName();

                System.out.println(NextPassenger3 + " is the 3rd passenger in cabin " + (x + 1));

            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 3 is Empty");

            }

        }

    }

    private static void DeleteCustomerFromcabin(cabin[] cruise, int roomNum, int next_number) {

        try{

            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number to delete(1-12):");
            roomNum = input.nextInt() - 1;
            System.out.println("which slot");
            next_number = input.nextInt() - 1;

            passenger temp = new passenger();


            if (next_number == 0) {
                cruise[roomNum].setPassenger1(temp);
            } else if (next_number == 1) {
                cruise[roomNum].setPassenger2(temp);

            } else if (next_number == 2) {
                cruise[roomNum].setPassenger3(temp);

            }

            System.out.println(" Deleted ");

            process();

        }catch(InputMismatchException e){
            System.out.println("Input Mismatch Exception has occurred. "+e);

        }


    }

    private static void FindcabinFromCustomerName(cabin[] cruise) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the First name to Search for:");
        String roomName = input.next();

        for (int x = 0; x < cruise.length; x++) {

            String passenger1_data = cruise[x].getPassenger1().getPassenegerFirstName();
            String passenger2_data = cruise[x].getPassenger2().getPassenegerFirstName();
            String passenger3_data = cruise[x].getPassenger3().getPassenegerFirstName();


            if (passenger1_data.equals(roomName)) {
                System.out.println(roomName + " is the 1st passenger in cabin " + (x + 1));

            } else if (passenger2_data.equals(roomName)) {
                System.out.println(roomName + " is the 2nd passenger in cabin " + (x + 1));

            } else if (passenger3_data.equals(roomName)) {
                System.out.println(roomName + " is the 3rd passenger in cabin " + (x + 1));

            } else {
                System.out.println("There are no cruise Booked with that name\\n(make sure you've used the correct words");
            }

        }

    }

    private static void StoreProgramDataInToFile(cabin[] cruise) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("Array.txt"))) {
            String saveF_nameOfPass1;
            String saveS_nameOfPass1;
            String saveF_nameOfPass2;
            String saveS_nameOfPass2;
            String saveF_nameOfPass3;
            String saveS_nameOfPass3;

            int saveExpensesOfPass1;
            int saveExpensesOfPass2;
            int saveExpensesOfPass3;

            String GetPass1Data;
            String GetPass2Data;
            String GetPass3Data;

            String emp = "empty";

            for (int x = 0; x < cruise.length; x++) {

                GetPass1Data = cruise[x].getPassenger1().getPassenegerFirstName();
                GetPass2Data = cruise[x].getPassenger2().getPassenegerFirstName();
                GetPass3Data = cruise[x].getPassenger3().getPassenegerFirstName();

                if (!GetPass1Data.equals(emp)) {

                    saveF_nameOfPass1 = cruise[x].getPassenger1().getPassenegerFirstName();
                    saveS_nameOfPass1 = cruise[x].getPassenger1().getPassengerSecondName();
                    saveExpensesOfPass1 = cruise[x].getPassenger1().getexpenses();

                    out.println(
                            "cabin " + (x) + ": 1st passenger is occupied by " + saveF_nameOfPass1 + " " + saveS_nameOfPass1 + ": Rs " + saveExpensesOfPass1); // +

                } else {
                    out.println("cabin " + (x) + ": 1st passenger is empty ");

                }

                if (!GetPass2Data.equals(emp)) {

                    saveF_nameOfPass2 = cruise[x].getPassenger2().getPassenegerFirstName();
                    saveS_nameOfPass2 = cruise[x].getPassenger2().getPassengerSecondName();
                    saveExpensesOfPass2 = cruise[x].getPassenger1().getexpenses();

                    out.println(
                            "cabin " + (x) + ": 2nd passenger is occupied by " + saveF_nameOfPass2 + " " + saveS_nameOfPass2 + ": Rs " + saveExpensesOfPass2); // +

                } else {
                    out.println("cabin " + (x) + ": 2nd passenger is empty ");

                }

                if (!GetPass3Data.equals(emp)) {

                    saveF_nameOfPass3 = cruise[x].getPassenger3().getPassenegerFirstName();
                    saveS_nameOfPass3 = cruise[x].getPassenger3().getPassengerSecondName();
                    saveExpensesOfPass3 = cruise[x].getPassenger1().getexpenses();

                    out.println(
                            "cabin " + (x) + ": 3rd passenger is occupied by " + saveF_nameOfPass3 + " " + saveS_nameOfPass3 + ": Rs " + saveExpensesOfPass3); // +

                } else {
                    out.println("cabin " + (x) + ": 3rd passenger is empty ");

                }

            }

        }
        System.out.println("All Room Names have been Saved.");
    }

    private static void LoadProgramDataFromFile(cabin[] cruise) {
        try {
            File myobjct = new File("Array.txt");
            Scanner myscan = new Scanner(myobjct);

            while (myscan.hasNextLine()) {
                for (int k = 0; k < 36; k++) {
                    System.out.println(myscan.nextLine());

                }

            }
            myscan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();

        }

    }

    public static void Viewexpenses(cabin[] cruise) {

        try{
            String saveF_nameOfPass1;
            String saveS_nameOfPass1;
            String saveF_nameOfPass2;
            String saveS_nameOfPass2;
            String saveF_nameOfPass3;
            String saveS_nameOfPass3;

            String GetPass1Data;
            String GetPass2Data;
            String GetPass3Data;

            String emp = "empty";
            int total2 = 0;

            for (int x = 0; x < cruise.length; x++) {

                GetPass1Data = cruise[x].getPassenger1().getPassenegerFirstName();
                GetPass2Data = cruise[x].getPassenger2().getPassenegerFirstName();
                GetPass3Data = cruise[x].getPassenger3().getPassenegerFirstName();

                int saveExpensesOfPass1;
                int saveExpensesOfPass2;
                int saveExpensesOfPass3;

                if (!GetPass1Data.equals(emp)) {

                    saveF_nameOfPass1 = cruise[x].getPassenger1().getPassenegerFirstName();
                    saveS_nameOfPass1 = cruise[x].getPassenger1().getPassengerSecondName();
                    saveExpensesOfPass1 = cruise[x].getPassenger1().getexpenses();

                    System.out.println("cabin " + (x + 1) + "s 1st passenger: " + saveF_nameOfPass1 + " " + saveS_nameOfPass1 + ": Rs " + saveExpensesOfPass1); // +

                }


                if (!GetPass2Data.equals(emp)) {

                    saveF_nameOfPass2 = cruise[x].getPassenger2().getPassenegerFirstName();
                    saveS_nameOfPass2 = cruise[x].getPassenger2().getPassengerSecondName();
                    saveExpensesOfPass2 = cruise[x].getPassenger1().getexpenses();

                    System.out.println("cabin " + (x + 1) + "s 2nd passenger: " + saveF_nameOfPass2 + " " + saveS_nameOfPass2 + ": Rs " + saveExpensesOfPass2);
                    // ":
                    // Rs."
                    // +
                    // saveF_nameOfPass2
                } // else{
                // System.out.println("cabin "+(x+1)+"s 2nd passenger is empty " );

                // }

                if (!GetPass3Data.equals(emp)) {

                    saveF_nameOfPass3 = cruise[x].getPassenger3().getPassenegerFirstName();
                    saveS_nameOfPass3 = cruise[x].getPassenger3().getPassengerSecondName();
                    saveExpensesOfPass3 = cruise[x].getPassenger1().getexpenses();

                    System.out.println("cabin " + (x + 1) + "s 1st passenger: " + saveF_nameOfPass3 + " " + saveS_nameOfPass3 + ": Rs " + saveExpensesOfPass3);

                }



            }
        }catch(InputMismatchException e){
            System.out.println("Input Mismatch Exception has occurred. "+e);

        }





        for (int t = 0; t < cruise.length; t++) {
            int savex;
            int savey;
            int savez;
            savex = cruise[t].getPassenger1().getexpenses();
            savex = cruise[t].getPassenger2().getexpenses();
            savex = cruise[t].getPassenger3().getexpenses();

        }

    }

    private static void initialise() {
        passenger temp_initialize = new passenger();

        // cabin[] cruise = new cabin[12];
        for (int x = 0; x < cruise.length; x++) {
            cruise[x] = new cabin();
            cruise[x].setPassenger1(temp_initialize);
            cruise[x].setPassenger2(temp_initialize);
            cruise[x].setPassenger3(temp_initialize);

        }
    }


}