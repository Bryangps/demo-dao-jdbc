package application;

import models.dao.DaoFacotory;
import models.dao.DepartmentDao;
import models.entities.Department;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFacotory.createDepartmentDao();

        System.out.println("=== TEST 1: seller findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);

    }
}
