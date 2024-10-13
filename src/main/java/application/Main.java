package application;

import model.entities.Department;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Department obj = new Department(1, "books");
        System.out.println(obj);


    }
}