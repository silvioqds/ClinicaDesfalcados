package clinica.Model;

import javax.persistence.*;

@Entity
@Table(name = "Dentista")

public class Dentista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_DENTISTA;
	@Column
	private int CRO;
	@ManyToOne
	@JoinColumn(name = "ID_ESPECIALIZACAO")
	private Especializacao especializacao;
	@ManyToOne
	@JoinColumn(name = "ID_FUNCIONARIO")
	private Funcionario funcionario;
	
	public int getID_DENTISTA() {
		return ID_DENTISTA;
	}
	public void setID_DENTISTA(int iD_DENTISTA) {
		ID_DENTISTA = iD_DENTISTA;
	}
	public int getCRO() {
		return CRO;
	}
	public void setCRO(int cRO) {
		CRO = cRO;
	}
	public Especializacao getEspecializacao() {
		return especializacao;
	}
	public void setEspecializacao(Especializacao especializacao) {
		this.especializacao = especializacao;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
