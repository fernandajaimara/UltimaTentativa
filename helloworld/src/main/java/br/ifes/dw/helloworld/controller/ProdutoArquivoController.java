package br.ifes.dw.helloworld.controller;

import br.ifes.dw.helloworld.application.ApplicationAbstract;
import br.ifes.dw.helloworld.exception.NotFoundException;
import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.repository.generic.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("produtos/arquivo")
public class ProdutoArquivoController {
		@Autowired
		private ApplicationAbstract<Produto, IRepository<Produto>> applicationAbstract;

		@GetMapping("/")
		public List<Produto> getAll() throws IOException {
				return applicationAbstract.getAll();
		}

		@GetMapping("/{id}")
		public Produto getById(@PathVariable int id) throws IOException, NotFoundException{
				return applicationAbstract.getById(id);
		}

		@DeleteMapping("/{id}")
		public void deleteById(@PathVariable int id) throws IOException, NotFoundException{
				applicationAbstract.deletar(id);
		}

		@PostMapping("/")
		public Produto criar(@RequestBody Produto produto) throws IOException {
				return applicationAbstract.criar(produto);
		}
}
