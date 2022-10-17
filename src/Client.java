import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Client {
    public String userName;
    public String password;
    public Account account;

    public Client(String userName, String password, float balance ) {
        this.userName = userName;
        this.password = password;
        Date date = Date.from(Instant.now());
        this.account = new Account(balance, date);
    }

    public boolean validateLogin(String user, String password){
        return Objects.equals(this.userName, user) && Objects.equals(this.password, password);
    }

    @Override
    public String toString() {
        return"Name : " + userName +
                " Account No.: " + account.id +
                " password: " + "****" + '\n';
    }
}