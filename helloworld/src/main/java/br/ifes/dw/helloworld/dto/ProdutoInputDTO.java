package br.ifes.dw.helloworld.dto;

import lombok.Data;

@Data
public class ProdutoInputDTO {
	private Long id;
  private String nome;

  private double preco;

	// Getter de id
	public Long getId() {
		return id;
	}

	// Setter para id
	public void setId(int id) {
			this.id = (long) id;
	}

	// Getter para nome
	public String getNome() {
			return nome;
	}

	// Setter para nome
	public void setNome(String nome) {
			this.nome = nome;
	}

	// Getter para preco
	public double getPreco() {
			return preco;
	}

	// Setter para preco
	public void setPreco(double preco) {
			this.preco = preco;
	}
}
