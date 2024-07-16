package Controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Etudiant;
import dao.Gestiondb;


/**
 * Servlet implementation class ajouter
 */
public class ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Etudiant e=new Etudiant();
	    Gestiondb g;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajouter() {
        super();
        g=new Gestiondb();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		    int num =Integer.parseInt(request.getParameter("num"));
	        String nom= request.getParameter("nom");
	        String prenom= request.getParameter("prenom");
	        String numr= request.getParameter("numr");
	        e=new Etudiant(num,nom,prenom,numr);
	   
	        g.addEtudiant(e);
	        response.sendRedirect("liste.jsp");
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}