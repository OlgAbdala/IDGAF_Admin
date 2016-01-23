package administration.beans;

public class Request {
	
	public enum RequestStatus{
		APPLICATION_SENT_TO_COMPANY,
		REFUSED_BY_COMPANY,
		ACCEPTED_BY_COMPANY,
		ACCEPTED_BY_TUTOR,
		REFUSED_BY_TUTOR,
		ACCEPTED_BY_ADMINISTRATION,
		REFUSED_BY_ADMINISTRATION,
		SIGNED_BY_STUDENT,
		SIGNED_BY_COMPANY,
		SIGNED_BY_ALL;
	}
	private long ID;
	private long companyID;
	private long internshipID; //ID de l'offre chez l'entreprise (deux entreprises différentes 
							   //pouvant donner le même ID à une offre)
	private long studentID;
	private RequestStatus status;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}
	public long getInternshipID() {
		return internshipID;
	}
	public void setInternshipID(long internshipID) {
		this.internshipID = internshipID;
	}
	public long getStudentID() {
		return studentID;
	}
	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}
	public RequestStatus getStatus() {
		return status;
	}
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	
}
