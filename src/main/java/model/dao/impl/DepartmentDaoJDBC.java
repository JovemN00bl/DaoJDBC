package model.dao.impl;

import model.dao.DepartmaneDao;
import model.entities.Department;

import java.sql.Connection;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmaneDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }



    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
