package clinica.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;;

@Entity
@Table(name = "Servico")
public class Servico implements Entidade {

	public Servico() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_SERVICO;
	@Column
	private String SERVICO;
	@ManyToOne
	@JoinColumn(name = "ID_ESPECIALIZACAO")
	private Especializacao especializacao;
	@Column
	private Date DT_INCLUSAO;
	@Column
	private double VALOR;

	public String getSERVICO() {
		return SERVICO;
	}

	public void setSERVICO(String sERVICO) {
		SERVICO = sERVICO;
	}

	public Especializacao getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(Especializacao especializacao) {
		this.especializacao = especializacao;
	}

	public Date getDT_INCLUSAO() {
		return DT_INCLUSAO;
	}

	public void setDT_INCLUSAO(Date dT_INCLUSAO) {
		DT_INCLUSAO = dT_INCLUSAO;
	}

	public double getVALOR() {
		return VALOR;
	}

	public void setVALOR(double vALOR) {
		VALOR = vALOR;
	}

	public void setID_SERVICO(long value) {
		ID_SERVICO = value;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return ID_SERVICO;
	}
	
	@Override
    public String toString() {
           String texto = ID_SERVICO +" - "+ SERVICO;
           return texto;
       }

     @Override
      public boolean equals(Object obj) {
    	 Servico f = (Servico) obj;
		return Objects.equals(this.ID_SERVICO, f.SERVICO);
      }

}