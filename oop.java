//Parent class bank Account      

class BankAccount {
    private String accountHolderName;
    private double balance;

    //Constructor
    public BankAccount (String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    //Encapsulation: Getter and Setter
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName (String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
        
    //Method to Deposit Money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Amount:" + amount);

        } else {
            System.out.println("Invalid deposit amount");
        }    

    }

    //Method to Withdraw Money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw Amount:");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }

    }
    //Polymorphism Overridable Method
    public void displayAccountDetails() {
        System.out.println("Account holder : " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

}

//Child class: Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;

    //Constructor
    public SavingsAccount(String accountHolderName, double initialBalance, double interestRate) {
        super(accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }

    //Method to Calculate Interest
    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;

        System.out.println("Interest earned: " + interest);

    }

    //Overriding displayAccountDetails Method
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

}

//Child class: Current Account
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    //Constructor
    public CurrentAccount(String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;

    }

    //Overriding Withdraw method to allow overdraft
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            double newBalance = getBalance() - amount;
            if (newBalance < 0) {
                overdraftLimit += newBalance; //Reduce overdraft Limit
            }

        super.deposit(-amount);
        
        System.out.println("Withdraw Amount: " + amount);
        
        }else {
            System.out.println("Invalid withdrawal amount or overdraft limit exceeded");
        }
    }

        //Overriding displayAccountDetails Method
        @Override
        public void displayAccountDetails() {
            super.displayAccountDetails();
            System.out.println("Overdraft Limit: " + overdraftLimit);
        }

    }  
    
//Main class to test the banking system

public class oop {
    public static void main(String[] args) {
        
        //Creating a Savings Account
        SavingsAccount savings = new SavingsAccount("Mark", 5000, 3);
        savings.displayAccountDetails();
        savings.deposit(500);
        savings.calculateInterest();
        savings.withdraw(500);
        System.out.println();

        //Creating a Current Account
        CurrentAccount current = new CurrentAccount("John", 3000, 2000);
        current.displayAccountDetails();
        current.deposit(1500);
        current.deposit(500);

        current.displayAccountDetails();

    }
}





