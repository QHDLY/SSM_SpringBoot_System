package cn.liuy.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stu_id")
	private Integer stu_id;
	
	
	@Column(name="stu_name")
	private String stu_name;
	
	
	@Column(name="stu_age")
	private Integer stu_age;
	
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable(name="t_stu_tea",joinColumns=@JoinColumn(name="t_stu_id"),inverseJoinColumns=@JoinColumn(name="t_tea_id"))
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	public Integer getStu_id() {
		return stu_id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public Integer getStu_age() {
		return stu_age;
	}
	public void setStu_age(Integer stu_age) {
		this.stu_age = stu_age;
	}
	
	
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_age=" + stu_age + "]";
	}
	
	
	
}
