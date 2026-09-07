package _iBi.Desafio.dto;

import jakarta.validation.constraints.*;

public record PaisRequest(

        @NotBlank
        String nome,

        @NotBlank
        String capital,

        @NotBlank
        String regiao,

        @NotBlank
        String subRegiao,

        @NotNull
        @Positive
        Double area
) {
}