package br.ifes.dw.helloworld.application;

import java.util.List;
import br.ifes.dw.helloworld.repository.ProdutoBDRepository;
import br.ifes.dw.helloworld.model.Produto;

public class AppProdutoBD extends ProdutoBDRepository {

    @Override
    public List<Produto> getAll() {
        return super.getAll();
    }

    @Override
    public Produto getById(int id) {
        return super.getById(id);
    }

    @Override
    public Produto criar(Produto produto) {
        int novoId = super.getNextId();
        produto.setId(novoId);
        super.criar(produto);
        return produto;
    }

    @Override
    public void atualizar(int id, Produto produto) {
        Produto produtoExistente = super.getById(id);
        if (produtoExistente != null) {
            produto.setId(id);
            super.criar(produto);
        } else {
            throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
        }
    }

    @Override
    public void deletar(int id) {
        Produto produtoExistente = super.getById(id);
        if (produtoExistente != null) {
            super.deletar(id);
        } else {
            throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
        }
    }
}
