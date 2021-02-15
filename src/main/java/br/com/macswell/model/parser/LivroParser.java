package br.com.macswell.model.parser;

import br.com.macswell.dto.LivroDto;
import br.com.macswell.model.Autor;
import br.com.macswell.model.Livro;

public class LivroParser {
	
	public static LivroParser get(){
		return  new LivroParser();
	}

	public LivroDto dto(Livro entidade){
	   	
		LivroDto dto = new LivroDto();
		dto.setId(entidade.getId());
	    dto.setTitulo(entidade.getTitulo());
	    dto.setAno(entidade.getAno());
	    dto.setAutor(entidade.getAutor().getNome());
	    dto.setAutor_id(entidade.getAutor().getId());
	        
	    return dto;
	}
	    
	public Livro entidade(LivroDto dto){
	    	
		Livro entidade = new Livro();
	    entidade.setId(dto.getId());
	    entidade.setTitulo(dto.getTitulo());
	    entidade.setAno(dto.getAno());
	    entidade.setAutor(
	    		new Autor(dto.getAutor_id(),
	    				dto.getAutor()
	    				));
	    return entidade;
	}
}
