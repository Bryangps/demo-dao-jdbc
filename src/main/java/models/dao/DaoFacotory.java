package models.dao;

import db.DAO;
import models.dao.impl.SellerDaoJDBC;

public class DaoFacotory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DAO.getConnection());
    }
}