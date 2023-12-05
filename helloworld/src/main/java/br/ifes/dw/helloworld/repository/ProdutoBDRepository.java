package br.ifes.dw.helloworld.repository;

import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.repository.generic.IRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class ProdutoBDRepository implements IRepository<Produto> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Produto> getAll() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    @Override
    public Produto getById(int id) {
        return entityManager.find(Produto.class, id);
    }

    @Override
    @Transactional
    public Produto criar(Produto produto) {
        entityManager.persist(produto);
        return produto;
    }

    @Override
    @Transactional
    public void deletar(int id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }

    @Override
    @Transactional
    public void atualizar(int id, Produto entity) {
        // Implemente a lógica de atualização conforme necessário
    }

    public int getNextId() {
        Integer maxId = entityManager.createQuery("SELECT MAX(p.id) FROM Produto p", Integer.class)
                                     .getSingleResult();
        return maxId != null ? maxId + 1 : 1;
    }
}
