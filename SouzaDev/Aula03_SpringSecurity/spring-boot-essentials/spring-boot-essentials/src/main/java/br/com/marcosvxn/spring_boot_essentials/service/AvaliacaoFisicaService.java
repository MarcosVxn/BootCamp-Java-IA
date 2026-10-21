package br.com.marcosvxn.spring_boot_essentials.service;

import br.com.marcosvxn.spring_boot_essentials.database.model.AlunosEntity;
import br.com.marcosvxn.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.marcosvxn.spring_boot_essentials.database.repository.IAlunosRepository;
import br.com.marcosvxn.spring_boot_essentials.database.repository.IAvaliacoesRepository;
import br.com.marcosvxn.spring_boot_essentials.dto.AvaliacaoFisicaDTO;
import br.com.marcosvxn.spring_boot_essentials.dto.AvaliacaoFisicaProjection;
import br.com.marcosvxn.spring_boot_essentials.exception.BadRequestException;
import br.com.marcosvxn.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesRepository avaliacoesRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDTO.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacoesFisicasEntity avaliacoesFisicas = aluno.getAvaliacoesFisicas();
        if (avaliacoesFisicas != null){
            throw new BadRequestException("Avaliação fisica ja cadastrada para este aluno");
        }

        avaliacoesFisicas = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDTO.getPeso())
                .altura(avaliacaoFisicaDTO.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDTO.getPorcentagemGorduraCorporal())
                .build();

        avaliacoesFisicas = avaliacoesRepository.save(avaliacoesFisicas);

        aluno.setAvaliacoesFisicas(avaliacoesFisicas);
        alunosRepository.save(aluno);
    }

    public List<AvaliacaoFisicaProjection> getAllAvaliacoes(){
        return avaliacoesRepository.getAllAvaliacoes();
    }

    public Page<AvaliacaoFisicaProjection> getAllAvaliacoesPageable(Integer page, Integer size){
        return avaliacoesRepository.getAllAvaliacoesPage(PageRequest.of(page, size));
    }

}
