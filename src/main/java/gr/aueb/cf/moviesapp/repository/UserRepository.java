package gr.aueb.cf.moviesapp.repository;

import gr.aueb.cf.moviesapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT COUNT(U) > 0 FROM User u WHERE u.email = ?1 AND u.password = ?2")
    boolean isUserValid(String username, String password);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = ?1")
    boolean emailExists(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User getUserByEmail(String email);


}
