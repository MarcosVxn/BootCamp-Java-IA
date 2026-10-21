package br.com.marcosvxn.spring_boot_essentials.database.repository;

import br.com.marcosvxn.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.marcosvxn.spring_boot_essentials.dto.AvaliacaoFisicaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface IAvaliacoesRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {

    @NativeQuery(value = """
    SELECT a.id                       AS "idAluno",
           a.nome                     AS "nomeAluno",
           af.id                      AS "idAvaliacao",
           af.peso                    AS "peso",
           af.altura                  AS "altura",
           af.porcental_gordura_corporal AS "percentualGorduracorporal"
    FROM alunos a
    INNER JOIN avaliacoes_fisicas af
        ON a.avaliacao_fisica_id = af.id
""")
    List<AvaliacaoFisicaProjection> getAllAvaliacoes();

    @NativeQuery(value = """
            SELECT a.id                       AS "idAluno",
               a.nome                     AS "nomeAluno",
               af.id                      AS "idAvaliacao",
               af.peso                    AS "peso",
               af.altura                  AS "altura",
               af.porcental_gordura_corporal AS "percentualGorduracorporal"
        FROM alunos a
        INNER JOIN avaliacoes_fisicas af
            ON a.avaliacao_fisica_id = af.id
        """,
            countQuery = """
    SELECT COUNT(af.id)
    FROM avaliacoes_fisicas af
    INNER JOIN alunos a
        ON a.avaliacao_fisica_id = af.id
    """)
    Page<AvaliacaoFisicaProjection> getAllAvaliacoesPage(PageRequest pageRequest);
}
