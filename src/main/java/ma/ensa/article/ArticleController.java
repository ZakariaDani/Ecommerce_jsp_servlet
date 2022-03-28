package ma.ensa.article;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class ArticleController
 */
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Article article = new Article();
		Set<Article> articles = new HashSet<>();
		if(request.getParameter("catalogue") != null) {
			articles = article.getByCategory(request.getParameter("catalogue"));
		}
		else
			articles = article.getArticles();
		request.setAttribute("articles", articles);
		this.getServletContext()
		.getRequestDispatcher("/catalogue.jsp")
		.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titre = request.getParameter("titre");
		String auteur = request.getParameter("auteur");

		InputStream inputStream = null ;//input stream of uploaded file
		String stock = request.getParameter("stock");
		String prix = request.getParameter("prix");
		String category = request.getParameter("category");
		Article article = new Article.ArticleBuilder()
					                .titre(titre)
					                .auteur(auteur)
					                .prix(prix)
					                .stock(Integer.parseInt(stock))
					                .category(category)
					                .build();
		article.addArticleToDB();
		
		doGet(request, response);
	}

}
