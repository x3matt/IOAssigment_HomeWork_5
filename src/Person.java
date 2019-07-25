
public class Person {

	private String firstName;
	private String lastName;
	private Technique tech;
	public Person(String firstName, String lastName, Technique tech) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.tech = tech;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Technique getTech() {
		return tech;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((tech == null) ? 0 : tech.hashCode());
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
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (tech == null) {
			if (other.tech != null)
				return false;
		} else if (!tech.equals(other.tech))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[firstName=" + firstName + ", lastName=" + lastName + ", tech=" + tech + "]";
	}
	
	
}
