package auditing.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import auditing.model.Auditing;
import auditing.repository.AuditingRepository;

@RestController
public class AuditingController {
	
	@Autowired
	AuditingRepository auditingRepository;
	
	private final String API_VERSION = "/v1";
	
	@GetMapping(API_VERSION + "/auditings")
    public List<Auditing> getAllAuditings() {
		return (List<Auditing>) auditingRepository.findAll();
    }
	
	@GetMapping(API_VERSION + "/auditings/{id}")
    public Auditing getAuditing(@PathVariable Long id, HttpServletResponse response) {
		Optional<Auditing> auditing = auditingRepository.findById(id);
		
		if (auditing.isPresent()) {
			return auditing.get();
		}
		
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
    }
	
	@PostMapping(API_VERSION + "/auditings")
    public Auditing addAuditing(@RequestBody Auditing newAuditing, HttpServletResponse response) {
		Auditing auditing = auditingRepository.save(newAuditing);
		response.setStatus(HttpServletResponse.SC_CREATED);
		return auditing;
    }
	
	@PutMapping(API_VERSION + "/auditings/{id}")
    public Auditing updateAuditing(@PathVariable Long id, @RequestBody Auditing newAuditing, HttpServletResponse response) {
		if (!auditingRepository.existsById(id)) {
			response.setStatus(HttpServletResponse.SC_CREATED);
		}
		return auditingRepository.save(newAuditing);
    }
	
	@DeleteMapping(API_VERSION + "/auditings/{id}")
    public void deleteAuditing(@PathVariable Long id, HttpServletResponse response) {
		auditingRepository.deleteById(id);
    }
}
