package pmd.di.ubi.pt.wdce;

public class User {

    private String email;
    private String username;
    private String password;
    private Integer score;
    private Integer level;


    public User(String email, String username, String password, Integer score, Integer level) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.score = score;
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
