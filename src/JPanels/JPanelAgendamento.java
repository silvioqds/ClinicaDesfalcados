package JPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import clinica.Controller.AgendamentoController;
import clinica.View.HomeView;

public class JPanelAgendamento extends JPanel {

	private JTextField textDataAgendamento;
	private JTextField txtCpf;
	private JTable table_1;
	private static final long serialVersionUID = 1L;

	public JPanelAgendamento() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Data Agendamento:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 35, 158, 25);
		add(lblNewLabel);

		textDataAgendamento = new JFormattedTextField(Mascara("##-##-####"));
		textDataAgendamento.setBounds(185, 37, 116, 22);
		add(textDataAgendamento);
		textDataAgendamento.setColumns(10);

		JLabel lblCpfDoPaciente = new JLabel("CPF do Paciente:");
		lblCpfDoPaciente.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblCpfDoPaciente.setBounds(313, 35, 133, 25);
		add(lblCpfDoPaciente);

		txtCpf = new JFormattedTextField(Mascara("###.###.###-##"));
		txtCpf.setColumns(10);
		txtCpf.setBounds(438, 37, 116, 22);
		add(txtCpf);

		JLabel lblDoutor = new JLabel("Doutor:");
		lblDoutor.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblDoutor.setBounds(566, 35, 58, 25);
		add(lblDoutor);

		JComboBox cboDentista = new JComboBox();
		cboDentista.setBounds(623, 37, 178, 22);
		add(cboDentista);

		JButton btnFuncionarios_1 = new JButton("");
		btnFuncionarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgendamentoController controllerAgendamento = new AgendamentoController();
				try {
					controllerAgendamento.GetAgendamentos(textDataAgendamento.getText(), txtCpf.getText(), 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnFuncionarios_1.setIcon(new ImageIcon(HomeView.class.getResource("/clinica/img/lupa (2).png")));
		btnFuncionarios_1.setForeground(Color.LIGHT_GRAY);
		btnFuncionarios_1.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnFuncionarios_1.setFocusPainted(false);
		btnFuncionarios_1.setBorderPainted(false);
		btnFuncionarios_1.setBackground(Color.WHITE);
		btnFuncionarios_1.setBounds(813, 32, 39, 38);
		add(btnFuncionarios_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 93, 823, 277);
		add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}

	private MaskFormatter Mascara(String Mascara) {

		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask(Mascara); // Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); // Caracter para
													// preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}

}
