package br.com.marcosvxn.spring_boot_essentials.controller;

import br.com.marcosvxn.spring_boot_essentials.dto.TreinoDTO;
import br.com.marcosvxn.spring_boot_essentials.exception.BadRequestException;
import br.com.marcosvxn.spring_boot_essentials.exception.NotFoundException;
import br.com.marcosvxn.spring_boot_essentials.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treinos")
@RequiredArgsConstructor
@Validated
public class TreinoController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDTO treinoDTO) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinoDTO);
    }

}
