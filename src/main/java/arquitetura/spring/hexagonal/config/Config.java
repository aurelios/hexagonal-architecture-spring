package arquitetura.spring.hexagonal.config;

import arquitetura.spring.hexagonal.adapters.outbound.EnderecoBuscaCepAdapter;
import arquitetura.spring.hexagonal.adapters.outbound.UsuarioAdapter;
import arquitetura.spring.hexagonal.application.core.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
	public UsuarioService salvarUsuarioService(UsuarioAdapter usuarioAdapter, EnderecoBuscaCepAdapter buscarEnderecoBuscaCepAdapter){
		return new UsuarioService(usuarioAdapter, buscarEnderecoBuscaCepAdapter);
	}
}
