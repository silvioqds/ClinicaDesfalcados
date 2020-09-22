package clinica.View;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import clinica.Controller.CargoController;
import clinica.Model.Cargo;

public class ComboModelCargo extends AbstractListModel<Cargo> implements ComboBoxModel<Cargo> {

	private List<Cargo> lista;

	/* Seleciona um objeto na caixa de seleção */
	private Cargo selecionado;

	/* Método construtor */
	public ComboModelCargo() {
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
	public Cargo getElementAt(int indice) {
		Cargo t = lista.get(indice);
		return t;
	}

	/* Marca um objeto na lista como selecionado */
	public void setSelectedItem(Object item) {
		selecionado = (Cargo) item;
	}

	/* Captura o objeto selecionado da lista */
	public Object getSelectedItem() {
		return selecionado;
	}

	private void popular() {
		try {
			/* Cria o DAO */
			CargoController controller = new CargoController();

			/* Cria um modelo vazio */
			Cargo t = new Cargo();
			t.setCARGO("");

			/* Recupera os registros da tabela */
			lista = controller.GetAllObjects();

			/* Cria o primeiro registro da lista */
			Cargo primeiro = new Cargo();
			primeiro.setID_CARGO(0);
			primeiro.setCARGO("SELECIONE UM CARGO");

			/* Adiciona o primeiro registro a lista */
			lista.add(0, primeiro);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
