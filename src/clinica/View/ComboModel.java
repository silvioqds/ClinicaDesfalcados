package clinica.View;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import clinica.Controller.EspecializacaoController;
import clinica.Model.Especializacao;

public class ComboModel extends AbstractListModel<Especializacao> implements ComboBoxModel<Especializacao> {

	   private List<Especializacao> lista;

	    /* Seleciona um objeto na caixa de seleção */
	    private Especializacao selecionado;

	    /* Método construtor */
	    public ComboModel() {
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
	    public Especializacao getElementAt(int indice) {
	        Especializacao t = lista.get(indice);
	        return t;
	    }

	    /* Marca um objeto na lista como selecionado */
	    public void setSelectedItem(Object item) {
	        selecionado = (Especializacao) item;
	    }

	    /* Captura o objeto selecionado da lista */
	    public Object getSelectedItem() {
	        return selecionado;
	    }

	    private void popular() {
	        try {
	            /* Cria o DAO */
	            EspecializacaoController controller = new EspecializacaoController();

	            /* Cria um modelo vazio */
	            Especializacao t = new Especializacao();
	            t.setESPECIALIZACAO("");

	            /* Recupera os registros da tabela */
	            lista = controller.GetAllObjects();

	            /* Cria o primeiro registro da lista */
	            Especializacao primeiro = new Especializacao();
	            primeiro.setID_ESPECIALIZACAO(0);
	            primeiro.setESPECIALIZACAO("SELECIONE UMA ESPECIALIZAÇÃO  ");

	            /* Adiciona o primeiro registro a lista */
	            lista.add(0, primeiro);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	    }
	    
	   
	}