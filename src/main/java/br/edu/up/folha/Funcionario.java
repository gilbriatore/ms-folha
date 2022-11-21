package br.edu.up.folha;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
class Funcionario {

  private @Id @GeneratedValue Long id;
  private String nome;
  private Papel papel;

  @Transient
  private Salario salario;

  Funcionario() {}

  Funcionario(String nome, Papel papel) {
    this.nome = nome;
    this.papel = papel;
  }

  Funcionario(String nome, Papel papel, Salario salario) {
    this.nome = nome;
    this.papel = papel;
    this.salario = salario;
  }

  public double getSalario(){
    if (salario == null) {
      return 0;
    }
    return salario.getValor();
  }

  public Long getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public Papel getPapel() {
    return this.papel;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPapel(Papel papel) {
    this.papel = papel;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Funcionario))
      return false;
    Funcionario funcionario = (Funcionario) o;
    return Objects.equals(this.id, funcionario.id) && Objects.equals(this.nome, funcionario.nome)
        && Objects.equals(this.papel, funcionario.papel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.nome, this.papel);
  }

  @Override
  public String toString() {
    return "Funcionario{" + "id=" + this.id + ", nome='" + this.nome + '\'' + ", papel='" + this.papel + '\'' + '}';
  }
}