package clinica.Controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;

import clinica.DAO.DaoGenerica;
import clinica.Model.Cargo;
import clinica.Model.Especializacao;

public class EspecializacaoController {
	private static DaoGenerica<Especializacao> dao;

	public EspecializacaoController() {
		dao = new DaoGenerica<Especializacao>();
	}

	public boolean salvar(Especializacao Especializacao) {
		try {
			if (StringUtils.isNullOrEmpty(Especializacao.getESPECIALIZACAO())) {
				JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
				return false;
			}
			dao.saveOrUpdate(Especializacao);
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
			int result = JOptionPane.showOptionDialog(jf, "Deseja excluir a especialização: " + id, "Informação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

			if (result == 0) {
				dao.remove(Especializacao.class, id);
			}
		} catch (Exception ex) {
			return false;
		}
		JFrame jf = new JFrame();
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(jf, "Especializacao excluído");
		return true;
	}

	public DefaultTableModel GetAll() {
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		List<Especializacao> Especializacaos = dao.GetAll(Especializacao.class);

		// adiciona as colunas
		dtm.addColumn("ID");
		dtm.addColumn("Especializacao");

		for (final Especializacao especializacao : Especializacaos) {
			// pega os valores do bd para popular tabela
			dtm.addRow(new String[] { Long.toString(especializacao.getId()), especializacao.getESPECIALIZACAO() });
		}

		return dtm;

	}
	
	public List<Especializacao> GetAllObjects() {
		
		List<Especializacao> Especializacaos = dao.GetAll(Especializacao.class);

		return Especializacaos;

	}

	public Especializacao pesquisar(long id) {
		Especializacao Especializacao = dao.findById(Especializacao.class, id);
		return Especializacao;
	}
}
