/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Categoria;



/**
 *
 * @author Elton
 */
public interface CategoriaDao {
    public void salvar(Categoria autor);
    public void atualizar(Categoria autor);
    public void remover(Categoria  autor);
    public List<Categoria> getListAll();
    public Categoria findById(int id);
    
    
    
    
    
    
    
}
