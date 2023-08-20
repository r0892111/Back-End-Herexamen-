package demo;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int age;
    private String email;
    private String password;
    private List<Integer> membershipYears = new ArrayList<Integer>();

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

}