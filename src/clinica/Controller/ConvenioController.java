package clinica.Controller;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;

import clinica.DAO.DaoGenerica;
import clinica.Model.Convenio;

public class ConvenioController {

	private static DaoGenerica<Convenio> dao;

	public ConvenioController() {
		dao = new DaoGenerica<Convenio>();
	}

	public boolean salvar(Convenio convenio) {
		try {
			if (StringUtils.isNullOrEmpty(convenio.getCONVENIO()) || convenio.getDESCONTO_VALOR_SERVICO() == 0) {
				JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
				return false;
			}
			convenio.setDT_INCLUSAO(new Date());
			dao.saveOrUpdate(convenio);
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
			int result = JOptionPane.showOptionDialog(jf, "Deseja excluir o convênio: " + id, "Informação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

			if (result == 0) {
				dao.remove(Convenio.class, id);
			}
		} catch (Exception ex) {
			return false;
		}
		JFrame jf = new JFrame();
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(jf, "Convenio excluído");
		return true;
	}

	public DefaultTableModel GetAll() {
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		List<Convenio> Convenios = dao.GetAll(Convenio.class);

		// adiciona as colunas
		dtm.addColumn("ID");
		dtm.addColumn("Convenio");
		dtm.addColumn("Valor desconto");

		for (final Convenio convenio : Convenios) {
			// pega os valores do bd para popular tabela
			dtm.addRow(new String[] { Long.toString(convenio.getId()), convenio.getCONVENIO(),Double.toString(convenio.getDESCONTO_VALOR_SERVICO())  });
		}

		return dtm;
	}
	
	public List<Convenio> GetAllObjects() {		
		List<Convenio> convenios = dao.GetAll(Convenio.class);
		return convenios;
	}

	public Convenio pesquisar(long id) {
		Convenio convenio = dao.findById(Convenio.class, id);
		return convenio;
	}
}
