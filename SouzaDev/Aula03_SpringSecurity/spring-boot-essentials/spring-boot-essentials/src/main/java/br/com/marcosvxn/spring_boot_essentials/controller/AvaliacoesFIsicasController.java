package br.com.marcosvxn.spring_boot_essentials.controller;

import br.com.marcosvxn.spring_boot_essentials.dto.AvaliacaoFisicaDTO;
import br.com.marcosvxn.spring_boot_essentials.dto.AvaliacaoFisicaProjection;
import br.com.marcosvxn.spring_boot_essentials.exception.BadRequestException;
import br.com.marcosvxn.spring_boot_essentials.exception.NotFoundException;
import br.com.marcosvxn.spring_boot_essentials.service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacoesFIsicasController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacaoFisicaProjection> getAllAvaliacoes(){
        return avaliacaoFisicaService.getAllAvaliacoes();
    }

    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacaoFisicaProjection> getAllAvaliacoesPageable(@PathVariable Integer page,
                                                                    @PathVariable Integer size){
        return avaliacaoFisicaService.getAllAvaliacoesPageable(page, size);
    }
}
