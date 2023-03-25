public class passenger {

    String PassenegerFirstName = "";  //PassenegerFirstName
    String PassengerSecondName = "";
    int expenses =0;
    int PassengerNumber = 0;

    public String getPassenegerFirstName() {
        return PassenegerFirstName==""?"empty":PassenegerFirstName;
    }


    public void setPassenegerFirstName(String PassenegerFirstName) {

        this.PassenegerFirstName = PassenegerFirstName;

    }

    public String getPassengerSecondName() {

        return PassengerSecondName==""? "empty" : PassengerSecondName;

    }



    public void setPassengerSecondName(String PassengerSecondName) {
        this.PassengerSecondName = PassengerSecondName;
    }

    public int getexpenses() {
        return expenses;
    }

    public void setexpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getPassengerNumber() {
        return PassengerNumber;
    }

    public void setPassengerNumber(int PassengerNumber) {
        this.PassengerNumber = PassengerNumber;
    }
}


