package br.ifes.dw.helloworld.application;

import java.util.List;
import br.ifes.dw.helloworld.repository.ProdutoBDRepository;
import br.ifes.dw.helloworld.model.Produto;

public class AppProdutoBD implements ProdutoBDRepository {

    @Override
    public List<Produto> getAll() {
        // Implementação do método getAll
        return null; // Substitua isso pela lógica real
    }

    @Override
    public Produto getById(int id) {
        // Implementação do método getById
        return null; // Substitua isso pela lógica real
    }

    @Override
    public void salvar(Produto produto) {
        // Implementação do método salvar
    }

    @Override
    public void atualizar(int id, Produto produto) {
        // Implementação do método atualizar
    }

    @Override
    public void deletar(Long id) {
        // Implementação do método deletar
    }
}
