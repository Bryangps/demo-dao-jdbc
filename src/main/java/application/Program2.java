package application;

import models.dao.DaoFacotory;
import models.dao.DepartmentDao;
import models.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFacotory.createDepartmentDao();

        System.out.println("=== TEST 1: Departement findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("\n=== TEST 2: Department findAll ===");
        List<Department> departments = departmentDao.findAll();
        for (Department dep : departments){
            System.out.println(dep);
        }

    }
}