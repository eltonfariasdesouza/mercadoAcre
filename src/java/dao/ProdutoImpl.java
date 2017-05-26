
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
public class ProdutoImpl implements ProdutoDao{
    
    public Connection conn;
    public PreparedStatement stmt;
    public ResultSet rs;
    
    @Override
   
    public void salvar(Connection conn, Produto autor) {
        String sql = "INSERT INTO Produtos (nome,preco,descricao,categoria_id) values(?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getNome());
            stmt.setFloat(2, autor.getPreco());
            stmt.setString(3, autor.getDescricao());
            stmt.setInt(4, Integer.valueOf(autor.getCategoria_id()));
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Connection conn, Produto autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Connection conn, Produto autor) {
        String sql = "delete from produtos where id="+autor.getId();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Produto> getListAll() {
        try {
            List<Produto> list = new ArrayList<>();
            String sql = "select id, nome, preco, descricao, categoria_id from produtos";
            Connection conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPreco(rs.getInt(3));
                p.setDescricao(rs.getString(4));
                p.setCategoria_id(rs.getString(5));
                list.add(p);
        }
        conn.close();
        return list;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
}
    
    @Override
    public Produto findById(Connection conn, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
