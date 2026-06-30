package cl.resumen.filler.controller;

import cl.resumen.filler.model.Reaccion;
import cl.resumen.filler.repository.ReaccionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReaccionController.class)
class ReaccionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReaccionRepository repository;

    @Test
    void guardarReaccion() throws Exception {

        Reaccion reaccion = new Reaccion();
        reaccion.setPerfilId(1L);
        reaccion.setNombre("Naruto");
        reaccion.setAnime("Naruto");
        reaccion.setAccion("LIKE");
        reaccion.setFecha(LocalDateTime.now());

        Mockito.when(repository.save(any(Reaccion.class)))
                .thenReturn(reaccion);

        mockMvc.perform(post("/api/reacciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "perfilId":1,
                            "nombre":"Naruto",
                            "anime":"Naruto",
                            "accion":"LIKE"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Naruto"))
                .andExpect(jsonPath("$.anime").value("Naruto"))
                .andExpect(jsonPath("$.accion").value("LIKE"));
    }

    @Test
    void listarReacciones() throws Exception {

        Reaccion reaccion = new Reaccion();
        reaccion.setPerfilId(1L);
        reaccion.setNombre("Naruto");
        reaccion.setAnime("Naruto");
        reaccion.setAccion("LIKE");

        Mockito.when(repository.findAll())
                .thenReturn(List.of(reaccion));

        mockMvc.perform(get("/api/reacciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Naruto"));
    }

    @Test
    void listarLikes() throws Exception {

        Reaccion reaccion = new Reaccion();
        reaccion.setPerfilId(1L);
        reaccion.setNombre("Naruto");
        reaccion.setAnime("Naruto");
        reaccion.setAccion("LIKE");

        Mockito.when(repository.findByAccion("LIKE"))
                .thenReturn(List.of(reaccion));

        mockMvc.perform(get("/api/reacciones/likes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].accion").value("LIKE"));
    }

    @Test
    void listarDislikes() throws Exception {

        Reaccion reaccion = new Reaccion();
        reaccion.setPerfilId(2L);
        reaccion.setNombre("Sasuke");
        reaccion.setAnime("Naruto");
        reaccion.setAccion("DISLIKE");

        Mockito.when(repository.findByAccion("DISLIKE"))
                .thenReturn(List.of(reaccion));

        mockMvc.perform(get("/api/reacciones/dislikes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].accion").value("DISLIKE"));
    }
}