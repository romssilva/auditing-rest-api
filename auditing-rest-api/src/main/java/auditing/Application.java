package auditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import auditing.model.Auditing;
import auditing.repository.AuditingRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	AuditingRepository auditingRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		auditingRepository.save(new Auditing(null, "GET", "/v1/users", ""));
	}
}
