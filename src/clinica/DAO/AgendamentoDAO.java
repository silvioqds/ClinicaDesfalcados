package clinica.DAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import clinica.ConnectionFactory;
import clinica.Model.Agendamento;

public class AgendamentoDAO {

	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public List<Agendamento> GetAgendamentos(String data, String cpf, long DentistaID) {

		List<Agendamento> agendamentos = new ArrayList<Agendamento>();
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String outDate = new Date().toString();
		
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			Date dataAgendamento = (Date)formatter.parse(data);
		
			agendamentos = manager
					.createQuery(
							"SELECT x FROM Agendamento x  WHERE (date_format(x.DT_HORA_ATENDIMENTO,'%d%-%m-%Y') = :data) OR(x.paciente.CPF = :cpf AND x.funcionario.ID_FUNCIONARIO = :dentistaID))")
					.setParameter("data", data).setParameter("cpf", cpf).setParameter("dentistaID", DentistaID)
					.getResultList();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		

		return agendamentos;
	}

}
