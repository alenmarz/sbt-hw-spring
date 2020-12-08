package ru.sbt.spring.DTO;

import ru.sbt.spring.LoginStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Audit {
    private @Id @GeneratedValue Long id;
    private LocalDateTime dateTime;
    private String login;
    private LoginStatus loginStatus;

    public Audit() {}

    public Audit(String login, LoginStatus loginStatus) {
        this.dateTime = LocalDateTime.now();
        this.login = login;
        this.loginStatus = loginStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", dateTime=" + dateTime +
                ", login='" + login + '\'' +
                ", loginStatus=" + loginStatus;
    }
}
