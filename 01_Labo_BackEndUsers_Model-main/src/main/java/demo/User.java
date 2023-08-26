package demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "users")


public class User {
    public User(){};

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    public long id;

    @Transient List<Integer> membershipYears = new ArrayList<Integer>();
    private String name;
    private int age;
    private String email;
    private String password;
    public User(String name, int age,String email, String password) {
        this.name = name;
        if (age >= 0) 
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
        if(this.email.contains("@"))
            return this.email;
        return null;
    }
    public String getPassword(){
        if(this.password.contains(" "))
            this.password = "t";
        return "@$-"+this.password+"&%#";
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