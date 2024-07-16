package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gestiondb;

/**
 * Servlet implementation class Verifivation
 */
public class Verifivation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Verifivation() {
        super();

    }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                response.getWriter().append("Served at: ").append(request.getContextPath());
        response.sendRedirect("authentificationjsp.jsp");


        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String l=request.getParameter("user");
        String p=request.getParameter("mp");
        Gestiondb gb=new Gestiondb();
        gb.verif(l, p);
        response.sendRedirect("liste.jsp");
        }}