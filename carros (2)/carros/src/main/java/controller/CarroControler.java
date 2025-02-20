package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.services.CarroService;

import entities.Carro;

@RestController 
@RequestMapping("/car")
public class CarroController {
	private final CarroService carroService;

	@Autowired
	public CarroController(CarroService carroService) {
		this.carroService = carroService;
	}

	@PostMapping
	public Carro createCarro(@RequestBody Carro carro) {
		return carroService.saveCarro(carro);
	}

	@GetMapping("/{id}")
	public Carro getCarro(@PathVariable Long id) {
		return carroService.getCarroById(id);
	}

	@GetMapping
	public List<Carro> getAllCarro() {
		return carroService.getAllCarros();
	}

	@DeleteMapping("/{id}")
	public void deleteCarro(@PathVariable Long id) {
		carroService.deleteCarro(id);
	}
}