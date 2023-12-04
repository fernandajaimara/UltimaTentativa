package br.ifes.dw.helloworld.repository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import br.ifes.dw.helloworld.model.Produto;
//import br.ifes.dw.helloworld.model.ProdutoArquivoRepository;
//import br.ifes.dw.helloworld.model.ProductRepositoryImpl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
	List<Produto> getAll();
		
	Produto getById(Long id);
		
	void salvar(Produto produto);
		
	void atualizar(Long id, Produto produto);
		
	void deletar(Long id);
}
