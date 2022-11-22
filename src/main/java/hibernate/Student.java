package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="StudentDetails")
public class Student {
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, int num) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="StudentId")
	private int id;
	@Column(name="StudentName")
	private String name;
	@Column(name="EnrollNumber")
	private int num;
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", num=" + num + "]";
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
	public void setName(String demoname) {
		this.name = demoname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	

}
