package arquitetura.spring.hexagonal.application.core.service;


import arquitetura.spring.hexagonal.application.core.domain.Usuario;
import arquitetura.spring.hexagonal.application.ports.in.UsuarioServicePort;
import arquitetura.spring.hexagonal.application.ports.out.EnderecoPort;
import arquitetura.spring.hexagonal.application.ports.out.UsuarioPort;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioPort usuarioPort;
    private final EnderecoPort enderecoPort;

    public UsuarioService(UsuarioPort usuarioPort, EnderecoPort enderecoPort) {
        this.usuarioPort = usuarioPort;
        this.enderecoPort = enderecoPort;
    }
    @Override
    public Usuario salvar(Usuario usuario, String cep) {

        var endereco = enderecoPort.buscar(cep);
        usuario.setEndereco(endereco);

        return usuarioPort.salvar(usuario);
    }
}
