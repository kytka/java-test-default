package com.etnetera.hr.controller;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Simple REST controller for accessing application logic.
 * 
 * @author Etnetera
 *
 */
@RestController
public class JavaScriptFrameworkController extends EtnRestController {

	private final JavaScriptFrameworkRepository repository;

	@Autowired
	public JavaScriptFrameworkController(JavaScriptFrameworkRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/frameworks")
	public Iterable<JavaScriptFramework> frameworks() {
		return repository.findAll();
	}


	@PostMapping("/frameworks")
	JavaScriptFramework newFramework(@RequestBody JavaScriptFramework newFramework){
		return repository.save(newFramework);
	}

	@GetMapping("/frameworks/{id}")
	JavaScriptFramework searchById (@PathVariable Long id){
		return repository.findById(id)
				.orElseThrow(() -> new FrameworkNotFoundException(id));
	}

	@GetMapping("/search")
	Iterable<JavaScriptFramework> searchByName(@RequestParam String name){
		return repository.findByName(name);
	}

	@PutMapping("/frameworks/{id}")
	JavaScriptFramework replaceFramework (@RequestBody JavaScriptFramework newFramework, @PathVariable Long id){

		return repository.findById(id)
				.map(framework -> {
					framework.setName(newFramework.getName());
					framework.setDeprecationDate(newFramework.getDeprecationDate());
					framework.setHypeLevel(newFramework.getHypeLevel());
					framework.setVersion(newFramework.getVersion());
					return repository.save(framework);
				})
				.orElseGet(() -> {
					newFramework.setId(id);
					return repository.save(newFramework);
				});
	}

	@DeleteMapping("/frameworks/{id}")
	void deleteFramework(@PathVariable Long id){
		repository.deleteById(id);
	}


}
