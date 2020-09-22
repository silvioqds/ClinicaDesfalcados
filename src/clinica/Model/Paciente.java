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
@Table(name = "Paciente")
public class Paciente implements Entidade {

	public Paciente() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_PACIENTE;
	@Column
	private String NOME;
	@Column
	private String NOME_PAI;
	@Column
	private String NOME_MAE;
	@Column
	private String CPF;
	@Column(length = 1)
	private String Sexo;
	@Column
	private int IDADE;
	@ManyToOne
	@JoinColumn(name = "ID_CONVENIO",nullable = true)
	private Convenio convenio;


	public void setID_PACIENTE(long iD_PACIENTE) {
		ID_PACIENTE = iD_PACIENTE;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public String getNOME_PAI() {
		return NOME_PAI;
	}

	public void setNOME_PAI(String nOME_PAI) {
		NOME_PAI = nOME_PAI;
	}

	public String getNOME_MAE() {
		return NOME_MAE;
	}

	public void setNOME_MAE(String nOME_MAE) {
		NOME_MAE = nOME_MAE;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	
	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public int getIDADE() {
		return IDADE;
	}

	public void setIDADE(int iDADE) {
		IDADE = iDADE;
	}

	

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return ID_PACIENTE;
	}

}