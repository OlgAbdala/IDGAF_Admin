package administration.testServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.beans.Request;
import administration.beans.Request.RequestStatus;
import administration.dao.DAOException;
import administration.dao.DAOFactory;
import administration.dao.RequestDao;

public class TestRequests extends HttpServlet{
	private static final String CONF_DAO="daofactory";
	private RequestDao requestDao;
	
	public void init(){
		this.requestDao=((DAOFactory)getServletContext().getAttribute(CONF_DAO)).getRequestDao();
	}
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		//Test void createRequest(Request request) throws DAOException;
		Request req=new Request();
		req.setCompanyID(1);
		req.setInternshipID(1);
		req.setStatus(RequestStatus.APPLICATION_SENT_TO_COMPANY);
		req.setStudentID(1);
		this.requestDao.createRequest(req);
		
		//Test void updateRequestStatus(Request request) throws DAOException;
		req.setStatus(RequestStatus.ACCEPTED_BY_COMPANY);
		this.requestDao.updateRequestStatus(req);
		
		//Test List<Request> listRequests() throws DAOException;
		ArrayList<Request> requestsList=(ArrayList<Request>) this.requestDao.listRequests();
		request.setAttribute("requestsList", requestsList);
		
		//Test Request retrieveRequestFromID(long ID) throws DAOException;
		Request requestFromID=this.requestDao.retrieveRequestFromID(1);
		request.setAttribute("requestFromID", requestFromID);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/TestRequests.jsp").forward(request, response);
	}
	
}
