package clinica.Model;

import java.util.Date;

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
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_FUNCIONARIO;
	@Column
	private String NOME;
	@Column
	private double VL_SALARIO;
	@Column
	private Date DT_NASCIMENTO;
	@Column
	private Date DT_INCLUSAO;
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	public int getID_FUNCIONARIO() {
		return ID_FUNCIONARIO;
	}

	public void setID_FUNCIONARIO(int iD_FUNCIONARIO) {
		ID_FUNCIONARIO = iD_FUNCIONARIO;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public double getVL_SALARIO() {
		return VL_SALARIO;
	}

	public void setVL_SALARIO(double vL_SALARIO) {
		VL_SALARIO = vL_SALARIO;
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

}
