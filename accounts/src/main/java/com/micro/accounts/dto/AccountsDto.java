package com.micro.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @NotEmpty(message = "AccountNumber should not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "AccountNumber should be 10 digits")
    @Schema(
            description = "Account Number of bank account",
            example = "1234567890"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType should not be null or empty")
    @Schema(
            description = "Account Type of bank account",
            example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "BranchAddress should not be null or empty")

    @Schema(
            description = "Branch address of bank account",
            example = "New York Street"
    )
    private String branchAddress;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
