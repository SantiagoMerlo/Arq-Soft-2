package ar.edu.ucc.arqsoft.test.controller;

import ar.edu.ucc.arqsoft.test.dto.UsuarioDto;
import ar.edu.ucc.arqsoft.test.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UsuarioController{

    @Autowired
    UsuarioService servicio;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuario/{usuarioID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> mostrarUsuario(@PathVariable("usuarioID") Long id, Double saldo) throws Exception {

        UsuarioDto usuario = servicio.mostrarUsuario(id);

        return new ResponseEntity( usuario , HttpStatus.OK);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuario", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDto dto) throws Exception {

        UsuarioDto creado = servicio.crearUsuario(dto);

        return new ResponseEntity( creado , HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> mostrarUsuarios() throws Exception {

        List<UsuarioDto> dtos = servicio.mostrarTodos();

        return new ResponseEntity( dtos , HttpStatus.OK);
    }


}

