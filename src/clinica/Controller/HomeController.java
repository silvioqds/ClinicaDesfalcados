package clinica.Controller;
import java.text.ParseException;
import java.util.List;
import clinica.DAO.FuncionarioDAO;
import clinica.Model.Aniversariante;
import clinica.View.HomeView;

public class HomeController {

	private static FuncionarioDAO dao;

	public HomeController() {
		dao = new FuncionarioDAO();
	}

	public void Index(boolean adm) throws ParseException {
		List<Aniversariante> aniversariantes = dao.GetAniversariantes();
		HomeView view = new HomeView(aniversariantes,adm);
		view.setVisible(true);
	}

}
