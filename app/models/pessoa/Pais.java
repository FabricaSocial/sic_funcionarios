package models.pessoa;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Pais")
public class Pais extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer id;

  @Column(name="nome")
  public String nome;

  public Pais()
  {
    this.nome = "";
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getNome()
  {
    return this.nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public String toString()
  {
    return getNome();
  }

  public Model.Finder<Integer,Pais> find =
    new Model.Finder<Integer,Pais>(Integer.class,Pais.class);
}
