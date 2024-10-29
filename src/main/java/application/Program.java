package application;

import models.dao.DaoFacotory;
import models.dao.SellerDao;
import models.entities.Seller;


public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFacotory.createSellerDao();

        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
