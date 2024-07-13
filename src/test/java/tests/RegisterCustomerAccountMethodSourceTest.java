package tests;

import datas.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.RegisterAccountPage;
import utils.TestData;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.exactText;

public class RegisterCustomerAccountMethodSourceTest extends TestBase {

    RegisterAccountPage registerAccountPage = new RegisterAccountPage();

    static Stream<BankAccount> invalidBankAccountsProvider() {
        TestData testData = new TestData();
        return Stream.of(
                BankAccount.builder().firstName(testData.generateFakeBankAccount().getFirstName()).build(),
                BankAccount.builder().address(testData.generateFakeBankAccount().getAddress()).build(),
                BankAccount.builder().city(testData.generateFakeBankAccount().getCity()).build(),
                BankAccount.builder().state(testData.generateFakeBankAccount().getState()).build(),
                BankAccount.builder().zipCode(testData.generateFakeBankAccount().getZipCode()).build(),
                BankAccount.builder().phoneNumber(testData.generateFakeBankAccount().getPhoneNumber()).build(),
                BankAccount.builder().ssn(testData.generateFakeBankAccount().getSsn()).build(),
                BankAccount.builder().username(testData.generateFakeBankAccount().getUsername()).build(),
                BankAccount.builder().password(testData.generateFakeBankAccount().getPassword()).passwordConfirmation("").build(),
                BankAccount.builder().passwordConfirmation(testData.generateFakeBankAccount().getPasswordConfirmation()).build()
        );
    }

    @MethodSource("invalidBankAccountsProvider")
    @ParameterizedTest
    @Tag("SMOKE")
    @DisplayName("Пользователь не может создать аккаунт без заполнения обязательных полей")

    public void userCannotCreateAccountWithInvalidData(BankAccount bankAccount) {
        registerAccountPage.openRegisterAccountPage();
        registerAccountPage.register(bankAccount);

        if (bankAccount.getFirstName() == null) {
            registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        }
        if (bankAccount.getLastName() == null) {
            registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        }
        if (bankAccount.getAddress() == null) {
            registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        }
        if (bankAccount.getCity() == null) {
            registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        }
        if (bankAccount.getState() == null) {
            registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        }
        if (bankAccount.getZipCode() == null) {
            registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        }
        if (bankAccount.getSsn() == null) {
            registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        }
        if (bankAccount.getUsername() == null) {
            registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        }
        if (bankAccount.getPassword() == null) {
            registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        }
    }
}