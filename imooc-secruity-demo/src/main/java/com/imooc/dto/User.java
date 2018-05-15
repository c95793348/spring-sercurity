package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyContraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by wbcaoa on 2018/5/14.
 */
public class User {

    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{}

    private String id;
    @MyContraint(message = "测试自定义注解提示!")
    private String username;
    @NotBlank(message = "密码不能为空!")
    private String password;

    @Past(message = "生日不能是将来时")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
