package br.com.marcosvxn.spring_boot_essentials.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExerciciosDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
