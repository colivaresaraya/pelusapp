package cl.org.pelusapp.domain;

import java.io.Serializable;

public class Race implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5859632116355876702L;

	private String idRace;
	private String idSpecies;
	private String description;

	public Race() {
		// TODO Auto-generated constructor stub
	}

	public String getIdRace() {
		return idRace;
	}

	public void setIdRace(String idRace) {
		this.idRace = idRace;
	}

	public String getIdSpecies() {
		return idSpecies;
	}

	public void setIdSpecies(String idSpecies) {
		this.idSpecies = idSpecies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Race [idRace=" + idRace + ", idSpecies=" + idSpecies + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRace == null) ? 0 : idRace.hashCode());
		result = prime * result + ((idSpecies == null) ? 0 : idSpecies.hashCode());
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
		Race other = (Race) obj;
		if (idRace == null) {
			if (other.idRace != null)
				return false;
		} else if (!idRace.equals(other.idRace))
			return false;
		if (idSpecies == null) {
			if (other.idSpecies != null)
				return false;
		} else if (!idSpecies.equals(other.idSpecies))
			return false;
		return true;
	}

}
