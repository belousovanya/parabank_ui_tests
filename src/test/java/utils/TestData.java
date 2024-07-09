package utils;

import com.github.javafaker.Faker;
import datas.BankAccount;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public BankAccount generateFakeBankAccount() {
        String password = faker.internet().password();

        return BankAccount.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .zipCode(faker.address().zipCode())
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .ssn(faker.idNumber().ssnValid())
                .username(faker.name().username())
                .password(password)
                .passwordConfirmation(password)
                .build();
    }
}
