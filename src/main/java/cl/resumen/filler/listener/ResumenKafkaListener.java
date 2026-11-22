package cl.resumen.filler.listener;

import cl.resumen.filler.dto.AnaliticaResumenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ResumenKafkaListener {

    private static final Logger log = LoggerFactory.getLogger(ResumenKafkaListener.class);

    @KafkaListener(
            topics = "filler-analitica-topic",
            groupId = "resumen-historial-group"
    )
    public void recibirAnaliticaParaResumen(AnaliticaResumenDTO evento) {
        if (evento == null || evento.getTipoEvento() == null) {
            log.warn("[RESUMEN - KAFKA] Evento vacío ignorado.");
            return;
        }
        log.info("[RESUMEN - KAFKA] Evento recibido en microservicio Resumen -> Tipo: {} | Perfil: {} | Detalle: {}",
                evento.getTipoEvento(), evento.getNombrePerfil(), evento.getDetalle());
    }
}