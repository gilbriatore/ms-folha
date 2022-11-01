package br.edu.up.folha;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Funcionario {

  private @Id @GeneratedValue Long id;
  private String nome;
  private String papel;

  Funcionario() {}

  Funcionario(String nome, String papel) {

    this.nome = nome;
    this.papel = papel;
  }

  public Long getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getPapel() {
    return this.papel;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPapel(String papel) {
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