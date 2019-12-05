package cn.liuy.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="principal")
public class Principal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prin_id")
	private Integer prin_id;
	
	
	
	@Column(name="prin_name")
	private String prin_name;
	
	
	@Column(name="prin_power")
	private String prin_power;
	
	@OneToMany(mappedBy="principal")
	private Set<Subordinate> subordinates = new HashSet<Subordinate>();
	
	public Integer getPrin_id() {
		return prin_id;
	}
	public void setPrin_id(Integer prin_id) {
		this.prin_id = prin_id;
	}
	public String getPrin_name() {
		return prin_name;
	}
	public void setPrin_name(String prin_name) {
		this.prin_name = prin_name;
	}
	public String getPrin_power() {
		return prin_power;
	}
	public void setPrin_power(String prin_power) {
		this.prin_power = prin_power;
	}
	
	
	
	public Set<Subordinate> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(Set<Subordinate> subordinates) {
		this.subordinates = subordinates;
	}
	
	
	
	@Override
	public String toString() {
		return "Principal [prin_id=" + prin_id + ", prin_name=" + prin_name + ", prin_power=" + prin_power + "]";
	}
	
	
	
	
}
