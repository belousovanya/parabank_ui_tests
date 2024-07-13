package tests;

import datas.BankAccount;
import org.junit.jupiter.api.Test;
import pages.RegisterAccountPage;
import utils.TestData;

import static com.codeborne.selenide.Condition.*;

public class RegisterCustomerAccountTest extends TestBase {

    RegisterAccountPage registerAccountPage = new RegisterAccountPage();
    TestData testData = new TestData();

    @Test
    public void userCanCreateAccountWithAllFields() {
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
                .password(generatedBankAccount.getPassword())
                .passwordConfirmation(generatedBankAccount.getPasswordConfirmation())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        String expectedWelcomeText = "Welcome " + bankAccount.getUsername();
        registerAccountPage.getWelcomeTitle().shouldHave(exactText(expectedWelcomeText));
        registerAccountPage.getSuccessMessage().shouldHave(exactText("Your account was created successfully. You are now logged in."));
    }


    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {

        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(testData.generateFakeBankAccount().getFirstName())
                .lastName(testData.generateFakeBankAccount().getLastName())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }


    @Test
    public void userCanNotCreateAccountWithAddressOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .address(testData.generateFakeBankAccount().getAddress())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }


    @Test
    public void userCanNotCreateAccountWithCityOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .city(testData.generateFakeBankAccount().getCity())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }


    @Test
    public void userCanNotCreateAccountWithStateOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .state(testData.generateFakeBankAccount().getState())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithZipCodeOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .zipCode(testData.generateFakeBankAccount().getZipCode())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithPhoneNumberOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .phoneNumber(testData.generateFakeBankAccount().getPhoneNumber())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithSsnOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .ssn(testData.generateFakeBankAccount().getSsn())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithUsernameOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .username(testData.generateFakeBankAccount().getUsername())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithPasswordOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .password(testData.generateFakeBankAccount().getPassword())
                .passwordConfirmation("")
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithPasswordConfirmationOnly() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .passwordConfirmation(testData.generateFakeBankAccount().getPasswordConfirmation())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(exactText("Password is required."));
    }


    @Test
    public void userCanNotCreateAccountWithMismatchedPasswords() {
        registerAccountPage.openRegisterAccountPage();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(testData.generateFakeBankAccount().getFirstName())
                .lastName(testData.generateFakeBankAccount().getLastName())
                .address(testData.generateFakeBankAccount().getAddress())
                .city(testData.generateFakeBankAccount().getCity())
                .state(testData.generateFakeBankAccount().getState())
                .zipCode(testData.generateFakeBankAccount().getZipCode())
                .phoneNumber(testData.generateFakeBankAccount().getPhoneNumber())
                .ssn(testData.generateFakeBankAccount().getSsn())
                .username(testData.generateFakeBankAccount().getUsername())
                .password(testData.generateFakeBankAccount().getPassword())
                .passwordConfirmation(testData.generateFakeBankAccount().getPasswordConfirmation())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getPasswordConfirmationError().shouldHave(exactText("Passwords did not match."));
    }
}
