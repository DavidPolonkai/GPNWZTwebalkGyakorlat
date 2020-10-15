package CRUD;

public class Cats {
	private int id;
	private String name;
	private String breed;
	private int age;
	private String owner;
	
	public Cats(int id, String name, String breed, int age, String owner) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.owner = owner;
	}
	
	public Cats() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}
