package application;

import models.dao.DaoFacotory;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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


        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(),
                4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " +  newSeller.getId());


        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(6);
        seller.setName("Silva");
        seller.setEmail("silva@gmail.com");
        seller.setBirthDate(sdf.parse("17/11/2001"));
        seller.setBaseSalary(4000.0);
        sellerDao.update(seller);
        System.out.println("Update completed");


        System.out.println("\n=== TEST 6: seller delete ===");
        sellerDao.deleteById(9);
        System.out.println("Delete completed");

    }
}
