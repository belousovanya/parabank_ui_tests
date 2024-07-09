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

    // Добавьте аналогичные методы для остальных тестов
}
