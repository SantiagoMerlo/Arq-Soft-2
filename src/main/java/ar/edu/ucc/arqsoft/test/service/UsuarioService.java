package ar.edu.ucc.arqsoft.test.service;

import ar.edu.ucc.arqsoft.test.dao.DaoGenerico;
import ar.edu.ucc.arqsoft.test.dto.UsuarioDto;
import ar.edu.ucc.arqsoft.test.model.Usuario;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    DaoGenerico<Usuario,Long> dao;

    public UsuarioDto crearUsuario(UsuarioDto dto){
        Usuario u = new Usuario();

        u.setApellido(dto.getApellido());
        u.setNombre(dto.getNombre());
        u.setDni(dto.getDni());

        dao.saveOrUpdate(u);

        dto.setId(u.getId());

        return dto;
    }

    public UsuarioDto mostrarUsuario(Long id){
        Usuario u = dao.load(id);

        UsuarioDto dto = new UsuarioDto(u.getId(), u.getNombre(), u.getApellido(), u.getDni());

        return dto;
    }

    public List<UsuarioDto> mostrarTodos(){
        List<Usuario> usuarios;

        usuarios = dao.getAll();

        List<UsuarioDto> usuarioDtos = new ArrayList<UsuarioDto>();

        for (Usuario u : usuarios){
            usuarioDtos.add(new UsuarioDto(u.getId(), u.getNombre(), u.getApellido(), u.getDni()));
        }
        return usuarioDtos;
    }
}
