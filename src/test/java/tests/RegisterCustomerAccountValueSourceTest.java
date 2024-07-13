package tests;

import datas.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegisterAccountPage;
import utils.TestData;


public class RegisterCustomerAccountValueSourceTest extends TestBase {

    RegisterAccountPage registerAccountPage = new RegisterAccountPage();
    TestData testData = new TestData();

    @ValueSource(strings = {
            "Пэрис", "Paris", "Paris123"
    })
    @ParameterizedTest(name = "Пользователь может создать аккаунт с именем {0}")
    @DisplayName("Пользователь может создать аккаунт с именами разного формата")
    @Tag("SMOKE")
    public void userCanCreateAccountWithDifferentFirstName(String name) {
        registerAccountPage.openRegisterAccountPage();

        BankAccount generatedBankAccount = testData.generateFakeBankAccount();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(name)
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
    }

}
