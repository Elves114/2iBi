package _iBi.Desafio.dto;


public record PaisResponse(
        Long id,
        String nome,
        String capital,
        String regiao,
        String subRegiao,
        Double area
) {
}