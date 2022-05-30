package arquitetura.spring.hexagonal.adapters.outbound;

import arquitetura.spring.hexagonal.adapters.outbound.rest.BuscaCepClient;
import arquitetura.spring.hexagonal.application.core.domain.Endereco;
import arquitetura.spring.hexagonal.application.ports.out.EnderecoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnderecoBuscaCepAdapter implements EnderecoPort {

    private final BuscaCepClient buscaCepClient;

    @Override
    public Endereco buscar(String cep) {
        var endereco = buscaCepClient.buscar(cep);
        return endereco.getBody();
    }
}
