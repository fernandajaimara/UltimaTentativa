package br.ifes.dw.helloworld.application;

import br.ifes.dw.helloworld.dto.ProdutoInputDTO;
import br.ifes.dw.helloworld.exception.NotFoundException;
import br.ifes.dw.helloworld.exception.VaiMeuFilhoException;
import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.repository.generic.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppProduto {

		private List<Produto> produtos = new ArrayList<>();
		private int lastId = 0;
		private final IRepository<Produto> repository;

		@Autowired
		public AppProduto(IRepository<Produto> repository) {
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
