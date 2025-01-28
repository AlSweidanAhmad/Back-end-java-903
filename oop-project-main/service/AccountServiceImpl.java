//package main.project.service;
package service;

import java.security.PublicKey;
import java.util.List;

import model.Account;
import model.Account;
import model.Ewallet;
import model.Ewallet;
//import main.project.model.Account;
//import main.project.model.Account;
//import main.project.model.Ewallet;
//import main.project.model.Ewallet;

public class AccountServiceImpl implements AccountService {

    Ewallet ewallet = Ewallet.getInstance();


    // Check if the account exists   
    private boolean isExistingAccount(Account account) {
    	List<Account> accounts = ewallet.getAccounts();
    	for (Account isAccount : accounts) 
    		if(isAccount.getUserName().equals(account.getUserName()))
    			return true;//Account exists 	
    	return false;//Account exists does not
	}
    
    
    @Override
    public Account geAccountByname(String name) {
		List<Account> accounts = ewallet.getAccounts();
		for (Account account : accounts) {
			if (account.getUserName().equals(name)) {
				return account;
			}
		}
		
    	 return  null;
	}
 
    
    @Override
    public boolean createAccount(Account account) {
        if (isExistingAccount(account)) {
            System.out.println("Account already exists with the same username.");
            return false;
        }

        this.ewallet.getAccounts().add(account); 
        return true;

    }

    
    @Override
    public boolean loginAccount(Account account) {

        List<Account> accounts = ewallet.getAccounts();
        System.out.println(accounts.size());
        for (Account isAccount : accounts) {
            if (isAccount.getUserName().equals(account.getUserName())) {
                if (isAccount.getPassword().equals(account.getPassword())) {
                    return true; // Login success
                } else {
                    System.out.println("Incorrect password.");
                    return false;
                }
            }
        }
        System.out.println("Account does not exist.");
        return false;
    }
    
    
    // Account validation
    @Override
    public boolean isValidAccount(Account account) {
       if (account == null) {
            System.out.println("Account not found");
            return false;
        }
        
    	if (!isExistingAccount(account)) {
            System.out.println("Account does not exist.");
            return false;
        }

        if (!account.getActive()) {
            System.out.println("Account is not active.");
            return false;
        }
    	return true;	
    }
    public boolean isDeposit(Account account, int amount) {

        List<Account> accounts = ewallet.getAccounts();     
        accounts.get(accounts.indexOf(account)).setBalance(account.getBalance() +amount);
    	return true;
    }
    
    
    public boolean isWithdraw(Account account, int amount) {
  
        List<Account> accounts = ewallet.getAccounts();     
        // Check sufficient balance
    	if (accounts.get(accounts.indexOf(account)).getBalance()<amount) {
    		System.out.println("Insufficient funds. Withdrawal failed.");
    		return false;
    	}
        accounts.get(accounts.indexOf(account)).setBalance(account.getBalance() -amount);
    	return true;
    }
    
    public boolean isTransfer(Account sender,Account receiver, int amount) {
    	if(isValidAccount(receiver)) {
    		List<Account> accounts = ewallet.getAccounts();
    		for (Account acc : accounts) {
    			if (acc.equals(sender)) {
    				acc.setBalance(acc.getBalance() - amount);
    				if (acc.equals(receiver)) {
						acc.setBalance(acc.getBalance() + amount);
						return true;
					}
    			}
    		}
    	}
    	System.out.println("Transfer failed due to receiver account issues.");
        return false;  
    }
    
    public boolean showBalance(Account account) {
    	  
    	if (isValidAccount(account))
    	{
    		List<Account> accounts = ewallet.getAccounts();
    		for (Account acc : accounts) {
    			if (acc.equals(account)) {
    				acc.getBalance();
    				return true;
    			}
    		}
    	}
    	
    	return false;
    	}
    
    public boolean showDetails(Account account) {
  	  
    	if (isValidAccount(account))
    	{
    		List<Account> accounts = ewallet.getAccounts();
    		for (Account acc : accounts) {
    			if (acc.equals(account)) {
    				acc.getUserName();
    				acc.getBalance();
    				acc.getActive();
    				
    				
    				return true;
    			}
    		}
    	}
    	
    	return false;
    	}
  
 
    
    
    
    
    // TODO create function with name deposit that return
    // TODO true if deposit success
    // TODO false if deposit fail
    // TODO check if account exist on wallet or not if not print account not exist
    // TODO check if account is active or not  if not print account not active
    // TODO make deposit

    // TODO without duplication
    // TODO make withdraw
    // TODO create function with name withdraw that return
    // TODO true if withdraw success
    // TODO false if withdraw fail
    // TODO check if account exist on wallet or not if not print account not exist
    // TODO check if account is active or not  if not print account not active
    // TODO check if account balance is greater than  money if not print can't deposit because ....
    // TODO make deposit



    // Transfer Account depositAccount, Account withdrawAccount, int money
    // TODO without duplication
    // TODO make Transfer
    // TODO create function with name transfer that return
    // TODO true if transfer success
    // TODO false if transfer fail
    // TODO check if depositAccount and withdrawAccount exist on wallet or not if not print account not exist
    // TODO check if depositAccount and withdrawAccount is active or not  if not print account not active
    // TODO check if withdrawAccount balance is greater than money if not print can't deposit because ....

    // TODO SHOW Account Details


    // TODO SHOW show Balance
}
