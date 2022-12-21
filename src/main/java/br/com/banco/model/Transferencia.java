package br.com.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "transferencia")
@Data
public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_transferencia")
	private LocalDateTime dataTransferencia;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "nome_operador_transacao")
	private String nomeOperadorTransacao;

	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
}
