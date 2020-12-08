package ru.sbt.spring.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbt.spring.DAO.entity.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
}
