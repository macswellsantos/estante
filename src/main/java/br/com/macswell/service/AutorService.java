package br.com.macswell.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.macswell.dao.AutorDao;
import br.com.macswell.dto.AutorDto;
import br.com.macswell.model.parser.AutorParser;

@ApplicationScoped
public class AutorService {

	@Inject
	AutorDao dao;
	
	public List<AutorDto> listar(){
        return dao.listar().stream().map(AutorParser.get()::dto).collect(Collectors.toList());
    }
	
	public void salvar(AutorDto dto) {
		dao.salvar(AutorParser.get().entidade(dto));
	}
	
}
