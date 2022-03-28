package ma.ensa.panier;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.ensa.article.Article;
import ma.ensa.client.Client;

/**
 * Servlet implementation class PanierAllController
 */
public class PanierAllController extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Client currentClient = (Client) session.getAttribute("currentClient");
		Panier panier = new Panier.PanierBuilder()
							.id(currentClient.getId())
							.build();
		Set<Article> articles = panier.getArticlesOnPanier();
		System.out.print(articles);
		request.setAttribute("articles", articles);
		this.getServletContext()
		.getRequestDispatcher("/panier.jsp")
		.forward(request, response);	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
