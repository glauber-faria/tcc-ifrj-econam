package org.econam.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "read_input")
public class ReadInput {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//data read
	private LocalDateTime read;
	private String value;
	
	//Foreing keys
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id")
	private Device device;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parameter_id")
	private Parameter parameterId;
}
