package administration.testServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.beans.Administrator;
import administration.dao.AdministratorDao;
import administration.dao.DAOFactory;

public class TestAdministrators extends HttpServlet{
	private static final String CONF_DAO="daofactory";
	private AdministratorDao administratorDao;
	
	public void init(){
		this.administratorDao=((DAOFactory)getServletContext().getAttribute(CONF_DAO)).getAdministratorDao();
	}
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		//Test loginAdministrator(String login, String password)
		String login="admin",password="admin";
		Administrator admin=this.administratorDao.loginAdministrator(login, password);
		request.setAttribute("admin", admin);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/TestAdministrators.jsp").forward(request, response);
	}
}
