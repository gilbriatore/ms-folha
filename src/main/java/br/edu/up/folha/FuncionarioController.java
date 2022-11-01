package br.edu.up.folha;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FuncionarioController {

  private final FuncionarioRepository repository;

  FuncionarioController(FuncionarioRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/funcionarios")
  List<Funcionario> listar() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/funcionarios")
  Funcionario novoFuncionario(@RequestBody Funcionario novoFuncionario) {
    return repository.save(novoFuncionario);
  }

  // Single item
  
  @GetMapping("/funcionarios/{id}")
  Funcionario getFuncionario(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new FuncionarioNotFoundException(id));
  }

  @PutMapping("/funcionarios/{id}")
  Funcionario atualizarFuncionario(@RequestBody Funcionario novoFuncionario, 
      @PathVariable Long id) {
    
    return repository.findById(id)
      .map(funcionario -> {
        funcionario.setNome(novoFuncionario.getNome());
        funcionario.setPapel(novoFuncionario.getPapel());
        return repository.save(funcionario);
      })
      .orElseGet(() -> {
        novoFuncionario.setId(id);
        return repository.save(novoFuncionario);
      });
  }

  @DeleteMapping("/funcionarios/{id}")
  void excluirFuncionario(@PathVariable Long id) {
    repository.deleteById(id);
  }
}