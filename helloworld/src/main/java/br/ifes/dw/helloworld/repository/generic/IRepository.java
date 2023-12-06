package br.ifes.dw.helloworld.repository.generic;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IRepository<R> {

    List<R> getAll();

    R getById(int id);

    R criar(R entity);

    void atualizar(int id, R entity);

    void deletar(int id);
}
