package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import persistence.ClienteDao;

@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
	  List<Cliente> lst = new ClienteDao().findAll();
	  request.setAttribute("lista", lst);

	
        String cmd= request.getParameter("cmd");
	      if (cmd.equals("editar")){
		      editar(request,response);
	        }else if(cmd.equals("excluir")){
		    excluir(request,response);
	     }
	    
    }catch(Exception ex){
    	
    }
	}
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String cmd= request.getParameter("cmd");
	    if (cmd.equals("cadastrar")){
		    cadastrar(request,response);
		    
	    }else if(cmd.equals("alterar")){
	    	
		    alterar(request,response);
	    }
	}
	
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cliente c = new Cliente();
		  c.setNome(request.getParameter("nome"));
	      c.setEmail(request.getParameter("email"));
	      try{
	    	   new ClienteDao().create(c);
	    	   request.setAttribute("msg", "Dados Gravados");
	    	  
	      }catch(Exception ex){
	    	   request.setAttribute("msg",  "Error :" + ex.getMessage());
	      }
	      finally{
	    	  request.getRequestDispatcher("sistema.jsp").
	    	     forward(request, response);
	      }
	}
	
	
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		Integer idCliente = new Integer(request.getParameter("idCliente"));
    try{
		  Cliente cliente = new ClienteDao().findByCode(idCliente);
		  request.setAttribute("cliente",cliente);
		     
	}catch(Exception ex){
	  	 request.setAttribute("msg","Error :" + ex.getMessage());
	}
	
	finally{
		
		request.getRequestDispatcher("editar.jsp").
		    forward(request,response);
	}
	
 }
	
	protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		Integer idCliente = new Integer(request.getParameter("idCliente"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		try{
			Cliente c = new Cliente(idCliente, nome, email);
			new ClienteDao().update(c);
			request.setAttribute("cliente",c);
		}catch(Exception ex){
          request.setAttribute("msg","Error :" + ex.getMessage());
		}
        finally{
  request.getRequestDispatcher("sistema.jsp").forward(request,response);
       }
  }
	
	protected void consultarCodigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void consultarTodos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 Integer idCliente =
			 new Integer(request.getParameter("idCliente"));
	 
	 try{
		 ClienteDao cd = new ClienteDao();
		 Cliente cliente = cd.findByCode(idCliente);  
		 cd.delete(idCliente); 
		 
		 
		 String real =
			request.getServletContext().getRealPath("/txt/log.txt");

		 
		 System.out.println(real); 
		   
		    File f = new File(real);
		    FileWriter fw =new FileWriter(f, true);
		    fw.write(cliente.toString() + "\n");
		    fw.flush();
		  
		  fw.close();
		 
		 request.setAttribute("cliente", cliente);   
		 
	 }catch(Exception ex){
		 request.setAttribute("msg","Error :" + ex.getMessage());
	 }
	 finally{
		 request.getRequestDispatcher("sistema.jsp").
		    forward(request, response);
	 }
	 
		
	}
	
	

	
	
}
