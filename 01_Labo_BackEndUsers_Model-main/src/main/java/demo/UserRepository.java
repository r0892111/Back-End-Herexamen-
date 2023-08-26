package demo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends JpaRepository<User, Long> {
 public List<User> findUsersByAgeAfter(int age);
 public User findUserByEmail(String email);
 public User findUserByName(String name);

 public User deleteByEmail(String email);
 public List<User> findAll();
 public List<User> findUsersByAgeAndEmail(int age, String email);
 public List<User> findUsersByAgeBetween(int age1, int age2);
 public List<User> findAllByOrderByAgeDesc();
}
