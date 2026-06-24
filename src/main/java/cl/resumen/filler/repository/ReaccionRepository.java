package cl.resumen.filler.repository;

import cl.resumen.filler.model.Reaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaccionRepository extends JpaRepository<Reaccion, Long> {

    List<Reaccion> findByAccion(String accion);
}