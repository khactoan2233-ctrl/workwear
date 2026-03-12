package model.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.CRUD;
import model.dto.CategoryDTO;

/**
 *
 * @author Toan
 */
public class CategoryDAO implements CRUD<CategoryDTO> {

    private static final String CREATE = "";
    private static final String SEARCH = "";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String GETALL = "Select * from Category";

 

    @Override
    public boolean update(CategoryDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CategoryDTO> getAll() {
         List<CategoryDTO> categoryList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getWorkWearConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETALL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String category_id = rs.getString("category_id");
                    String category_name = rs.getString("category_name");
                    CategoryDTO cate = new CategoryDTO(category_id, category_name);
                    categoryList.add(cate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ptm != null) {
                try {
                    ptm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return categoryList;
    }

    @Override
    public CategoryDTO getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(CategoryDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
