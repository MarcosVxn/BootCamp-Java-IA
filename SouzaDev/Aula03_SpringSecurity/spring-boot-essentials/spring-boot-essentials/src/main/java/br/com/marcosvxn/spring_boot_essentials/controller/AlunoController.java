package br.com.marcosvxn.spring_boot_essentials.controller;

import br.com.marcosvxn.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.marcosvxn.spring_boot_essentials.dto.AlunoDTO;
import br.com.marcosvxn.spring_boot_essentials.exception.BadRequestException;
import br.com.marcosvxn.spring_boot_essentials.exception.NotFoundException;
import br.com.marcosvxn.spring_boot_essentials.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunoController {

    private final AlunoService alunoService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDTO alunoDTO) throws BadRequestException {
        alunoService.criarAluno(alunoDTO);
    }


    @PreAuthorize("#alunoId == authentication.principal.id or hasAuthority('ADMIN')")
    @GetMapping("/{alunoId}/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacoesFisicasEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunoService.getAlunoAvaliacao(alunoId);
    }


    @DeleteMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAluno(@PathVariable Integer alunoId) throws  NotFoundException{
        alunoService.deletarAluno(alunoId);
    }

}
