package models.dao.impl;

import db.DAO;
import db.DbException;
import models.dao.DepartmentDao;
import models.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn = null;

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
        PreparedStatement st = null;
        try {
           String sql = "delete from department where id = ?";
           st = conn.prepareStatement(sql);
           st.setInt(1, id);
           st.executeQuery();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
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
            String sql = "select * from department";
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
