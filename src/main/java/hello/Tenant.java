package hello;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Tenant")
public class Tenant {

	static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//
    private Long id;
	private String FirstName;
    private String LastName;
    private String Start;
    private String End;
    private String email;
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getStart() {
		return Start;
	}

	public void setStart(String start) {
		Start = start;
	}

	public String getEnd() {
		return End;
	}

	public void setEnd(String end) {
		End = end;
	}

 
    public Tenant() {
 
    }

    @Override
	public String toString() {
		return "Tenant [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Start=" + Start
				+ ", End=" + End + ", email=" + email + "]";
	}

	public Tenant(String firstName, String lastName) {
		FirstName = firstName;
		LastName = lastName;
		Start = formatter.format(new Date()).toString();
		End = formatter.format(new Date()).toString();
	}
    public Tenant(Long id, String firstName, String lastName) throws ParseException {
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Start = formatter.format(new Date()).toString();
		End = formatter.format(new Date()).toString();
	}
    public Tenant(String firstName, String lastName,String email, String start, String end) {
		FirstName = firstName;
		LastName = lastName;
		Start = start;
		End = end;
		this.email=email;
	}
}
