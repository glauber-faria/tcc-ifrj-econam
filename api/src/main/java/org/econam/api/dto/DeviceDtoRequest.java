package org.econam.api.dto;

import org.econam.api.model.Device;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeviceDtoRequest {
	@NotNull
	private String name;
	
	@NotNull
	private String topic;
	
	@NotNull
	@NotBlank
	private Long clientId;
}
