package br.com.macswell.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.macswell.dao.LivroDao;
import br.com.macswell.dto.LivroDto;
import br.com.macswell.model.parser.LivroParser;

@ApplicationScoped
public class LivroService {
	
	@Inject
	LivroDao dao;

	public List<LivroDto> listar(){
        return dao.listar().stream().map(LivroParser.get()::dto).collect(Collectors.toList());
    }
	
	public void salvar(LivroDto dto) {
		dao.salvar(LivroParser.get().entidade(dto));
	}
	
	public void editar(int id, LivroDto dto) {
		dao.editar(id, LivroParser.get().entidade(dto));
	}
	
	public void excluir(int id) {
		dao.excluir(id);
	}
	
}
