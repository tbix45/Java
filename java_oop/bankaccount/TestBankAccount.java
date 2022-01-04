public class TestBankAccount{
    public static void main(String[] args){


        BankAccount account1 = new BankAccount(100.0, 200.0);
        BankAccount account2 = new BankAccount(0.0,51.0);
        BankAccount account3 = new BankAccount(0.0,51.0);
        BankAccount account4 = new BankAccount(0.0,51.0);

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        System.out.println(account2.getCheckingBalance());
        System.out.println(account2.getSavingsBalance());
        // System.out.printf("Total money in %s: %s\n", account1, BankAccount.showTotalMoney());
        account2.deposit( "checking", 500);
        System.out.println(account2.getCheckingBalance());
        // account2.withdraw("checking", 500);
        // System.out.println(account2.getCheckingBalance());
        System.out.printf("All money in Account 2: %s\n", account2.showTotalMoney());
        System.out.printf("Total # of Accounts: %s\n", BankAccount.showTotalAccounts());

    }
}