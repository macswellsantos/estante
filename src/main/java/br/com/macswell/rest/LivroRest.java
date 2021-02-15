package br.com.macswell.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import br.com.macswell.dto.LivroDto;
import br.com.macswell.service.LivroService;

@Path("/estante")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroRest {
	
	@Inject
	LivroService service;
    
	@GET
    @Operation(summary = "Listar livros",
            description = "Lista de livros cadastrados")
    @APIResponse(responseCode = "200",
            description = "Retorna a lista de livros cadastrados",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = LivroDto.class))
            }
    )
	public Response listar() {
		return Response
                .status(Response.Status.OK)
                .entity(service.listar())
                .build();
	}
	
	@POST
    @Operation(summary = "Cadastrar Livros",
            description = "Cadastro de livros")
    @APIResponse(responseCode = "201",
            description = "Retorna a confirmação de adição de um novo livro")
	public Response adicionar(LivroDto dto) {
		
		service.salvar(dto);
		
		return Response
                .status(Response.Status.CREATED)
                .build();
	}
	
	
	@PUT
	@Path("{id}")
    @Operation(summary = "Editar Livros",
            description = "Realiza a edição de livros cadastrados")
    @APIResponse(responseCode = "200",
            description = "Retorna a confirmação de edição")
	public Response adicionar(@PathParam("id") int id, LivroDto dto) {
		
		service.editar(id, dto);
		
		return Response
                .status(Response.Status.OK)
                .build();
	}
	

	
	@DELETE
	@Path("{id}")
    @Operation(summary = "Exclui Livros",
            description = "Realiza a exclusão de um livro cadastrado")
    @APIResponse(responseCode = "200", description = "Retorna a confirmação de exclusão")
	public Response excluir(@PathParam("id") int id) {
		
		service.excluir(id);
		
		return Response
                .status(Response.Status.OK)
                .build();
	}
    
}