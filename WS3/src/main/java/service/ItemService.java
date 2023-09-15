package service;

import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import dao.ItemDAO;
import model.Item;
import spark.Request;
import spark.Response;


public class ItemService {

	private ItemDAO itemDAO = new ItemDAO();
	private String form;
	private final int FORM_INSERT = 1;
	private final int FORM_DETAIL = 2;
	private final int FORM_UPDATE = 3;
	private final int FORM_ORDERBY_ID = 1;
	private final int FORM_ORDERBY_NOME = 2;
  private final int FORM_ORDERBY_QNT = 3;
	private final int FORM_ORDERBY_PRECO = 4;
	
	
	public ItemService() {
		makeForm();
	}

	
	public void makeForm() {
		makeForm(FORM_INSERT, new Item(), FORM_ORDERBY_NOME);
	}

	
	public void makeForm(int orderBy) {
		makeForm(FORM_INSERT, new Item(), orderBy);
	}

	
	public void makeForm(int tipo, Item item, int orderBy) {
		String nomeArquivo = "form.html";
		form = "";
		try{
			Scanner entrada = new Scanner(new File(nomeArquivo));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
		
		String umItem = "";
		if(tipo != FORM_INSERT) {
			umRPG += "\t<table width=\"80%\" bgcolor=\"#f3f3f3\" align=\"center\">";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;<a href=\"/item/list/1\">Novo Item</a></b></font></td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t</table>";
			umRPG += "\t<br>";			
		}
		
		if(tipo == FORM_INSERT || tipo == FORM_UPDATE) {
			String action = "/item/";
			String titulo, nome, buttonLabel;
			if (tipo == FORM_INSERT){
				action += "insert";
				titulo = "Inserir Produto";
				descricao = "cura, fogo, flecha, ...";
				buttonLabel = "Inserir";
			} else {
				action += "update/" + produto.getID();
				titulo = "Atualizar Item (ID " + produto.getID() + ")";
				nome = produto.getNome();
				buttonLabel = "Atualizar";
			}
			umRPG += "\t<form class=\"form--register\" action=\"" + action + "\" method=\"post\" id=\"form-add\">";
			umRPG += "\t<table width=\"80%\" bgcolor=\"#f3f3f3\" align=\"center\">";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;" + titulo + "</b></font></td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td>&nbsp;Nome: <input class=\"input--register\" type=\"text\" titulo=\"nome\" value=\""+ nome +"\"></td>";
      umRPG += "\t\t\t<td>Quantidade: <input class=\"input--register\" type=\"text\" titulo=\"qnt\" value=\""+ item.getQnt() +"\"></td>";
			umRPG += "\t\t\t<td>Preco: <input class=\"input--register\" type=\"text\" titulo=\"preco\" value=\""+ item.getPreco() +"\"></td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td align=\"center\"><input type=\"submit\" value=\""+ buttonLabel +"\" class=\"input--main__style input--button\"></td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t</table>";
			umRPG += "\t</form>";		
		} else if (tipo == FORM_DETAIL){
			umRPG += "\t<table width=\"80%\" bgcolor=\"#f3f3f3\" align=\"center\">";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;Detalhar Item (ID " + item.getID() + ")</b></font></td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td>&nbsp;Nome: "+ item.getNome() +"</td>";
      umRPG += "\t\t\t<td>Quantidade: "+ item.getQnt() +"</td>";
			umRPG += "\t\t\t<td>Preco: "+ item.getPreco() +"</td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t\t<tr>";
			umRPG += "\t\t\t<td>&nbsp;</td>";
			umRPG += "\t\t</tr>";
			umRPG += "\t</table>";		
		} else {
			System.out.println("ERRO! Tipo não identificado " + tipo);
		}
		form = form.replaceFirst("<UM-RPG>", umProduto);
		
