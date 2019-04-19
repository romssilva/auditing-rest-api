package auditing.repository;

import org.springframework.data.repository.CrudRepository;

import auditing.model.Auditing;

public interface AuditingRepository extends CrudRepository<Auditing, Long> {}
