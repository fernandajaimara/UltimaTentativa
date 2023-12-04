package br.ifes.dw.helloworld.application;

import java.util.ArrayList;
import java.util.List;

import br.ifes.dw.helloworld.dto.ProdutoInputDTO;
import br.ifes.dw.helloworld.exception.*;
import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.repository.generic.IRepository;

import org.springframework.stereotype.*;

@Component
public class AppProduto <T extends IRepository<Produto>> {

  private List<Produto> produtos = new ArrayList<Produto>();
  private int lastId = 0;
  private final T repository;

  public AppProduto(T repository) {
      this.repository = repository;
  }

  public List<Produto> getAll() {
    return repository.getAll();
  }

  public Produto create(ProdutoInputDTO produtoInputDTO) {
    lastId++;
    Produto produto = new Produto();
    produto.setId(lastId);
    produto.setNome(produtoInputDTO.getNome());
    produto.setPreco(produtoInputDTO.getPreco());
    produtos.add(produto);

    return produto;
  }

  public void delete(int id) {
    this.produtos.removeIf(produto -> produto.getId() == id);
  }

  public Produto getById(int id) throws NotFoundException, VaiMeuFilhoException {

    if (id == 0) {
      throw new VaiMeuFilhoException();
    }

    for (Produto produto : this.produtos) {
      if (produto.getId() == id) {
        return repository.getById(id);
      }
    }
    throw new NotFoundException();

  }

}