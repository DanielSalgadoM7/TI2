package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Item {
	private int id;
  private String nome;
	private int qnt;
	private float preco;
	
	public Item() {
		id = -1;
    nome = "";
    qnt = 0;
		preco = 0.00F;
	}

	public Item(int id, int qnt, float preco) {
		setId(id);
    setNome(nome);
    setQnt(qnt);
		setPreco(preco);
	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

  public String getNome() {
		return descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQnt() {
		return qnt;
	}
	
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Item: " + nome + "   Quantidade: R$" + qnt + "   Preço: " + preço;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Item) obj).getID());
	}	
}
