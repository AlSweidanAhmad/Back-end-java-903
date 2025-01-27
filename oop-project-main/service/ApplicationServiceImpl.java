package service;
//package main.project.service;


import model.Account;
//import main.project.model.Account;
//import main.project.model.Account;



import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {
//    private Scanner scanner = new Scanner(System.in);
//    private ValidationService validationService = new ValidationServiceImpl();
//    private AccountService accountService = new AccountServiceImpl();
	@Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
		
        int ac = 0;
        System.out.println("Welcome Sir");

        // TODO on case (Invalid Choose) repeat for 4 times
        do
        {	
        System.out.println("Please Enter your choose");
        System.out.println("a.login     b.signup   c.exit");		
        char choose = scanner.next().charAt(0);
//        scanner.nextLine();
        switch (choose) {
            case 'a':
                login();
                ac = 4;
                break;
            case 'b':
                signup();
                ac = 4;
                break;
            case 'c':
                System.out.println("you are welcome.");
                ac = 4;
                break;
            default:
                System.out.println("Oops,Invalid Choose");
                ac++;
        }
        }while(ac < 4);
        scanner.close();
    }
       private void signup() {

           Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter User name");
        String name = scanner.nextLine();

        System.out.println("Please Enter password");
        String password = scanner.nextLine();

        ValidationService validationService = new ValidationServiceImpl();

        // TODO Validation on UserName and Password
        if (!validationService.validateUserName(name)) { // "eslam"
            System.out.println("Invalid UserName");
            return;
        }

        if (!validationService.validatePassword(password)) {
            System.out.println("Invalid Password");
            return;
        }

        // TODO SERVICE OF ACCOUNT TO CREATE ACCOUNT

        AccountService accountService = new AccountServiceImpl();
        Account account = new Account(name, password);
        // TODO   impl createAccount
        boolean isAccountCreated = accountService.createAccount(account);
        if (isAccountCreated) {
            System.out.println("Account Created");
        } else {
            System.out.println("Account not Created Because There exist account with same user name");
        }

    }
    /**
     * 
     */
    private void login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter User name");
        String name = scanner.nextLine();

        System.out.println("Please Enter password");
        String password = scanner.nextLine();

       ValidationService validationService = new ValidationServiceImpl();

        // TODO Validation on UserName and Password
        if (!validationService.validateUserName(name)) {
            System.out.println("Invalid UserName");
            return;
        }

        if (!validationService.validatePassword(password)) {
            System.out.println("Invalid Password");
            return;
        }

       AccountService accountService = new AccountServiceImpl();
        // TODO SERVICE OF ACCOUNT TO LOGIN
        if (accountService.loginAccount(new Account(name, password))) {
            System.out.println("Login Success");
            services();
        } else {
            System.out.println("Account not Exist");
        }

    }
    private void services() {
    	Account account = new Account();
        Scanner scanner = new Scanner(System.in);

    	char choose;
        do {
			
        System.out.println("1.Deposit   2.Withdraw    3.show details    4.Transfer    5. show balance   6.exit");
        System.out.print("Please enter your choice: ");
        choose = scanner.next().charAt(0);
        
        // TODO create switch case such as on run function
        switch (choose) {
        case '1':
            deposit(account);
            break;
        case '2':
            withdraw(account);
            break;
        case '3':
            System.out.println("EraaSoft Cash");
            showDetails(account);
            break;
        case '4':
        	transfer(account);
            
            break;
        case '5':

        	showBalance(account);
            break;
        case '6':
            System.out.println("EraaSoft wishes you a wonderful day. Thank you for using our service!");
            break;
        default:
            System.out.println("Invalid Choose");
            services();
		}
        } while (choose != 6);        // TODO create switch case such as on run function
        // TODO every case on switch call function  don't forget (Invalid choose)
        scanner.close();
    }
    // # create deposit function
    void deposit(Account account){
      Scanner scanner = new Scanner(System.in);
      AccountServiceImpl accountService= new AccountServiceImpl();
      ValidationServiceImpl validationService = new ValidationServiceImpl();
      final int minAmount = 100;
      final int maxAmount = 20000;
      int amount;
      
      System.out.println("Enter the amount between " + minAmount + " and " + maxAmount + " to deposit:");
      amount = scanner.nextInt();
  	  
      // Validation of the amount
      if (!validationService.validateAmount(amount,minAmount,maxAmount)) {
          System.out.println("Deposit failed due to invalid amount.");
          return;
      }
      // Validation of the Account
      if (!accountService.isValidAccount(account)) {
          System.out.println("Deposit failed due to account issues.");
          return;
      }
      
      // Make a deposit
      account.setBalance(account.getBalance() + amount);
      System.out.println("Deposit successful. New balance: " + account.getBalance());
	

  }
    
    // # create Withdraw function
  	void withdraw(Account account){
//        ValidationServiceImpl validateAmount = new ValidationServiceImpl();
//        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
        Scanner scanner = new Scanner(System.in);
        AccountServiceImpl accountService= new AccountServiceImpl();
        ValidationServiceImpl validationService = new ValidationServiceImpl();

        final int minAmount = 100;
        final int maxAmount = 8000;
        int amount;
        
        System.out.println("Enter the amount between " + minAmount + " and " + maxAmount + " to Withdraw:");
        amount = scanner.nextInt();
    	  
        // Validation of the amount
        if (!validationService.validateAmount(amount,minAmount,maxAmount)) {
            System.out.println("Withdraw failed due to invalid amount.");
            return;
        }
        // Validation of the Account
        if (!accountService.isValidAccount(account)) {
            System.out.println("Withdraw failed due to account issues.");
            return;
        }
        // Check sufficient balance
        if (account.getBalance() < amount) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return;
        }
        
        // Make a Withdrawal
  		account.setBalance(account.getBalance() - amount);
  		System.out.println("Withdrawal successful. New balance: " + account.getBalance());

  	}
  	// #
    void showDetails(Account account)
    {	
        AccountServiceImpl accountService = new AccountServiceImpl();

        // // validate Accounts
        if (!accountService.isValidAccount(account)) {
            System.out.println("showDetails failed due to account issues.");
            return;
        }

        // Details anzeigen
        System.out.println("Account Details:");
        System.out.println("Name: " + account.getUserName());
        System.out.println("Status: Active");
        System.out.println("Balance: " + account.getBalance());
        // System.out.println("Status: " + (account.getActive() ? "Active" : "Inactive"));
    }
    void showBalance(Account account)
    {	
        AccountServiceImpl accountService = new AccountServiceImpl();

        // validate Accounts
        if (!accountService.isValidAccount(account)) {
            System.out.println("showDetails failed due to account issues.");
            return;
        }
        // Balance show

        System.out.println("Balance: " + account.getBalance());
    }
    // #    
    void transfer(Account withdrawAccount){
        Scanner scanner = new Scanner(System.in);
        AccountServiceImpl accountService= new AccountServiceImpl();
        ValidationServiceImpl validationService = new ValidationServiceImpl();

        int amount;
        final int minAmount = 1;
        final int maxAmount =  (int) withdrawAccount.getBalance();

        
        System.out.println("Enter the amount between " + minAmount + " and " + maxAmount + " to Transfer:");
        amount = scanner.nextInt();
    	  
        // Check sufficient balance
        if (withdrawAccount.getBalance() < amount) {
            System.out.println("Insufficient funds. Transfer failed.");
            return;
        }
        
        // Validation of the amount
        if (! validationService.validateAmount(amount,  minAmount, maxAmount)) {
            System.out.println("Transfer failed due to invalid amount.");
            return;
        }
        // Validation of the Account
        if (!accountService.isValidAccount(withdrawAccount)) {
            System.out.println("Transfer failed due to sender account issues.");
            return;
        }

        String receiverName;
        System.out.println("Please enter the Receiver name: ");
        receiverName = scanner.nextLine();
        Account receiverAccount = accountService.geAccountByname(receiverName);

        
        if (!accountService.isValidAccount(receiverAccount)) {
            System.out.println("Transfer failed due to receiver account issues.");
            return;
        }
		
        withdrawAccount.setBalance(withdrawAccount.getBalance() - amount);
		receiverAccount.setBalance(receiverAccount.getBalance() + amount);
        System.out.println("Transfer successful.");
        	

    }


}
