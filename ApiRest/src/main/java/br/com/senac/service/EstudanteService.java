package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Estudante;
import br.com.senac.exception.ObjectNotFoundException;
import br.com.senac.repository.EstudanteRepository;

@Service
public class EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepo;
	
	
	public Estudante salvar(Estudante estudante) {
		return estudanteRepo.save(estudante);
	}
	
	
	public List<Estudante> buscarTodosEstudantes(){
		return estudanteRepo.findAll();
	}
	
	
	public Estudante getEstudanteByID(Integer id) {
		//return estudanteRepo.findById(id).orElse(null);
		Optional<Estudante> estudante = estudanteRepo.findById(id);
		return estudante.orElseThrow(() -> new ObjectNotFoundException("Estudante não encontrado"));
	}
	
	public Boolean deleteEstudante(Integer id) {
		Estudante estudante = estudanteRepo.findById(id).orElse(null);
		if(estudante != null) {
			estudanteRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	
	public Estudante updateEstudante(Integer id, Estudante estudante) {
		Estudante estudanteBD = estudanteRepo.findById(id).orElse(null);
		if(estudanteBD != null) {
			estudanteBD.setNome(estudante.getNome());
			estudanteBD.setEmail(estudante.getEmail());
			estudanteBD.setSobreNome(estudante.getSobreNome());
			return estudanteRepo.save(estudanteBD);
		}else {
			return null;
		}
	}
	
	public Page<Estudante> buscaEstudantePorPaginacao(PageRequest page){
		return estudanteRepo.findAll(page);
	}
	
	
	
	
	
	
	
	
	
	
	
}
