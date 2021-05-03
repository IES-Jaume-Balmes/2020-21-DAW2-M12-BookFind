

@Entity
public class Employee {



    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empleatId;

    private String nom;
    private String username;
    private String psw;

    public Employee() {
    }

    public Employee(String nom, String username, String psw) {
        super();
        this.nom = nom;
        this.username = username;
        this.psw = psw;
    }

    public long getEmpleatId() {
        return empleatId;
    }

    public void setEmpleatId(long empleatId) {
        this.empleatId = empleatId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}