package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public List<User> userRepository = new ArrayList<>();

    // public User(){
        

    //     elke.addMembershipYear(2000);
    // }

    public UserService() {
        User elke = new User("Elke", 44,"str@str1","str");
        elke.addMembershipYear(2000);
        userRepository.add(elke);
        userRepository.add(new User("Elke", 10,"str@str2","str"));
        userRepository.add(new User("Miyo", 30,"str@str3","str"));
        userRepository.add(new User("John2", 70,"str@str4","str"));
    }

    public List<User> getAllUsers() {
        return userRepository;
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.stream().filter(user -> user.getAge()>age).toList();
    }

    public User getOldestUser() {
        User oldest = null;
        if (userRepository.size()>0) {
            oldest = userRepository.get(0);
            for (User user : userRepository) {
                if (user.getAge() > oldest.getAge())
                    oldest = user;
            }
        }
        return oldest;
    }

    public User getUserWithName(String name) {
        return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public boolean addUser(User user) {
        for(User user1:userRepository){
            if(user.getName().equals(user1.getName()))
                return false;
        }
        return userRepository.add(user);
    }

    public User getUserWithEmail(String email){
        for(User user: userRepository){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public User removeUser(String email){
        for(User user: userRepository){
            if(user.getEmail().equals(email)){
                userRepository.remove(user);
                return user;
            }
        }return null;
    }

    public List<User> getListOfAllUsersWithMembershipFromYear(int year){
        List<User> result = new ArrayList<>();
        for(User user: userRepository){
            if(user.hasMembershipFromYear(year)){
                result.add(user);
            }
        }return result;
    }

    public List<User> getUsersWithAgeAndEmail(int age, String email){
        List<User> result = new ArrayList<>();
        for(User user:userRepository){
            if(user.getAge()==age && user.getEmail().equals(email)){
                result.add(user);
            }
        }return result;
    }

    public List<User> getUsersBetweenAges(int min,int max){
        List<User> result = new ArrayList<>();
        for(User user: userRepository){
            if(user.getAge()>min&&user.getAge()<max){
                result.add(user);
            }
        }return result;
    }
}