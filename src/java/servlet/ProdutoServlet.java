/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ConnectionFactory;
import dao.ProdutoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;

/**
 *
 * @author Elton
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/servlet/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {
    
    public Connection conn = ConnectionFactory.getConnection();
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void destroy() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String cmd = request.getParameter("cmd");
            Produto p = new Produto();
            ProdutoImpl p_imp;
            
            switch (cmd.toLowerCase()) {
                case "salvar":
                    p.setNome(request.getParameter("nome"));
                    p.setPreco(Integer.valueOf(request.getParameter("preco")));
                    p.setDescricao(request.getParameter("descricao"));
                    p.setCategoria_id(request.getParameter("categoria_id"));
                    p_imp = new ProdutoImpl();
                    p_imp.salvar(conn, p);
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Gravaçao Realizada Com Sucesso!</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<a href=\"/MercadoAcre/jsp/produtojsp.jsp\">Novo Produto</a>");
                    out.println("</body>");
                    out.println("</html>");
                    break;
                case "editar":
                    break;
                case"excluir":
                    p.setId(Integer.valueOf(request.getParameter("id")));
                    p_imp = new ProdutoImpl();
                    p_imp.remover(conn, p);
                    
                    response.sendRedirect("/MercadoAcre/jsp/produtolista.jsp");
                    

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
