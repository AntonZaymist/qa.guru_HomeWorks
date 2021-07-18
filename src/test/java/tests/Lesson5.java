package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class Lesson5 {
    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Male";
    String phone = "9855553366";
    String day = "18";
    String month = "March";
    String year = "1999";
    String subject = "Computer Science";
    String hobbies = "Sports";
    String pictures = "hqdefault-5.jpg";
    String adress = "Moscow Krasnopresnenskaya, 12";
    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
            .typeLasttName(lastName)
            .typeEmail(email)
            .selectGenger(gender)
            .typePhone(phone)
            .setDateOfBirth(day, month, year)
            .typeSubject(subject)
            .selectHobbies(hobbies)
            .uploadPicture(pictures)
            .typeAdress(adress)
            .selectState(state)
            .selectCity(city)
            .submitForm();


        //Проверка
        registrationPage.checkResults(firstName+ " " + lastName)
                .checkResults(email)
                .checkResults(gender)
                .checkResults(phone)
                .checkResults(day+ " " +month+ "," +year)
                .checkResults(subject)
                .checkResults(subject)
                .checkResults(subject)
                .checkResults(hobbies)
                .checkResults(pictures)
                .checkResults(adress)
                .checkResults(state)
                .checkResults(city);

    }
}


