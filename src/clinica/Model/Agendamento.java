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
@Table(name = "Agendamento")
public class Agendamento implements Entidade{	

	public Agendamento() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID_AGENDAMENTO;
	
	@ManyToOne
	@JoinColumn(name = "ID_FUNCIONARIO")
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "ID_SERVICO")
	private Servico servico;

	@ManyToOne
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;

	@Column
	private Date DT_HORA_ATENDIMENTO;
	@Column
	private boolean FL_CANCELADO = false;
	@Column
	private String MOTIVO_CANCELAMENTO = null;
	@Column
	private Date DT_INCLUSAO;

	@Column
	private double VL_ATENDIMENTO;
	
	public long getID_AGENDAMENTO() {
		return ID_AGENDAMENTO;
	}

	public void setID_AGENDAMENTO(long iD_AGENDAMENTO) {
		ID_AGENDAMENTO = iD_AGENDAMENTO;
	}

	
	public Date getDT_HORA_ATENDIMENTO() {
		return DT_HORA_ATENDIMENTO;
	}

	public void setDT_HORA_ATENDIMENTO(Date dT_HORA_ATENDIMENTO) {
		DT_HORA_ATENDIMENTO = dT_HORA_ATENDIMENTO;
	}

	public boolean isFL_CANCELADO() {
		return FL_CANCELADO;
	}

	public void setFL_CANCELADO(boolean fL_CANCELADO) {
		FL_CANCELADO = fL_CANCELADO;
	}

	public String getMOTIVO_CANCELAMENTO() {
		return MOTIVO_CANCELAMENTO;
	}

	public void setMOTIVO_CANCELAMENTO(String mOTIVO_CANCELAMENTO) {
		MOTIVO_CANCELAMENTO = mOTIVO_CANCELAMENTO;
	}

	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getDT_INCLUSAO() {
		return DT_INCLUSAO;
	}

	public void setDT_INCLUSAO(Date dT_INCLUSAO) {
		DT_INCLUSAO = dT_INCLUSAO;
	}

	
	public double getVL_ATENDIMENTO() {
		return VL_ATENDIMENTO;
	}

	public void setVL_ATENDIMENTO(double vL_ATENDIMENTO) {
		VL_ATENDIMENTO = vL_ATENDIMENTO;
	}
	

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return ID_AGENDAMENTO;
	}

}