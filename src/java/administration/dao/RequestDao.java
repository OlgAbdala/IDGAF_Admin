package administration.dao;

import java.util.List;

import administration.beans.Request;

public interface RequestDao {
	void createRequest(Request request) throws DAOException;
	void updateRequestStatus(Request request) throws DAOException;
	List<Request> listRequests() throws DAOException;
	Request retrieveRequestFromID(long ID) throws DAOException;
}
