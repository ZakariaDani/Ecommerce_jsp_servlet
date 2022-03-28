package ma.ensa.article;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Objects;
import java.util.Set;

import ma.ensa.panier.Panier;

public class Article {
	private String ref;
	private String titre;
	private String auteur;
	private int stock;
	private String prix;
	private String category;
	ArticleDaoImpl articleDao = new ArticleDaoImpl();
	
	public static class ArticleBuilder{
		private String ref;
		private String titre;
		private String auteur;
		private int stock;
		private String prix;
		private String category;
		
        public ArticleBuilder ref(String ref){
            this.ref = ref;
            return this;
        }
		public ArticleBuilder titre(String titre){
            this.titre = titre;
            return this;
        }
        public ArticleBuilder auteur(String auteur){
            this.auteur = auteur;
            return this;
        }
        public ArticleBuilder stock(int stock){
            this.stock = stock;
            return this;
        }
        public ArticleBuilder prix(String prix){
            this.prix = prix;
            return this;
        }

        public ArticleBuilder category(String category){
            this.category = category;
            return this;
        }
        public Article build(){
        	Article article = new Article();
        	article.ref = ref;
        	article.titre = titre;
        	article.auteur = auteur;
        	article.stock = stock;
        	article.prix = prix;
        	article.category = category;
            return article;
        }
    }
	public String getRef() {
		return String.valueOf(Math.abs(this.hashCode()));
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getStock() {
		return stock;
	}
	public void setPhoto(int stock) {
		this.stock = stock;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		if(titre != null && auteur != null && prix != null && category != null)
			return 2*titre.hashCode()*this.auteur.hashCode()*this.prix.hashCode()*this.category.hashCode();
		else
			return 0;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(ref, other.ref);
	}
	public void addArticleToDB() {
			this.articleDao.addArticle(this);
	}
	public Set<Article> getByCategory(String category) {
		return this.articleDao.getByCategory(category);
	}
	public Set<Article> getArticles(){
		return this.articleDao.selectAll();
	}
	public Article getByRef(String ref) {
		return this.articleDao.getByRef(ref);
	}
	public void stock(String ref, String method, Panier panier) {
		articleDao.updateStock(ref, method, panier);
	}
}
