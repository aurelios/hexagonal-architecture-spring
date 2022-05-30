package arquitetura.spring.hexagonal.application.ports.in;


import arquitetura.spring.hexagonal.application.core.domain.Usuario;

public interface UsuarioServicePort {
    Usuario salvar(Usuario usuario, String cep);
}
