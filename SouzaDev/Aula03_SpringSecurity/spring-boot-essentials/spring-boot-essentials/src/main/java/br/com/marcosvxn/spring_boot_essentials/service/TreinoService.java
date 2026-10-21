package br.com.marcosvxn.spring_boot_essentials.service;

import br.com.marcosvxn.spring_boot_essentials.database.model.AlunosEntity;
import br.com.marcosvxn.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.marcosvxn.spring_boot_essentials.database.model.TreinoEntity;
import br.com.marcosvxn.spring_boot_essentials.database.repository.IAlunosRepository;
import br.com.marcosvxn.spring_boot_essentials.database.repository.IExerciciosRepository;
import br.com.marcosvxn.spring_boot_essentials.database.repository.ITreinosRepository;
import br.com.marcosvxn.spring_boot_essentials.dto.TreinoDTO;
import br.com.marcosvxn.spring_boot_essentials.exception.BadRequestException;
import br.com.marcosvxn.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;
    private final ITreinosRepository treinosRepository;

    public void criarTreino(TreinoDTO treinoDTO) throws NotFoundException, BadRequestException {
        Set<ExerciciosEntity> exercicios = new HashSet<>();

        AlunosEntity aluno = alunosRepository.findById(treinoDTO.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        TreinoEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDTO.getNome(), treinoDTO.getAlunoId())
                .orElse(null);

        if (treino != null){
            throw new BadRequestException("Já existe um treino com esse nome para esse aluno");
        }

        for (Integer exercicioId : treinoDTO.getExerciciosIds()){
            ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException(String.format("Exercicio %s não encontrado", exercicioId)));

            exercicios.add(exercicio);
        }

        treino = TreinoEntity.builder()
                .nome(treinoDTO.getNome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

        treinosRepository.save(treino);
    }


}
