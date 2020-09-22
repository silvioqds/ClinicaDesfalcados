package clinica.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class FuncionarioView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView frame = new FuncionarioView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FuncionarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 524);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Arquivo");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogou = new JMenuItem("Logout");
		mntmLogou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Deseja realmente sair?");
				System.exit(0);
			}
		});
		mntmLogou.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mntmLogou);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(122, 79, 289, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNome.setBounds(124, 63, 56, 16);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(122, 128, 289, 22);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 176, 289, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 226, 289, 22);
		contentPane.add(textField_2);
		
		JLabel lblNomePai = new JLabel("Nome do Pai");
		lblNomePai.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNomePai.setBounds(122, 112, 101, 16);
		contentPane.add(lblNomePai);
		
		JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e");
		lblNomeDaMe.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNomeDaMe.setBounds(122, 160, 121, 16);
		contentPane.add(lblNomeDaMe);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(122, 211, 191, 16);
		contentPane.add(lblDataDeNascimento);
	}
}
