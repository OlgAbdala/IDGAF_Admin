package administration.dao;

import administration.beans.Administrator;

public interface AdministratorDao {
	Administrator loginAdministrator(String login, String password) throws DAOException;
}
