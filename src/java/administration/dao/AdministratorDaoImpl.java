package administration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import administration.beans.Administrator;
import static administration.dao.DAOUtility.*;

public class AdministratorDaoImpl implements AdministratorDao {
	
	private DAOFactory daoFactory;
	
	private String SQL_SELECT_ADMINISTRATOR_FROM_CREDENTIALS="SELECT * FROM Administrators WHERE login=? AND password=?";
	
	public AdministratorDaoImpl(DAOFactory dao){
		this.daoFactory=dao;
	}
	
	@Override
	public Administrator loginAdministrator(String login, String password)
			throws DAOException {
		Administrator administrator=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			connection=this.daoFactory.getConnection();
			preparedStatement=initializePreparedStatement(connection, SQL_SELECT_ADMINISTRATOR_FROM_CREDENTIALS, false, login,password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				administrator=map(resultSet);
			}
		}catch(SQLException e){
			throw new DAOException(e);
		}finally{
			silentClosings(resultSet, preparedStatement, connection);
		}
	return administrator;
	}
	
	private static Administrator map(ResultSet resultSet) throws SQLException{
		Administrator admin=new Administrator();
		admin.setID(resultSet.getLong("ID"));
		admin.setLogin(resultSet.getString("login"));
		admin.setPassword(resultSet.getString("password"));
		return admin;
	}
}
