package com.mballem.demoparkapi.entity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UsuarioResponseDto {

	private Long id;
	private String username;
	private String role;
}
