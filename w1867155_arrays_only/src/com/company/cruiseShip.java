
package com.company;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.File;
import java.lang.String;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class cruiseShip {

    //Submmenu - To Loop the menubar
    //Menu1 - To get out of the menubar and process the personal details

    private static boolean Menu1 = true;
    private static boolean Menu2 = true;


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

        while (Menu1) {
            while (Menu2) {

                System.out.println("A: Book A New Cabin.");

                System.out.println("E: Display Empty cruise.");

                System.out.println("V: View all cruise.");

                System.out.println("D: Delete customer from a Cabin.");

                System.out.println("F: Find Cabin from customer name.");

                System.out.println("S: Store program data in to file.");

                System.out.println("L: Load program data from file.");

                System.out.println("O: View cruise Ordered alphabetically by name.");



                String Selection = input.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookAcabin(cruise ,roomNum);
                        break;
                    case "E":
                        CheckIfEmpty(cruise);
                        break;
                    case "V":
                        ViewAllcabins(cruise);
                        break;
                    case "D":
                        DeleteCustomerFromcabin(cruise, roomNum);
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



                    default:
                        System.out.println("Invalid Selection");
                        break;
                }

                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");

                if (input.nextInt() == 1) {
                    Menu2 = true;
                } else {
                    Menu2 = false;
                }
            }
            Menu2 = true;

            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");

            if (input.nextInt() == 1) {
                Menu1 = true;
            } else {
                System.out.println("Have a nice day!!");
                System.exit(0);

            }
        }
    }



    private static void initialise(cabin[] cruise) {
        for (int x = 0; x < cruise.length; x++) {
            cruise[x].setName("nobody");
        }
    }

    private static void CheckIfEmpty(cabin[] cruise) {
        for (int x = 0; x < cruise.length; x++) {
            if (cruise[x].getName().equals("nobody")) {
                System.out.println("cabin " + (x + 1) + " is empty");
            }
        }
    }

    private static void BookAcabin(cabin[] cruise, int roomNum) {

        try{

            String cabinName;
            Scanner input = new Scanner(System.in);

            for (int x = 0; x < cruise.length; x++) {
                int z = 12;
                if (cruise.length>12){
                    System.out.println("All cabins are occupied");
                }
            }

            System.out.println("Enter cabin number (1-12):");
            roomNum = input.nextInt() - 1;
            System.out.println("Enter name for cabin " + (roomNum + 1) + " :");
            cabinName = input.next();
            cruise[roomNum].setName(cabinName);

            for (int x = 0; x < cruise.length; x++) {
                int z = 12;
                if (cruise.length>12){
                    System.out.println("All cabins are occupied");
                }
            }


        }catch(InputMismatchException e){
            System.out.println("Input Mismatch Exception has occurred. "+e);

        }


    }

    private static void ViewAllcabins(cabin[] cruise) {
        for (int x = 0; x < cruise.length; x++) {
            System.out.println("cabin " + (x + 1) + " occupied by " + cruise[x].getName());
        }
    }

    private static void DeleteCustomerFromcabin(cabin[] cruise, int roomNum) {

        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter cabin number to delete(1-12):");
            roomNum = input.nextInt() - 1;
            cruise[roomNum].setName("nobody");
            System.out.println("Entry Deleted ");

        }catch(InputMismatchException e){
            System.out.println("Input Mismatch Exception has occurred. "+e);}



    }

    private static void FindcabinFromCustomerName(cabin[] cruise) {
        Scanner input = new Scanner(System.in);
        String cabinName;
        System.out.println("Enter name to Search for:");
        cabinName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < cruise.length; x++) {
            if (cabinName.equals(cruise[x].getName())) {
                System.out.println("The Customer That Matches That name is in " + x+"th cabin");
                Checker = true;
            }
        }
        if (Checker == false) {
            System.out.println("There are no Cabins Booked with that name\\n(make sure you've used the correct words");
        }
    }

    private static void StoreProgramDataInToFile(cabin[] cruise) throws IOException {

        try (PrintWriter out = new PrintWriter(new FileWriter("Array.txt"))) {

            for (int x = 0; x < cruise.length; x++) {
                out.println(  cruise[x].getName()   );
            }

        }
        System.out.println("All Room Names have been Saved.");

    }



    private static void LoadProgramDataFromFile(cabin[] cruise){

        try {
            File myobjct = new File("Array.txt");
            Scanner myscan = new Scanner(myobjct);


            while (myscan.hasNextLine()) {
                for (int k=0;k<cruise.length;k++){
                    if(Objects.equals(cruise[k], "Empty ")) {
                        cruise[k].setName("empty");;
                    }

                    else {
                        cruise[k].setName(myscan.nextLine()); ;
                    }

                }



            }
            myscan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();


    }

}

    private static void ViewcabinsOrderedAlphabeticallyByName(cabin[] cruise) {

    /*    String[] sorted_list= new String[cruise.length];
        for (int i=0;i< sorted_list.length; i++){
            sorted_list[i]= cruise[i];
        }

        for(int i = 0; i< sorted_list.length; i++) {
            for (int j = i + 1; j < (sorted_list.length); j++) {
                if ((sorted_list[i].compareTo(sorted_list[j])) > 0) {
                    String temp_store = sorted_list[i];
                    sorted_list[i] = sorted_list[j];
                    sorted_list[j] = temp_store;
                }
            }

        }*/


    }

    public static class cabin {

        //protected String mainName;
        private String mainName;
        int guestsIncabin;

        public cabin() {
            mainName = "k";

        }

        public void setName(String aName) {
            //  System.out.println("add name class method ");
            mainName = aName;
        }

        public String getName() {
            return mainName;
        }
    }
}

