import java.util.Scanner;

class ATM 
{
    private BankAccount bankAccount;
    
    public ATM(BankAccount bankAccount) 
    {
        this.bankAccount = bankAccount;
    }
    
    public void displayMenu() 
    {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    
    public void performTransaction(int choice, Scanner s) 
    {
        switch (choice) 
        {
            case 1:
                System.out.println("Current balance: Rs"+ bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: Rs");
                double depositAmount = s.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: Rs");
                double withdrawalAmount = s.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                s.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please select a valid option.");

        }
    }
}
public class ATM_Interface 
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);


        BankAccount bankAccount = new BankAccount(2000.0);

        ATM atm = new ATM(bankAccount);

        while (true) 
        {
            atm.displayMenu();
            System.out.print("Select an option: ");
            int choice = s.nextInt();

            atm.performTransaction(choice, s);
        }
    }
}