package cl.org.pelusapp.domain;

import java.io.Serializable;
import java.util.Date;

public class Case implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5859632116355876702L;
	
	private String id;
	private String statusCase;
	private String idPet;
	private Date addDate;
	private Date exitDate;
	private String story;


		
	public Case() {
		this.addDate = new Date();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatusCase() {
		return statusCase;
	}

	public void setStatusCase(String statusCase) {
		this.statusCase = statusCase;
	}

	public String getIdPet() {
		return idPet;
	}

	public void setIdPet(String idPet) {
		this.idPet = idPet;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Case [id=" + id + ", statusCase=" + statusCase + ", idPet=" + idPet + ", addDate=" + addDate
				+ ", exitDate=" + exitDate + ", story=" + story + "]";
	}


}
