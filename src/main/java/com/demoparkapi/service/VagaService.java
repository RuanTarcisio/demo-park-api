package com.demoparkapi.service;

import static com.demoparkapi.entity.Vaga.StatusVaga.LIVRE;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoparkapi.entity.Vaga;
import com.demoparkapi.exception.CodigoUniqueViolationException;
import com.demoparkapi.exception.EntityNotFoundException;
import com.demoparkapi.repository.VagaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    @Transactional
    public Vaga salvar(Vaga vaga) {
        try {
            return vagaRepository.save(vaga);
        } catch (DataIntegrityViolationException ex) {
            throw new CodigoUniqueViolationException(
                    String.format("Vaga com código '%s' já cadastrada", vaga.getCodigo())
            );
        }
    }

    @Transactional(readOnly = true)
    public Vaga buscarPorCodigo(String codigo) {
        return vagaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntityNotFoundException(String.format("Vaga com código '%s' não foi encontrada", codigo))
        );
    }

    @Transactional(readOnly = true)
    public Vaga buscarPorVagaLivre() {
        return vagaRepository.findFirstByStatus(LIVRE).orElseThrow(
                () -> new EntityNotFoundException("Nenhuma vaga livre foi encontrada")
        );
    }
}
