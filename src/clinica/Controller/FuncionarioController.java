package clinica.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;

import clinica.DAO.DaoGenerica;
import clinica.DAO.FuncionarioDAO;
import clinica.DAO.UsuarioDAO;
import clinica.Model.Funcionario;
import clinica.Model.Usuario;

public class FuncionarioController {
	private static DaoGenerica<Funcionario> dao;

	public FuncionarioController() {
		dao = new DaoGenerica<Funcionario>();
	}

	public boolean salvar(Funcionario funcionario) {
		try {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			if (StringUtils.isNullOrEmpty(funcionario.getNOME()) || StringUtils.isNullOrEmpty(funcionario.getCPF())
					|| funcionario.getCargo() == null || funcionario.getUsuario() == null
					|| StringUtils.isNullOrEmpty(funcionario.getDT_NASCIMENTO().toString())
					|| StringUtils.isNullOrEmpty(funcionario.getUsuario().getUSERNAME())
					|| StringUtils.isNullOrEmpty(funcionario.getUsuario().getPASSWORD())) {
				JOptionPane.showMessageDialog(jf, "É necessário preencher todos os campos");
				return false;
			}

			UsuarioDAO daoUsuario = new UsuarioDAO();
			Usuario usuario = daoUsuario.GetUsuario(funcionario.getUsuario().getUSERNAME());

			if (usuario != null) {
				if (usuario.getId() == 0) {

					JOptionPane.showMessageDialog(jf, "Nome de usuário em uso, escolha outro!");
					return false;
				}
			} else {
				funcionario.getUsuario().setDT_INCLUSAO(new Date());
			}
			if (funcionario.getId() == 0) {
				funcionario.setDT_INCLUSAO(new Date());
			}
			daoUsuario.saveOrUpdate(funcionario.getUsuario());

			dao.saveOrUpdate(funcionario);
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
				dao.remove(Funcionario.class, id);
			}
		} catch (Exception ex) {
			return false;
		}
		JFrame jf = new JFrame();
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(jf, "Funcionario excluído");
		return true;
	}

	public DefaultTableModel GetAll() {
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		List<Funcionario> Funcionarios = dao.GetAll(Funcionario.class);

		// adiciona as colunas
		dtm.addColumn("ID_FUNCIONARIO");
		dtm.addColumn("Funcionario");
		dtm.addColumn("CPF");
		dtm.addColumn("Data Nascimento");
		dtm.addColumn("CRO");
		dtm.addColumn("ID_USUARIO");
		dtm.addColumn("Username");
		dtm.addColumn("ADM");
		dtm.addColumn("Cargo");
		dtm.addColumn("Data de Inclusão");

		for (final Funcionario func : Funcionarios) {

			String adm = "Não";
			if (func.getUsuario().isFL_ADM()) {
				adm = "Sim";
			}

			SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy");

			String datanascimento = "";
			String dataInclusao = "";
			try {
				Date date = sdfIn.parse(func.getDT_NASCIMENTO().toString());
				datanascimento = sdfOut.format(date);

				Date date2 = sdfIn.parse(func.getDT_INCLUSAO().toString());
				dataInclusao = sdfOut.format(date2);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String CRO = "NÃO POSSUI";
			try {
				if (!StringUtils.isNullOrEmpty(Integer.toString(func.getCRO()))) {
					CRO = Integer.toString(func.getCRO());
				}
			} catch (Exception ex) {
				CRO = "NÃO POSSUI";
			}
			dtm.addRow(new String[] { Long.toString(func.getId()), func.getNOME(), func.getCPF(), datanascimento, CRO,
					Long.toString(func.getUsuario().getId()), func.getUsuario().getUSERNAME(), adm,
					func.getCargo().getCARGO(), dataInclusao });
		}

		return dtm;

	}
	
	public List<Funcionario> GetDoutores(long ID_ESPECIALIZACAO){
		FuncionarioDAO funcDao = new  FuncionarioDAO();
		return funcDao.GetDoutores(ID_ESPECIALIZACAO);
	}

	public static boolean isDateValid(String strDate) {
		String dateFormat = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
