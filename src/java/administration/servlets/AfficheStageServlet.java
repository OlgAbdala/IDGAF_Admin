/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package administration.servlets;

import administration.beans.Request;
import administration.dao.DAOFactory;
import administration.dao.RequestDao;
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
 private static final String CONF_DAO="daofactory";
	private RequestDao requestDao;
	
	public void init(){
		this.requestDao=((DAOFactory)getServletContext().getAttribute(CONF_DAO)).getRequestDao();
	}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //void createRequest(Request request) throws DAOException;
		Request req;

		// List<Request> listRequests() throws DAOException;
		ArrayList<Request> requestsList=(ArrayList<Request>) this.requestDao.listRequests();
		request.setAttribute("requestsList", requestsList);
		
          request.getRequestDispatcher("/WEB-INF/afficheStageAdmin.jsp").forward(request, response);

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
