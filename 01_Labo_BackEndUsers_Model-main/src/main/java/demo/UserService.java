package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // public List<User> userRepository = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    // public User(){
        

    //     elke.addMembershipYear(2000);
    // }

    public UserService() {
        // User elke = new User("Elke", 44,"str@str1","str");
        // elke.addMembershipYear(2000);
        // userRepository.add(elke);
        // userRepository.add(new User("Elke", 10,"str@str2","str"));
        // userRepository.add(new User("Miyo", 30,"str@str3","str"));
        // userRepository.add(new User("John2", 70,"str@str4","str"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.findUsersByAgeAfter(age);
    }

   

    public User getUserWithName(String name) {
        return userRepository.findUserByName(name);
    }

    public boolean addUser(User user) {
        if (getUserWithEmail(user.getEmail()) != null)
            return false;
        userRepository.save(user);
        return true;
    }

    public User getUserWithEmail(String email){
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            return null;
        }
        
        return userRepository.findUserByEmail(email);
           
    }

    public User removeUser(String email){
        userRepository.deleteByEmail(email);
        return userRepository.findUserByEmail(email);
    }

    public List<User> getListOfAllUsersWithMembershipFromYear(int year){
        List<User> AllUsers = userRepository.findAll();
        List<User> filteredUsers = new ArrayList<>();
        for (User user:AllUsers){
            if(user.membershipYears.contains(year)){
                filteredUsers.add(user);
            }
        }return filteredUsers;

    }

    public List<User> getUsersWithAgeAndEmail(int age, String email){
        return userRepository.findUsersByAgeAndEmail(age,email);
    }

    public List<User> getUsersBetweenAges(int min,int max){
        return userRepository.findUsersByAgeBetween(min, max);
    }
   

    public User getOldestUser() {
        if(userRepository.findAllByOrderByAgeDesc()==null){
            return null;
        }
        return userRepository.findAllByOrderByAgeDesc().get(0);
    }

    public User delete(String email){
        User var = getUserWithEmail(email);
        if(var == null){
            return null;
        }
        userRepository.delete(var);
        return var;
    }
}