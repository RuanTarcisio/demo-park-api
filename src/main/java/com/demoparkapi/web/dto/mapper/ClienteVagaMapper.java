package com.demoparkapi.web.dto.mapper;

import org.modelmapper.ModelMapper;

import com.demoparkapi.entity.ClienteVaga;
import com.demoparkapi.web.dto.EstacionamentoCreateDto;
import com.demoparkapi.web.dto.EstacionamentoResponseDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteVagaMapper {

    public static ClienteVaga toClienteVaga(EstacionamentoCreateDto dto) {
        return new ModelMapper().map(dto, ClienteVaga.class);
    }

    public static EstacionamentoResponseDto toDto(ClienteVaga clienteVaga) {
        return new ModelMapper().map(clienteVaga, EstacionamentoResponseDto.class);
    }
}
