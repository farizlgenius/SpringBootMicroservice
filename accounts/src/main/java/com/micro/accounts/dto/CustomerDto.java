package com.micro.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer",
            example = "Jimmy Dan"
    )
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 5,max = 30,message = "The length of name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "Jimmy@email.com"
    )
    @NotEmpty(message = "Email should not be null or empty")
    @Email(message = "Email address is not valid")
    private String email;

    @Schema(
            description = "Mobile Number of the customer",
            example = "0980511710"
    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account detail of customer"
    )
    private AccountsDto accountsDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountsDto getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(AccountsDto accountsDto) {
        this.accountsDto = accountsDto;
    }
}
