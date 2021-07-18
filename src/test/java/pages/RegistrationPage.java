package pages;

import components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {

    private Calendar calendar = new Calendar();

    public void openPage() {
        open("/automation-practice-form");

    }

    public RegistrationPage typeFirstName(String firstName) {

        $("#firstName").val(firstName);
        return this;
    }

    public RegistrationPage typeLasttName(String lastName) {
        $("#lastName").val(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        $("#userEmail").val(email);
        return this;
    }

    public RegistrationPage selectGenger(String gender) {
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    public RegistrationPage typePhone(String phone) {
        $("#userNumber").val(phone);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage typeSubject(String subject) {
        $("#subjectsInput").val(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String pictures) {
        $("#uploadPicture").uploadFromClasspath("./hqdefault-5.jpg");
        return this;

    }
    public RegistrationPage typeAdress(String adress) {
        $("#currentAddress").val(adress);
        return this;
    }
    public RegistrationPage selectState(String state) {
        $("#state").click();
        $("#state").$(byText(state)).click();
        return this;
    }
    public RegistrationPage selectCity(String city) {
        $("#city").click();
        $("#city").$(byText(city)).click();
        return this;
    }
    public RegistrationPage submitForm() {
        $("#submit").click();
        return this;
    }
    public RegistrationPage checkResults(String results){
        $(".table-responsive").shouldHave(text(results));
        return this;
    }
}
