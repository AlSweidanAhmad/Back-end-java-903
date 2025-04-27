//package main.project.model;
package model;

import java.util.ArrayList;
import java.util.List;


// pls apply singleton
public class Ewallet {

	private static Ewallet instance;
    private String name = "EraaSoft Cash";

    private List<Account> accounts = new ArrayList<>();
    
    public static Ewallet getInstance() {
        if (instance == null) { // Falls noch keine Instanz existiert
            instance = new Ewallet(); // Erstellt die einzige Instanz
        }
        return instance; // Gibt die gleiche Instanz zurück
    }



    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
