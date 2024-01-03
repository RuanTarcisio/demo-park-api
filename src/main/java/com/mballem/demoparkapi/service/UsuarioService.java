package com.mballem.demoparkapi.service;

import com.mballem.demoparkapi.entity.Usuario;
import com.mballem.demoparkapi.entity.dto.UsuarioSenhaDto;
import com.mballem.demoparkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, UsuarioSenhaDto userDto) {
        if(!userDto.getNovaSenha().equals(userDto.getConfirmaSenha())) {
        	throw new RuntimeException("Nova senha nao confere com a confirmação");
        }
    	
    	Usuario user = buscarPorId(id);
    	if(!user.getPassword().equals(userDto.getSenhaAtual())) {
    		throw new RuntimeException("Senha nao confere");
    	}
        user.setPassword(userDto.getNovaSenha());
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
