package com.micro.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(
        description = "Schema to hold Loan information"
)
@Data
public class LoansDto {

    @NotEmpty(message = "MobileNumber should not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits")
    @Schema(
            description = "Mobile Number of the customer",example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "LoanNumber should not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})",message = "Loan number should be 12 digits")
    @Schema(
            description = "Loan Number of the customer",example = "123456789012"
    )
    private String loanNumber;

    @NotEmpty(message = "LoanType should not be null or empty")
    @Schema(
            description = "Type of thr load",example = "Home Loan"
    )
    private String loanType;

    @Positive(message = "Total load should be greater than zero")
    @Schema(
            description = "Total loan amount",example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "Amount paid should be greater than or equal to zero")
    @Schema(
            description = "Total loan amount paid",example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be greater than or equal to zero")
    @Schema(
            description = "Total outstanding amount",example = "99000"
    )
    private int outstandingAmount;

    public @NotEmpty(message = "MobileNumber should not be null or empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits") String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotEmpty(message = "MobileNumber should not be null or empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public @NotEmpty(message = "LoanNumber should not be null or empty") @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number should be 12 digits") String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(@NotEmpty(message = "LoanNumber should not be null or empty") @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number should be 12 digits") String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public @NotEmpty(message = "LoanType should not be null or empty") String getLoanType() {
        return loanType;
    }

    public void setLoanType(@NotEmpty(message = "LoanType should not be null or empty") String loanType) {
        this.loanType = loanType;
    }

    @Positive(message = "Total load should be greater than zero")
    public int getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(@Positive(message = "Total load should be greater than zero") int totalLoan) {
        this.totalLoan = totalLoan;
    }

    @PositiveOrZero(message = "Amount paid should be greater than or equal to zero")
    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(@PositiveOrZero(message = "Amount paid should be greater than or equal to zero") int amountPaid) {
        this.amountPaid = amountPaid;
    }

    @PositiveOrZero(message = "Total outstanding amount should be greater than or equal to zero")
    public int getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(@PositiveOrZero(message = "Total outstanding amount should be greater than or equal to zero") int outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
}
