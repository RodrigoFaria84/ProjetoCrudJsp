package persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import entity.Cliente;

public class ClienteDao extends Dao {	
	
	public List<Cliente> findAll() throws Exception{
		open();
		stmt = con.prepareStatement("select * from cliente");
		rs = stmt.executeQuery(); 
		List<Cliente> lst = new ArrayList<Cliente>();
		while(rs.next()){
			Cliente c = new Cliente();
			     c.setIdCliente(rs.getInt(1));
			     c.setNome(rs.getString(2));
			     c.setEmail(rs.getString(3));
			lst.add(c);
		}
		close();
		return lst;
	}

	public Cliente findByCode(Integer cod)throws Exception{
		open();
		  stmt = con.
prepareStatement("select * from cliente where idCliente=?");
		 stmt.setInt(1, cod);
		 rs = stmt.executeQuery();
		 Cliente cliente = null;
		 if (rs.next()){
			 cliente = new Cliente();
			   cliente.setIdCliente(rs.getInt(1));
			   cliente.setNome(rs.getString(2));
			   cliente.setEmail(rs.getString(3));
		 }
		close();
		return cliente;
	}
	
	public void delete(Integer cod)throws Exception{
		open();
		  stmt = con.
prepareStatement("delete from cliente where idCliente=?");
		 stmt.setInt(1, cod);
		 stmt.execute();
		close();
	}
	
	public void update(Cliente c)throws Exception{
		open();
		  stmt = con.
prepareStatement
("update cliente set nome=?,email=? where idCliente=?");
		  stmt.setString(1, c.getNome());
		  stmt.setString(2, c.getEmail());
		  stmt.setInt(3, c.getIdCliente());
	 stmt.execute();
		close();
	}

	

	public void create(Cliente c)throws Exception{
		open();
		  stmt = con.
    prepareStatement("insert into cliente  values (null,?,?)",
    		PreparedStatement.RETURN_GENERATED_KEYS
    		);
		  stmt.setString(1, c.getNome());
		  stmt.setString(2, c.getEmail());
		 stmt.execute();
		 rs = stmt.getGeneratedKeys();
		 rs.next();
		 c.setIdCliente(rs.getInt(1));
		close();
	}
	
	
	//Testando a gravacao
	
	
	public static void main(String[] args) {
		try{
		Cliente c = new Cliente(null,"Usuario","usu@gmail.com");
		ClienteDao dao = new ClienteDao();
		  dao.create(c);
		 System.out.println("Dados Gravados ..." + c);	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
}
