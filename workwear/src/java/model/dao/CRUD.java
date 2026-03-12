/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;

/**
 *
 * @author Toan
 */
public interface CRUD<T> {

    boolean insert(T obj);

    boolean update(T obj);

    boolean delete(int id);

    List<T> getAll();

    T getById(int id);
}
