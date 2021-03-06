package administration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import administration.beans.Request;
import administration.beans.Request.RequestStatus;
import static administration.dao.DAOUtility.silentClosings;
import static administration.dao.DAOUtility.initializePreparedStatement;


public class RequestDaoImpl implements RequestDao{
	
	private DAOFactory daoFactory;
	
	private String SQL_SELECT_ALL_REQUESTS="SELECT * FROM Requests";
	private String SQL_SELECT_REQUEST_FROM_ID="SELECT * FROM Requests WHERE ID=?";
	private String SQL_INSERT_REQUEST="INSERT INTO Requests (internshipID,companyID,studentID,status) "
									+ "VALUES(?,?,?,?)";
	private String SQL_UPDATE_REQUEST_STATUS="UPDATE Requests SET status=? WHERE ID=?";
	
	public RequestDaoImpl(DAOFactory dao){
		this.daoFactory=dao;
	}
	
	@Override
	public void createRequest(Request request) throws DAOException {
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet autoGeneratedKeys=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=initializePreparedStatement(connection, SQL_INSERT_REQUEST, true,
            		request.getInternshipID(),
            		request.getCompanyID(),
            		request.getStudentID(),
            		RequestStatus.APPLICATION_SENT_TO_COMPANY.toString());
            int status=preparedStatement.executeUpdate();
            if(status==0){
                throw new DAOException("Failed to insert an Application");
            }
            autoGeneratedKeys=preparedStatement.getGeneratedKeys();
            if(autoGeneratedKeys.next()){
                request.setID(autoGeneratedKeys.getLong(1));
            }
            else{
                throw new DAOException("Failed to insert an Application : no generated index returned");
            }
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            silentClosings(autoGeneratedKeys, preparedStatement, connection);
        }
	}
	
	@Override
	public void updateRequestStatus(Request request) throws DAOException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=this.daoFactory.getConnection();
			preparedStatement=initializePreparedStatement(connection, SQL_UPDATE_REQUEST_STATUS, true,
					request.getStatus().toString(),
					request.getID());
			int status=preparedStatement.executeUpdate();
			System.out.println(preparedStatement.toString());
			if(status==0){
				throw new DAOException("Failed to update the request status");
			}
		}catch(SQLException e){
			throw new DAOException(e);
		}finally{
			silentClosings(preparedStatement, connection);
		}
	}
	
	@Override
	public List<Request> listRequests() throws DAOException{
		List<Request> requestsList=new ArrayList<Request>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			connection=this.daoFactory.getConnection();
			preparedStatement=connection.prepareStatement(SQL_SELECT_ALL_REQUESTS);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				requestsList.add(map(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e);
		}finally{
			silentClosings(resultSet, preparedStatement, connection);
		}
		return requestsList;
		
	}
	@Override
	public Request retrieveRequestFromID(long ID) throws DAOException{
		Request request=null;
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=this.daoFactory.getConnection();
			preparedStatement=initializePreparedStatement(connection,SQL_SELECT_REQUEST_FROM_ID, false, ID);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				request=map(resultSet);
			}
		}catch(SQLException e){
			throw new DAOException(e);
		}finally{
			silentClosings(resultSet, preparedStatement, connection);
		}
		return request;
	}
	
	private static Request map(ResultSet resultSet) throws SQLException{
		Request request=new Request();
		request.setCompanyID(resultSet.getLong("companyID"));
		request.setID(resultSet.getLong("ID"));
		request.setInternshipID(resultSet.getLong("internshipID"));
		request.setStatus(RequestStatus.valueOf(resultSet.getString("status")));
		request.setStudentID(resultSet.getLong("studentID"));
		return request;
	}
}
