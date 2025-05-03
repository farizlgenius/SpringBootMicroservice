package com.micro.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(
        description = "Schema to hold Card information"
)
@Data
public class CardsDto {

    @NotEmpty(message = "MobileNumber should not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits")
    @Schema(
            description = "Mobile Number of the customer",example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "MobileNumber should not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})",message = "Cards number should be 12 digits")
    @Schema(
            description = "Card Number of the customer",example = "436532769812"
    )
    private String cardNumber;

    @NotEmpty(message = "CardType should not be null or empty")
    @Schema(
            description = "Type of thr card",example = "Debit Card"
    )
    private String cardType;

    @Positive(message = "Total Limit should be greater than zero")
    @Schema(
            description = "Total amount limit available against a card",example = "100000"
    )
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be greater than or equal to zero")
    @Schema(
            description = "Total card amount used",example = "1000"
    )
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be greater than or equal to zero")
    @Schema(
            description = "Total available amount in card",example = "1000"
    )
    private int availableAmount;

    public @NotEmpty(message = "MobileNumber should not be null or empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits") String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotEmpty(message = "MobileNumber should not be null or empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public @NotEmpty(message = "MobileNumber should not be null or empty") @Pattern(regexp = "(^$|[0-9]{12})", message = "Cards number should be 12 digits") String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(@NotEmpty(message = "MobileNumber should not be null or empty") @Pattern(regexp = "(^$|[0-9]{12})", message = "Cards number should be 12 digits") String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public @NotEmpty(message = "CardType should not be null or empty") String getCardType() {
        return cardType;
    }

    public void setCardType(@NotEmpty(message = "CardType should not be null or empty") String cardType) {
        this.cardType = cardType;
    }

    public @Positive(message = "Card Limit should be greater than zero") int getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(@Positive(message = "Card Limit should be greater than zero") int totalLimit) {
        this.totalLimit = totalLimit;
    }

    @PositiveOrZero(message = "Total amount used should be greater than or equal to zero")
    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(@PositiveOrZero(message = "Total amount used should be greater than or equal to zero") int amountUsed) {
        this.amountUsed = amountUsed;
    }

    @PositiveOrZero(message = "Total available amount should be greater than or equal to zero")
    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(@PositiveOrZero(message = "Total available amount should be greater than or equal to zero") int availableAmount) {
        this.availableAmount = availableAmount;
    }
}
