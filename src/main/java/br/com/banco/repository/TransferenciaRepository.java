package br.com.banco.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.banco.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	// Recupera todas as transferências de um determinado período de tempo
	@Query("SELECT t FROM Transferencia t WHERE t.dataTransferencia BETWEEN :startDate AND :endDate")
	List<Transferencia> findByPeriodo(@Param("startDate") LocalDateTime startDate,
			@Param("endDate") LocalDateTime endDate);

	// Recupera todas as transferências de um determinado operador
	@Query("SELECT t FROM Transferencia t WHERE t.nomeOperadorTransacao = :nomeOperador")
	List<Transferencia> findByOperador(@Param("nomeOperador") String nomeOperador);

	// Recupera todas as transferências de um determinado período de tempo e
	// operador
	@Query("SELECT t FROM Transferencia t WHERE t.dataTransferencia BETWEEN :startDate AND :endDate AND t.nomeOperadorTransacao = :nomeOperador")
	List<Transferencia> findByPeriodoAndOperador(@Param("startDate") LocalDateTime startDate,
			@Param("endDate") LocalDateTime endDate, @Param("nomeOperador") String nomeOperador);

	// Recupera todas as transferências de uma determinada conta
	@Query("SELECT t FROM Transferencia t WHERE t.conta.id = :contaId")
	List<Transferencia> findByContaId(@Param("contaId") Integer contaId);

	// Recupera todas as transferências sem colocar nenhum filtro
	// Está null pois mesmo se não for informado nada vai recuperar tudo
	@Query("SELECT t FROM Transferencia t" + " JOIN t.conta c " + "WHERE ((?1 IS NULL) or c.id = ?1) "
			+ "AND ((?2 IS NULL and ?3 IS NULL) or t.dataTransferencia BETWEEN ?2 AND ?3) "
			+ "AND ((?4 IS NULL) or UPPER(t.nomeOperadorTransacao) LIKE UPPER(CONCAT('%',?4,'%')))")
	Page<Transferencia> findByFilter(Long idConta, LocalDateTime startDate, LocalDateTime endDate, String nomeOperador,
			Pageable pageable);
}
