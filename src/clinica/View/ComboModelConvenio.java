package clinica.View;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import clinica.Controller.ConvenioController;
import clinica.Model.Convenio;

public class ComboModelConvenio extends AbstractListModel<Convenio> implements ComboBoxModel<Convenio> {

	private List<Convenio> lista;

	/* Seleciona um objeto na caixa de seleção */
	private Convenio selecionado;

	/* Método construtor */
	public ComboModelConvenio() {
		/* Popula a lista */
		popular();

		/* Define o objeto selecionado */
		setSelectedItem(lista.get(0));
	}

	/* Captura o tamanho da listagem */
	public int getSize() {
		int totalElementos = lista.size();
		return totalElementos;
	}

	/* Captura um elemento da lista em uma posição informada */
	public Convenio getElementAt(int indice) {
		Convenio t = lista.get(indice);
		return t;
	}

	/* Marca um objeto na lista como selecionado */
	public void setSelectedItem(Object item) {
		selecionado = (Convenio) item;
	}

	/* Captura o objeto selecionado da lista */
	public Object getSelectedItem() {
		return selecionado;
	}

	private void popular() {
		try {
			/* Cria o DAO */
			ConvenioController controller = new ConvenioController();

			/* Cria um modelo vazio */
			Convenio t = new Convenio();
			t.setCONVENIO("");

			/* Recupera os registros da tabela */
			lista = controller.GetAllObjects();

			/* Cria o primeiro registro da lista */
			Convenio primeiro = new Convenio();
			primeiro.setID_CONVENIO(0);
			primeiro.setCONVENIO("SELECIONE UM CONVÊNIO");

			/* Adiciona o primeiro registro a lista */
			lista.add(0, primeiro);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
