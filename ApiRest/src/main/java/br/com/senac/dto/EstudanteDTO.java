package br.com.senac.dto;

import lombok.Getter;
import lombok.Setter;

public class EstudanteDTO {

	
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String nome;
	
	
	private String email;
	
	
	@Getter
	@Setter
	private String sobreNome;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
}
