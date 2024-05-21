package br.unipar.programacaoweb.clinica2.controller.api;

import br.unipar.programacaoweb.clinica2.model.Atendimento;
import br.unipar.programacaoweb.clinica2.service.AtendimentoService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoApiController {

    private final AtendimentoService atendimentoService;

    public AtendimentoApiController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping
    public ResponseEntity<List<Atendimento>> listarAtendimento(){
        return ResponseEntity.ok(atendimentoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Atendimento> salvarAtendimento(@RequestBody Atendimento atendimento){
        return ResponseEntity.ok(atendimentoService.save(atendimento));
    }
}
