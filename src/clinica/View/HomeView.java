package clinica.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;

import com.mysql.jdbc.StringUtils;

import clinica.Controller.AgendamentoController;
import clinica.Controller.CargoController;
import clinica.Controller.ConvenioController;
import clinica.Controller.EspecializacaoController;
import clinica.Controller.FuncionarioController;
import clinica.Controller.PacienteController;
import clinica.Controller.ServicoController;
import clinica.Model.Aniversariante;
import clinica.Model.Cargo;
import clinica.Model.Convenio;
import clinica.Model.Especializacao;
import clinica.Model.Funcionario;
import clinica.Model.Paciente;
import clinica.Model.Servico;
import clinica.Model.Usuario;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class HomeView extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_home;
	private JPanel panel_agendamento;
	private JPanel panel_paciente;
	private JPanel panel_funcionarios;
	private JPanel panel_especializacao;
	private JPanel panel_cargo;
	private JPanel panel_convenio;
	private JPanel panel_servico;
	private JLabel lblAniversriantesDoMs;
	private JTable table_home;
	private JTextField textDataAgendamento;
	private JTextField txtCPFPesquisa;
	private JTable table_agendamento;
	private JTable table_cargo;
	private JTextField txtCargo;
	private JTextField txtValorSalarial;
	private JTextField txtID_CARGO;
	private JTextField txtServico;
	private JTextField txtID_SERVICO;
	private JTextField txtValorServico;
	private JTextField txtEspecializacao;
	private JTextField txtID_ESPECIALIZACAO;
	private JTable table_especializacao;
	private JTable table_servico;
	private JTextField txtConvenio;
	private JTextField txtID_CONVENIO;
	private JTable table_convenio;
	private JTextField txtDescontoConvenio;
	private JTextField txtNomeFuncionario;
	private JTextField txtID_FUNCIONARIO;
	private JTextField txtCRO;
	private JTextField txtUsername;
	private JPasswordField txtSenha;
	private JTable table_funcionario;
	private JTextField txtID_USUARIO;
	private JTextField txtNomePaciente;
	private JTextField txtID_PACIENTE;
	private JTextField txtIdade;
	private JTextField txtNomePai;
	private JTable table_paciente;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { HomeView frame = new
	 * HomeView(null); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public HomeView(List<Aniversariante> aniversariantes, boolean adm) throws ParseException {

		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1468, 736);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Deseja realmente sair?");
				System.exit(0);
			}
		});
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnArquivo.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_tabbed = new JPanel();
		panel_tabbed.setBackground(Color.WHITE);
		panel_tabbed.setBounds(0, 0, 1462, 675);
		contentPane.add(panel_tabbed);

		JPanel panelADM = new JPanel();
		panelADM.setBounds(0, 570, 1462, 105);
		panelADM.setBackground(new Color(255, 255, 255));
		panelADM.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1462, 100);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 98, 1462, 30);
		panel.setBackground(new Color(0, 191, 255));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 542, 1462, 30);
		panel_3.setBackground(new Color(0, 191, 255));
		panel_tabbed.setLayout(null);
		panel_tabbed.add(panelADM);

		panel_tabbed.add(panel_2);
		panel_tabbed.add(panel);
		panel_tabbed.add(panel_3);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 130, 1462, 413);
		panel_tabbed.add(tabbedPane);

		panel_home = new JPanel();
		panel_home.setBackground(Color.WHITE);
		tabbedPane.addTab("Home",
				new ImageIcon(
						HomeView.class.getResource("/clinica/img/dashboard_-removebg-preview-removebg-preview.png")),
				panel_home, null);
		tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setPreferredSize(new Dimension(0, 0));

		lblAniversriantesDoMs = new JLabel("Anivers\u00E1riantes do M\u00EAs");
		lblAniversriantesDoMs.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblAniversriantesDoMs.setIcon(new ImageIcon(HomeView.class.getResource("/clinica/img/festa.png")));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_home = new GroupLayout(panel_home);
		gl_panel_home
				.setHorizontalGroup(
						gl_panel_home.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_home.createSequentialGroup().addGap(362)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 728,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(367, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_panel_home.createSequentialGroup()
										.addContainerGap(536, Short.MAX_VALUE).addComponent(lblAniversriantesDoMs,
												GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
										.addGap(421)));
		gl_panel_home.setVerticalGroup(gl_panel_home.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_home
				.createSequentialGroup()
				.addComponent(lblAniversriantesDoMs, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE).addGap(4)));

		table_home = new JTable();

		table_home.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Dia" }));
		Object[] fila = new Object[2];

		for (final Aniversariante an : aniversariantes) {
			fila[0] = an.getNome();

			SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy");
			String input = "2014-12-09 02:18:38";
			Date date = sdfIn.parse(an.getDataNascimento());

			fila[1] = sdfOut.format(date);
		}

		DefaultTableModel model = (DefaultTableModel) table_home.getModel();
		model.addRow(fila);

		scrollPane.setViewportView(table_home);
		panel_home.setLayout(gl_panel_home);

		panel_agendamento = new JPanel();
		tabbedPane.addTab("Agendamento",
				new ImageIcon(HomeView.class.getResource("/clinica/img/agenda-removebg-preview.png")),
				panel_agendamento, null);
		tabbedPane.setEnabledAt(1, true);
		panel_agendamento.setLayout(null);

		JLabel lblNewLabel = new JLabel("Data Agendamento:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 35, 158, 25);
		panel_agendamento.add(lblNewLabel);

		textDataAgendamento = new JFormattedTextField(Mascara("##-##-####"));
		textDataAgendamento.setBounds(185, 37, 116, 22);
		panel_agendamento.add(textDataAgendamento);
		textDataAgendamento.setColumns(10);

		JLabel lblCpfDoPaciente = new JLabel("CPF do Paciente:");
		lblCpfDoPaciente.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblCpfDoPaciente.setBounds(313, 35, 133, 25);
		panel_agendamento.add(lblCpfDoPaciente);

		txtCPFPesquisa = new JFormattedTextField(Mascara("###.###.###-##"));
		txtCPFPesquisa.setColumns(10);
		txtCPFPesquisa.setBounds(438, 37, 116, 22);
		panel_agendamento.add(txtCPFPesquisa);

		JLabel lblDoutor = new JLabel("Doutor:");
		lblDoutor.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblDoutor.setBounds(566, 35, 58, 25);
		panel_agendamento.add(lblDoutor);

		JComboBox cboDentista = new JComboBox();
		cboDentista.setEditable(true);
		ComboModelDoutor combo = new ComboModelDoutor();
		cboDentista.setModel(combo);
		cboDentista.setBounds(623, 37, 178, 22);
		panel_agendamento.add(cboDentista);
		JScrollPane scrollPane_agendamento = new JScrollPane();
		scrollPane_agendamento.setBounds(29, 93, 823, 233);
		panel_agendamento.add(scrollPane_agendamento);
		table_agendamento = new JTable();
		scrollPane_agendamento.setViewportView(table_agendamento);
		
		JButton btnFuncionarios_1 = new JButton("");
		btnFuncionarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgendamentoController controllerAgendamento = new AgendamentoController();
				try {
					Funcionario funcionario = (Funcionario) cboDentista.getSelectedItem();
					table_agendamento = new JTable (controllerAgendamento.GetAgendamentos(textDataAgendamento.getText(), txtCPFPesquisa.getText(),
								funcionario.getId()));
					scrollPane_agendamento.setViewportView(table_agendamento);
					
					textDataAgendamento.setText("");
					txtCPFPesquisa.setText("");
					
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
		panel_agendamento.add(btnFuncionarios_1);

		

		

		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID_AGENDAMENTO = Integer
						.parseInt(table_agendamento.getValueAt(table_agendamento.getSelectedRow(), 0).toString());
				ModalAgendamento modal = new ModalAgendamento(ID_AGENDAMENTO);
				modal.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(1034, 301, 97, 25);
		panel_agendamento.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("Novo Agendamento");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModalAgendamento modal = new ModalAgendamento();
				modal.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(Color.GREEN);
		btnNewButton_4.setBounds(867, 301, 155, 25);
		panel_agendamento.add(btnNewButton_4);
		panel_paciente = new JPanel();
		tabbedPane.addTab("Pacientes", new ImageIcon(HomeView.class.getResource("/clinica/img/paciente.png")),
				panel_paciente, null);
		panel_paciente.setLayout(null);

		JScrollPane scrollPane_paciente = new JScrollPane();
		scrollPane_paciente.setBounds(28, 26, 596, 246);
		panel_paciente.add(scrollPane_paciente);

		table_paciente = new JTable();
		scrollPane_paciente.setViewportView(table_paciente);

		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setLayout(null);
		panel_1_1_2_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1_1_2_1.setBounds(706, 26, 716, 284);
		panel_paciente.add(panel_1_1_2_1);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setColumns(10);
		txtNomePaciente.setBounds(22, 35, 177, 22);
		panel_1_1_2_1.add(txtNomePaciente);

		JLabel lblNewLabel_1_3_2_1 = new JLabel("Nome");
		lblNewLabel_1_3_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1_3_2_1.setBounds(22, 13, 99, 22);
		panel_1_1_2_1.add(lblNewLabel_1_3_2_1);

		txtID_PACIENTE = new JTextField();
		txtID_PACIENTE.setEnabled(false);
		txtID_PACIENTE.setEditable(false);
		txtID_PACIENTE.setColumns(10);
		txtID_PACIENTE.setBounds(677, 35, 27, 22);
		panel_1_1_2_1.add(txtID_PACIENTE);

		JLabel lblCPFFuncionario_1 = new JLabel("CPF");
		lblCPFFuncionario_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCPFFuncionario_1.setBounds(22, 62, 33, 22);
		panel_1_1_2_1.add(lblCPFFuncionario_1);

		JLabel lblNewLabel_1_3_2_1_1_1 = new JLabel("Nome M\u00E3e");
		lblNewLabel_1_3_2_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1_3_2_1_1_1.setBounds(22, 103, 152, 22);
		panel_1_1_2_1.add(lblNewLabel_1_3_2_1_1_1);

		JComboBox cboConvenioPaciente = new JComboBox();
		cboConvenioPaciente.setModel(new ComboModelConvenio());
		cboConvenioPaciente.setEditable(true);
		cboConvenioPaciente.setBounds(222, 35, 177, 22);
		panel_1_1_2_1.add(cboConvenioPaciente);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblIdade.setBounds(22, 150, 59, 22);
		panel_1_1_2_1.add(lblIdade);

		JTextField txtNomeMae = new JTextField();
		txtNomeMae.setColumns(10);
		txtNomeMae.setBounds(22, 126, 177, 22);
		panel_1_1_2_1.add(txtNomeMae);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(22, 174, 177, 22);
		panel_1_1_2_1.add(txtIdade);

		JLabel lblConvenio = new JLabel("Conv\u00EAnio");
		lblConvenio.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblConvenio.setBounds(222, 17, 76, 16);
		panel_1_1_2_1.add(lblConvenio);

		JLabel lblNewLabel_2_1_1 = new JLabel("G\u00EAnero");
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(222, 66, 108, 16);
		panel_1_1_2_1.add(lblNewLabel_2_1_1);

		JComboBox cboGeneroPaciente = new JComboBox();
		cboGeneroPaciente.setModel(new DefaultComboBoxModel(new String[] { "Selecione\t", "Masculino", "Feminino" }));
		cboGeneroPaciente.setEditable(true);
		cboGeneroPaciente.setBounds(222, 81, 177, 22);
		panel_1_1_2_1.add(cboGeneroPaciente);

		JLabel lblNewLabel_4_1 = new JLabel("Nome Pai");
		lblNewLabel_4_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(222, 107, 76, 16);
		panel_1_1_2_1.add(lblNewLabel_4_1);

		JFormattedTextField txtCPFPaciente = new JFormattedTextField(Mascara("###.###.###-##"));
		txtCPFPaciente.setColumns(10);
		txtCPFPaciente.setBounds(22, 81, 177, 22);
		panel_1_1_2_1.add(txtCPFPaciente);

		txtNomePai = new JTextField();
		txtNomePai.setColumns(10);
		txtNomePai.setBounds(222, 126, 177, 22);
		panel_1_1_2_1.add(txtNomePai);

		JButton btnAddPaciente = new JButton("Atualizar/Adicionar");
		btnAddPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Paciente paciente = new Paciente();

				if (!StringUtils.isNullOrEmpty(txtID_PACIENTE.getText())) {
					paciente.setID_PACIENTE(Long.parseLong(txtID_PACIENTE.getText()));
				}
				String genero = cboGeneroPaciente.getSelectedItem().toString().trim();
				if (genero.equals("Masculino")) {
					genero = "M";
				} else if (genero.equals("Feminino")) {
					genero = "F";
				} else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Selecione um gênero");
					return;
				}

				Convenio convenio = (Convenio) cboConvenioPaciente.getSelectedItem();
				if (convenio.getId() > 0) {
					paciente.setConvenio(convenio);
				}

				paciente.setNOME(txtNomePaciente.getText());
				paciente.setSexo(genero);
				paciente.setNOME_MAE(txtNomeMae.getText());
				paciente.setCPF(txtCPFPaciente.getText());
				paciente.setNOME_PAI(txtNomePai.getText());
				try {
					paciente.setIDADE(Integer.parseInt(txtIdade.getText()));
				} catch (NumberFormatException ex) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Idade inválida");
				}

				PacienteController controller = new PacienteController();
				if (controller.salvar(paciente)) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					if (!StringUtils.isNullOrEmpty(txtID_PACIENTE.getText())) {
						JOptionPane.showMessageDialog(jf, "Paciente atualizado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(jf, "Paciente adicionado com sucesso!");
					}
					try {
						table_paciente = new JTable(controller.GetAll());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					scrollPane_paciente.setViewportView(table_paciente);

					txtID_PACIENTE.setText("");
					txtNomePaciente.setText("");
					txtNomePai.setText("");
					txtIdade.setText("");
					txtCPFPaciente.setText("");
					txtNomeMae.setText("");
					txtCPFPaciente.setText("");

				} else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);

					JOptionPane.showMessageDialog(jf, "Falha ao adicionar/atualizar Paciente");
				}
			}
		});
		btnAddPaciente.setBounds(442, 246, 158, 25);
		panel_1_1_2_1.add(btnAddPaciente);

		JButton btnRemoverPaciente = new JButton("Remover");
		btnRemoverPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteController controller = new PacienteController();
				if (!StringUtils.isNullOrEmpty(txtID_PACIENTE.getText())) {

					if (controller.remover(Long.parseLong(txtID_PACIENTE.getText()))) {
						try {
							table_paciente = new JTable(controller.GetAll());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						scrollPane_paciente.setViewportView(table_paciente);
						txtID_PACIENTE.setText("");
						txtNomePaciente.setText("");
						txtNomePai.setText("");
						txtCPFPaciente.setText("");
						txtNomeMae.setText("");
						txtCPFPaciente.setText("");
						cboConvenioPaciente.setModel(new ComboModelConvenio());
					}
				}
			}
		});
		btnRemoverPaciente.setBounds(607, 246, 97, 25);
		panel_1_1_2_1.add(btnRemoverPaciente);

		JButton btnLimparPaciente = new JButton("Limpar");
		btnLimparPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_PACIENTE.setText("");
				txtNomePaciente.setText("");
				txtNomePai.setText("");
				txtCPFPaciente.setText("");
				txtNomeMae.setText("");
				txtCPFPaciente.setText("");
				cboConvenioPaciente.setModel(new ComboModelConvenio());
			}
		});
		btnLimparPaciente.setBounds(333, 246, 97, 25);
		panel_1_1_2_1.add(btnLimparPaciente);

		JButton btnPesquisarPaciente = new JButton("Pesquisar");
		btnPesquisarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteController controller = new PacienteController();
				try {
					table_paciente = new JTable(controller.GetAll());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				scrollPane_paciente.setViewportView(table_paciente);
			}
		});
		btnPesquisarPaciente.setBounds(529, 285, 97, 25);
		panel_paciente.add(btnPesquisarPaciente);

		JButton btnAddProxPaciente = new JButton(">");
		btnAddProxPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_PACIENTE.setText(table_paciente.getValueAt(table_paciente.getSelectedRow(), 0).toString());
				txtNomePaciente.setText(table_paciente.getValueAt(table_paciente.getSelectedRow(), 1).toString());
				String cpf = table_paciente.getValueAt(table_paciente.getSelectedRow(), 2).toString().replace(".", "")
						.replace("-", "");
				txtCPFPaciente.setText(cpf);
				txtIdade.setText(table_paciente.getValueAt(table_paciente.getSelectedRow(), 4).toString());
				txtNomeMae.setText(table_paciente.getValueAt(table_paciente.getSelectedRow(), 5).toString());
				txtNomePai.setText(table_paciente.getValueAt(table_paciente.getSelectedRow(), 6).toString());

			}
		});
		btnAddProxPaciente.setBounds(638, 118, 41, 25);
		panel_paciente.add(btnAddProxPaciente);

		panel_funcionarios = new JPanel();
		panel_funcionarios.setToolTipText("adm");
		tabbedPane.addTab("Funcion\u00E1rios",
				new ImageIcon(HomeView.class.getResource("/clinica/img/funcionario.png")), panel_funcionarios, "adm");
		panel_funcionarios.setLayout(null);

		JScrollPane scrollPane_funcionario = new JScrollPane();
		scrollPane_funcionario.setBounds(51, 42, 596, 246);
		panel_funcionarios.add(scrollPane_funcionario);

		table_funcionario = new JTable();
		scrollPane_funcionario.setViewportView(table_funcionario);

		JButton btnPesquisarFuncionario = new JButton("Pesquisar");
		btnPesquisarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioController controller = new FuncionarioController();
				table_funcionario = new JTable(controller.GetAll());
				scrollPane_funcionario.setViewportView(table_funcionario);
			}
		});
		btnPesquisarFuncionario.setBounds(552, 301, 97, 25);
		panel_funcionarios.add(btnPesquisarFuncionario);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1_1_2.setBounds(729, 42, 716, 284);
		panel_funcionarios.add(panel_1_1_2);

		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setColumns(10);
		txtNomeFuncionario.setBounds(22, 35, 177, 22);
		panel_1_1_2.add(txtNomeFuncionario);

		JLabel lblNewLabel_1_3_2 = new JLabel("Nome");
		lblNewLabel_1_3_2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1_3_2.setBounds(22, 13, 99, 22);
		panel_1_1_2.add(lblNewLabel_1_3_2);

		JComboBox cboCargoFuncionario = new JComboBox();
		cboCargoFuncionario.setEditable(true);
		ComboModelCargo cargoModel = new ComboModelCargo();

		txtID_FUNCIONARIO = new JTextField();
		txtID_FUNCIONARIO.setEnabled(false);
		txtID_FUNCIONARIO.setEditable(false);
		txtID_FUNCIONARIO.setColumns(10);
		txtID_FUNCIONARIO.setBounds(677, 35, 27, 22);
		panel_1_1_2.add(txtID_FUNCIONARIO);

		JLabel lblCPFFuncionario = new JLabel("CPF");
		lblCPFFuncionario.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCPFFuncionario.setBounds(22, 62, 33, 22);
		panel_1_1_2.add(lblCPFFuncionario);

		JLabel lblNewLabel_1_3_2_1_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1_3_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1_3_2_1_1.setBounds(22, 103, 152, 22);
		panel_1_1_2.add(lblNewLabel_1_3_2_1_1);

		cboCargoFuncionario.setModel(cargoModel);
		cboCargoFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cargo cargo = (Cargo) cboCargoFuncionario.getSelectedItem();
				if (cargo.isFL_DENTISTA()) {
					txtCRO.setEnabled(true);
				} else {
					txtCRO.setEnabled(false);
				}
			}
		});
		cboCargoFuncionario.setBounds(22, 174, 177, 22);
		panel_1_1_2.add(cboCargoFuncionario);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCargo.setBounds(22, 150, 59, 22);
		panel_1_1_2.add(lblCargo);

		JFormattedTextField txtDataNascimento = new JFormattedTextField(Mascara("##-##-####"));
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(22, 126, 177, 22);
		panel_1_1_2.add(txtDataNascimento);

		JFormattedTextField txtCPFFuncionario = new JFormattedTextField(Mascara("###.###.###-##"));
		txtCPFFuncionario.setColumns(10);
		txtCPFFuncionario.setBounds(22, 81, 177, 22);
		panel_1_1_2.add(txtCPFFuncionario);

		txtCRO = new JTextField();
		txtCRO.setEnabled(false);
		txtCRO.setBounds(222, 35, 168, 22);
		panel_1_1_2.add(txtCRO);
		txtCRO.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CRO");
		lblNewLabel_2.setBounds(222, 17, 33, 16);
		panel_1_1_2.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("G\u00EAnero");
		lblNewLabel_2_1.setBounds(222, 66, 108, 16);
		panel_1_1_2.add(lblNewLabel_2_1);

		JComboBox cboGenero = new JComboBox();
		cboGenero.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "Masculino\t", "Feminino" }));
		cboGenero.setBounds(222, 81, 168, 22);
		panel_1_1_2.add(cboGenero);

		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setBounds(222, 107, 67, 16);
		panel_1_1_2.add(lblNewLabel_4);

		txtUsername = new JTextField();
		txtUsername.setBounds(222, 126, 168, 22);
		panel_1_1_2.add(txtUsername);
		txtUsername.setColumns(10);

		JCheckBox chkADM = new JCheckBox("Administrador ?");
		chkADM.setBounds(21, 216, 129, 25);
		panel_1_1_2.add(chkADM);

		JLabel lblNewLabel_5 = new JLabel("Senha");
		lblNewLabel_5.setBounds(222, 154, 56, 16);
		panel_1_1_2.add(lblNewLabel_5);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(222, 174, 168, 22);
		panel_1_1_2.add(txtSenha);
		tabbedPane.setDisabledIconAt(3, null);

		panel_especializacao = new JPanel();
		panel_especializacao.setToolTipText("adm");
		tabbedPane.addTab("Especializa\u00E7\u00F5es",
				new ImageIcon(HomeView.class.getResource("/clinica/img/certificado.png")), panel_especializacao, "adm");
		panel_especializacao.setLayout(null);

		panel_convenio = new JPanel();
		panel_convenio.setToolTipText("adm");
		tabbedPane.addTab("Conv\u00EAnios", new ImageIcon(HomeView.class.getResource("/clinica/img/convenio.png")),
				panel_convenio, "adm");
		panel_convenio.setLayout(null);

		panel_servico = new JPanel();
		panel_servico.setToolTipText("adm");
		tabbedPane.addTab("Servi\u00E7os", new ImageIcon(HomeView.class.getResource("/clinica/img/servicos.png")),
				panel_servico, "adm");
		panel_servico.setLayout(null);

		panel_cargo = new JPanel();
		panel_cargo.setToolTipText("adm");
		tabbedPane.addTab("Cargos", new ImageIcon(HomeView.class.getResource("/clinica/img/cargo.png")), panel_cargo,
				"adm");
		panel_cargo.setLayout(null);

		JButton btnAddFuncionario = new JButton("Atualizar/Adicionar");

		btnAddFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Funcionario funcionario = new Funcionario();
				Usuario usuario = new Usuario();

				if (!StringUtils.isNullOrEmpty(txtID_FUNCIONARIO.getText())) {
					funcionario.setID_FUNCIONARIO(Long.parseLong(txtID_FUNCIONARIO.getText()));
					usuario.setID_USUARIO(Long.parseLong(txtID_USUARIO.getText()));
				}
				Cargo cargo = (Cargo) cboCargoFuncionario.getSelectedItem();

				usuario.setUSERNAME(txtUsername.getText());
				usuario.setPASSWORD(txtSenha.getText());
				usuario.setFL_ADM(chkADM.isSelected());

				String genero = cboGenero.getSelectedItem().toString().trim();
				if (genero.equals("Masculino")) {
					genero = "M";
				} else if (genero.equals("Feminino")) {
					genero = "F";
				} else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Selecione um gênero");
					return;
				}
				funcionario.setNOME(txtNomeFuncionario.getText());
				funcionario.setSexo(genero);
				if (cargo.isFL_DENTISTA()) {
					try {
						funcionario.setCRO(Integer.parseInt(txtCRO.getText()));
					} catch (NumberFormatException ex) {
						JFrame jf = new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "CRO inválido");
						return;
					}
				}
				funcionario.setCargo(cargo);
				funcionario.setCPF(txtCPFFuncionario.getText());

				try {
					funcionario.setDT_NASCIMENTO(new SimpleDateFormat("dd-MM-yyyy").parse(txtDataNascimento.getText()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				funcionario.setUsuario(usuario);
				FuncionarioController controller = new FuncionarioController();
				if (controller.salvar(funcionario)) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					if (!StringUtils.isNullOrEmpty(txtID_FUNCIONARIO.getText())) {
						JOptionPane.showMessageDialog(jf, "Funcionário atualizado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(jf, "Funcionário adicionado com sucesso!");
					}
					table_funcionario = new JTable(controller.GetAll());
					scrollPane_funcionario.setViewportView(table_funcionario);

					txtID_USUARIO.setText("");
					txtUsername.setText("");
					txtSenha.setText("");
					txtCRO.setText("");
					chkADM.setSelected(false);
					txtID_FUNCIONARIO.setText("");
					txtNomeFuncionario.setText("");
					txtCPFFuncionario.setText("");
					txtDataNascimento.setText("");
					cboCargoFuncionario.setSelectedIndex(0);
				} else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);

					JOptionPane.showMessageDialog(jf, "Falha ao adicionar/atualizar funcionário");
				}

			}
		});
		btnAddFuncionario.setBounds(442, 246, 158, 25);
		panel_1_1_2.add(btnAddFuncionario);

		JButton btnRemoverFuncionario = new JButton("Remover");
		btnRemoverFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioController controller = new FuncionarioController();
				if (!StringUtils.isNullOrEmpty(txtID_FUNCIONARIO.getText())) {

					if (controller.remover(Long.parseLong(txtID_FUNCIONARIO.getText()))) {
						table_funcionario = new JTable(controller.GetAll());
						scrollPane_funcionario.setViewportView(table_funcionario);
						txtID_USUARIO.setText("");
						txtUsername.setText("");
						txtSenha.setText("");
						txtCRO.setText("");
						chkADM.setSelected(false);
						txtID_FUNCIONARIO.setText("");
						txtNomeFuncionario.setText("");
						txtCPFFuncionario.setText("");
						txtDataNascimento.setText("");
						cboCargoFuncionario.setSelectedIndex(0);

					}
				}
			}
		});
		btnRemoverFuncionario.setBounds(607, 246, 97, 25);
		panel_1_1_2.add(btnRemoverFuncionario);

		txtID_USUARIO = new JTextField();
		txtID_USUARIO.setVisible(false);
		txtID_USUARIO.setEnabled(false);
		txtID_USUARIO.setEditable(false);
		txtID_USUARIO.setBounds(632, 35, 27, 22);
		panel_1_1_2.add(txtID_USUARIO);
		txtID_USUARIO.setColumns(10);

		JButton btnLimparFuncionario = new JButton("Limpar");
		btnLimparFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				txtSenha.setText("");
				txtCRO.setText("");
				chkADM.setSelected(false);
				txtID_FUNCIONARIO.setText("");
				txtID_USUARIO.setText("");
				txtNomeFuncionario.setText("");
				txtCPFFuncionario.setText("");
				txtDataNascimento.setText("");
				cboCargoFuncionario.setSelectedIndex(0);
				cboCargoFuncionario.setModel(new ComboModelCargo());
			}
		});
		btnLimparFuncionario.setBounds(333, 246, 97, 25);
		panel_1_1_2.add(btnLimparFuncionario);

		JButton btnAddProxFuncionario = new JButton(">");
		btnAddProxFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtID_FUNCIONARIO
						.setText(table_funcionario.getValueAt(table_funcionario.getSelectedRow(), 0).toString());
				txtNomeFuncionario
						.setText(table_funcionario.getValueAt(table_funcionario.getSelectedRow(), 1).toString());
				String cpf = table_funcionario.getValueAt(table_funcionario.getSelectedRow(), 2).toString()
						.replace(".", "").replace("-", "");
				txtCPFFuncionario.setText(cpf);
				String datanascimento = table_funcionario.getValueAt(table_funcionario.getSelectedRow(), 3).toString();

				// SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd
				// HH:mm:ss");
				// SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy");

				// try {
				// Date date = sdfIn.parse(datanascimento);
				// datanascimento = sdfOut.format(date);
				txtDataNascimento.setText(datanascimento);
				// } catch (ParseException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
				// }

				// txtCRO.setText(table_funcionario.getValueAt(table_funcionario.getSelectedRow(),
				// 4).toString());
				txtID_USUARIO.setText(table_funcionario.getValueAt(table_funcionario.getSelectedRow(), 5).toString());
				txtUsername.setText(table_funcionario.getValueAt(table_funcionario.getSelectedRow(), 6).toString());
				if (table_funcionario.getValueAt(table_funcionario.getSelectedRow(), 7).toString() == "Sim") {
					chkADM.setSelected(true);
				} else {
					chkADM.setSelected(false);
				}
			}
		});
		btnAddProxFuncionario.setBounds(661, 134, 41, 25);
		panel_funcionarios.add(btnAddProxFuncionario);

		JButton btnAddProxEspecializacao = new JButton(">");
		btnAddProxEspecializacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_ESPECIALIZACAO
						.setText(table_especializacao.getValueAt(table_especializacao.getSelectedRow(), 0).toString());
				txtEspecializacao
						.setText(table_especializacao.getValueAt(table_especializacao.getSelectedRow(), 1).toString());
			}
		});
		btnAddProxEspecializacao.setBounds(852, 139, 41, 25);
		panel_especializacao.add(btnAddProxEspecializacao);

		JScrollPane scrollPane_espec = new JScrollPane();
		scrollPane_espec.setBounds(242, 47, 596, 225);
		panel_especializacao.add(scrollPane_espec);

		table_especializacao = new JTable();
		scrollPane_espec.setViewportView(table_especializacao);

		JButton btnPesquisarEspecializacao = new JButton("Pesquisar");
		btnPesquisarEspecializacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EspecializacaoController controller = new EspecializacaoController();
				table_especializacao = new JTable(controller.GetAll());
				scrollPane_espec.setViewportView(table_especializacao);
			}
		});
		btnPesquisarEspecializacao.setBounds(741, 281, 97, 25);
		panel_especializacao.add(btnPesquisarEspecializacao);

		JPanel panel_1_1 = new JPanel();
		// panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(906, 50, 338, 225);
		panel_especializacao.add(panel_1_1);
		panel_1_1.setLayout(null);

		txtEspecializacao = new JTextField();
		txtEspecializacao.setColumns(10);
		txtEspecializacao.setBounds(85, 85, 137, 22);
		panel_1_1.add(txtEspecializacao);

		JLabel lblNewLabel_1_3 = new JLabel("Especializa\u00E7\u00E3o");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(111, 64, 99, 22);
		panel_1_1.add(lblNewLabel_1_3);

		JButton btnA_2 = new JButton("Atualizar/Adicionar");
		btnA_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especializacao especializacao = new Especializacao();

				if (!StringUtils.isNullOrEmpty(txtID_ESPECIALIZACAO.getText())) {
					especializacao.setID_ESPECIALIZACAO(Long.parseLong(txtID_ESPECIALIZACAO.getText()));
				}
				especializacao.setESPECIALIZACAO(txtEspecializacao.getText());

				EspecializacaoController controller = new EspecializacaoController();
				if (controller.salvar(especializacao)) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					if (!StringUtils.isNullOrEmpty(txtID_ESPECIALIZACAO.getText())) {
						JOptionPane.showMessageDialog(jf, "Especializacao atualizada com sucesso!");
					} else {
						JOptionPane.showMessageDialog(jf, "Especializacao adicionada com sucesso!");
					}
					table_especializacao = new JTable(controller.GetAll());
					scrollPane_espec.setViewportView(table_especializacao);
					txtID_ESPECIALIZACAO.setText("");
					txtEspecializacao.setText("");
				} else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Falha ao adicionar/atualizar especialização");
				}
			}
		});
		btnA_2.setBounds(12, 146, 158, 25);
		panel_1_1.add(btnA_2);

		JButton btnRemover_2 = new JButton("Remover");
		btnRemover_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EspecializacaoController controller = new EspecializacaoController();
				if (!StringUtils.isNullOrEmpty(txtID_ESPECIALIZACAO.getText())) {

					if (controller.remover(Long.parseLong(txtID_ESPECIALIZACAO.getText()))) {
						table_especializacao = new JTable(controller.GetAll());
						scrollPane_espec.setViewportView(table_especializacao);
						txtID_ESPECIALIZACAO.setText("");
						txtEspecializacao.setText("");
					}
				}

			}
		});
		btnRemover_2.setBounds(125, 187, 97, 25);
		panel_1_1.add(btnRemover_2);

		txtID_ESPECIALIZACAO = new JTextField();
		txtID_ESPECIALIZACAO.setEnabled(false);
		txtID_ESPECIALIZACAO.setEditable(false);
		txtID_ESPECIALIZACAO.setVisible(false);
		txtID_ESPECIALIZACAO.setColumns(10);
		txtID_ESPECIALIZACAO.setBounds(94, 29, 116, 22);
		panel_1_1.add(txtID_ESPECIALIZACAO);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_ESPECIALIZACAO.setText("");
				txtEspecializacao.setText("");
			}
		});
		btnNewButton.setBounds(192, 146, 97, 25);
		panel_1_1.add(btnNewButton);

		JScrollPane scrollPane_convenio = new JScrollPane();
		scrollPane_convenio.setBounds(236, 41, 596, 225);
		panel_convenio.add(scrollPane_convenio);

		table_convenio = new JTable();
		scrollPane_convenio.setViewportView(table_convenio);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		// panel_1_1_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1_1_1.setBounds(900, 44, 338, 256);
		panel_convenio.add(panel_1_1_1);

		txtConvenio = new JTextField();
		txtConvenio.setColumns(10);
		txtConvenio.setBounds(105, 93, 137, 22);
		panel_1_1_1.add(txtConvenio);

		JLabel lblNewLabel_1_3_1 = new JLabel("C\u00F4nvenio");
		lblNewLabel_1_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(137, 70, 73, 22);
		panel_1_1_1.add(lblNewLabel_1_3_1);

		txtID_CONVENIO = new JTextField();
		txtID_CONVENIO.setEnabled(false);
		txtID_CONVENIO.setVisible(false);
		txtID_CONVENIO.setEditable(false);
		txtID_CONVENIO.setColumns(10);
		txtID_CONVENIO.setBounds(145, 31, 49, 22);
		panel_1_1_1.add(txtID_CONVENIO);

		txtDescontoConvenio = new JTextField();
		txtDescontoConvenio.setColumns(10);
		txtDescontoConvenio.setBounds(105, 139, 137, 22);
		panel_1_1_1.add(txtDescontoConvenio);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Desconto Servi\u00E7os");
		lblNewLabel_1_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1.setBounds(115, 117, 127, 22);
		panel_1_1_1.add(lblNewLabel_1_3_1_1);

		JScrollPane scrollPane_servico = new JScrollPane();
		scrollPane_servico.setBounds(138, 34, 596, 225);
		panel_servico.add(scrollPane_servico);

		table_servico = new JTable();
		scrollPane_servico.setViewportView(table_servico);

		JButton btnAddProxServico = new JButton(">");
		btnAddProxServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_SERVICO.setText(table_servico.getValueAt(table_servico.getSelectedRow(), 0).toString());
				txtServico.setText(table_servico.getValueAt(table_servico.getSelectedRow(), 1).toString());
				txtValorServico.setText(table_servico.getValueAt(table_servico.getSelectedRow(), 2).toString());
			}
		});
		btnAddProxServico.setBounds(740, 126, 41, 25);
		panel_servico.add(btnAddProxServico);

		JButton btnPesquisarServicos = new JButton("Pesquisar");
		btnPesquisarServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServicoController controller = new ServicoController();
				table_servico = new JTable(controller.GetAll());
				scrollPane_servico.setViewportView(table_servico);
			}
		});
		btnPesquisarServicos.setBounds(637, 272, 97, 25);
		panel_servico.add(btnPesquisarServicos);

		JComboBox cboEspecializacaoServico = new JComboBox();
		cboEspecializacaoServico.setEditable(true);
		ComboModel cbomodel = new ComboModel();
		cboEspecializacaoServico.setModel(cbomodel);
		cboEspecializacaoServico.setBounds(869, 164, 137, 22);
		panel_servico.add(cboEspecializacaoServico);

		JButton btnAtualizarServico = new JButton("Atualizar/Adicionar");
		btnAtualizarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servico servico = new Servico();

				if (!StringUtils.isNullOrEmpty(txtID_SERVICO.getText())) {
					servico.setID_SERVICO(Long.parseLong(txtID_SERVICO.getText()));
				}
				servico.setSERVICO(txtServico.getText());
				servico.setVALOR(Double.parseDouble(txtValorServico.getText()));

				Especializacao especializacao = (Especializacao) cboEspecializacaoServico.getSelectedItem();
				servico.setEspecializacao(especializacao);

				ServicoController controller = new ServicoController();
				if (controller.salvar(servico)) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					if (!StringUtils.isNullOrEmpty(txtID_SERVICO.getText())) {
						JOptionPane.showMessageDialog(jf, "Servico atualizado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(jf, "Servico adicionado com sucesso!");
					}
					table_servico = new JTable(controller.GetAll());
					scrollPane_servico.setViewportView(table_servico);
					txtID_SERVICO.setText("");
					txtValorServico.setText("");
					txtServico.setText("");
					cboEspecializacaoServico.setSelectedIndex(1);
				} else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Falha ao adicionar/atualizar serviço");
				}
				cboEspecializacaoServico.setModel(new ComboModel());
			}
		});

		btnAtualizarServico.setBounds(877, 234, 158, 25);
		panel_servico.add(btnAtualizarServico);

		JButton btnRemover_Servico = new JButton("Remover");
		btnRemover_Servico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServicoController controller = new ServicoController();
				if (!StringUtils.isNullOrEmpty(txtID_CARGO.getText())) {

					if (controller.remover(Long.parseLong(txtID_CARGO.getText()))) {
						table_servico = new JTable(controller.GetAll());
						scrollPane_servico.setViewportView(table_servico);
						txtID_SERVICO.setText("");
						txtValorServico.setText("");
						txtServico.setText("");
						cboEspecializacaoServico.setSelectedIndex(1);
					}
				}
			}
		});
		btnRemover_Servico.setBounds(1020, 272, 97, 25);
		panel_servico.add(btnRemover_Servico);

		JLabel lblValorServico = new JLabel("Valor Servi\u00E7o");
		lblValorServico.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblValorServico.setBounds(895, 95, 111, 16);
		panel_servico.add(lblValorServico);

		txtServico = new JTextField();
		txtServico.setColumns(10);
		txtServico.setBounds(869, 70, 137, 22);
		panel_servico.add(txtServico);

		JLabel lblServico = new JLabel("Servi\u00E7o");
		lblServico.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblServico.setBounds(915, 49, 52, 22);
		panel_servico.add(lblServico);

		txtID_SERVICO = new JTextField();
		txtID_SERVICO.setEnabled(false);
		txtID_SERVICO.setEditable(false);
		txtID_SERVICO.setColumns(10);
		txtID_SERVICO.setBounds(874, 14, 116, 22);
		txtID_SERVICO.hide();
		panel_servico.add(txtID_SERVICO);

		txtValorServico = new JTextField();
		txtValorServico.setColumns(10);
		txtValorServico.setBounds(869, 112, 137, 22);
		panel_servico.add(txtValorServico);

		JLabel lblEspecializacao = new JLabel("Especializa\u00E7\u00E3o");
		lblEspecializacao.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblEspecializacao.setBounds(879, 145, 97, 16);
		panel_servico.add(lblEspecializacao);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(187, 71, 596, 225);
		panel_cargo.add(scrollPane_2);

		table_cargo = new JTable();
		table_cargo.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane_2.setViewportView(table_cargo);

		JButton btnPesquisarCargos = new JButton("Pesquisar");

		btnPesquisarCargos.setBounds(686, 309, 97, 25);
		panel_cargo.add(btnPesquisarCargos);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(835, 13, 309, 313);
		// panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_cargo.add(panel_1);
		panel_1.setLayout(null);

		txtCargo = new JTextField();
		txtCargo.setBounds(85, 69, 137, 22);
		panel_1.add(txtCargo);
		txtCargo.setColumns(10);

		txtValorSalarial = new JTextField();
		txtValorSalarial.setColumns(10);
		txtValorSalarial.setBounds(85, 112, 137, 22);
		panel_1.add(txtValorSalarial);

		JLabel lblNewLabel_1 = new JLabel("Cargo");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(121, 48, 52, 22);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Valor Salarial");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(111, 94, 111, 16);
		panel_1.add(lblNewLabel_1_1);

		JButton btnA = new JButton("Atualizar/Adicionar");

		btnA.setBounds(80, 238, 158, 25);
		panel_1.add(btnA);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(200, 276, 97, 25);
		panel_1.add(btnRemover);

		txtID_CARGO = new JTextField();
		txtID_CARGO.setEditable(false);
		txtID_CARGO.setEnabled(false);
		txtID_CARGO.setBounds(12, 28, 30, 22);
		panel_1.add(txtID_CARGO);
		txtID_CARGO.setColumns(10);

		JComboBox cboEspecializacaoCargo = new JComboBox();
		cboEspecializacaoCargo.setEditable(true);
		cboEspecializacaoServico.setEditable(true);

		JButton btnLimparServico = new JButton("Limpar");
		btnLimparServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_SERVICO.setText("");
				txtServico.setText("");
				txtValorServico.setText("");
				cboEspecializacaoServico.setSelectedIndex(0);

				cboEspecializacaoServico.setModel(new ComboModel());
			}
		});
		btnLimparServico.setBounds(800, 272, 97, 25);
		panel_servico.add(btnLimparServico);
		cboEspecializacaoCargo.setModel(cbomodel);
		cboEspecializacaoCargo.setBounds(85, 156, 137, 22);
		panel_1.add(cboEspecializacaoCargo);

		JLabel lblNewLabel_3 = new JLabel("Especializa\u00E7\u00E3o");
		lblNewLabel_3.setBounds(111, 135, 89, 16);
		panel_1.add(lblNewLabel_3);

		JCheckBox chkDoutor = new JCheckBox("Doutor ?");
		chkDoutor.setBounds(106, 187, 113, 25);
		panel_1.add(chkDoutor);

		JButton btnLimparCargo = new JButton("Limpar");
		btnLimparCargo.setBounds(12, 276, 97, 25);
		panel_1.add(btnLimparCargo);
		btnLimparCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_CARGO.setText("");
				txtCargo.setText("");
				txtValorSalarial.setText("");
				cboEspecializacaoCargo.setSelectedIndex(0);

				cboEspecializacaoCargo.setModel(new ComboModel());
			}
		});

		// CONVENIO EVENTOS//
		JButton btnPesquisarConvenio = new JButton("Pesquisar");
		btnPesquisarConvenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvenioController controller = new ConvenioController();
				table_convenio = new JTable(controller.GetAll());
				scrollPane_convenio.setViewportView(table_convenio);
			}
		});
		btnPesquisarConvenio.setBounds(735, 275, 97, 25);
		panel_convenio.add(btnPesquisarConvenio);

		JButton btnAdicionaConvenio = new JButton("Atualizar/Adicionar");
		btnAdicionaConvenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Convenio Convenio = new Convenio();

				if (!StringUtils.isNullOrEmpty(txtID_CONVENIO.getText())) {
					Convenio.setID_CONVENIO(Long.parseLong(txtID_CONVENIO.getText()));
				}
				Convenio.setCONVENIO(txtConvenio.getText());
				Convenio.setDESCONTO_VALOR_SERVICO(Double.parseDouble(txtDescontoConvenio.getText()));

				ConvenioController controller = new ConvenioController();
				if (controller.salvar(Convenio)) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					if (!StringUtils.isNullOrEmpty(txtID_CONVENIO.getText())) {
						JOptionPane.showMessageDialog(jf, "Convênio atualizado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(jf, "Convênio adicionado com sucesso!");
					}
					table_convenio = new JTable(controller.GetAll());
					scrollPane_convenio.setViewportView(table_convenio);
					txtID_CONVENIO.setText("");
					txtConvenio.setText("");
					txtDescontoConvenio.setText("");
				} else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Falha ao adicionar/atualizar convênio");
				}
			}
		});
		btnAdicionaConvenio.setBounds(95, 180, 158, 25);
		panel_1_1_1.add(btnAdicionaConvenio);

		JButton btnRemoverConvenio = new JButton("Remover");
		btnRemoverConvenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvenioController controller = new ConvenioController();
				if (!StringUtils.isNullOrEmpty(txtID_CONVENIO.getText())) {

					if (controller.remover(Long.parseLong(txtID_CONVENIO.getText()))) {
						table_convenio = new JTable(controller.GetAll());
						scrollPane_convenio.setViewportView(table_convenio);
						txtID_CONVENIO.setText("");
						txtConvenio.setText("");
						txtDescontoConvenio.setText("");
					}
				}
			}
		});
		btnRemoverConvenio.setBounds(229, 218, 97, 25);
		panel_1_1_1.add(btnRemoverConvenio);

		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_CONVENIO.setText("");
				txtConvenio.setText("");
				txtDescontoConvenio.setText("");
			}
		});
		btnNewButton_1.setBounds(12, 218, 97, 25);
		panel_1_1_1.add(btnNewButton_1);

		JButton btnAddProxConvenio2 = new JButton(">");
		btnAddProxConvenio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID_CONVENIO.setText(table_convenio.getValueAt(table_convenio.getSelectedRow(), 0).toString());
				txtConvenio.setText(table_convenio.getValueAt(table_convenio.getSelectedRow(), 1).toString());
				txtDescontoConvenio.setText(table_convenio.getValueAt(table_convenio.getSelectedRow(), 2).toString());
			}
		});
		btnAddProxConvenio2.setBounds(847, 129, 41, 25);
		panel_convenio.add(btnAddProxConvenio2);

		// -----------------------------------------------------------------------------------//

		/* CARGO EVENTOS */
		JButton btnAddProxCargo = new JButton(">");

		btnAddProxCargo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				txtID_CARGO.setText(table_cargo.getValueAt(table_cargo.getSelectedRow(), 0).toString());
				txtCargo.setText(table_cargo.getValueAt(table_cargo.getSelectedRow(), 1).toString());
				txtValorSalarial.setText(table_cargo.getValueAt(table_cargo.getSelectedRow(), 2).toString());
			}
		});
		btnAddProxCargo.setBounds(789, 163, 41, 25);
		panel_cargo.add(btnAddProxCargo);

		btnA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cargo cargo = new Cargo();
				try {
					if (!StringUtils.isNullOrEmpty(txtID_CARGO.getText())) {
						cargo.setID_CARGO(Long.parseLong(txtID_CARGO.getText()));
					}

					Especializacao especializacao = (Especializacao) cboEspecializacaoCargo.getSelectedItem();
					cargo.setEspecializacao(especializacao);
					cargo.setFL_DENTISTA(chkDoutor.isSelected());
					cargo.setCARGO(txtCargo.getText());
					cargo.setVL_SALARIO(Double.parseDouble(txtValorSalarial.getText()));
				} catch (NumberFormatException ex) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Salário em formato inválido ou não informado");
					return;
				}

				CargoController controller = new CargoController();
				if (controller.salvar(cargo)) {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					if (cargo.getId() > 0) {
						JOptionPane.showMessageDialog(jf, "Cargo atualizado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(jf, "Cargo adicionado com sucesso!");
					}
					CargoController cargoController = new CargoController();
					table_cargo = new JTable(cargoController.GetAll());
					scrollPane_2.setViewportView(table_cargo);
					txtID_CARGO.setText("");
					txtCargo.setText("");
					txtValorSalarial.setText("");
				} else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Falha ao adicionar cargo");
				}
				cboEspecializacaoCargo.setModel(new ComboModel());
			}
		});

		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CargoController cargoController = new CargoController();
				if (!StringUtils.isNullOrEmpty(txtID_CARGO.getText())) {

					if (cargoController.remover(Long.parseLong(txtID_CARGO.getText()))) {
						table_cargo = new JTable(cargoController.GetAll());
						scrollPane_2.setViewportView(table_cargo);
						txtID_CARGO.setText("");
						txtCargo.setText("");
						txtValorSalarial.setText("");
					}
				}

			}
		});
		btnPesquisarCargos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CargoController cargoController = new CargoController();
				table_cargo = new JTable(cargoController.GetAll());

				scrollPane_2.setViewportView(table_cargo);
			}
		});
		/* FIM CARGO EVENTOS */

		// REMOVE TABS NÃO ADM
		if (!adm) {
			RemoveTabs();
		}
	}

	public void RemoveTabs() {
		int count = tabbedPane.getTabCount();
		int telas = 0;		
		for (int i = 0; i < count; i++) {
			if(telas == 5){
				break;
			}
			String tipo = tabbedPane.getToolTipTextAt(i);
			if (tipo != null)
				if (tipo.equals("adm")) {
					tabbedPane.remove(i);
					i = i-1;
					telas++;					
				}
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
