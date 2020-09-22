package clinica.Controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;

import clinica.DAO.DaoGenerica;
import clinica.Model.Agendamento;
import clinica.Model.Cargo;
import clinica.Model.Especializacao;

public class CargoController {

	private static DaoGenerica<Cargo> dao;

	public CargoController() {
		dao = new DaoGenerica<Cargo>();
	}

	public boolean salvar(Cargo cargo) {
		try {
			if (StringUtils.isNullOrEmpty(cargo.getCARGO()) || cargo.getVL_SALARIO() <= 0
					|| cargo.getEspecializacao() == null) {
				JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
				return false;
			}
			dao.saveOrUpdate(cargo);
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
			int result = JOptionPane.showOptionDialog(jf, "Deseja excluir o cargo: " + id, "Informação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

			if (result == 0) {
				dao.remove(Cargo.class, id);
			}
		} catch (Exception ex) {
			return false;
		}
		JFrame jf = new JFrame();
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(jf, "Cargo excluído");
		return true;
	}

	public DefaultTableModel GetAll() {
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		List<Cargo> cargos = dao.GetAll(Cargo.class);

		// adiciona as colunas
		dtm.addColumn("ID");
		dtm.addColumn("Cargo");
		dtm.addColumn("Salário");
		dtm.addColumn("Especialização");
		dtm.addColumn("Doutor");

		for (final Cargo cargo : cargos) {

			String isDoutor = "Não";
			if (cargo.isFL_DENTISTA()) {
				isDoutor = "Sim";	
			}

			dtm.addRow(new String[] { Long.toString(cargo.getId()), cargo.getCARGO(),
					Double.toString(cargo.getVL_SALARIO()), cargo.getEspecializacao().getESPECIALIZACAO(),
					isDoutor});
		}

		return dtm;

	}

	public List<Cargo> GetAllObjects() {

		List<Cargo> cargos = dao.GetAll(Cargo.class);

		return cargos;

	}

	public Cargo pesquisar(long id) {
		Cargo cargo = dao.findById(Cargo.class, id);
		return cargo;
	}

}
