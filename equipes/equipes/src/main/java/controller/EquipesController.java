package com.equipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equipes.entities.Equipes;
import com.equipes.services.EquipesService;

@RestController 
@RequestMapping("/Equipe")
public class EquipesController {
	private final EquipesService equipesService;

	@Autowired
	public EquipesController(EquipesService equipesService) {
		this.equipesService = equipesService;
	}

	@PostMapping
	public Equipes createEquipes(@RequestBody Equipes equipes) {
		return equipesService.saveEquipes(equipes);
	}

	@GetMapping("/{id}")
	public Equipes getEquipes(@PathVariable Long id) {
		return equipesService.getEquipesById(id);
	}

	@GetMapping
	public List<Equipes> getAllEquipes() {
		return equipesService.getAllCarros();
	}

	@DeleteMapping("/{id}")
	public void deleteEquipes(@PathVariable Long id) {
		equipesService.deleteEquipes(id);
	}
}