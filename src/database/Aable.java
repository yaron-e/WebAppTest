package database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Aable implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "userID", unique = true, nullable = false)
	private int UserID; // Index
	
	private int tableID;
	private String variableString;
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getTableID() {
		return tableID;
	}
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	public String getVariableString() {
		return variableString;
	}
	public void setVariableString(String variableString) {
		this.variableString = variableString;
	}
	

}
