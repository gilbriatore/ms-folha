package br.edu.up.folha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CarregarDados {

  private static final Logger log = LoggerFactory.getLogger(CarregarDados.class);

  @Bean
  CommandLineRunner initDatabase(FuncionarioRepository repository) {

    return args -> {
      log.info("Carregando " + repository.save(new Funcionario("Bilbo Baggins", Papel.Gerente)));
      log.info("Carregando " + repository.save(new Funcionario("Frodo Baggins", Papel.Vendedor)));
    };
  }
}