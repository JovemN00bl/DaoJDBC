package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerdao = DaoFactory.createSellerDao();

        System.out.println("------ TEST 1: Seller findById ------");
        Seller seller = sellerdao.findById(3);
        System.out.println(seller);
        System.out.println();

        System.out.println("------ TEST 2: Seller findByDepartment ------");
        Department dep = new Department(2, null);
        List<Seller> lst = sellerdao.findByDepartment(dep);
        for(Seller obj : lst){
            System.out.println(obj);
        }



    }
}