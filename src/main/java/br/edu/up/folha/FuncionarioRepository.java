package br.edu.up.folha;

import org.springframework.data.jpa.repository.JpaRepository;

interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}