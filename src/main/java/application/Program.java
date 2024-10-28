package application;

import models.entities.Department;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(1, "Libray");
        System.out.println(department);
    }
}
