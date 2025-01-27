//package main.project.model;
package model;

import java.util.ArrayList;
import java.util.List;


// pls apply singleton
public class Ewallet {


    private String name = "EraaSoft Cash";

    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
