package beans;

public class Signup {
	private int id;
	private String name, contact, email, password, userrole;

	public Signup() {

		// TODO Auto-generated constructor stub
	}

	public Signup(String name, String contact, String email, String password, String userrole) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.userrole = userrole;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

}
