package pages;

import com.codeborne.selenide.SelenideElement;
import datas.BankAccount;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class RegisterAccountPage {
    public SelenideElement firstNameInput = $("#customer\\.firstName"),
            lastNameInput = $("#customer\\.lastName"),
            addressInput = $("#customer\\.address\\.street"),
            cityInput = $("#customer\\.address\\.city"),
            stateInput = $("#customer\\.address\\.state"),
            zipCodeInput = $("#customer\\.address\\.zipCode"),
            phoneNumberInput = $("#customer\\.phoneNumber"),
            ssnInput = $("#customer\\.ssn"),
            usernameInput = $("#customer\\.username"),
            passwordInput = $("#customer\\.password"),
            passwordConfirmationInput = $("#repeatedPassword"),
            registerButton = $(byAttribute("value", "Register")),

    // Поля ошибок
            firstNameError = $("#customer\\.firstName\\.errors"),
            lastNameError = $("#customer\\.lastName\\.errors"),
            addressError = $("#customer\\.address\\.street\\.errors"),
            cityError = $("#customer\\.address\\.city\\.errors"),
            stateError = $("#customer\\.address\\.state\\.errors"),
            zipCodeError = $("#customer\\.address\\.zipCode\\.errors"),
            ssnError = $("#customer\\.ssn\\.errors"),
            usernameError = $("#customer\\.username\\.errors"),
            passwordError = $("#customer\\.password\\.errors"),
            passwordConfirmationError = $("#repeatedPassword\\.errors"),
            welcomeTitle = $("#rightPanel h1.title"),
            successMessage = $("#rightPanel p");

    public void openRegisterAccountPage() {
        open("/parabank/register.htm");
    }

    private void fillInputField(SelenideElement element, String value) {
        if (value != 0) {
            element.sendKeys(value);
        }
    }

    public void register(BankAccount bankAccount) {
        fillInputField(firstNameInput, bankAccount.getFirstName());
        fillInputField(lastNameInput, bankAccount.getLastName());
        fillInputField(addressInput, bankAccount.getAddress());
        fillInputField(cityInput, bankAccount.getCity());
        fillInputField(stateInput, bankAccount.getState());
        fillInputField(zipCodeInput, bankAccount.getZipCode());
        fillInputField(phoneNumberInput, bankAccount.getPhoneNumber());
        fillInputField(ssnInput, bankAccount.getSsn());
        fillInputField(usernameInput, bankAccount.getUsername());
        fillInputField(passwordInput, bankAccount.getPassword());
        fillInputField(passwordConfirmationInput, bankAccount.getPasswordConfirmation());


        registerButton.click();
    }

    public String getWelcomeText(String username) {
        return "Welcome " + username;
    }
}
