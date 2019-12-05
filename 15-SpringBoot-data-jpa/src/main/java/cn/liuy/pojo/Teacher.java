package cn.liuy.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tea_id")
	private Integer tea_id;
	
	
	@Column(name="tea_name")
	private String tea_name;
	
	
	@Column(name="tea_age")
	private Integer tea_age;
	
	@ManyToMany(mappedBy="teachers")
	private Set<Student> students = new HashSet<Student>();
	
	
	public Integer getTea_id() {
		return tea_id;
	}
	public void setTea_id(Integer tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public Integer getTea_age() {
		return tea_age;
	}
	public void setTea_age(Integer tea_age) {
		this.tea_age = tea_age;
	}
	
	
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
	@Override
	public String toString() {
		return "Teacher [tea_id=" + tea_id + ", tea_name=" + tea_name + ", tea_age=" + tea_age + "]";
	}
	
	
	
}
