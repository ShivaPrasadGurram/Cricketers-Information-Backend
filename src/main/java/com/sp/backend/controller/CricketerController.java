package com.sp.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.backend.exception.ResourceNotFoundException;
import com.sp.backend.model.Cricketer;
import com.sp.backend.repository.CricketerRepository;

@CrossOrigin(origins = "https://gifted-wilson-60a1b7.netlify.app")
@RestController
@RequestMapping("/api/v1/")
public class CricketerController {

	@Autowired
	private CricketerRepository cricketRepository;
	
	//get all cricketers
	@GetMapping("/cricketers")
	public List<Cricketer> getAllCricketers()
	{
		return cricketRepository.findAll();
	}
	
	//create cricketer
	@PostMapping("/cricketers")
	public Cricketer createCricketer(@RequestBody Cricketer cricketer)
	{
		return cricketRepository.save(cricketer);
	}
	
	//get cricketer by id
	@GetMapping("/cricketers/{id}")
	public ResponseEntity<Cricketer> getCricketerById(@PathVariable Long id) {
		
		Cricketer crick = cricketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cricketer not exists with id :" + id));
		return ResponseEntity.ok(crick);
	}
	
	//update cricketer 
	@PutMapping("/cricketers/{id}")
	public ResponseEntity<Cricketer> updateCricketer(@PathVariable Long id,@RequestBody Cricketer cric)
	{
		Cricketer cricketer = cricketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cricketer not exists with id :" + id));
		cricketer.setFirstName(cric.getFirstName());
		cricketer.setLastName(cric.getLastName());
		cricketer.setEmailId(cric.getEmailId());
		cricketer.setCountry(cric.getCountry());
		cricketer.setRole(cric.getRole());
		cricketer.setIsRetired(cric.getIsRetired());
		cricketer.setProfileLink(cric.getProfileLink());
		
		Cricketer upCric = cricketRepository.save(cricketer);
		return ResponseEntity.ok(upCric);
	}
	
	//delete cricketer
	@DeleteMapping("/cricketers/{id}")
	public ResponseEntity<Map<String , Boolean>> deleteCricketer(@PathVariable Long id)
	{
		Cricketer cricketer = cricketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cricketer not exists with id :" + id));
		cricketRepository.delete(cricketer);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
