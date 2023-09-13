package br.com.senac.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.senac.dto.EstudanteDTO;
import br.com.senac.entity.Estudante;
import br.com.senac.exception.ObjectNotFoundException;
import br.com.senac.repository.EstudanteRepository;

@SpringBootTest
class EstudanteServiceTest {
	
	
	private static final Integer ID = 1;
	private static final String NOME = "Lucas";
	private static final String SOBRENOME = "Silva";
	private static final String EMAIL = "lucassilva@gmail.com";
	
	
	
	@InjectMocks
	private EstudanteService estudanteService;
	
	@Mock
	private EstudanteRepository estudanteRepository;
	
	@Mock
	private ModelMapper mapper;
	
	private Estudante estudante;
	private EstudanteDTO estudanteDTO;
	private Optional<Estudante> estudanteOptional;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startEstudante();
	}
	
	
	
	private void startEstudante() {
		estudante = new Estudante(ID,NOME,SOBRENOME,EMAIL);
		estudanteDTO = new EstudanteDTO(ID,NOME,SOBRENOME,EMAIL);
		estudanteOptional = Optional.of(new Estudante(ID,NOME,SOBRENOME,EMAIL));
		
	}
	
	@Test
	void whenFindByIdThenAnReturnEstudanteInstance() {
		Mockito.when(estudanteRepository.findById(Mockito.anyInt())).thenReturn(estudanteOptional);
		Estudante response = estudanteService.getEstudanteByID(ID);
		Assertions.assertEquals(Estudante.class, response.getClass());
		Assertions.assertEquals(ID, response.getId());
		Assertions.assertEquals(NOME, response.getNome());
		Assertions.assertEquals(SOBRENOME, response.getSobreNome());
		Assertions.assertEquals(EMAIL, response.getEmail());
		
	}
	
	@Test
	void whenFindByIdThenReturnAnObjectNotFoundException() {
		Mockito.when(estudanteRepository.findById(Mockito.anyInt())).thenThrow(new ObjectNotFoundException("Estudante não encontrado"));
		try {
			estudanteService.getEstudanteByID(ID);
			
		}catch(Exception e) {
			Assertions.assertEquals(ObjectNotFoundException.class, e.getClass());
			Assertions.assertEquals("Estudante não encontrado", e.getMessage());
		}
		
	}
	
	


}
