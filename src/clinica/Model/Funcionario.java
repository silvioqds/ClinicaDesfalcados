package clinica.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Funcionario")
public class Funcionario implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_FUNCIONARIO;
	@Column
	private String NOME;	
	@Column
	private Date DT_NASCIMENTO;
	@Column
	private Date DT_INCLUSAO;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "ID_CARGO")
	private Cargo cargo;
	@Column
	private String CPF;
	@Column(length=1)
	private String Sexo;
	@Column
	private Integer CRO;
	

	public void setID_FUNCIONARIO(long iD_FUNCIONARIO) {
		ID_FUNCIONARIO = iD_FUNCIONARIO;
	}
	
	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public Date getDT_NASCIMENTO() {
		return DT_NASCIMENTO;
	}

	public void setDT_NASCIMENTO(Date dT_NASCIMENTO) {
		DT_NASCIMENTO = dT_NASCIMENTO;
	}

	public Date getDT_INCLUSAO() {
		return DT_INCLUSAO;
	}

	public void setDT_INCLUSAO(Date dT_INCLUSAO) {
		DT_INCLUSAO = dT_INCLUSAO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public int getCRO() {
		return CRO;
	}

	public void setCRO(int cRO) {
		CRO = cRO;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return ID_FUNCIONARIO;
	}
	
	@Override
    public String toString() {
           String texto = ID_FUNCIONARIO +" - "+ NOME;
           return texto;
       }

     @Override
      public boolean equals(Object obj) {
    	 Funcionario f = (Funcionario) obj;
		return Objects.equals(this.ID_FUNCIONARIO, f.NOME);
      }

}
