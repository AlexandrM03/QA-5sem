package service;

import model.User;

import java.util.Locale;
import java.util.ResourceBundle;

public class UserFactory {
    public static User getUserInfo() {
        return new User(TestDataReader.getTestData("email"),
                        TestDataReader.getTestData("password"));
    }
}
