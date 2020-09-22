package clinica.Controller;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;

import clinica.DAO.AgendamentoDAO;
import clinica.DAO.DaoGenerica;
import clinica.DAO.UsuarioDAO;
import clinica.Model.Agendamento;
import clinica.Model.Funcionario;
import clinica.Model.Usuario;

public class AgendamentoController {

	private static AgendamentoDAO daoAgendamento;
	private static DaoGenerica<Agendamento> dao;

	public AgendamentoController() {
		daoAgendamento = new AgendamentoDAO();
		dao = new DaoGenerica<Agendamento>();
	}

	public boolean salvar(Agendamento agendamento) {
		try {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			if (agendamento.getFuncionario() == null || agendamento.getServico() == null
					|| agendamento.getPaciente() == null
					|| StringUtils.isNullOrEmpty(agendamento.getDT_HORA_ATENDIMENTO().toString())) {
				JOptionPane.showMessageDialog(jf, "É necessário preencher todos os campos");
				return false;
			}
			agendamento.setDT_INCLUSAO(new Date());
			dao.saveOrUpdate(agendamento);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public Agendamento GetAgendamento(long id) {
		return dao.findById(Agendamento.class, id);
	}

	public DefaultTableModel GetAgendamentos(String data, String cpf, long ID_DENTISTA) throws Exception {

		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// adiciona as colunas
		dtm.addColumn("ID");
		dtm.addColumn("Paciente");
		dtm.addColumn("Doutor");
		dtm.addColumn("Serviço");		
		dtm.addColumn("Data Agendamento");
		dtm.addColumn("Data Entrada");
		dtm.addColumn("Motivo Cancelamento");
		dtm.addColumn("Valor");

		if (StringUtils.isNullOrEmpty(data)) {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, "Selecione uma data");
			return dtm;
		}
		List<Agendamento> agendamentos = daoAgendamento.GetAgendamentos(data, cpf, ID_DENTISTA);

		for (final Agendamento agen : agendamentos) {

			String cancelado = "Não possui cancelamento";
			if(agen.isFL_CANCELADO()){
				cancelado = agen.getMOTIVO_CANCELAMENTO();
			}
			
			dtm.addRow(new String[] { Long.toString(agen.getId()), agen.getPaciente().getNOME(),
					agen.getFuncionario().getNOME(), agen.getServico().getSERVICO(),
					agen.getDT_HORA_ATENDIMENTO().toString(), agen.getDT_INCLUSAO().toString(),cancelado,
					Double.toString(agen.getVL_ATENDIMENTO()) });
		}

		return dtm;
	}

}
