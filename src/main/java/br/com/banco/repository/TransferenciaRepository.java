package br.com.banco.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	@Query("SELECT t FROM Transferencia t" + " JOIN t.conta c " + "WHERE ((?1 IS NULL) or c.id = ?1) "
			+ "AND ((?2 IS NULL and ?3 IS NULL) or t.dataTransferencia BETWEEN ?2 AND ?3) "
			+ "AND ((?4 IS NULL) or UPPER(t.nomeOperadorTransacao) LIKE UPPER(CONCAT('%',?4,'%')))")
	Page<Transferencia> findByFilter(Long idConta, LocalDate startDate, LocalDate endDate, String nomeOperador,
			Pageable pageable);

}
