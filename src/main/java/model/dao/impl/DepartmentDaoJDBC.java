package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmaneDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmaneDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }


    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?) ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1,obj.getName());
            //st.setString(2, obj.getName());

            int rowsCreated = st.executeUpdate();

            if(rowsCreated > 0){
                rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }else{
                throw new DbException("Unexpected error! No rows affected!");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }


    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE department SET Name = ?, Id = ? WHERE Id = ? ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(3, obj.getId());
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            int rowsModified = st.executeUpdate();

            if (rowsModified == 0) {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ? ");
            st.setInt(1, id);
            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM department WHERE Id = ? ");
            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()){
                return instantiateDepartment(rs);
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        return new Department(rs.getInt("id"), rs.getString("Name"));
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT * FROM department ORDER BY Id ");
            rs = st.executeQuery();

            List<Department> depList = new ArrayList<>();

            while(rs.next()){
                depList.add(instantiateDepartment(rs));
            }
            return depList;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }




    }
}
