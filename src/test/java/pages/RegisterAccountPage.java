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

    public void register(BankAccount bankAccount) {
        if (bankAccount.getFirstName() != null) {
            firstNameInput.sendKeys(bankAccount.getFirstName());
        }
        if (bankAccount.getLastName() != null) {
            lastNameInput.sendKeys(bankAccount.getLastName());
        }
        if (bankAccount.getAddress() != null) {
            addressInput.sendKeys(bankAccount.getAddress());
        }
        if (bankAccount.getCity() != null) {
            cityInput.sendKeys(bankAccount.getCity());
        }
        if (bankAccount.getState() != null) {
            stateInput.sendKeys(bankAccount.getState());
        }
        if (bankAccount.getZipCode() != null) {
            zipCodeInput.sendKeys(bankAccount.getZipCode());
        }
        if (bankAccount.getPhoneNumber() != null) {
            phoneNumberInput.sendKeys(bankAccount.getPhoneNumber());
        }
        if (bankAccount.getSsn() != null) {
            ssnInput.sendKeys(bankAccount.getSsn());
        }
        if (bankAccount.getUsername() != null) {
            usernameInput.sendKeys(bankAccount.getUsername());
        }
        if (bankAccount.getPassword() != null) {
            passwordInput.sendKeys(bankAccount.getPassword());
        }
        if (bankAccount.getPasswordConfirmation() != null) {
            passwordConfirmationInput.sendKeys(bankAccount.getPasswordConfirmation());
        }

        registerButton.click();
    }
}
