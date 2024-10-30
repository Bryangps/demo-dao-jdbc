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

        System.out.println("\n=== TEST 3: Department delete ===");
        departmentDao.deleteById(2);
        System.out.println("Delete completed");

        System.out.println("\n=== TEST 4: Department insert ===");
        Department newDepartment = new Department(null, "Celular");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 5: Department update ===");
        department = departmentDao.findById(6);
        department.setName("Fabrica");
        departmentDao.update(department);
        System.out.println("Update completed");

    }
}
