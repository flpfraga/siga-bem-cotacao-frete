package com.c2tech.desafio.repository;
import org.springframework.stereotype.Repository;
import com.c2tech.desafio.model.CotacaoFrete;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CotacaoFreteRepository extends JpaRepository <CotacaoFrete, Integer>{
    
}
