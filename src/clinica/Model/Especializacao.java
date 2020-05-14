package clinica.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Especializacao")
public class Especializacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID_ESPECIALIZACAO;
	@Column
	private String ESPECIALIZACAO;
	
	
	public int getID_ESPECIALIZACAO() {
		return ID_ESPECIALIZACAO;
	}
	public void setID_ESPECIALIZACAO(int iD_ESPECIALIZACAO) {
		ID_ESPECIALIZACAO = iD_ESPECIALIZACAO;
	}
	public String getESPECIALIZACAO() {
		return ESPECIALIZACAO;
	}
	public void setESPECIALIZACAO(String eSPECIALIZACAO) {
		ESPECIALIZACAO = eSPECIALIZACAO;
	}
}
