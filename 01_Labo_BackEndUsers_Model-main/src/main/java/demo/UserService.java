package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public List<User> userRepository = new ArrayList<>();

    public UserService() {
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
        }return null;
    }

    public User removeUser(String email){
        for(User user: userRepository){
            if(user.getEmail().equals(email)){
                userRepository.remove(user);
                return user;
            }
        }return null;
    }

    public List getListOfAllUsersWithMembershipFromYear(int year){
        List<User> result = new ArrayList<>();
        for(User user: userRepository){
            if(user.hasMembershipFromYear(year)){
                result.add(user);
            }
        }return result;
    }
}