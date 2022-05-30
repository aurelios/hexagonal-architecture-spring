package arquitetura.spring.hexagonal.adapters.outbound.rest;

import arquitetura.spring.hexagonal.application.core.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "buscaCep", url = "${url.buscaCep}")
public interface BuscaCepClient {

    @GetMapping( "${buscaCep.api}")
    ResponseEntity<Endereco> buscar(@PathVariable String cep);

}
