package br.unipar.programacaoweb.clinica2.controller.api;
import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.repository.PacienteRepository;
import br.unipar.programacaoweb.clinica2.service.MedicoService;
import br.unipar.programacaoweb.clinica2.service.PacienteService;
import br.unipar.programacaoweb.clinica2.service.UsuarioService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.hibernate.service.spi.InjectService;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoApiController {
    private final MedicoService medicoService;

    public MedicoApiController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listarMedico(){
        return ResponseEntity.ok(medicoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Medico> salvarMedico(@RequestBody Medico medico){
        return ResponseEntity.ok(medicoService.save(medico));
    }
}
