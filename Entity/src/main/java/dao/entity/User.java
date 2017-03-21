package dao.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class User {


    private int id;

    private String eMail;

    @Column(name = "user_email")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    private String password;

    private String login;

    private String name;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    public int getId() {
        return id;
    }

    @Column(name = "user_psw")
    public String getPassword() {
        return password;
    }

    @Column(name = "user_login")
    public String getLogin() {
        return login;
    }

    @Column(name = "user_name")
    public String getName() {
        return name;
    }

    public User(String password, String login, String name, String eMail) {
        this.password = password;
        this.login = login;
        this.name = name;
        this.eMail = eMail;
    }

    @OneToMany(mappedBy = "user")
    @JoinTable(name = "user_comment", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private Set<Comment> commentList = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JoinTable(name = "user_places", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "place_id"))
    private Set<Place> placeList = new HashSet<>();


}
