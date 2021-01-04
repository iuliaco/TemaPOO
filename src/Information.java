import java.time.LocalDate;
import java.util.HashMap;

public class Information {
    private String name, email, phone, sex;
    LocalDate birthdate;
    private HashMap<String, String> languages;

    public Information() {
        languages = new HashMap<>();
    }

    public Information(String name, String email, String phone, LocalDate birthdate, String sex) {
        languages = new HashMap<>();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
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

    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdate=" + birthdate +
                ", languages=" + languages +
                '}';
    }
}
