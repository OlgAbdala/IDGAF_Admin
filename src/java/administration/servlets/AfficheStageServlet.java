/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package administration.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChaySi
 */
public class AfficheStageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         List<String> l1 = new ArrayList();
         l1.add("etudiant1");
         l1.add("etudiant2");
         l1.add("etudiant3");
          request.setAttribute("l1",l1);
           List<String> l2 = new ArrayList();
         l2.add("offre1");
         l2.add("offre2");
         l2.add("offre3");
          request.setAttribute("l2",l2);
         List<String> l3 = new ArrayList();
         l3.add("convention1");
         l3.add("convention2");
         l3.add("convention3");
          request.setAttribute("l3",l3);
          List<String> l4 = new ArrayList();
         l4.add("validé");
         l4.add("pas encore");
         l4.add("à corriger");
          request.setAttribute("l4",l4);
          
          request.getRequestDispatcher("portailAdmin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
