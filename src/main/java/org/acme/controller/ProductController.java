package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ProductDTO;
import org.acme.service.ProductService;

import java.util.List;

@Path("api/products") // caminho que os arquivos externos vao consumir os endpoints
public class ProductController {

    @Inject
    ProductService productService;

    @GET // metodo que mostra os arquivos
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> findAllProducts(){
        return productService.getAllProducts();
    }

    @POST // metodo que adiciona os arquivos
    @Transactional // identifica a classe que vai alterar o estado do banco de dados
    public Response saveProduct(ProductDTO productDTO){
        try{
            productService.createNewProduct(productDTO);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT // metodo que adiciona os arquivos
    @Path("/{id}")
    @Transactional // identifica a classe que vai alterar o estado do banco de dados @PathParam com @Path-id ira exigir o id do arquivo para que ocorra a ação
    public Response changeProduct(@PathParam("id") Long id, ProductDTO productDTO){
        try{
            productService.changeProduct(id,productDTO);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE // metodo que faz um delete no banco de dados
    @Path("/{id}")
    @Transactional  // identifica a classe que vai alterar o estado do banco de dados @PathParam com @Path-id  ira exigir o id do arquivo para que ocorra a ação
    public Response removeProduct(@PathParam("id") Long id){
        try{
            productService.deleteProduct(id);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }


}
