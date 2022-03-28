package ma.ensa.panier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import ma.ensa.ConnDB;
import ma.ensa.article.Article;
import ma.ensa.client.Client;

public class PanierDaoImpl implements PanierDao {
	private ConnDB connDB;

    public PanierDaoImpl(){
        this.connDB = new ConnDB();
    }
    
	@Override
	public int addToPanier(Panier panier) {
		String req = "INSERT INTO panier VALUES(?,?,?,?);";
        int r = 0;
        try{
        	PreparedStatement prst = connDB.getConn().prepareStatement(req);
        	prst.setString(1,panier.getOrderId());
        	prst.setInt(2,panier.getId());
        	prst.setString(3,panier.getRef());
        	prst.setInt(4,panier.getQuantity());
        	r = prst.executeUpdate();
            System.out.println("ajouté...");
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
	}

	@Override
	public Set<Article> getArticles(int id) {
		// TODO Auto-generated method stub
		Set<Article> articles = new HashSet<>();
        String req = "SELECT * FROM panier,articles WHERE panier.id='"+id+"' AND panier.ref=articles.ref;";
        ResultSet rs = null;
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
            	articles.add( new Article.ArticleBuilder()
                        .ref(rs.getString("ref"))
                        .titre(rs.getString("titre"))
                        .auteur(rs.getString("auteur"))
                        .stock(rs.getInt("quantity"))
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
	public int updateQuantity(Panier panier) {
		// TODO Auto-generated method stub
		String req = "UPDATE panier SET quantity=quantity+1 WHERE panier.ref='"+panier.getRef()+"' AND panier.id='"+panier.getId()+"';";
		int r = 0;
        try{
        		r = connDB.getSt().executeUpdate(req);
                System.out.println("ajouté...");
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
	}

	@Override
	public int deleteArticleFromPanier(Panier panier) {
		// TODO Auto-generated method stub
		String req = "DELETE FROM panier WHERE panier.ref='"+panier.getRef()+"' AND panier.id='"+panier.getId()+"';";
		int r = 0;
        try{
        		r = connDB.getSt().executeUpdate(req);
                System.out.println("ajouté...");
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
	}
	@Override
	public Panier getPanierFromDB(Panier panier) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM panier WHERE panier.ref='"+panier.getRef()+"' AND panier.id='"+panier.getId()+"';";
        ResultSet rs = null;
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
            	panier = new Panier.PanierBuilder()
            			.id(rs.getInt("id"))
                        .ref(rs.getString("ref"))
                        .quantity(rs.getInt("quantity"))
                        .orderId(rs.getString("orderId"))
                        .build();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return panier;
		
	}
}
