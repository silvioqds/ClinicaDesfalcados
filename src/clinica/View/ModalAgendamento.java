package clinica.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.mysql.jdbc.StringUtils;

import clinica.Controller.AgendamentoController;
import clinica.Controller.PacienteController;
import clinica.Model.Agendamento;
import clinica.Model.Convenio;
import clinica.Model.Funcionario;
import clinica.Model.Paciente;
import clinica.Model.Servico;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class ModalAgendamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDataHoraAgendamento;
	private JTextField txtMotivoCancelamento;
	private JPanel panel_cancelamento;
	private JComboBox cboServico;
	private JComboBox cboDoutor;
	private JFormattedTextField txtCPF;
	private JTextArea txtOrcamento;
	private JCheckBox chkCancelar;

	private Paciente paciente;
	private Agendamento agendamento;
	private long ID_AGENDAMENTO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModalAgendamento dialog = new ModalAgendamento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModalAgendamento(int... ID) {
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setBounds(100, 100, 565, 626);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		cboServico = new JComboBox();
		cboServico.setEnabled(false);
		cboServico.setEditable(true);
		cboServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servico servico = (Servico) cboServico.getSelectedItem();
				long id = servico.getEspecializacao().getId();
				cboDoutor.setModel(new ComboModelDoutor(id));
			}
		});
		cboServico.setModel(new ComboModelServico());
		cboServico.setBounds(22, 134, 178, 22);
		contentPanel.add(cboServico);

		cboDoutor = new JComboBox();
		cboDoutor.setEnabled(false);
		cboDoutor.setEditable(true);
		cboDoutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Servico servico = (Servico) cboServico.getSelectedItem();
				Funcionario funcionario = (Funcionario) cboDoutor.getSelectedItem();
				if (servico.getId() == 0) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Selecione um serviço");
					return;
				}

				agendamento = new Agendamento();
				agendamento.setVL_ATENDIMENTO(servico.getVALOR());
				txtOrcamento.setText("Orçamento:" + "\n Valor Serviço: " + servico.getVALOR() + "\n Valor Final"
						+ agendamento.getVL_ATENDIMENTO());
				if (paciente.getConvenio() != null) {
					agendamento
							.setVL_ATENDIMENTO(servico.getVALOR() - paciente.getConvenio().getDESCONTO_VALOR_SERVICO());
					txtOrcamento.setText("");
					txtOrcamento.setText("Orçamento:" + "\n Desconto convênio " + paciente.getConvenio().getCONVENIO()
							+ " = " + paciente.getConvenio().getDESCONTO_VALOR_SERVICO() + "" + "\n Valor Serviço = "
							+ servico.getVALOR() + "\n Valor Final = " + agendamento.getVL_ATENDIMENTO());
				}
				agendamento.setServico(servico);
				agendamento.setPaciente(paciente);
				agendamento.setFuncionario(funcionario);

			}
		});
		cboDoutor.setBounds(22, 187, 178, 22);
		contentPanel.add(cboDoutor);

		
		
		txtDataHoraAgendamento = new JFormattedTextField(Mascara("##-##-#### ##:##"));
		txtDataHoraAgendamento.setBounds(294, 56, 152, 22);
		contentPanel.add(txtDataHoraAgendamento);
		txtDataHoraAgendamento.setColumns(10);

		txtCPF = new JFormattedTextField(Mascara("###.###.###-##"));
		txtCPF.setBounds(22, 56, 167, 22);
		contentPanel.add(txtCPF);

		JLabel lblNewLabel = new JLabel("CPF Paciente");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setBounds(22, 39, 95, 16);
		contentPanel.add(lblNewLabel);

		JLabel lblDataAgendamento = new JLabel("Data Agendamento");
		lblDataAgendamento.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblDataAgendamento.setBounds(294, 39, 137, 16);
		contentPanel.add(lblDataAgendamento);

		JLabel lblNewLabel_2 = new JLabel("Servi\u00E7o");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(22, 116, 88, 16);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Doutor");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(22, 169, 53, 16);
		contentPanel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Valor do or\u00E7amento:");
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(22, 253, 196, 16);
		contentPanel.add(lblNewLabel_2_2);

		txtOrcamento = new JTextArea();
		txtOrcamento.setEnabled(false);
		txtOrcamento.setEditable(false);
		txtOrcamento.setBounds(22, 282, 289, 138);
		contentPanel.add(txtOrcamento);

		panel_cancelamento = new JPanel();
		panel_cancelamento.setVisible(false);
		panel_cancelamento.setBounds(12, 435, 489, 104);
		contentPanel.add(panel_cancelamento);
		panel_cancelamento.setLayout(null);

		chkCancelar = new JCheckBox("Cancelar Agendamento ?");
		chkCancelar.setBounds(8, 9, 171, 25);
		panel_cancelamento.add(chkCancelar);

		JLabel lblMotivoCancelamento = new JLabel("Motivo cancelamento:");
		lblMotivoCancelamento.setBounds(8, 43, 149, 17);
		panel_cancelamento.add(lblMotivoCancelamento);
		lblMotivoCancelamento.setFont(new Font("Century Gothic", Font.PLAIN, 13));

		txtMotivoCancelamento = new JTextField();
		txtMotivoCancelamento.setBounds(158, 43, 319, 22);
		panel_cancelamento.add(txtMotivoCancelamento);
		txtMotivoCancelamento.setColumns(10);

		JButton btnPesquisarPaciente = new JButton("");
		btnPesquisarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteController controller = new PacienteController();
				
				paciente = controller.GetByCPF(txtCPF.getText());
				if(paciente == null){
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Paciente não localizado, cadastre ou verifique o cpf digitado!");
					return;
				}
				
				cboServico.setEnabled(true);
				cboDoutor.setEnabled(true);
				
			}
		});
		btnPesquisarPaciente.setIcon(new ImageIcon(ModalAgendamento.class.getResource("/clinica/img/lupa (2).png")));
		btnPesquisarPaciente.setBounds(196, 51, 38, 37);
		contentPanel.add(btnPesquisarPaciente);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						

						if (ID_AGENDAMENTO > 0) {
							agendamento.setID_AGENDAMENTO(ID_AGENDAMENTO);
						}

						JFrame jf = new JFrame();
						jf.setAlwaysOnTop(true);
						if (StringUtils.isNullOrEmpty(txtDataHoraAgendamento.getText())) {
							JOptionPane.showMessageDialog(jf, "Data de agendamento obrigatorio");
							return;
						}

						try {
							agendamento.setDT_HORA_ATENDIMENTO(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(txtDataHoraAgendamento.getText()));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						agendamento.setFL_CANCELADO(chkCancelar.isSelected());
					
						if (chkCancelar.isSelected()) {
							agendamento.setMOTIVO_CANCELAMENTO(txtMotivoCancelamento.getText());
							if (StringUtils.isNullOrEmpty(txtMotivoCancelamento.getText())) {
								JOptionPane.showMessageDialog(jf, "Selecione o motivo do cancelamento!");
								return;
							}							
						}

						AgendamentoController controller = new AgendamentoController();
						if (controller.salvar(agendamento)) {							
							if (ID_AGENDAMENTO > 0) {
								JOptionPane.showMessageDialog(jf, "Agendamento atualizado com sucesso!");
							} else {
								JOptionPane.showMessageDialog(jf, "Agendamento adicionado com sucesso!");
							}
						} else {						
							JOptionPane.showMessageDialog(jf, "Falha ao adicionar/atualizar agendamento");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		VerificaAlteracao(ID);
	}

	public void VerificaAlteracao(int... ID) {

		if (ID.length > 0) {
			ID_AGENDAMENTO = ID[0];

			AgendamentoController controller = new AgendamentoController();
			Agendamento agendamento = controller.GetAgendamento(ID_AGENDAMENTO);

			txtCPF.setText(agendamento.getPaciente().getCPF());
			txtDataHoraAgendamento.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(agendamento.getDT_HORA_ATENDIMENTO()).toString());

			panel_cancelamento.setVisible(true);
		} else {
			ID_AGENDAMENTO = 0;
		}

	}

	public MaskFormatter Mascara(String Mascara) {

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
