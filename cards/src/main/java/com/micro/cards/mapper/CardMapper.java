package com.micro.cards.mapper;

import com.micro.cards.dto.CardsDto;
import com.micro.cards.entity.Cards;

public class CardMapper {

    public static Cards mapToCards(CardsDto cardsDto,Cards cards){
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setCardType(cardsDto.getCardType());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        return cards;
    }

    public static CardsDto mapToCardsDto(Cards cards,CardsDto cardsDto){
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        return cardsDto;

    }

}
