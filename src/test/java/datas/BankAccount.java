package datas;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BankAccount {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String ssn;
    private String username;
    private String password;
    private String passwordConfirmation;
}
