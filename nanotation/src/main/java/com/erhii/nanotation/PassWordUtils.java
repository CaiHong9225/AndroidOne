package com.erhii.nanotation;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.nanotation
 * @ClassName: PassWordUtils
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/19 15:44
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/19 15:44
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PassWordUtils {

    @UserCases(id = "47", description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }
    @UserCases(id = "48")
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }
}
