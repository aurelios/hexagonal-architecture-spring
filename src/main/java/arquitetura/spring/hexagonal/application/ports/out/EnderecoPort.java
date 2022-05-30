package arquitetura.spring.hexagonal.application.ports.out;


import arquitetura.spring.hexagonal.application.core.domain.Endereco;

public interface EnderecoPort {
    Endereco buscar(String cep);
}
