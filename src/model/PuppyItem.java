package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="puppy")
public class PuppyItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="PUPPY")
	private String puppy;
	@Column(name="BREED")
	private String breed;

	public PuppyItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PuppyItem(String puppy, String breed) {
		super();
		this.puppy = puppy;
		this.breed = breed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPuppy() {
		return puppy;
	}

	public void setPuppy(String puppy) {
		this.puppy = puppy;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "PuppyItem [id=" + id + ", puppy=" + puppy + ", breed=" + breed + "]";
	}

	public String returnItemDetails() {
		return this.puppy + ": " + this.breed;
	}
}