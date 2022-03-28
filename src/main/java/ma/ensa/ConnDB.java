package ma.ensa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {
    private Connection conn;
    private Statement st;
    public ConnDB(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://ec2-52-48-159-67.eu-west-1.compute.amazonaws.com:5432/d65mdjuqmdjhbt?sslmode=require","fnxejedbbgymcx","43af5350aa7b70c317741056843317aaccfae71e498c743f01d41642553dd86f");
            st = conn.createStatement();
            System.out.println("ok");
            String createTableClients = "CREATE TABLE IF NOT EXISTS clients (id SERIAL NOT NULL, email VARCHAR(255) NOT NULL UNIQUE, nom VARCHAR(255) NOT NULL, prenom VARCHAR(255) NOT NULL, adresse VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, PRIMARY KEY ( id ));";
            String createTableArticles = "CREATE TABLE IF NOT EXISTS articles (ref VARCHAR(255) NOT NULL, titre VARCHAR(255) NOT NULL, auteur VARCHAR(255) NOT NULL, stock INTEGER NOT NULL, prix VARCHAR(255) NOT NULL, category VARCHAR(255) NOT NULL, PRIMARY KEY ( ref ));";
            String createTablePanier = "CREATE TABLE IF NOT EXISTS panier (orderId VARCHAR(255), id INTEGER, ref VARCHAR(255), quantity INTEGER, PRIMARY KEY ( orderId ), FOREIGN KEY(id) REFERENCES clients(id), FOREIGN KEY(ref) REFERENCES articles(ref));";
            st.executeUpdate(createTableClients);
            st.executeUpdate(createTableArticles);
            st.executeUpdate(createTablePanier);
            System.out.println("Created tables in given database...");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement getSt(){
        return st;
    }

	public Connection getConn() {
		return conn;
	}
    
}
