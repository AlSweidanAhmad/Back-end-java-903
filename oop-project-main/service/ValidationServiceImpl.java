//package main.project.service;
package service;

import model.Account;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validateUserName(String userName) {
    	  
    	if (userName.length() <= 3 
    		|| userName.isEmpty()
    		|| !(Character.isUpperCase(userName.charAt(0)))) {
			
    		return false;
		}
    	
        return true;
    }

    
    @Override
    public boolean validatePassword(String password) {
        if(password.length()<4 || password.isEmpty())
        	return false;
        
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        for (char checkChar : password.toCharArray()) {
        	if (Character.isUpperCase(checkChar)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(checkChar)) {
                hasLowercase = true;
            } else if (Character.isDigit(checkChar)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(checkChar)) {
                hasSpecialChar = true;
            } else if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
                break;
            }
		}
        	
        return hasDigit&&hasLowercase&&hasSpecialChar&&hasUppercase;
    }
    
    
    @Override
    public boolean validateAmount(int amount , int minAmount, int maxAmount) {
    	if(!(amount >= minAmount && amount <=maxAmount)) {
    		System.out.println("Invalid amount. Please enter a value between " +  minAmount + " and " + maxAmount);
    		return false;
    	}
    	return true;
    }
    
}
