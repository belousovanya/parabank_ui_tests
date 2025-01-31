package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import datas.BankAccount;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class RegisterAccountPage {

    private static final String REGISTER_URL = "/parabank/register.htm";

    private SelenideElement firstNameInput = $("#customer\\.firstName");
    private SelenideElement lastNameInput = $("#customer\\.lastName");
    private SelenideElement addressInput = $("#customer\\.address\\.street");
    private SelenideElement cityInput = $("#customer\\.address\\.city");
    private SelenideElement stateInput = $("#customer\\.address\\.state");
    private SelenideElement zipCodeInput = $("#customer\\.address\\.zipCode");
    private SelenideElement phoneNumberInput = $("#customer\\.phoneNumber");
    private SelenideElement ssnInput = $("#customer\\.ssn");
    private SelenideElement usernameInput = $("#customer\\.username");
    private SelenideElement passwordInput = $("#customer\\.password");
    private SelenideElement passwordConfirmationInput = $("#repeatedPassword");
    private SelenideElement registerButton = $(byAttribute("value", "Register"));

    // Поля ошибок
    private SelenideElement firstNameError = $("#customer\\.firstName\\.errors");
    private SelenideElement lastNameError = $("#customer\\.lastName\\.errors");
    private SelenideElement addressError = $("#customer\\.address\\.street\\.errors");
    private SelenideElement cityError = $("#customer\\.address\\.city\\.errors");
    private SelenideElement stateError = $("#customer\\.address\\.state\\.errors");
    private SelenideElement zipCodeError = $("#customer\\.address\\.zipCode\\.errors");
    private SelenideElement ssnError = $("#customer\\.ssn\\.errors");
    private SelenideElement usernameError = $("#customer\\.username\\.errors");
    private SelenideElement passwordError = $("#customer\\.password\\.errors");
    private SelenideElement passwordConfirmationError = $("#repeatedPassword\\.errors");
    private SelenideElement welcomeTitle = $("#rightPanel h1.title");
    private SelenideElement successMessage = $("#rightPanel p");

    public static RegisterAccountPage open() {
        return Selenide.open(REGISTER_URL, RegisterAccountPage.class);
    }

    public void register(BankAccount bankAccount) {
        firstNameInput.val(bankAccount.getFirstName());
        lastNameInput.val(bankAccount.getLastName());
        addressInput.val(bankAccount.getAddress());
        cityInput.val(bankAccount.getCity());
        stateInput.val(bankAccount.getState());
        zipCodeInput.val(bankAccount.getZipCode());
        phoneNumberInput.val(bankAccount.getPhoneNumber());
        ssnInput.val(bankAccount.getSsn());
        usernameInput.val(bankAccount.getUsername());
        passwordInput.val(bankAccount.getPassword());
        passwordConfirmationInput.val(bankAccount.getPasswordConfirmation());

        registerButton.click();
    }

    public String getWelcomeText() {
        return welcomeTitle.getText();
    }
}
