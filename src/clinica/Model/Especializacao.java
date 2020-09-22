package clinica.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Especializacao")
public class Especializacao implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID_ESPECIALIZACAO;
	@Column
	private String ESPECIALIZACAO;

	public void setID_ESPECIALIZACAO(long iD_ESPECIALIZACAO) {
		ID_ESPECIALIZACAO = iD_ESPECIALIZACAO;
	}

	public String getESPECIALIZACAO() {
		return ESPECIALIZACAO;
	}

	public void setESPECIALIZACAO(String eSPECIALIZACAO) {
		ESPECIALIZACAO = eSPECIALIZACAO;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return ID_ESPECIALIZACAO;
	}
	
	@Override
    public String toString() {
           String texto = ID_ESPECIALIZACAO+" - "+ ESPECIALIZACAO;
           return texto;
       }

     @Override
      public boolean equals(Object obj) {
    	 Especializacao f = (Especializacao) obj;
		return Objects.equals(this.ID_ESPECIALIZACAO, f.ESPECIALIZACAO);
      }
}
