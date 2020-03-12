package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeCard;
import com.example.demo.repository.EmployeeCardRepository;

@Service
public class EmployeeCardService {
	@Autowired
	EmployeeCardRepository cardRepository;

	public List<EmployeeCard> createOrUpdateEmployeeCard(EmployeeCard[] readValue) {
		// TODO Auto-generated method stub

		List<EmployeeCard> saveAll = cardRepository.saveAll(Arrays.asList(readValue));

		return saveAll;
	}

	public List<EmployeeCard> getFreeCards() {
		List<EmployeeCard> findFreeCards = cardRepository.findFreeCards();
		return findFreeCards;

	}

}
