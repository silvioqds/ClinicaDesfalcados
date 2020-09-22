package clinica.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Convenio")
public class Convenio implements Entidade {

	public Convenio() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_CONVENIO;
	@Column
	private String CONVENIO;
	@Column	
	private double DESCONTO_VALOR_SERVICO;
	@Column
	private Date DT_INCLUSAO;

	public String getCONVENIO() {
		return CONVENIO;
	}

	public void setCONVENIO(String cONVENIO) {
		CONVENIO = cONVENIO;
	}

	
	public double getDESCONTO_VALOR_SERVICO() {
		return DESCONTO_VALOR_SERVICO;
	}

	public void setDESCONTO_VALOR_SERVICO(double dESCONTO_VALOR_SERVICO) {
		DESCONTO_VALOR_SERVICO = dESCONTO_VALOR_SERVICO;
	}

	public Date getDT_INCLUSAO() {
		return DT_INCLUSAO;
	}

	public void setDT_INCLUSAO(Date dT_INCLUSAO) {
		DT_INCLUSAO = dT_INCLUSAO;
	}

	public void setID_CONVENIO(long iD_CONVENIO) {
		ID_CONVENIO = iD_CONVENIO;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return ID_CONVENIO;
	}
	@Override
    public String toString() {
           String texto = ID_CONVENIO+" - "+ CONVENIO;
           return texto;
       }

     @Override
      public boolean equals(Object obj) {
    	 Convenio f = (Convenio) obj;
		return Objects.equals(this.ID_CONVENIO, f.CONVENIO);
      }

}