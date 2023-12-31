package br.com.senac.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class EstudanteDTO {

	
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	@NotNull
	private String nome;
	
	@NotNull
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
