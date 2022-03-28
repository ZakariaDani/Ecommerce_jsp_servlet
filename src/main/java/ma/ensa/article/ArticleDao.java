package ma.ensa.article;
import java.util.Set;

import ma.ensa.panier.Panier;

public interface ArticleDao {
    public Set<Article> selectAll();
    public int addArticle(Article article);
	public boolean isArticle(Article article);
	public Set<Article> getByCategory(String ref);
	public Article getByRef(String ref);
	public int updateStock(String ref, String method, Panier panier);
}
