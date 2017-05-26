/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author Anglete
 */
public interface ProdutoDao {
    public void salvar(Connection conn, Produto autor);
    public void atualizar(Connection conn, Produto autor);
    public void remover(Connection conn, Produto  autor);
    public List<Produto> getListAll();
    public Produto findById(Connection conn, int id);
    
    
}
