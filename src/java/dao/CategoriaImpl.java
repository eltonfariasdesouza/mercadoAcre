/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;
import modelo.Produto;


/**
 *
 * @author Elton
 */
public class CategoriaImpl implements CategoriaDao{
    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
   
    public void salvar(Categoria autor) {
        String sql = "INSERT INTO categorias (nome) values(?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getNome());
            
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Categoria autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Categoria autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> getListAll() {
        try {
        List<Categoria> list = new ArrayList<>();
        String sql = "select id, nome from categorias";
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Categoria c = new Categoria();
            c.setId(rs.getInt(1));
            c.setNome(rs.getString(2));
            list.add(c);
        }
        return list;
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Categoria findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
