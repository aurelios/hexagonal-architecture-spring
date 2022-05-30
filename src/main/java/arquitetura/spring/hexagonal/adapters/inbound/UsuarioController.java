package arquitetura.spring.hexagonal.adapters.inbound;

import arquitetura.spring.hexagonal.adapters.inbound.mapper.UsuarioRequestToUsuarioMapper;
import arquitetura.spring.hexagonal.adapters.inbound.request.UsuarioRequest;
import arquitetura.spring.hexagonal.application.core.domain.Usuario;
import arquitetura.spring.hexagonal.application.ports.in.UsuarioServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioServicePort usuarioServicePort;
    private final UsuarioRequestToUsuarioMapper usuarioRequestToUsuario;

    @PostMapping
    public Usuario salvar(@RequestBody UsuarioRequest usuarioRequest){
        var usuario = usuarioRequestToUsuario.mapper(usuarioRequest);
        return usuarioServicePort.salvar(usuario, usuarioRequest.getCep());
    }

}
