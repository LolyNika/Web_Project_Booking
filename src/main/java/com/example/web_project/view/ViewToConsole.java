package com.example.web_project.view;


import java.util.Scanner;

/**
 * This class is used to display actions in the console
 * @author LolyNika
 */
public class ViewToConsole {
    /** Method that outputs CRUD operations to the console */
    public static void menu() {
        System.out.println("1) Create table Booking");
        System.out.println("2) Create table Guest");
        System.out.println("3) Create table Room");
        System.out.println("4) Add data to a table Booking");
        System.out.println("5) Add data to a table Guest");
        System.out.println("6) Add data to a table Room");
        System.out.println("7) Get data from a table Booking");
        System.out.println("8) Get data from a table Guest");
        System.out.println("9) Get data from a table Room");
        System.out.println("10) Update data from the table Booking");
        System.out.println("11) Update data from the table Guest");
        System.out.println("12) Update data from the table Room");
        System.out.println("13) Delete data from the table Booking ПО ID!!");
        System.out.println("14) Delete data from the table Guest");
        System.out.println("15) Delete data from the table Room");
        System.out.println("16) Searching in table Booking по ID!!!");
    }
    /** Method that outputs info to entrance to Account to the console */
    public void entranceAcc() {
        System.out.println("Вход в аккаунт");
        System.out.println("1 - Создать новый аккаунт");
        System.out.println("2 - Войти в аккаунт");
    }
    /** Method to entrance to Account to the console */
    public void accountLogin() {
        System.out.println("ВХОД В АККАУНТ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String nickname = scanner.next();
        System.out.println("Введите пароль: ");
        String password = scanner.next();
        System.out.println("Введите имя: " + nickname);
        System.out.println("Введите пароль: " + password);
//        if (nickname == ){
//            System.out.println("You`re finally access");
//        } else {
//            System.out.println("Error to access");
//        }
        System.out.println("Вы успешно вошли в аккаунт");
    }
}
