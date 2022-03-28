package ma.ensa.client;

import java.util.Objects;

public class Client {
	public static int counter = 0;
	private int id;
	private String email;
	private String nom;
	private String prenom;
	private String adresse;
	private String password;
	ClientDaoImpl clientDao = new ClientDaoImpl();
	
	public static class ClientBuilder{
		private int id;
		private String email;
		private String nom;
		private String prenom;
		private String adresse;
		private String password;
		
        public ClientBuilder id(int id){
            this.id = id;
            return this;
        }
        public ClientBuilder nom(String nom){
            this.nom = nom;
            return this;
        }
        public ClientBuilder prenom(String prenom){
            this.prenom = prenom;
            return this;
        }
        public ClientBuilder email(String email){
            this.email = email;
            return this;
        }
        public ClientBuilder adresse(String adresse){
            this.adresse = adresse;
            return this;
        }
        public ClientBuilder password(String password){
            this.password = password;
            return this;
        }
        public Client build(){
            Client client = new Client();
            client.id = id;
            client.nom = nom;
            client.prenom = prenom;
            client.email = email;
            client.adresse = adresse;
            client.password = password;
            return client;
        }
    }
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void clientTraitement() {
		
			clientDao.addClient(this);
		
	}
	
	public boolean isClient() {
		return clientDao.isClient(this);
	}
	
	public Client getClientByEmail() {
		return clientDao.getByEmail(this.email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}
	
	
	
}
