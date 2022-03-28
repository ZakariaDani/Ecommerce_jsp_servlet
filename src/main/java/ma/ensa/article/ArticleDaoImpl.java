package ma.ensa.article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


import ma.ensa.ConnDB;
import ma.ensa.panier.Panier;

public class ArticleDaoImpl implements ArticleDao {
	private ConnDB connDB;

    public ArticleDaoImpl(){
        this.connDB = new ConnDB();
    }

	@Override
	public Set<Article> selectAll() {
		Set<Article> articles = new HashSet<>();
        String req = "SELECT * FROM articles;";
        ResultSet rs = null;
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
            	articles.add( new Article.ArticleBuilder()
                        .ref(rs.getString("ref"))
                        .titre(rs.getString("titre"))
                        .auteur(rs.getString("auteur"))
                        .stock(rs.getInt("stock"))
                        .prix(rs.getString("prix"))
                        .category(rs.getString("category"))
                        .build()
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return articles;
	}

	@Override
	public int addArticle(Article article) {
	  
		String req = "INSERT INTO articles VALUES(?,?,?,?,?,?);";

        int r = 0;
        try{
        	if(article.hashCode() != 0) {
        		PreparedStatement prst = connDB.getConn().prepareStatement(req);
        		prst.setString(1,article.getRef());
        		prst.setString(2,article.getTitre());
        		prst.setString(3,article.getAuteur());
        		prst.setInt(4, article.getStock());
        		prst.setString(5,article.getPrix());
        		prst.setString(6,article.getCategory());
        		r = prst.executeUpdate();
                System.out.println("article ajouté...");
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
	}
	
	@Override
	public boolean isArticle(Article article) {
        String req = "SELECT * FROM articles WHERE articles.ref='"+article.getRef()+"';";
        ResultSet rs = null;
        Article article1 = new Article();
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
            	article1 = new Article.ArticleBuilder()
            			.ref(rs.getString("ref"))
                        .titre(rs.getString("titre"))
                        .auteur(rs.getString("auteur"))
                        .stock(rs.getInt("stock"))
                        .prix(rs.getString("prix"))
                        .category(rs.getString("category"))
                        .build();	
            }
            return article.equals(article1); 
            }
        catch (SQLException e){
            e.printStackTrace();
        }
		return false;
	}
	@Override
	public Set<Article> getByCategory(String category) {
		Set<Article> articles = new HashSet<>();
        String req = "SELECT * FROM articles WHERE articles.category='"+category+"';";
        ResultSet rs = null;
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
            	articles.add(new Article.ArticleBuilder()
            			.ref(rs.getString("ref"))
                        .titre(rs.getString("titre"))
                        .auteur(rs.getString("auteur"))
                        .stock(rs.getInt("stock"))
                        .prix(rs.getString("prix"))
                        .category(rs.getString("category"))
                        .build()
                        );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return articles;
	}
	@Override
	public Article getByRef(String ref) {
		// TODO Auto-generated method stub
		Article article = new Article();
        String req = "SELECT * FROM articles WHERE articles.ref='"+ref+"';";
        ResultSet rs = null;
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
            	article = new Article.ArticleBuilder()
            			.ref(rs.getString("ref"))
                        .titre(rs.getString("titre"))
                        .auteur(rs.getString("auteur"))
                        .stock(rs.getInt("stock"))
                        .prix(rs.getString("prix"))
                        .category(rs.getString("category"))
                        .build();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return article;
	}

	@Override
	public int updateStock(String ref, String method, Panier panier) {
		// TODO Auto-generated method stub
	
		String req1 = "";
		System.out.println(panier.getQuantity());
		if(method.equals("UP"))
			req1 = "UPDATE articles SET stock=stock-1 WHERE articles.ref='"+ref+"';";
		if(method.equals("DOWN"))
			req1 = "UPDATE articles SET stock=stock+"+panier.getQuantity()+" WHERE articles.ref='"+ref+"';";
		int r = 0;
        try{
        		r = connDB.getSt().executeUpdate(req1);
                System.out.println("ajouté...");
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
	}

}
