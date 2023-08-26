package demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import demo.UserService.ServiceException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "users")


public class User {

    

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    public long id;

    @Transient List<Integer> membershipYears = new ArrayList<Integer>();
    @NotBlank(message="name may not be empty")
    private String name;
    @Positive(message="age may not be negative")
    private int age;
    @NotBlank
    @Email(message="no valid email")
    private String email;
    @Pattern(regexp = "^[^\\s]*$", message = "password must be minimum 8 characters and may not contain white spaces")
    @Length(min=8,message="password must be minimum 8 characters and may not contain white spaces")
    @Pattern(regexp = ".*\\d.*", message = "password must contain a digit")

    private String password;

    public User(){};
    public User(String name, int age,String email, String password) {

        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
    
    public int countMembershipYearsAfter1999 () {
        int result = 0;
        for(Integer year: membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public int countYearsOfMembership () {
        return membershipYears.size();
    }

    public void addMembershipYear (int year) {
        membershipYears.add(year);
    }

    public int getAge() {
        return this.age;
    }

    public String getName () {
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public int getFirstMembershipYear(){
        if(this.membershipYears.isEmpty())
            return 0;
        int result = this.membershipYears.get(0);
        for(int year:membershipYears){
            if(year<result)
                result = year;
        }return result;
    }
    public String toString(){
        return this.getName()+" is "+this.getAge()+" years old and has as email "+this.getEmail();
    }

    public int getNumberOfMembershipYearsIn2000(){
        int result = 0;
        if(this.membershipYears.contains(2000))
            for(int year:membershipYears){
                if(year<=2000)
                    result += 1;
            }return result;
    }

    public boolean isPasswordCorrect(String password){
        if(this.password.equals(password))
            return true;
        return false;
    }

    public boolean hasMembershipFromYear(int year){
        return membershipYears.contains(year);
    }

    public boolean equals(User otherUser){
        boolean result = false;
        if(this.name.equals(otherUser.getName())){
            if(this.age==otherUser.getAge()){
                if (this.email.equals(otherUser.getEmail())){
                    result = true;
                }
            }
        }return result;
    }

}