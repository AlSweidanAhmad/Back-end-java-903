package service;
//package main.project.service;

public interface ValidationService {


    boolean validateUserName(String userName);
    boolean validatePassword(String password);
    boolean validateAmount(int amount , int minAmount, int maxAmount);

}
