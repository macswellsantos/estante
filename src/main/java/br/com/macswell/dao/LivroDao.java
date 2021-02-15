package br.com.macswell.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.macswell.model.Livro;

@ApplicationScoped
public class LivroDao {
	
	public List<Livro> listar(){
		 return Livro.listAll();
	 }
	
	@Transactional
	public void salvar(Livro livro) {
		Livro.persist(livro);
	}
	
	@Transactional
	public void editar(int id, Livro livro) {
		Livro livroSalvo = buscarId(id);
        if (livro == null) {
            throw new WebApplicationException("Livro com o id " + id + " não existe.", Response.Status.NOT_FOUND);
        } else {
        	livroSalvo.setTitulo(livro.getTitulo());
    		livroSalvo.setAno(livro.getAno());
    		livroSalvo.setAutor(livro.getAutor());
        }
	}
	
	@Transactional
	public void excluir(int id) {
		
		Livro livro = buscarId(id);
        if (livro == null) {
            throw new WebApplicationException("Livro com o id " + id + " não existe.", Response.Status.NOT_FOUND);
        } else {
        	livro.delete();
        }
	}
	
	@Transactional
	public Livro buscarId(int id) {
		
		Livro livro = Livro.findById(id);
        if (livro == null) {
            throw new WebApplicationException("Livro com o id " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        return livro;
	}
}
