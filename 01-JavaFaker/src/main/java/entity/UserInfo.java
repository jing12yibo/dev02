package entity;

import lombok.Data;

@Data
public class UserInfo {
    //真实姓名
    private String realName;
    //手机
    private String cellPhone;
    //大学
    private String universityName;
    //城市
    private String city;
    //地址
    private String street;
}
