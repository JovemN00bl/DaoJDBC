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
        System.out.println();

        //System.out.println("------ TEST 4: Seller insert ------");
        //Department dp = new Department(1, null);
        //sellerdao.insert(new Seller(dp,11, "LOUCO1", "LOCUO1@gmail.com", new Date(21/2/2003),3000.00 ));
        //System.out.println();



        System.out.println("------ TEST 5: Seller Update ------");
        sellerdao.update(new Seller(dep,10,"Louca1", "Louca1@hotmail.com", new Date(), 1000.00));
        System.out.println();



        System.out.println("------ TEST 6: Seller Delete ------");
        sellerdao.deleteById(11);
        System.out.println();


        System.out.println("------ TEST 3: Seller findAll ------");
        lst = sellerdao.findAll();
        for(Seller obj : lst){
            System.out.println(obj);
        }
        System.out.println();






    }
}