package models.pessoa.capacitando;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.math.BigInteger;

import java.time.LocalTime;
import java.time.LocalDate;

import models.pessoa.Pessoa;

@Entity
@Table(name="Capacitando")
public class Capacitando extends Model
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="matricula")
  private BigInteger matricula;

  @Column(name="identificacao_social")
  private BigInteger identificacaoSocial;

  @Column(name="responsavel_familia")
  private Boolean responsavelFamilia;

  @Column(name="familia")
  private BigInteger familia;

  @Column(name="renda_per_capita")
  private Float rendaPerCapita;

  @Column(name="atualizacao_cadastral")
  private LocalDate atualizacaoCadastral;

  @Column(name="inicio_atividades")
  private LocalDate inicioAtividades;

  @Column(name="status")
  private Boolean status;

  @Column(name="data_registro")
  private LocalDate dataRegistro;

  @Column(name="hora_registro")
  private LocalTime horaRegistro;

  @Column(name="area_atuacao")
  private AreaAtuacao areaAtuacao;

  @Column(name="especialidade")
  private Especialidade especialidade;

  @OneToOne
  @JoinColumn(name="pessoa_id", referencedColumnName="id")
  private Pessoa pessoa;

  @ManyToOne
  @JoinColumn(name="necessidade_especial_id", referencedColumnName="id")
  private NecessidadeEspecial necessidadeEspecial;

  @ManyToOne
  @JoinColumn(name="categoria_id", referencedColumnName="id")
  private Categoria categoria;

  @ManyToOne
  @JoinColumn(name="unidade_id", referencedColumnName="id")
  private Unidade unidade;

  @ManyToOne
  @JoinColumn(name="turno_id", referencedColumnName="id")
  private Turno turno;

  public Capacitando()
  {
    this.matricula = BigInteger.valueOf(0);
    this.identificacaoSocial = BigInteger.valueOf(0);
    this.responsavelFamilia = false;
    this.familia = BigInteger.valueOf(0);
    this.rendaPerCapita = Float.valueOf(0);
    this.atualizacaoCadastral = LocalDate.now();
    this.inicioAtividades = LocalDate.now();
    this.status = false;
    this.dataRegistro = LocalDate.now();
    this.horaRegistro = LocalTime.now();
    this.areaAtuacao = new AreaAtuacao();
    this.especialidade = new Especialidade();
    this.pessoa = new Pessoa();
    this.necessidadeEspecial = new NecessidadeEspecial();
    this.categoria = new Categoria();
    this.unidade = new Unidade();
    this.turno = new Turno();
  }

  public Integer getId() { return this.id; }
  public BigInteger getMatricula() { return this.matricula; }
  public void setMatricula(BigInteger matricula) { this.matricula = matricula; }
  public BigInteger getIdentificacaoSocial() { return this.identificacaoSocial; }
  public void setIdentificacaoSocial(BigInteger identificacaoSocial) { this.identificacaoSocial = identificacaoSocial; }
  public Boolean getResponsavelFamilia() { return this.responsavelFamilia; }
  public void setResponsavelFamilia(Boolean responsavelFamilia) { this.responsavelFamilia = responsavelFamilia; }
  public BigInteger getFamilia() { return this.familia; }
  public void setFamilia(BigInteger familia) { this.familia = familia; }
  public Float getRendaPerCapita() { return this.rendaPerCapita; }
  public void setRendaPerCapita(Float rendaPerCapita) { this.rendaPerCapita = rendaPerCapita; }
  public LocalDate getAtualizacaoCadastral() { return this.atualizacaoCadastral; }
  public void setAtualizacaoCadastral(LocalDate atualizacaoCadastral) { this.atualizacaoCadastral = atualizacaoCadastral; }
  public LocalDate getInicioAtividades() { return this.inicioAtividades; }
  public void setInicioAtividades(LocalDate inicioAtividades) { this.inicioAtividades = inicioAtividades; }
  public Boolean getStatus() { return this.status; }
  public void setStatus(Boolean status) { this.status = status; }
  public LocalDate getDataRegistro() { return this.dataRegistro; }
  public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }
  public LocalTime getHoraRegistro() { return this.horaRegistro; }
  public void setHoraRegistro(LocalTime horaRegistro) { this.horaRegistro = horaRegistro; }
  public AreaAtuacao getAreaAtuacao() { return this.areaAtuacao; }
  public void setAreaAtuacao(AreaAtuacao areaAtuacao) { this.areaAtuacao = areaAtuacao; }
  public Especialidade getEspecialidade() { return this.especialidade; }
  public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }
  public Pessoa getPessoa() { return this.pessoa; }
  public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
  public NecessidadeEspecial getNecessidadeEspecial() { return this.necessidadeEspecial; }
  public void setNecessidadeEspecial(NecessidadeEspecial necessidadeEspecial) { this.necessidadeEspecial = necessidadeEspecial; }
  public Categoria getCategoria() { return this.categoria; }
  public void setCategoria(Categoria categoria) { this.categoria = categoria; }
  public Unidade getUnidade() { return this.unidade; }
  public void setUnidade(Unidade unidade) { this.unidade = unidade; }
  public Turno getTurno() { return this.turno; }
  public void setTurno(Turno turno) { this.turno = turno; }

  public String toString()
  {
    return getPessoa().toString() + " - " + getMatricula().toString();
  }

  public static Finder<Integer,Capacitando> find =
    new Finder<Integer,Capacitando>(Integer.class,Capacitando.class);
}
