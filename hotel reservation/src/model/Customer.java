package model;


import java.util.Objects;
import java.util.regex.Pattern;


public class Customer {
    final String firstName;
    final String lastName;
    final String email;


    public Customer(String firstName, String lastName, String email){
       final String emailRegEx = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegEx);
        if(!(pattern.matcher(email).find())){
            throw new IllegalArgumentException("Please enter an email address in the following format: name@domain.com");

        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }


    public String getFirstName() {

        return firstName;
    }

    /*public void setFirstName(String firstName) {

        this.firstName = firstName;
    }*/

    public String getLastName() {

        return lastName;
    }

   /* public void setLastName(String lastName) {

        this.lastName = lastName;
    }*/

    public String getEmail() {

        return email;
    }

   /* public void setEmail(String email) {

        this.email = email;
    }*/
    /*
    I gained information about why to override equals, and hashcode methods from:
    https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/
    2021.07.19.
     */
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof Customer)){
            return false;
        }
        Customer first = (Customer) object;
        if(!this.getFirstName().equals(first.getFirstName())){
            return false;
        } else if(!this.getLastName().equals(first.getLastName())){
            return false;
        } else if(!this.getEmail().equals(first.getEmail())){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        return Objects.hash(firstName, lastName, email);
    }
    @Override
    public String toString(){
        return "First name: " + getFirstName() + " Last name: " + getLastName() + " Email address: " + getEmail();
    }


}
