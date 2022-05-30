package org.econam.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String cpf;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	@JsonIgnore
	private List<Device> devices;
	
	//contact
	private String email;
	private String phone;
	private String celphone;

	//adress
	private String street;
	private String city;
	private String state;
	private String country;
	private String number;
	
	@Column(name="zip_code")
	private String zipCode;
}
