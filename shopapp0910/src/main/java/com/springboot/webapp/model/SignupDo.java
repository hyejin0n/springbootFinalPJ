package com.springboot.webapp.model;

public class SignupDo {
    //smember 테이블 기반의 DO 멤버변수 구성
    private int usernum;
    private String email;
    private String userName;
    private String passWord;

    @Override
    public String toString(){
        return "SignupDo [usernum=" + usernum + ", email" + email + ", userName=" + userName + ", passWord=" + passWord + "]";
    }

    public int getUsernum() {
        return usernum;
    }

    public void setUsernum(int usernum) {
        this.usernum = usernum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
