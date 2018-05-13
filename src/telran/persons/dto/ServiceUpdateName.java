package telran.persons.dto;

public class ServiceUpdateName {
	
	int id;
	String newName;
	public int getId() {
		return id;
	}
	public String getNewName() {
		return newName;
	}
	@Override
	public String toString() {
		return "ServiceUpdateName [id=" + id + ", newName=" + newName + "]";
	}
	public ServiceUpdateName(int id, String newName) {
		super();
		this.id = id;
		this.newName = newName;
	}
	
	public ServiceUpdateName() {}
		

}
