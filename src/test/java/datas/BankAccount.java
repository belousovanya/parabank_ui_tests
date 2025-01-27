package datas;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

@Getter
@Builder
@With
public class BankAccount {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String phoneNumber;
    private final String ssn;
    private final String username;
    private final String password;
    private final String passwordConfirmation;
}
