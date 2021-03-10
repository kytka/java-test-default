package com.etnetera.hr.controller;

import com.etnetera.hr.data.FrameworkVersion;
import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.FrameworkVersionRepository;
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

	private final JavaScriptFrameworkRepository frameworkRepository;
	private final FrameworkVersionRepository frameworkVersionRepository;

	@Autowired
	public JavaScriptFrameworkController(JavaScriptFrameworkRepository frameworkRepository, FrameworkVersionRepository frameworkVersionRepository) {
		this.frameworkRepository = frameworkRepository;
		this.frameworkVersionRepository = frameworkVersionRepository;
	}


	@GetMapping("/frameworks")
	public Iterable<JavaScriptFramework> getFrameworks() {
		return frameworkRepository.findAll();
	}

	@GetMapping("/versions")
	public Iterable<FrameworkVersion> getVersions() {
		return frameworkVersionRepository.findAll();
	}


	@PostMapping("/frameworks")
	JavaScriptFramework newFramework(@RequestBody JavaScriptFramework newFramework){
		return frameworkRepository.save(newFramework);
	}


	@PostMapping("/versions")
	FrameworkVersion newVersion(@RequestBody FrameworkVersion newVersion){
		return frameworkVersionRepository.save(newVersion);
	}

	@GetMapping("/frameworks/{id}")
	JavaScriptFramework searchFrameworksById (@PathVariable Long id){
		return frameworkRepository.findById(id)
				.orElseThrow(() -> new FrameworkNotFoundException(id));
	}

	@GetMapping("/versions/{id}")
	FrameworkVersion searchVersionsById(@PathVariable Long id){
		return frameworkVersionRepository.findById(id)
				.orElseThrow(() -> new VersionNotFoundException(id));
	}

	@GetMapping("/search")
	Iterable<JavaScriptFramework> searchByName(@RequestParam String name){
		return frameworkRepository.findByName(name);
	}

	@PutMapping("/frameworks/{id}")
	JavaScriptFramework replaceFramework (@RequestBody JavaScriptFramework newFramework, @PathVariable Long id){

		return frameworkRepository.findById(id)
				.map(framework -> {
					framework.setName(newFramework.getName());
					return frameworkRepository.save(framework);
				})
				.orElseGet(() -> {
					newFramework.setId(id);
					return frameworkRepository.save(newFramework);
				});
	}

	@PutMapping("/versions/{id}")
	FrameworkVersion replaceVersion(@RequestBody FrameworkVersion newVersion, @PathVariable Long id){

		return frameworkVersionRepository.findById(id)
				.map(version -> {
					version.setVersion(newVersion.getVersion());
					version.setDeprecationDate(newVersion.getDeprecationDate());
					version.setHypeLevel(newVersion.getHypeLevel());
					return frameworkVersionRepository.save(newVersion);
				})
				.orElseGet(() -> {
					newVersion.setId(id);
					return frameworkVersionRepository.save(newVersion);
				});
	}

	@DeleteMapping("/frameworks/{id}")
	void deleteFramework(@PathVariable Long id){
		frameworkRepository.deleteById(id);
	}

	@DeleteMapping("/versions/{id}")
	void deleteVersion(@PathVariable Long id) {
		frameworkVersionRepository.deleteById(id
		);
	}

	public JavaScriptFramework addVersionToFramework(Long frameworkId, Long versionId){
		JavaScriptFramework framework = searchFrameworksById(frameworkId);
		FrameworkVersion version = searchVersionsById(versionId);

		framework.addVersion(version);
		return framework;
	}

	public JavaScriptFramework removeVersionFromFramework(Long frameworkId, Long versionId){
		JavaScriptFramework framework = searchFrameworksById(frameworkId);
		FrameworkVersion version = searchVersionsById(versionId);

		framework.removeVersion(version);
		return framework;
	}

}
