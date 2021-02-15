package br.com.macswell.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.macswell.dto.AutorDto;
import br.com.macswell.service.AutorService;

@Path("/estante/autor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutorRest {
	
	@Inject
	AutorService service;
    
	@GET
    @Operation(summary = "Listar Autores",
            description = "Lista de autores cadastrados")
    @APIResponse(responseCode = "200",
            description = "Retorna a lista de autores cadastrados",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = AutorDto.class))
            }
    )
	public Response listar() {
		return Response
                .status(Response.Status.OK)
                .entity(service.listar())
                .build();
	}
	
	
	@POST
    @Operation(summary = "Cadastrar Autores",
    		description = "Cadastro de autores")
	@APIResponse(responseCode = "201",
    		description = "Retorna a confirmação de adição de um novo autor")
	public Response adicionar(AutorDto dto) {

		service.salvar(dto);

		return Response
		        .status(Response.Status.CREATED)
		        .build();
	}

}
