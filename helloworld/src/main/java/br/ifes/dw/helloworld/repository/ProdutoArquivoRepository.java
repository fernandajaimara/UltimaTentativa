package br.ifes.dw.helloworld.repository;

import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.repository.generic.IRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoArquivoRepository implements IRepository<Produto> {

    private static final String FILE_PATH = "produtos.txt";

    @Override
    public List<Produto> getAll() {
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] parts = linha.split(",");
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(parts[0]));
                produto.setNome(parts[1]);
                produto.setPreco(Double.parseDouble(parts[2]));
                produtos.add(produto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produtos;
    }
	

    @Override
    public Produto getById(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] parts = linha.split(",");
                int produtoId = Integer.parseInt(parts[0]);
                if (produtoId == id) {
                    Produto produto = new Produto();
                    produto.setId(produtoId);
                    produto.setNome(parts[1]);
                    produto.setPreco(Double.parseDouble(parts[2]));
                    return produto;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Produto criar(Produto produto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(produto.getId() + "," + produto.getNome() + "," + produto.getPreco());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
		return produto;
    }

    @Override
    public void atualizar(int id, Produto produto) {
        List<Produto> produtos = getAll();
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.set(i, produto);
                salvarTodos(produtos);
                return;
            }
        }
    }

    @Override
    public void deletar(int id) {
        List<Produto> produtos = getAll();
        produtos.removeIf(produto -> produto.getId() == id);
        salvarTodos(produtos);
    }

	private void salvarTodos(List<Produto> produtos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Produto produto : produtos) {
                writer.write(produto.getId() + "," + produto.getNome() + "," + produto.getPreco());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
  
}
