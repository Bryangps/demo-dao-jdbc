package application;

import models.dao.DaoFacotory;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

import java.util.List;


public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFacotory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }
    }
}
