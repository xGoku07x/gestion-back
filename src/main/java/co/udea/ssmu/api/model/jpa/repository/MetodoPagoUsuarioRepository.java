package co.udea.ssmu.api.model.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.udea.ssmu.api.model.jpa.model.MetodoPagoUsuario;

@Repository
public interface MetodoPagoUsuarioRepository extends JpaRepository<MetodoPagoUsuario, Long>{
    
    List<MetodoPagoUsuario> findAllByIdUsuario_IdUsuario(Long id);
}
