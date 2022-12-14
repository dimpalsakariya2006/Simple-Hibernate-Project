package hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="StudentDetails")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="StudentId")
	private int id;
	@Column(name="StudentName")
	private String name;
	@Column(name="EnrollNumber")
	private int num;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private StudentAddress studentAddress;
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", num=" + num + ", studentAddress=" + studentAddress + "]";
	}
	public StudentAddress getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
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
