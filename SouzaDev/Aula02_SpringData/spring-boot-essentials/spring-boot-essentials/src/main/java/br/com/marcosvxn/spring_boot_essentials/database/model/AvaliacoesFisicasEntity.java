package br.com.marcosvxn.spring_boot_essentials.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "avaliacoes_fisicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class AvaliacoesFisicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal peso;

    @Column(nullable = false)
    private BigDecimal altura;

    @Column(name = "porcental_gordura_corporal", nullable = false)
    private BigDecimal porcentagemGorduraCorporal;

}
