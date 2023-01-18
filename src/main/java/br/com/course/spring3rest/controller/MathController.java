package br.com.course.spring3rest.controller;

import br.com.course.spring3rest.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/math")
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
	) {
			throw new ResourceNotFoundException("Please set a numeric value!");
	}
}
