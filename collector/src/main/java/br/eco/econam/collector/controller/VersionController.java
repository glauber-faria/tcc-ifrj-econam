package br.eco.econam.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eco.econam.collector.dto.VersionDtoResponse;

@RestController
@RequestMapping("/version")
public class VersionController {
    
    @Value("${project.name}")
    public String name;

    @Value("${project.version}")
    public String version;

    @GetMapping()
    public VersionDtoResponse getVersion(){
       return new VersionDtoResponse(this.name, this.version);
    }
}
