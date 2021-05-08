package com.semanaspringreact.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semanaspringreact.dsvendas.dto.SaleDTO;
import com.semanaspringreact.dsvendas.dto.SaleSuccessDTO;
import com.semanaspringreact.dsvendas.dto.SaleSumDTO;
import com.semanaspringreact.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedbySeller(){
		List<SaleSumDTO> list = service.amountGroupedbySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedbySeller(){
		List<SaleSuccessDTO> list = service.successGroupedbySeller();
		return ResponseEntity.ok(list);
	}
}
