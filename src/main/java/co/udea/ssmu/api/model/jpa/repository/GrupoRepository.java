package co.udea.ssmu.api.model.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.udea.ssmu.api.model.jpa.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{
    
}
