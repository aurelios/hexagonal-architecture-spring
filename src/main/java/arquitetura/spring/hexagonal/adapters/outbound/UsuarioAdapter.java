package arquitetura.spring.hexagonal.adapters.outbound;

import arquitetura.spring.hexagonal.adapters.inbound.mapper.EnderecoToEnderecoEntityMapper;
import arquitetura.spring.hexagonal.adapters.inbound.mapper.UsuarioEntityToUsuarioMapper;
import arquitetura.spring.hexagonal.adapters.inbound.mapper.UsuarioToUsuarioEntityMapper;
import arquitetura.spring.hexagonal.adapters.outbound.repository.UsuarioRepository;
import arquitetura.spring.hexagonal.application.core.domain.Usuario;
import arquitetura.spring.hexagonal.application.ports.out.UsuarioPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class UsuarioAdapter implements UsuarioPort {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioToUsuarioEntityMapper usuarioToUsuarioEntity;

    private final UsuarioEntityToUsuarioMapper usuarioEntityToUsuario;

    private final EnderecoToEnderecoEntityMapper enderecoToEnderecoEntity;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = usuarioToUsuarioEntity.mapper(usuario);
        var enderecoEntity = enderecoToEnderecoEntity.mapper(usuario.getEndereco());
        usuarioEntity.setEndereco(enderecoEntity);
        return usuarioEntityToUsuario.mapper(usuarioRepository.save(usuarioEntity));
    }
}
