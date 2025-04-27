//package main.project.service;
package service;

//import main.project.model.Account;
import model.Account;

public interface AccountService {

    boolean createAccount(Account account);
    boolean loginAccount(Account account);
    boolean isValidAccount(Account account);
    Account geAccountByname(String name);

}
