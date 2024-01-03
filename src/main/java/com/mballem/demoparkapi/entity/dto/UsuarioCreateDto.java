package com.mballem.demoparkapi.entity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
public class UsuarioCreateDto {

	private String username;
	private String password;
}
