package models.dao.impl;

import db.DAO;
import db.DbException;
import models.dao.DepartmentDao;
import models.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn = null;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try {
            String sql = "insert into department "
                    + "(name) "
                    + "values (?)";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0 ){
               ResultSet rs = st.getGeneratedKeys();
               if (rs.next()){
                   int id = rs.getInt(1);
                   obj.setId(id);
               }
               DAO.closeResultSet(rs);
            }
            else{
                throw new DbException("Unexpected error! No rows affected!");
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DAO.closeStmament(st);
        }

    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try {
            String sql = "update department " +
                    "set name = ? " +
                    "where id = ? ";
            st = conn.prepareStatement(sql);
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());
            st.executeUpdate();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DAO.closeStmament(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
           String sql = "delete from department where id = ?";
           st = conn.prepareStatement(sql);
           st.setInt(1, id);
           st.executeUpdate();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DAO.closeStmament(st);
        }

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "Select * from department "
                    + "where id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()){
                Department dep = new Department();
                dep.setId(rs.getInt("id"));
                dep.setName(rs.getString("name"));

                return dep;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DAO.closeStmament(st);
            DAO.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "select * from department order by name";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            List<Department> listDep = new ArrayList<>();

            while (rs.next()){
                listDep.add(new Department(rs.getInt("id"), rs.getString("name")));
            }
            return listDep;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DAO.closeStmament(st);
            DAO.closeResultSet(rs);
        }
    }
}
