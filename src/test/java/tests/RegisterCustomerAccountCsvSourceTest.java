package tests;

import datas.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import pages.RegisterAccountPage;
import utils.TestData;

import static com.codeborne.selenide.Condition.exactText;

public class RegisterCustomerAccountCsvSourceTest extends TestBase {

    RegisterAccountPage registerAccountPage = new RegisterAccountPage();
    TestData testData = new TestData();

    @CsvFileSource(resources = "/test_data/registerAccountValidData.csv")
    @ParameterizedTest
    @Tag("SMOKE")
    @DisplayName("Пользователь может создать аккаунт с корректными данными")
    public void userCanCreateAccountWithAllFields(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String username, String password, String passwordConfirmation) {

        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .city(city)
                .state(state)
                .zipCode(zipCode)
                .phoneNumber(phoneNumber)
                .ssn(ssn)
                .username(username)
                .password(password)
                .passwordConfirmation(passwordConfirmation)
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        String expectedWelcomeText = "Welcome " + username;
        registerAccountPage.getWelcomeTitle().shouldHave(exactText(expectedWelcomeText));
        registerAccountPage.getSuccessMessage().shouldHave(exactText("Your account was created successfully. You are now logged in."));
    }


    @ParameterizedTest
    @CsvSource({
            "password123, differentpassword123"
    })
    @Tag("SMOKE")
    @DisplayName("Пользователь не может создать аккаунт с несовпадающими паролями")
    public void userCannotCreateAccountWithMismatchedPasswords(String password, String passwordConfirmation) {
        registerAccountPage.openRegisterAccountPage();

        BankAccount generatedBankAccount = testData.generateFakeBankAccount();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(generatedBankAccount.getFirstName())
                .lastName(generatedBankAccount.getLastName())
                .address(generatedBankAccount.getAddress())
                .city(generatedBankAccount.getCity())
                .state(generatedBankAccount.getState())
                .zipCode(generatedBankAccount.getZipCode())
                .phoneNumber(generatedBankAccount.getPhoneNumber())
                .ssn(generatedBankAccount.getSsn())
                .username(generatedBankAccount.getUsername())
                .password(password)
                .passwordConfirmation(passwordConfirmation)
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Passwords did not match."));
    }
}
