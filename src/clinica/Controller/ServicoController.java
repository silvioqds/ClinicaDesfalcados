package clinica.Controller;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;

import clinica.DAO.DaoGenerica;
import clinica.Model.Servico;

public class ServicoController {
	private static DaoGenerica<Servico> dao;

	public ServicoController() {
		dao = new DaoGenerica<Servico>();
	}

	public boolean salvar(Servico Servico) {
		try {
			if (StringUtils.isNullOrEmpty(Servico.getSERVICO()) || Servico.getVALOR() <= 0 || Servico.getEspecializacao().getId() == 0) {
				JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
				return false;
			}
			Servico.setDT_INCLUSAO(new Date());
			dao.saveOrUpdate(Servico);
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
			int result = JOptionPane.showOptionDialog(jf, "Deseja excluir o serviço: "+ id, "Informação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

			if (result == 0) {
				dao.remove(Servico.class, id);
			}
		} catch (Exception ex) {
			return false;
		}
		JFrame jf = new JFrame();
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(jf, "Servico excluído");
		return true;
	}

	public DefaultTableModel GetAll() {
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		List<Servico> Servicos = dao.GetAll(Servico.class);

		// adiciona as colunas
		dtm.addColumn("ID");
		dtm.addColumn("Servico");
		dtm.addColumn("Valor");
		dtm.addColumn("Especialização");

		for (final Servico Servico : Servicos) {
			// pega os valores do bd para popular tabela
			dtm.addRow(new String[] { Long.toString(Servico.getId()), Servico.getSERVICO(), 
					Double.toString(Servico.getVALOR()), Servico.getEspecializacao().getESPECIALIZACAO() });
		}

		return dtm;

	}
	
	public List<Servico> GetAllObjects() {
		
		List<Servico> Servicos = dao.GetAll(Servico.class);

		return Servicos;

	}

	public Servico pesquisar(long id) {
		Servico Servico = dao.findById(Servico.class, id);
		return Servico;
	}
}
