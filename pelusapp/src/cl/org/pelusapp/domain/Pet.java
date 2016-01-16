package cl.org.pelusapp.domain;

import java.io.Serializable;
import java.util.List;

public class Pet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4717318645816098407L;

	private String id;
	private String name;
	private String color;
	private String description;
	private Size size;
	private Race race;
	private AgeGroup ageGroup;
	private List<Image> lstImage;

	public List<Image> getLstImage() {
		return lstImage;
	}

	public void setLstImage(List<Image> lstImage) {
		this.lstImage = lstImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		Pet other = (Pet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", color=" + color + ", description=" + description + ", size="
				+ size + ", race=" + race + ", ageGroup=" + ageGroup + "]";
	}

}
