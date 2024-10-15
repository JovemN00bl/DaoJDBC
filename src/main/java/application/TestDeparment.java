package application;

import model.dao.DaoFactory;
import model.dao.DepartmaneDao;
import model.entities.Department;

import java.util.List;

public class TestDeparment {

    public static void main(String[] args){
        DepartmaneDao dpDao = DaoFactory.createDepartmentDao();

        System.out.println("------ TEST 1: Department Insert ------");
        //dpDao.insert(new Department(null,"Artist"));
        System.out.println();

        System.out.println("------ TEST 2: Department findById ------");
        Department dpp = dpDao.findById(5);
        System.out.println(dpp);
        System.out.println();

        System.out.println("------ TEST 3: Department Update ------");
        dpp.setName("Novo");
        dpDao.update(dpp);
        System.out.println();

        System.out.println("------ TEST 4: Department Delete ------");
        dpDao.deleteById(8);
        System.out.println();

        System.out.println("------ TEST 5: Department findAll ------");
        List<Department> lst = dpDao.findAll();
        for(Department dp : lst){
            System.out.println(dp);
        }







    }
}
