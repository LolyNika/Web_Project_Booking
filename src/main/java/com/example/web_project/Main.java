package com.example.web_project;

import com.example.web_project.controller.ControllerSwitch;

import static com.example.web_project.dao.Impl.ConnectionPool.createNewDBconnection;
import static com.example.web_project.view.ViewToConsole.menu;

/**
 * This class is Main, where we called all methods
 * @author LolyNika
 */
public class Main {
    public static void main(String[] args) {
        createNewDBconnection();
        ControllerSwitch controllerSwitch = new ControllerSwitch();
        while (true) {
            menu();
            //controllerSwitch.switch_menu();
        }
    }
}