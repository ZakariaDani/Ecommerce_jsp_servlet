package ma.ensa.client;
import java.util.Set;

public interface ClientDao {
    public Set<Client> selectAll();
    public int addClient(Client client);
	public boolean isClient(Client client);
	public Client getByEmail(String email);
}
