package models.dao;

import models.dao.impl.SellerDaoJDBC;

public class DaoFacotory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
