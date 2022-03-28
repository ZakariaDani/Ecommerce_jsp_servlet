package ma.ensa.client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


import ma.ensa.ConnDB;

public class ClientDaoImpl implements ClientDao {
	private ConnDB connDB;

    public ClientDaoImpl(){
        this.connDB = new ConnDB();
    }

	@Override
	public Set<Client> selectAll() {
		Set<Client> clients = new HashSet<>();
        String req = "SELECT * FROM clients;";
        ResultSet rs = null;
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
                clients.add( new Client.ClientBuilder()
                        .id(rs.getInt("id"))
                        .nom(rs.getString("nom"))
                        .prenom(rs.getString("prenom"))
                        .email(rs.getString("email"))
                        .adresse(rs.getString("adresse"))
                        .password(rs.getString("password"))
                        .build()
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return clients;
	}

	@Override
	public int addClient(Client client) {
		
		//String req = "INSERT INTO clients VALUES('"+client.getId()+"','"+client.getEmail()+"','"+client.getNom()+"','"+client.getPrenom()+"','"+client.getAdresse()+"', '"+client.getPassword()+"');";
		String req = "INSERT INTO clients(email,nom,prenom,adresse,password) VALUES(?,?,?,?,?);";
        int r = 0;
        try{
        	if(client.getEmail()!= null && client.getNom() != null && client.getPrenom()!= null && client.getAdresse()!= null && client.getPassword()!= null) {
        		Client.counter++;
        		//r = connDB.getSt().executeUpdate(req);
        		PreparedStatement prst = connDB.getConn().prepareStatement(req);
        		//prst.setInt(1,client.getId());
        		prst.setString(1,client.getEmail());
        		prst.setString(2,client.getNom());
        		prst.setString(3,client.getPrenom());
        		prst.setString(4,client.getAdresse());
        		prst.setString(5,client.getPassword());
        		r = prst.executeUpdate();
                System.out.println("ajouté...");
        	}
        	else {
        		System.out.print("not added...");
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
	}
	
	@Override
	public boolean isClient(Client client) {
        String req = "SELECT * FROM clients WHERE clients.email='"+client.getEmail()+"' AND clients.password='"+client.getPassword()+"';";
        ResultSet rs = null;
        Client client1 = new Client();
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
            	client1 = new Client.ClientBuilder()
            			.id(rs.getInt("id"))
                        .nom(rs.getString("nom"))
                        .prenom(rs.getString("prenom"))
                        .email(rs.getString("email"))
                        .adresse(rs.getString("adresse"))
                        .password(rs.getString("password"))
                        .build();	
            }
            return client.equals(client1); 
            }
        catch (SQLException e){
            e.printStackTrace();
        }
		return false;
	}
	@Override
	public Client getByEmail(String email) {
        String req = "SELECT * FROM clients WHERE clients.email='"+email+"';";
        ResultSet rs = null;
        Client client = new Client();
        try {
            rs = connDB.getSt().executeQuery(req);
            while(rs.next()){
            	client = new Client.ClientBuilder()
            			.id(rs.getInt("id"))
                        .nom(rs.getString("nom"))
                        .prenom(rs.getString("prenom"))
                        .email(rs.getString("email"))
                        .adresse(rs.getString("adresse"))
                        .password(rs.getString("password"))
                        .build();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return client;
	}
}
