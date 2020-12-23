import java.util.HashMap;

public class Information {
    private String name, surname, email, phone, birthdate, sex;
    private HashMap<String, String> languages;

    public Information() {
        languages = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public HashMap<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(HashMap<String, String> languages) {
        this.languages = languages;
    }

    public void addLanguages(String language, String level) {
        languages.put(language, level);
    }
}
