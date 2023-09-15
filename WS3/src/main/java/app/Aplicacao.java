package app;

import static spark.Spark.*;
import service.ProdutoService;


public class Aplicacao {
	
	private static ProdutoService produtoService = new ProdutoService();
	
    public static void main(String[] args) {
      //a porta mudou que eu fiz o segundo run
        port(5678);
        
        staticFiles.location("/public");
        
        post("/item/insert", (request, response) -> produtoService.insert(request, response));

        get("/item/:id", (request, response) -> produtoService.get(request, response));
        
        get("/item/list/:orderby", (request, response) -> produtoService.getAll(request, response));

        get("/item/update/:id", (request, response) -> produtoService.getToUpdate(request, response));

        post("/item/update/:id", (request, response) -> produtoService.update(request, response));
           
        get("/item/delete/:id", (request, response) -> produtoService.delete(request, response));

             
    }
}
