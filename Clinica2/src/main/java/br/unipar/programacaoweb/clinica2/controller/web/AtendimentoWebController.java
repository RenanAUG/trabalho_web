package br.unipar.programacaoweb.clinica2.controller.web;

import br.unipar.programacaoweb.clinica2.model.Atendimento;
import br.unipar.programacaoweb.clinica2.service.AtendimentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AtendimentoWebController {

    private final AtendimentoService atendimentoService;

    public AtendimentoWebController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping("/atendimentos")
    private String getAllAtendimentos(Model model) {
        List<Atendimento> atendimentos = atendimentoService.getAll();
        model.addAttribute("atendimentos", atendimentos);
        return "atendimentos";
    }

    @PostMapping("/atendimentos/save")
    public String saveAtendimentos(Atendimento atendimento) {
        atendimentoService.save(atendimento);
        return "redirect:/atendimentos";
    }
}
