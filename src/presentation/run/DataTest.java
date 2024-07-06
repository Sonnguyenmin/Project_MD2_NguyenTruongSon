package presentation.run;

import constants.Roles;
import entity.User;
import feature.impl.UserFeatureImpl;

import java.util.Date;

public class DataTest {
    static final UserFeatureImpl userFeature = new UserFeatureImpl();

    public static void main(String[] args) {
        User user = new User();
        user.setUserId(1);
        user.setUserName("admin");
        user.setPassword("123456");
        user.setFullName("Nguyễn Trường Sơn");
        user.setEmail("admin@gmail.com");
        user.setRoles(Roles.ROLE_ADMIN);
        user.setCreatedAt(new Date());
        user.setAddress("Văn Giang, Hưng Yên");
        user.setPhone("0353090212");
        user.setStatus(true);
        userFeature.save(user);
//        userFeature.getAll().forEach(User::displayData);
    }
}
