package br.com.macswell.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.macswell.model.Autor;

@ApplicationScoped
public class AutorDao {
	
	
	public List<Autor> listar(){
		 return Autor.listAll();
	 }
	
	@Transactional
	public void salvar(Autor autor) {
		Autor.persist(autor);
	}
	
	@Transactional
	public Autor buscarId(int id) {
		
		Autor autor = Autor.findById(id);
        if (autor == null) {
            throw new WebApplicationException("Autor com o id " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        return autor;
	}
}
