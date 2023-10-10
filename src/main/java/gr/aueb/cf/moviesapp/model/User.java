package gr.aueb.cf.moviesapp.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "FAV_USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;

    //relations

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Favorite> favorites;

    protected List<Favorite> getFavorites() {
        return favorites;
    }

    protected void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public List<Favorite> getAllFavorites() {
        return Collections.unmodifiableList(getFavorites());
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
