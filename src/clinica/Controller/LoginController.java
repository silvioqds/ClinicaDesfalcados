package clinica.Controller;

import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.mysql.jdbc.StringUtils;
import clinica.DAO.UsuarioDAO;
import clinica.Model.Usuario;

public class LoginController {

	private static UsuarioDAO daoUsuario;

	public LoginController() {
		daoUsuario = new UsuarioDAO();
	}

	public boolean Authenticated(String username, String password) throws ParseException {

		try {
			if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)
					|| StringUtils.isEmptyOrWhitespaceOnly(username) || StringUtils.isEmptyOrWhitespaceOnly(password)) {

				JOptionPane.showMessageDialog(null, "Usu�rio ou senha n�o preenchidos");
				return false;
			}

			Usuario usuario = daoUsuario.GetUsuario(username);

			if (usuario == null) {

				JOptionPane.showMessageDialog(null, "Usu�rio informado inexistente!");
				return false;
			}

			if (usuario.getPASSWORD().equals(password) && usuario.getUSERNAME().equals(username)) {
				HomeController home = new HomeController();
				home.Index(usuario.isFL_ADM());
			} else {
				JOptionPane.showMessageDialog(null, "Usu�rio ou senha inv�lidos");
				return false;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Erro ao autenticar, entre em contato com o administrador do sistema, ERRO: " + ex.getMessage());
			return false;
		}
		return true;
	}

}
