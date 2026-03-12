/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.ProductDTO;


/**
 *
 * @author Toan
 */
public class ProductDAO implements CRUD<ProductDTO> {

    private static final String CREATE = "";
    private static final String SEARCH
            = "SELECT product_id, product_name, price, image, category_Id FROM Product WHERE product_name LIKE ? ";
    private static final String UPDATE = "";
    private static final String DELETE = "DELETE FROM Product WHERE id = ?";
    private static final String GETALL = "SELECT * FROM Product";



    @Override
    public boolean update(ProductDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int productId) {
        Connection conn = null;
        PreparedStatement ptm = null;
        int rs = 0;
        try {
            conn = DBUtils.getWorkWearConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setInt(1, productId);
                rs = ptm.executeUpdate();
                return rs > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                try {
                    ptm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<ProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getWorkWearConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETALL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int product_id = rs.getInt("product_id");
                    String product_name = rs.getString("product_name");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    int category_id = rs.getInt("category_id");
                    ProductDTO productDTO = new ProductDTO(product_id, product_name, price, image, category_id);
                    listProduct.add(productDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ptm != null) {
                try {
                    ptm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listProduct;

    }

    @Override
    public ProductDTO getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ProductDTO> getProductByName(String search) throws SQLException {
        List<ProductDTO> listProductByName = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getWorkWearConnection();
            System.out.println(conn.getCatalog());

            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int product_id = rs.getInt("product_id");
                    String product_name = rs.getString("product_name");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    int category_Id = rs.getInt("category_Id");
                    ProductDTO productDTO = new ProductDTO(product_id, product_name, price, image, category_Id);
                    listProductByName.add(productDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listProductByName;
    }

    @Override
    public boolean insert(ProductDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
