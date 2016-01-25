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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author star
 */
public class SignatureDemandeServlet extends HttpServlet {
   private static final String CONF_DAO="daofactory";
	private RequestDao requestDao;
	
	public void init(){
		this.requestDao=((DAOFactory)getServletContext().getAttribute(CONF_DAO)).getRequestDao();
	}
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignatureDemandeServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignatureDemandeServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        if(request.getParameter("ID")!=null){
            long ID=Long.valueOf(request.getParameter("ID"));
          Request req=this.requestDao.retrieveRequestFromID(ID);
          req.setStatus(Request.RequestStatus.ACCEPTED_BY_ADMINISTRATION);		
            this.requestDao.updateRequestStatus(req);  
        }
           
     
           RequestDispatcher dispatcher=request.getRequestDispatcher("/AfficheStageServlet");
        dispatcher.forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
