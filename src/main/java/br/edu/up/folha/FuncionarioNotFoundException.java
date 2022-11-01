package br.edu.up.folha;

class FuncionarioNotFoundException extends RuntimeException {

  FuncionarioNotFoundException(Long id) {
    super("Não conseguir encontrar o funcionário " + id);
  }
}