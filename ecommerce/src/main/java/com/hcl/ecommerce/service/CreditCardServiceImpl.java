package com.hcl.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.CreditCard;
import com.hcl.ecommerce.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardRepository creditCardRepository;

	@Override
	public synchronized boolean addCreditCard(CreditCard creditCard) {
		creditCardRepository.save(creditCard);
		return true;
	}

	@Override
	public CreditCard getCreditCardById(Integer creditCardId) {
		Optional<CreditCard> creditCard = creditCardRepository.findById(creditCardId);
		if (creditCard.isPresent())
			return creditCard.get();
		return null;
	}

	@Override
	public void updateCreditCard(CreditCard creditCard) {
		CreditCard card = getCreditCardById(creditCard.getId());
		card.setName(creditCard.getName());
		card.setCreditCardNumber(creditCard.getCreditCardNumber());
		card.setExpirationDate(creditCard.getExpirationDate());
		card.setSecurityCode(creditCard.getSecurityCode());
		creditCardRepository.save(card);
	}

	@Override
	public void deleteCreditCard(Integer creditCardId) {
		creditCardRepository.deleteById(creditCardId);
	}

}
