package br.com.macswell.model.parser;

import br.com.macswell.dto.AutorDto;
import br.com.macswell.model.Autor;

public class AutorParser {
	
	public static AutorParser get(){
		return  new AutorParser();
	}

	public AutorDto dto(Autor entidade){
	   	
		AutorDto dto = new AutorDto();
		dto.setId(entidade.getId());
	    dto.setNome(entidade.getNome());
	        
	    return dto;
	}
	    
	public Autor entidade(AutorDto dto){
	    	
		Autor entidade = new Autor();
	    entidade.setId(dto.getId());
	    entidade.setNome(dto.getNome());
	    return entidade;
	}

}
