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
 * Servlet implementation class PanierController
 */
public class PanierController extends HttpServlet {
	private static final long serialVersionUID = 5L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext()
		.getRequestDispatcher("/panier.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Article article = new Article();
		Client currentClient = (Client)session.getAttribute("currentClient");
		String refArticle = request.getParameter("refArticle");
		Panier panier = new Panier.PanierBuilder()
							.id(currentClient.getId())
							.ref(refArticle)
							.build();
		Article artcl = article.getByRef(refArticle);
		if(refArticle != null) {
			if(artcl.getStock() > 0) {
				panier.addToDB();
				article.stock(refArticle, "UP", panier);
				panier.Quantity();
			}
				
		}
			
		
		Set<Article> articles = panier.getArticlesOnPanier();
		
		request.setAttribute("articles", articles);
		
		doGet(request, response);
	}

}
