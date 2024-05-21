package br.unipar.programacaoweb.clinica2.controller.api;

import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.repository.PacienteRepository;
import br.unipar.programacaoweb.clinica2.service.PacienteService;
import br.unipar.programacaoweb.clinica2.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteApiController {

    private final PacienteService pacienteService;

    public PacienteApiController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    private ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(pacienteService.getAll());
    }

    @PostMapping
    private ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.save(paciente));
    }
}
