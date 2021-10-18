package io.github.caiocldias.desenvolvedores.Desenvolvedores.model.repository;

import io.github.caiocldias.desenvolvedores.Desenvolvedores.model.entity.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Integer> {

    @Query(" select d from Desenvolvedor d where  upper(d.nome) like upper( :nome )")
    List<Desenvolvedor> findByName(@Param("nome") String nome);
}
