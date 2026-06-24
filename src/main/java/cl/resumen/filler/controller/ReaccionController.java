package cl.resumen.filler.controller;

import cl.resumen.filler.model.Reaccion;
import cl.resumen.filler.repository.ReaccionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reacciones")
public class ReaccionController {

    private final ReaccionRepository repository;

    public ReaccionController(ReaccionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Reaccion guardar(@RequestBody Reaccion reaccion) {
        return repository.save(reaccion);
    }

    @GetMapping
    public List<Reaccion> listar() {
        return repository.findAll();
    }

    @GetMapping("/likes")
    public List<Reaccion> likes() {
        return repository.findByAccion("LIKE");
    }

    @GetMapping("/dislikes")
    public List<Reaccion> dislikes() {
        return repository.findByAccion("DISLIKE");
    }
}