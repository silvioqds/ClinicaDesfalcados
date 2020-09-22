package clinica.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Cargo")
public class Cargo implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_CARGO;
	@Column
	private String CARGO;
	@Column
	private double VL_SALARIO;
	@ManyToOne
	@JoinColumn(name = "ID_ESPECIALIZACAO")
	private Especializacao especializacao;
	@Column
	private boolean FL_DENTISTA;

	public void setID_CARGO(long iD_CARGO) {
		ID_CARGO = iD_CARGO;
	}

	public String getCARGO() {
		return CARGO;
	}

	public void setCARGO(String cARGO) {
		CARGO = cARGO;
	}

	public double getVL_SALARIO() {
		return VL_SALARIO;
	}

	public void setVL_SALARIO(double vL_SALARIO) {
		VL_SALARIO = vL_SALARIO;
	}

	
	
	public Especializacao getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(Especializacao especializacao) {
		this.especializacao = especializacao;
	}

	public boolean isFL_DENTISTA() {
		return FL_DENTISTA;
	}

	public void setFL_DENTISTA(boolean fL_DENTISTA) {
		FL_DENTISTA = fL_DENTISTA;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return ID_CARGO;
	}
	
	@Override
    public String toString() {
           String texto = ID_CARGO+" - "+ CARGO;
           return texto;
       }

     @Override
      public boolean equals(Object obj) {
    	 Cargo f = (Cargo) obj;
		return Objects.equals(this.ID_CARGO, f.CARGO);
      }

	 
}
