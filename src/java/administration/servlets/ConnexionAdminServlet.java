/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package administration.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import administration.beans.*;
import administration.dao.DAOException;
import administration.dao.DAOFactory;
import administration.dao.AdministratorDao;
import administration.beans.Administrator;

/**
 *
 * @author Chaymaa
 */
public class ConnexionAdminServlet extends HttpServlet {

    public static final String ATTR_LOGIN = "login";
    public static final String ATTR_PASWWORD = "password";
    public static final String ATT_SESSION_USER = "sessionUser";

    //Connexion to the database
    private static final String CONF_DAO="daofactory";
	private AdministratorDao administratorDao;
	
	public void init(){
		this.administratorDao=((DAOFactory)getServletContext().getAttribute(CONF_DAO)).getAdministratorDao();
	}

    private String nextPage;

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
        //Test loginAdministrator(String login, String password)
		String login="admin",password="admin";
		Administrator admin=this.administratorDao.loginAdministrator(login, password);
		request.setAttribute("admin", admin);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminLoginPage.jsp").forward(request, response);

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
    }

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
        public String getServletInfo() {
        return "In ConnexionServlet : Servlet en charge de rédiriger vers la bonne page selon que tu es étudiant ou tuteur ";
    }

}
