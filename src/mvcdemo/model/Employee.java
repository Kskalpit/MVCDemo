package mvcdemo.model;
 
public class Employee {
 
	private String Name;
	private String Email;
	private int ID;
	private int Salary;
 
	public Employee (String Name, String Email, int ID, int Salary){
		this.Name = Name;
		this.Email = Email;
		this.ID = ID;
		this.Salary = Salary;
	}
	public Employee () {
		
	}
 
	public String getEmployeename() {
		return Name;
	}
 
	public void setEmployeeName(String Name) {
		this.Name = Name;
	}
 
	public String getEmail() {
		return Email;
	}
 
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public int getID() {
		return ID;
	}
 
	public void setID(int ID) {
		this.ID = ID;
	}
	public int getSalary() {
		return Salary;
	}
 
	public void setSalary (int Salary) {
		this.Salary = Salary;
	}
}