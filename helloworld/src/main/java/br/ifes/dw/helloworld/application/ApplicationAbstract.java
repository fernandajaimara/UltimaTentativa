package br.ifes.dw.helloworld.application;

import br.ifes.dw.helloworld.repository.generic.IRepository;

import java.util.List;

public abstract class ApplicationAbstract<T, R extends IRepository<T>> {

    protected R repository;

    public ApplicationAbstract(R repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.getAll();
    }

    public T getById(int id) {
        return repository.getById(id);
    }

    public T criar(T entity) {
        return repository.criar(entity);
    }

    public void atualizar(int id, T entity) {
        repository.atualizar(id, entity);
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}
