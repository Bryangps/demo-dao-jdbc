package application;

import models.entities.Department;
import models.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(1, "Libray");

        Seller seller = new Seller(1, "maria", "maria@gmail.com", new Date(), 3000.00, department);
        System.out.println(seller);
    }
}
