package auditing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import auditing.model.Auditing;

public interface AuditingRepository extends PagingAndSortingRepository<Auditing, Long> {}
