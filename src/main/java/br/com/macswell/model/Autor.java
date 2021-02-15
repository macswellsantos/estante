package br.com.macswell.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="autor")
public class Autor extends PanacheEntityBase{
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome", length = 50, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Livro> livros;

	public Autor(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Autor(String nome) {
		this.nome = nome;
	}
	
	public Autor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	
}
