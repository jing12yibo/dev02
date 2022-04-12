package test;

import com.github.javafaker.Faker;
import entity.UserInfo;
import org.junit.Test;

import java.util.Locale;

public class FakerTest {
    @Test
    public void testFaker() {
        Faker faker = new Faker((Locale.CHINA));

        for (int i = 0; i<10;i++) {
            UserInfo userInfo = new UserInfo();

            userInfo.setRealName(faker.name().fullName());
            userInfo.setCellPhone(faker.phoneNumber().cellPhone());
            userInfo.setCity(faker.address().city());
            userInfo.setStreet(faker.address().streetAddress());
            userInfo.setUniversityName(faker.university().name());
            System.out.println("userInfo = " + userInfo);
        }
    }
}
