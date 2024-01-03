package com.mballem.demoparkapi.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class UsuarioSenhaDto {
	
	private String senhaAtual;
	private String novaSenha;
	private String confirmaSenha;

}
