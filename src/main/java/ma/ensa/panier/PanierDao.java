package ma.ensa.panier;

import java.util.Set;

import ma.ensa.article.Article;

public interface PanierDao {
	public int addToPanier(Panier panier);
	public Set<Article> getArticles(int id);
	public int updateQuantity(Panier panier);
	public int deleteArticleFromPanier(Panier panier);
	public Panier getPanierFromDB(Panier panier);
}
