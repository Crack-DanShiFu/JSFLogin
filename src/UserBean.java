import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean {
    private String name;
    private String password;

    public UserBean() {
    }

    public UserBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String verify() {
        if (DBUtils.getInstance().verifyPasswd(this.name, this.password)) {
            System.out.println("success");
            return "success";
        }else {
            return "failure";
        }
    }
}
