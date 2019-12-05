package cn.liuy.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="subordinate")
public class Subordinate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sub_id")
	private Integer sub_id;
	
	
	@Column(name="sub_name")
	private String sub_name;
	
	
	@Column(name="sub_effect")
	private Integer sub_effect;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="prin_sub_id")
	private Principal principal;
	
	
	public Integer getSub_id() {
		return sub_id;
	}
	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public Integer getSub_effect() {
		return sub_effect;
	}
	public void setSub_effect(Integer sub_effect) {
		this.sub_effect = sub_effect;
	}
	
	
	
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	
	
	
	@Override
	public String toString() {
		return "Subordinate [sub_id=" + sub_id + ", sub_name=" + sub_name + ", sub_effect=" + sub_effect + "]";
	}
	
	
	
	
	
}
