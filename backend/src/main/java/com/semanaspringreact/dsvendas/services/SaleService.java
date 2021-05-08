package com.semanaspringreact.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semanaspringreact.dsvendas.dto.SaleDTO;
import com.semanaspringreact.dsvendas.dto.SaleSuccessDTO;
import com.semanaspringreact.dsvendas.dto.SaleSumDTO;
import com.semanaspringreact.dsvendas.entities.Sale;
import com.semanaspringreact.dsvendas.repositories.SaleRepository;
import com.semanaspringreact.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedbySeller(){
		return repository.amountGroupedbySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedbySeller(){
		return repository.successGroupedbySeller();
	}
}
