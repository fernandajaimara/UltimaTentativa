package br.ifes.dw.helloworld.repository;

import java.util.List;

import br.ifes.dw.helloworld.model.Produto;
//import br.ifes.dw.helloworld.model.ProdutoArquivoRepository;
//import br.ifes.dw.helloworld.model.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
	List<Produto> getAll();
		
	Produto getById(Long id);
		
	void salvar(Produto produto);
		
	void atualizar(Long id, Produto produto);
		
	void deletar(Long id);
}
