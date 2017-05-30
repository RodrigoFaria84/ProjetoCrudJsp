package manager;

import java.util.List;

import entity.Cliente;
import persistence.ClienteDao;

public class ManagerBean {

	 private List<Cliente> lista;

	 
	public List<Cliente> getLista() {
		try{
			lista = new ClienteDao().findAll();
		}catch(Exception ex){
		}
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}
	
	
	
}
