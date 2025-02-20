package com.equipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipes.entities.Equipes;
import com.equipes.repository.EquipesRepository;

@Service
public class EquipesService {
	private final EquipesRepository equipesRepository;

	@Autowired	
	public EquipesService(EquipesRepository equipesRepository) {
		this.equipesRepository = equipesRepository;
	}

	public Equipes saveEquipes(Equipes cequipes) {
		return equipesRepository.save(cequipes);
	}

	public Equipes getEquipesById(Long id) {
		return equipesRepository.findById(id).orElse(null);
	}

	public List<Equipes> getAllCarros(){
		return equipesRepository.findAll();
	}

	public void deleteEquipes (Long id) {
		equipesRepository.deleteById(id);
	}
}