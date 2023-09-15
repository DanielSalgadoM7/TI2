package dao;

import model.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class ItensDAO extends DAO {	
	public ItensDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Item item) {
		boolean status = false;
		try {
			String sql = "INSERT INTO item (nome, qnt, preco) "
		               + "VALUES ('" + item.getNome() + "', "
		               + item.getQnt() + ", " + item.getPreco() + ", ?, ?);";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Item get(int id) {
		Item item = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM item WHERE id="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 item = new Item(rs.getInt("id"), rs.getInt("qnt"), (float)rs.getDouble("preco");
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return item;
	}
	
	
	public List<Item> get() {
		return get("");
	}
	
	public List<Item> getOrderByID() {
		return get("id");		
	}
  
	public List<Item> getOrderByQnt() {
		return get("qnt");		
	}
  
	public List<Item> getOrderByPreco() {
		return get("preco");		
	}
	
	
	private List<Item> get(String orderBy) {
		List<Item> itens = new ArrayList<Item>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM item" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Item i = new Produto(rs.getInt("id"), rs.getInt("quantidade"), (float)rs.getDouble("preco");
	            itens.add(i);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return itens;
	}
	
	
	public boolean update(Item item) {
		boolean status = false;
		try {  
			String sql = "UPDATE produto SET qnt = '" + produto.getQnt() + "', "
					   + "preco = " + produto.getPreco();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM item WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}
