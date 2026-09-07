package _iBi.Desafio.service;

import _iBi.Desafio.dto.PaisRequest;
import _iBi.Desafio.dto.PaisResponse;
import _iBi.Desafio.entity.Pais;
import _iBi.Desafio.exception.PaisNotFoundException;
import _iBi.Desafio.repository.PaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisResponse criar(PaisRequest request) {

        Pais pais = Pais.builder()
                .nome(request.nome())
                .capital(request.capital())
                .regiao(request.regiao())
                .subRegiao(request.subRegiao())
                .area(request.area())
                .build();

        return converter(paisRepository.save(pais));
    }

    public List<PaisResponse> listar(String sort, String direction) {

        Sort.Direction direcao = Sort.Direction.fromString(direction);

        Sort ordenacao = Sort.by(direcao, sort);

        return paisRepository.findAll(ordenacao)
                .stream()
                .map(this::converter)
                .toList();
    }

    public PaisResponse buscarPorId(Long id) {

        Pais pais = paisRepository.findById(id)
                .orElseThrow(() ->
                        new PaisNotFoundException("País não encontrado: " + id));

        return converter(pais);
    }

    public PaisResponse atualizar(Long id, PaisRequest request) {

        Pais pais = paisRepository.findById(id)
                .orElseThrow(() ->
                        new PaisNotFoundException("País não encontrado: " + id));

        pais.setNome(request.nome());
        pais.setCapital(request.capital());
        pais.setRegiao(request.regiao());
        pais.setSubRegiao(request.subRegiao());
        pais.setArea(request.area());

        return converter(paisRepository.save(pais));
    }

    public void eliminar(Long id) {

        if (!paisRepository.existsById(id)) {
            throw new PaisNotFoundException(
                    "País não encontrado: " + id
            );
        }

        paisRepository.deleteById(id);
    }

    private PaisResponse converter(Pais pais) {

        return new PaisResponse(
                pais.getId(),
                pais.getNome(),
                pais.getCapital(),
                pais.getRegiao(),
                pais.getSubRegiao(),
                pais.getArea()
        );
    }
}