package utils;

import com.github.javafaker.Faker;
import datas.BankAccount;

import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en"));

    public static BankAccount generateFakeBankAccount() {
        String password = faker.internet().password();
        return BankAccount.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .state(faker.address().state())
                .zipCode(faker.address().zipCode())
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .ssn(faker.idNumber().ssnValid())
                .username(faker.name().username())
                .password(password)
                .passwordConfirmation(password)
                .build();
    }

    public static final Map<String, Function<BankAccount, BankAccount>> FIELD_REMOVERS = Map.of(
            "firstName", account -> account.withFirstName(null),
            "lastName", account -> account.withLastName(null),
            "address", account -> account.withAddress(null),
            "city", account -> account.withCity(null),
            "state", account -> account.withState(null),
            "zipCode", account -> account.withZipCode(null),
            "phoneNumber", account -> account.withPhoneNumber(null),
            "ssn", account -> account.withSsn(null),
            "username", account -> account.withUsername(null),
            "password", account -> account.withPassword(null).withPasswordConfirmation(null)
    );

    public static BankAccount generateBankAccountWithMissingField(String field) {
        BankAccount account = generateFakeBankAccount();
        return FIELD_REMOVERS.getOrDefault(field, Function.identity()).apply(account);
    }
}
