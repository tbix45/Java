public class BankAccount{


    //member variables 
    private double checkingBalance;
    private double savingsBalance;

    private double totalMoney=0;

    private static int numberOfAccounts=0;

    //constructors
    public BankAccount(){
        numberOfAccounts++;
    }

    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
        this.totalMoney= checkingBalance+savingsBalance;

    }

    //methods

    //deposit to either account and add to total amount stored
    public void deposit(String account, double amount){
        if(account.equals("checking")){
            this.checkingBalance+=amount;
        } else{
            this.savingsBalance+=amount;
        }
    }

    //withdraw from one account, cant if insufficient funds
    public void withdraw(String account, double amount){
        if(account.equals("checking")){
            if(this.checkingBalance-amount<0){
                System.out.printf("Not enough mula!\n");
            } else{
                this.checkingBalance-=amount;
            }
        } else{
            this.savingsBalance-=amount;
        }  
    }

    //see total money from checkings and savings
    public double showTotalMoney(){
        totalMoney= this.checkingBalance+ this.savingsBalance;
        return totalMoney;
    }

    //show total number of accounts
    public static int showTotalAccounts(){
        return numberOfAccounts;
    }

    //getters and setters

    //getter
    public double getCheckingBalance(){
        return checkingBalance;
    }

    //setter
    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    }

    //getter
    public double getSavingsBalance(){
        return savingsBalance;
    }

    //setter
    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

}