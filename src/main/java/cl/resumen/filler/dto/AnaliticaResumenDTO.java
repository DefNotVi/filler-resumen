package cl.resumen.filler.dto;

import lombok.Data;

@Data
public class AnaliticaResumenDTO {
    private String tipoEvento;
    private Long perfilId;
    private String nombrePerfil;
    private String detalle;
    private String fechaHora;
}