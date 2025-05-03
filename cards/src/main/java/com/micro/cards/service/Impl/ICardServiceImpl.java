package com.micro.cards.service.Impl;

import com.micro.cards.constant.CardsConstant;
import com.micro.cards.dto.CardsDto;
import com.micro.cards.entity.Cards;
import com.micro.cards.exception.CardAlreadyExistsException;
import com.micro.cards.exception.ResourceNotFoundException;
import com.micro.cards.mapper.CardMapper;
import com.micro.cards.repository.CardRepository;
import com.micro.cards.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ICardServiceImpl implements ICardService {

    private CardRepository cardRepository;

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCards = cardRepository.findByMobileNumber(mobileNumber);
        if (optionalCards.isPresent()) {
            throw new CardAlreadyExistsException("Loan already registered with given mobileNumber" + mobileNumber);
        }
        cardRepository.save(createNewCards(mobileNumber));
    }

    private Cards createNewCards(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(String.valueOf(randomCardNumber));
        newCard.setCardType(CardsConstant.DEBIT_CARD);
        newCard.setMobileNumber(mobileNumber);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstant.NEW_CARD_AVAILABLE);
        newCard.setTotalLimit(CardsConstant.NEW_CARD_LIMIT);

        return newCard;
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards cards = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber)
        );
        return CardMapper.mapToCardsDto(cards, new CardsDto());
    }



    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards cards = cardRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "cardNumber", cardsDto.getCardNumber())
        );
        CardMapper.mapToCards(cardsDto, cards);
        cardRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber)
        );
        cardRepository.deleteById(cards.getCardId());
        return true;
    }
}
