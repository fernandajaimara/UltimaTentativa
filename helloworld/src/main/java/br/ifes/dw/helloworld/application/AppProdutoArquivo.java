package br.ifes.dw.helloworld.application;

import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.repository.ProdutoArquivoRepository;

import java.util.List;

public class AppProdutoArquivo extends ApplicationAbstract<Produto, ProdutoArquivoRepository> {

    public AppProdutoArquivo(ProdutoArquivoRepository repository) {
        super(repository);
    }

	public List<Produto> getAll() {
        return repository.getAll();
    }

    public Produto getById(int id) {
        return repository.getById(id);
    }
    

    public Produto criar(Produto produto) {
        return repository.criar(produto);
    }

    public void atualizar(int id, Produto produto) {
        repository.atualizar(id, produto);
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}
