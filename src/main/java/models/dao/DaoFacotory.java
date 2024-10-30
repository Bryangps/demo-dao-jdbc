package models.dao;

import db.DAO;
import models.dao.impl.DepartmentDaoJDBC;
import models.dao.impl.SellerDaoJDBC;

public class DaoFacotory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DAO.getConnection());
    }

    public static DepartmentDaoJDBC createDepartmentDao(){
        return new DepartmentDaoJDBC(DAO.getConnection());
    }
}
