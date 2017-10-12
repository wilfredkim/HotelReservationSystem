package Pojo;

import javax.enterprise.context.ApplicationScoped;


public class Person {

    private  String person_name;
    private  String person_email;
    private String person_password;
    private  String person_idNumber;
    private String person_phoneNumber;



    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getPerson_password() {
        return person_password;
    }

    public void setPerson_password(String person_password) {
        this.person_password = person_password;
    }

    public String getPerson_idNumber() {
        return person_idNumber;
    }

    public void setPerson_idNumber(String person_idNumber) {
        this.person_idNumber = person_idNumber;
    }

    public String getPerson_phoneNumber() {
        return person_phoneNumber;
    }

    public void setPerson_phoneNumber(String person_phoneNumber) {
        this.person_phoneNumber = person_phoneNumber;
    }
}
