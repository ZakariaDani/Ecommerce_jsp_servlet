package ma.ensa.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignINController
 */
public class SignINController extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignINController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("currentClient") != null) {
			this.getServletContext()
			.getRequestDispatcher("/acceuil1.jsp")
			.forward(request, response);
		}else {
			this.getServletContext()
			.getRequestDispatcher("/identification.jsp")
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		client.setEmail(request.getParameter("email"));
		client.setPassword(request.getParameter("password"));

		boolean isValidClient = client.isClient();
		if(isValidClient){
			HttpSession session = request.getSession();
			Client currentClient = client.getClientByEmail();
			session.setAttribute("currentClient", currentClient);
			doGet(request, response);
		}else {
			request.setAttribute("invalidUser", true);
			this.getServletContext()
			.getRequestDispatcher("/inscription.jsp")
			.forward(request, response);
		}
	}

}
