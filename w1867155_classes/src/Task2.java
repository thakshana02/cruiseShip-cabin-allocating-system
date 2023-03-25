
import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Task2 {

    private static boolean MainMenu = true;
    private static boolean SubMenu = true;


    public static void main(String[] args) throws IOException {
    


        Scanner input = new Scanner(System.in);
        cabin[] cruise = new cabin[12];

        for (int i = 0; i < cruise.length; i++) {
            cruise[i] = new cabin();

        }

        int CabinNumber;
        initialise(cruise);

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
                    BookAcabin(next_number, roomNum, cruise);
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

    private static void initialise(cabin[] cruise) {
        passenger temp = new passenger();

        cabin[] cabin_initialize = new cabin[12];
        for (int x = 0; x < cabin_initialize.length; x++) {
            cabin_initialize[x] = new cabin();
            cabin_initialize[x].setPassenger1(temp);
            cabin_initialize[x].setPassenger2(temp);
            cabin_initialize[x].setPassenger3(temp);

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

    private static void BookAcabin(int next_number, int roomNum, cabin[] cruise) {

        try{
            double exp;
            String roomName;


            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number (1-12):");
            roomNum = input.nextInt() - 1;

            System.out.println("Enter the slot to book (1-3):");
            next_number = input.nextInt() - 1; //number of the name

            if (next_number == 0) {
                System.out.println("Enter first name");
                cruise[roomNum].getPassenger1().setPassenegerFirstName(input.next());
                System.out.println("Enter second name");
                cruise[roomNum].getPassenger1().setPassengerSecondName(input.next());
                System.out.println("Enter expenses");
                cruise[roomNum].getPassenger1().setexpenses(input.nextInt());

            } else if (next_number == 1) {
                System.out.println("Enter first name");
                cruise[roomNum].getPassenger2().setPassenegerFirstName(input.next());
                System.out.println("Enter second name");
                cruise[roomNum].getPassenger2().setPassengerSecondName(input.next());
                System.out.println("Enter expenses");
                cruise[roomNum].getPassenger2().setexpenses(input.nextInt());
            } else if (next_number == 2) {
                System.out.println("Enter first name");
                cruise[roomNum].getPassenger3().setPassenegerFirstName(input.next());
                System.out.println("Enter second name");
                cruise[roomNum].getPassenger3().setPassengerSecondName(input.next());
                System.out.println("Enter expenses");
                cruise[roomNum].getPassenger3().setexpenses(input.nextInt());
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
                String NextPassenger1 = cruise[x +1].getPassenger1().getPassenegerFirstName();

                System.out.println("1st passenger is the "+NextPassenger1 + "  in cabin " + (x + 1));


            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 1 is Empty");


            }
            if (passenger2_data != "empty") {
                String NextPassenger2 = cruise[x+1].getPassenger2().getPassenegerFirstName();

                System.out.println("2nd passenger is the "+ NextPassenger2 + "  in cabin " + (x + 1));


            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 2 is Empty");


            }
            if (passenger3_data != "empty") {
                String NextPassenger3 = cruise[x+1].getPassenger3().getPassenegerFirstName();

                System.out.println("2nd passenger is the "+ NextPassenger3 + "  in cabin " + (x + 1));

            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 3 is Empty");

            }

        }

    }

    private static void DeleteCustomerFromcabin(cabin[] cruise, int roomNum, int next_number) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter cabin number to delete(1-12):");
            roomNum = input.nextInt() - 1;
            System.out.println("Enter the slot to delete");
            next_number = input.nextInt() - 1;

            passenger delete_temp = new passenger();


            if (next_number == 0) {
                cruise[roomNum].setPassenger1(delete_temp);
            } else if (next_number == 1) {
                cruise[roomNum].setPassenger2(delete_temp);

            } else if (next_number == 2) {
                cruise[roomNum].setPassenger3(delete_temp);

            }


            System.out.println("Entry Deleted ");

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
                System.out.println("1st passenger is the "+roomName + " in cabin " + (x + 1));


            } else if (passenger2_data.equals(roomName)) {
                System.out.println("1st passenger is the "+roomName + " in cabin " + (x + 1));

            } else if (passenger3_data.equals(roomName)) {
                System.out.println("1st passenger is the "+roomName + " in cabin " + (x + 1));

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

            int saveExpensesOfPass1 ;
            int saveExpensesOfPass2;
            int saveExpensesOfPass3;

            String  GetPass1Data;
            String  GetPass2Data;
            String  GetPass3Data;

            String emp="empty";

            for (int x = 0; x < cruise.length; x++) {

                GetPass1Data=cruise[x].getPassenger1().getPassenegerFirstName();
                GetPass2Data=cruise[x].getPassenger2().getPassenegerFirstName();
                GetPass3Data=cruise[x].getPassenger3().getPassenegerFirstName();


                if (!GetPass1Data.equals(emp)) {

                    saveF_nameOfPass1 = cruise[x].getPassenger1().getPassenegerFirstName();
                    saveS_nameOfPass1 = cruise[x].getPassenger1().getPassengerSecondName();
                    saveExpensesOfPass1 = cruise[x].getPassenger1().getexpenses();

                    out.println("1st passenger is occupied by "+ saveF_nameOfPass1 + " " + saveS_nameOfPass1+" for : Rs "+ saveExpensesOfPass1 + "in cabin" + (x));
                }else{
                    out.println("cabin "+(x)+": 1st passenger is empty " );

                }

                if (!GetPass2Data.equals(emp)) {

                    saveF_nameOfPass2 = cruise[x].getPassenger2().getPassenegerFirstName();
                    saveS_nameOfPass2 = cruise[x].getPassenger2().getPassengerSecondName();
                    saveExpensesOfPass2 = cruise[x].getPassenger1().getexpenses();

                    out.println("1st passenger is occupied by "+ saveF_nameOfPass2 + " " + saveS_nameOfPass2+" for : Rs "+ saveExpensesOfPass2 + "in cabin" + (x));
                }else{
                    out.println("cabin "+(x)+": 2nd passenger is empty " );

                }

                if (!GetPass3Data.equals(emp)) {

                    saveF_nameOfPass3 = cruise[x].getPassenger3().getPassenegerFirstName();
                    saveS_nameOfPass3 = cruise[x].getPassenger3().getPassengerSecondName();
                    saveExpensesOfPass3 = cruise[x].getPassenger1().getexpenses();

                    out.println("1st passenger is occupied by "+ saveF_nameOfPass3 + " " + saveS_nameOfPass3+" for : Rs "+ saveExpensesOfPass3 + "in cabin" + (x));
                }else{
                    out.println("cabin "+(x)+": 3rd passenger is empty " );

                }

            }

        }
        System.out.println("All Names have been Saved.");
    }


   private static void LoadProgramDataFromFile(cabin[] cruise) {
        try {
            File inputFile = new File("Array.txt");
            Scanner rf = new Scanner(inputFile);


            while (rf.hasNextLine()) {
                for (int k = 0; k < 36; k++) {
                    System.out.println(rf.nextLine());

                }

            }
            rf.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();

        }

    }



    public static void Viewexpenses( cabin[] cruise){



        String save1;
        String save2;
        String save3;
        String save4;
        String save5;
        String save6;

        Integer savea;
        Integer saveb;
        Integer savec;


        String  trigger1;
        String  trigger2;
        String  trigger3;

        String emp="empty";
        int total2=0;
        Integer totalExp=0;

        for (int x = 0; x < cruise.length; x++) {

            trigger1=cruise[x].getPassenger1().getPassenegerFirstName();
            trigger2=cruise[x].getPassenger2().getPassenegerFirstName();
            trigger3=cruise[x].getPassenger3().getPassenegerFirstName();

            if (!trigger1.equals(emp)) {

                save1 = cruise[x].getPassenger1().getPassenegerFirstName();
                save2 = cruise[x].getPassenger1().getPassengerSecondName();
                savea = cruise[x].getPassenger1().getexpenses();

                System.out.println("cabin "+(x+1)+"s 1st passenger: "+ save1 + " " + save2+": Rs "+ savea );
                totalExp=totalExp+savea;

            }


            if (!trigger2.equals(emp)) {

                save3 = cruise[x].getPassenger2().getPassenegerFirstName();
                save4 = cruise[x].getPassenger2().getPassengerSecondName();
                saveb = cruise[x].getPassenger2().getexpenses();

                System.out.println("cabin "+(x+1)+"s 2nd passenger: "+ save3 + " " + save4+": Rs "+ saveb );     //+ ": Rs." + save3
                totalExp=totalExp+saveb;
            }


            if (!trigger3.equals(emp)) {

                save5 = cruise[x].getPassenger3().getPassenegerFirstName();
                save6 = cruise[x].getPassenger3().getPassengerSecondName();
                savec = cruise[x].getPassenger3().getexpenses();

                System.out.println("cabin "+(x+1)+"s 1st passenger: "+ save5 + " " + save6+": Rs "+ savec );     //+ ": Rs." + save3
                totalExp=totalExp+savec;
            }



        }

        System.out.println("Total expences of all the cruise are: Rs "+totalExp);


    }

    public static void ViewRoomsOrderedAlphabeticallyByName(cabin[] cabins){
        String save1;
        String save3;
        String save5;

        String  trigger1;
        String  trigger2;
        String  trigger3;

        String emp="empty";
        int count=0;


        for (int x = 0; x < cabins.length; x++) {

            trigger1 = cabins[x].getPassenger1().getPassenegerFirstName();
            trigger2 = cabins[x].getPassenger2().getPassenegerFirstName();
            trigger3 = cabins[x].getPassenger3().getPassenegerFirstName();


            if (!trigger1.equals(emp)) {

                save1 = cabins[x].getPassenger1().getPassenegerFirstName();
                count++;

            }

            if (!trigger2.equals(emp)) {

                save3 = cabins[x].getPassenger2().getPassenegerFirstName();
                count++;

            }

            if (!trigger3.equals(emp)) {

                save5 = cabins[x].getPassenger3().getPassenegerFirstName();
                count++;

            }
        }

        String myArraylist[]=new String[count];
        int arrcount=0;

        String savea;
        String saveb;
        String savec;


        String  trigger4;
        String  trigger5;
        String  trigger6;

        for (int i=0;i< cabins.length;i++){
            trigger4 = cabins[i].getPassenger1().getPassenegerFirstName();
            trigger5 = cabins[i].getPassenger2().getPassenegerFirstName();
            trigger6 = cabins[i].getPassenger3().getPassenegerFirstName();

            if (!trigger4.equals(emp)) {

                savea = cabins[i].getPassenger1().getPassenegerFirstName();
                myArraylist[arrcount]=savea;
                arrcount++;


            }

            if (!trigger5.equals(emp)) {

                saveb = cabins[i].getPassenger2().getPassenegerFirstName();
                myArraylist[arrcount]=saveb;
                arrcount++;

            }

            if (!trigger6.equals(emp)) {

                savec = cabins[i].getPassenger3().getPassenegerFirstName();
                myArraylist[arrcount]=savec;
                arrcount++;

            }



        }
        System.out.println(arrcount);

        for(int u = 0; u< myArraylist.length; u++) {
            for (int j = u + 1; j < (myArraylist.length); j++) {
                if ((myArraylist[u].compareTo(myArraylist[j])) > 0) {
                    String temp_store = myArraylist[u];
                    myArraylist[u] = myArraylist[j];
                    myArraylist[j] = temp_store;
                }
            }

        }



        for (int s=0;s<myArraylist.length;s++){
            System.out.println(myArraylist[s]);

        }


    }


       /* String saveF_nameOfPass1;
        String saveS_nameOfPass1;
        String saveF_nameOfPass2;
        String saveS_nameOfPass2;
        String saveF_nameOfPass3;
        String saveS_nameOfPass3;


        String  GetPass1Data;
        String  GetPass2Data;
        String  GetPass3Data;

        String emp="empty";
        int total2=0;

        for (int x = 0; x < cruise.length; x++) {

            GetPass1Data=cruise[x].getPassenger1().getPassenegerFirstName();
            GetPass2Data=cruise[x].getPassenger2().getPassenegerFirstName();
            GetPass3Data=cruise[x].getPassenger3().getPassenegerFirstName();

            int saveExpensesOfPass1;
            int saveExpensesOfPass2;
            int saveExpensesOfPass3;


            if (!GetPass1Data.equals(emp)) {

                saveF_nameOfPass1 = cruise[x].getPassenger1().getPassenegerFirstName();
                saveS_nameOfPass1 = cruise[x].getPassenger1().getPassengerSecondName();
                saveExpensesOfPass1 = cruise[x].getPassenger1().getexpenses();


                System.out.println("1st passenger is occupied by "+ saveF_nameOfPass1 + " " + saveS_nameOfPass1+"for : Rs "+ saveExpensesOfPass1 + "in cabin" +(x+1));     //+ ": Rs." + saveF_nameOfPass2
            }

            if (!GetPass2Data.equals(emp)) {

                saveF_nameOfPass2 = cruise[x].getPassenger2().getPassenegerFirstName();
                saveS_nameOfPass2 = cruise[x].getPassenger2().getPassengerSecondName();
                saveExpensesOfPass2 = cruise[x].getPassenger1().getexpenses();

                System.out.println("1st passenger is occupied by "+ saveF_nameOfPass2 + " " + saveS_nameOfPass2+"for : Rs "+ saveExpensesOfPass2 + "in cabin" +(x+1));     //+ ": Rs." + saveF_nameOfPass2
            }


            if (!GetPass3Data.equals(emp)) {

                saveF_nameOfPass3 = cruise[x].getPassenger3().getPassenegerFirstName();
                saveS_nameOfPass3 = cruise[x].getPassenger3().getPassengerSecondName();
                saveExpensesOfPass3 = cruise[x].getPassenger1().getexpenses();

                System.out.println("1st passenger is occupied by "+ saveF_nameOfPass3 + " " + saveS_nameOfPass3+"for : Rs "+ saveExpensesOfPass3 + "in cabin" +(x+1));    //+ ": Rs." + saveF_nameOfPass2
            }

               }

             for (int t=0;t<cruise.length;t++){
                    int savex;
                    int savey;
                    int savez;
               savex = cruise[t].getPassenger1().getexpenses();
               savex = cruise[t].getPassenger2().getexpenses();
               savex = cruise[t].getPassenger3().getexpenses();


        }*/

               /*  private static void order(cabin[] cruise) {


      String[] sorted_list= new String[cruise.length];
        for (int i=0;i< sorted_list.length; i++){
            sorted_list[i]= cruise[i];
        }
        //https://www.w3schools.com/java/ref_string_compareto.asp
        for(int i = 0; i< sorted_list.length; i++) {
            for (int j = i+1; j< (sorted_list.length); j++) {
                if((sorted_list[i].compareTo(sorted_list[j]))>0) {
                    String temp_store = sorted_list[i];
                    sorted_list[i] = sorted_list[j];
                    sorted_list[j] = temp_store;
                }
            }


    }*/


    }




