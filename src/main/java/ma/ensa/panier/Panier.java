package ma.ensa.panier;

import java.util.Objects;
import java.util.Set;

import ma.ensa.article.Article;

public class Panier {
	private int id;
	private String ref;
	private String orderId;
	private int quantity = 0;
	private PanierDaoImpl panierDao = new PanierDaoImpl();
	
	public static class PanierBuilder{
		private int id;
		private String orderId;
		private String ref;
		private int quantity;
		
        public PanierBuilder ref(String ref){
            this.ref = ref;
            return this;
        }
        public PanierBuilder orderId(String orderId){
            this.orderId = orderId;
            return this;
        }
        public PanierBuilder id(int id){
            this.id = id;
            return this;
        }
        public PanierBuilder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Panier build(){
            Panier panier = new Panier();
            panier.ref = ref;
            panier.id = id;
            panier.orderId = orderId;
            panier.quantity = quantity;
            return panier;
        }
    }

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public void addToDB() {
		panierDao.addToPanier(this);
	}
	public Set<Article> getArticlesOnPanier() {
		// TODO Auto-generated method stub
		return panierDao.getArticles(id);
	}
	public String getOrderId() {
		return "order"+this.hashCode();
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public int hashCode() {
		return id*ref.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Panier other = (Panier) obj;
		return id == other.id && Objects.equals(orderId, other.orderId) && Objects.equals(panierDao, other.panierDao)
				&& Objects.equals(ref, other.ref);
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void Quantity() {
		panierDao.updateQuantity(this);
	}
	public void delete() {
		panierDao.deleteArticleFromPanier(this);
	}
	public Panier getPanier() {
		return panierDao.getPanierFromDB(this);
	}
}
