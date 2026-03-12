/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.dao.UserDAO;
import model.dto.UserDTO;

/**
 *
 * @author Toan
 */
public class UserService {

    public List<UserDTO> getAll() throws SQLException {
        UserDAO dao = new UserDAO();
        List<UserDTO> lstUser = new ArrayList<>();
        lstUser = dao.getALL();
        return lstUser;
    }

    public void createUser() {
        
    }

    public void deleteUser() {
    }

    public void updateUser() {
        
    }

    public void getById() {

    }

    public UserDTO login(String userId, String password) throws SQLException, ClassNotFoundException {
        UserDAO dao = new UserDAO();
        UserDTO loginUser = dao.checkLogin(userId, password);
        return loginUser;
    }

    


}
