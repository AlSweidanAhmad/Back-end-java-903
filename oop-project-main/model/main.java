//package main.project.model;
package model;

//import main.project.service.AccountServiceImpl;
//import main.project.service.ApplicationServiceImpl;
import service.AccountServiceImpl;
import service.ApplicationServiceImpl;

public class main {
    public static void main(String[] args) {
        new ApplicationServiceImpl().run();

    }
}
