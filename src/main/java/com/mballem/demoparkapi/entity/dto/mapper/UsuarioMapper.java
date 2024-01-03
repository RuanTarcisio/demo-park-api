package com.mballem.demoparkapi.entity.dto.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.mballem.demoparkapi.entity.Usuario;
import com.mballem.demoparkapi.entity.dto.UsuarioCreateDto;
import com.mballem.demoparkapi.entity.dto.UsuarioResponseDto;

public class UsuarioMapper {

	public static Usuario toUsuario(UsuarioCreateDto createDto) {
		return new ModelMapper().map(createDto, Usuario.class);
	}
	
	public static UsuarioResponseDto toDto(Usuario usuario) {
		String role = usuario.getRole().name().substring("ROLE_".length());
		PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
			
			@Override
			protected void configure() {
				map().setRole(role);				
			}
		};
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(props);
		return mapper.map(usuario, UsuarioResponseDto.class);
	}
}
