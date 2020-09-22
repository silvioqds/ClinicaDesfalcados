package clinica.View;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import clinica.Controller.ServicoController;
import clinica.Model.Servico;

public class ComboModelServico extends AbstractListModel<Servico> implements ComboBoxModel<Servico> {

	private List<Servico> lista;

	/* Seleciona um objeto na caixa de seleção */
	private Servico selecionado;

	/* Método construtor */
	public ComboModelServico() {
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
	public Servico getElementAt(int indice) {
		Servico t = lista.get(indice);
		return t;
	}

	/* Marca um objeto na lista como selecionado */
	public void setSelectedItem(Object item) {
		selecionado = (Servico) item;
	}

	/* Captura o objeto selecionado da lista */
	public Object getSelectedItem() {
		return selecionado;
	}

	private void popular() {
		try {
			/* Cria o DAO */
			ServicoController controller = new ServicoController();

			/* Cria um modelo vazio */
			Servico t = new Servico();
			t.setSERVICO("");

			/* Recupera os registros da tabela */
			lista = controller.GetAllObjects();

			/* Cria o primeiro registro da lista */
			Servico primeiro = new Servico();
			primeiro.setID_SERVICO(0);
			primeiro.setSERVICO("SELECIONE UM SERVIÇO");

			/* Adiciona o primeiro registro a lista */
			lista.add(0, primeiro);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
