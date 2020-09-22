package clinica.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.StringUtils;
import clinica.DAO.DaoGenerica;
import clinica.DAO.PacienteDAO;
import clinica.Model.Paciente;

public class PacienteController {
	private static DaoGenerica<Paciente> dao;

	public PacienteController() {
		dao = new DaoGenerica<Paciente>();
	}

	public Paciente GetByCPF(String cpf){
		PacienteDAO pacienteDao = new PacienteDAO();
		return pacienteDao.GetByCPF(cpf);
	}
	
	public boolean salvar(Paciente paciente) {
		try {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			if (StringUtils.isNullOrEmpty(paciente.getNOME()) || StringUtils.isNullOrEmpty(paciente.getCPF())
					|| paciente.getIDADE() == 0 || StringUtils.isNullOrEmpty(paciente.getNOME_MAE())
					|| StringUtils.isNullOrEmpty(paciente.getSexo())) {
				JOptionPane.showMessageDialog(jf, "É necessário preencher todos os campos");
				return false;
			}

			//paciente.setDT_INCLUSAO_ALTERACAO(new Date());
						 
			dao.saveOrUpdate(paciente);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public boolean remover(long id) {
		try {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			Object[] options = { "Confirmar", "Cancelar" };
			int result = JOptionPane.showOptionDialog(jf, "Deseja excluir o paciente: " + id, "Informação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

			if (result == 0) {
				dao.remove(Paciente.class, id);
			}
		} catch (Exception ex) {
			return false;
		}
		JFrame jf = new JFrame();
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(jf, "Paciente excluído");
		return true;
	}

	public DefaultTableModel GetAll() throws ParseException {
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		List<Paciente> pacientes = dao.GetAll(Paciente.class);

		// adiciona as colunas
		dtm.addColumn("ID");
		dtm.addColumn("Nome");
		dtm.addColumn("CPF");
		dtm.addColumn("Sexo");
		dtm.addColumn("Idade");
		dtm.addColumn("Nome Mãe");
		dtm.addColumn("Nome Pai");
		dtm.addColumn("Convênio");
		

		for (final Paciente paciente : pacientes) {
		
			String convenio = "NÃO POSSUI";

			if (paciente.getConvenio() != null) {
				convenio = paciente.getConvenio().getCONVENIO();
			}

			dtm.addRow(new String[] { Long.toString(paciente.getId()), paciente.getNOME(), paciente.getCPF(),
					paciente.getSexo(), Integer.toString(paciente.getIDADE()), paciente.getNOME_MAE(),
					paciente.getNOME_PAI(), convenio});
		}

		return dtm;

	}
	

	public List<Paciente> GetAllObjects() {		
		List<Paciente> pacientes = dao.GetAll(Paciente.class);
		return pacientes;
	}

}
