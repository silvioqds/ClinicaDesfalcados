package clinica;

import Controllers.DentistaController;
import clinica.Model.Dentista;

public class Program {

	public static void main(String[] args) {
		
		Dentista dentista = new Dentista();
		
		dentista.setCRO(123456);
		
		DentistaController con = new DentistaController();
		
		//con.salvar(dentista);

	}

}
