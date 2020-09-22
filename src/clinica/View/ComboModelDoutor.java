package clinica.View;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import clinica.Controller.FuncionarioController;
import clinica.Model.Funcionario;

public class ComboModelDoutor extends AbstractListModel<Funcionario> implements ComboBoxModel<Funcionario> {

	private List<Funcionario> lista;
	

	/* Seleciona um objeto na caixa de seleção */
	private Funcionario selecionado;

	/* Método construtor */
	public ComboModelDoutor(long ID_ESPECIALIZACAO) {	
		/* Popula a lista */
		popular(ID_ESPECIALIZACAO);

		/* Define o objeto selecionado */
		setSelectedItem(lista.get(0));
	}
	public ComboModelDoutor() {		
		/* Popula a lista */
		popular(0);

		/* Define o objeto selecionado */
		setSelectedItem(lista.get(0));
	}

	/* Captura o tamanho da listagem */
	public int getSize() {
		int totalElementos = lista.size();
		return totalElementos;
	}

	/* Captura um elemento da lista em uma posição informada */
	public Funcionario getElementAt(int indice) {
		Funcionario t = lista.get(indice);
		return t;
	}

	/* Marca um objeto na lista como selecionado */
	public void setSelectedItem(Object item) {
		selecionado = (Funcionario) item;
	}

	/* Captura o objeto selecionado da lista */
	public Object getSelectedItem() {
		return selecionado;
	}

	private void popular(long ID_ESPECIALIZACAO) {
		try {
			/* Cria o DAO */
			FuncionarioController controller = new FuncionarioController();

			/* Cria um modelo vazio */
			Funcionario t = new Funcionario();
			t.setNOME("");

			/* Recupera os registros da tabela */
			lista = controller.GetDoutores(ID_ESPECIALIZACAO);

			List<Funcionario> doutoresEspecialistas = new ArrayList<Funcionario>();
			if(ID_ESPECIALIZACAO > 0){
				for(final Funcionario funcionario : lista){
					if(funcionario.getCargo().getEspecializacao().getId() == ID_ESPECIALIZACAO){
						doutoresEspecialistas.add(funcionario);
					}
				}
				lista = doutoresEspecialistas;
			}
			/* Cria o primeiro registro da lista */
			Funcionario primeiro = new Funcionario();
			primeiro.setID_FUNCIONARIO(0);
			primeiro.setNOME("SELECIONE UM DOUTOR");

			/* Adiciona o primeiro registro a lista */
			lista.add(0, primeiro);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
