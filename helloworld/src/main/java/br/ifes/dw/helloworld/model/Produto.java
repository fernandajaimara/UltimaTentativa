package br.ifes.dw.helloworld.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Produto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String nome;
	private double preco;

	}


