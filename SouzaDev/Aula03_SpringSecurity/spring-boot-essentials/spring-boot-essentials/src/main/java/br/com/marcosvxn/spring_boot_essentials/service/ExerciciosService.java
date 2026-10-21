package br.com.marcosvxn.spring_boot_essentials.service;

import br.com.marcosvxn.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.marcosvxn.spring_boot_essentials.database.repository.IExerciciosRepository;
import br.com.marcosvxn.spring_boot_essentials.dto.ExerciciosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final IExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }

    public void save(ExerciciosDTO exerciciosDTO){
        exerciciosRepository.save(ExerciciosEntity.builder()
                .nome(exerciciosDTO.getNome())
                .grupoMuscular(exerciciosDTO.getGrupoMuscular())
                .build());
    }

    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
