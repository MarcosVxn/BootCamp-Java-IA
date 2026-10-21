package br.com.marcosvxn.spring_boot_essentials.database.repository;

import br.com.marcosvxn.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.marcosvxn.spring_boot_essentials.database.model.TreinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITreinosRepository extends JpaRepository<TreinoEntity, Integer> {

    Optional<TreinoEntity> findByNomeAndAlunoId(String nome, Integer alunoId);
}
