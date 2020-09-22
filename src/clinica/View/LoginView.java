package clinica.View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.Controller.LoginController;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

import javax.swing.JLabel;
import keeptoo.KButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private static LoginView frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginView();
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
	public LoginView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1184, 716);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsuario = new JTextField("Usuário");
		txtUsuario.setToolTipText("");
		txtUsuario.setFont(new Font("Century Gothic", Font.BOLD, 18));
		txtUsuario.setBounds(704, 218, 248, 48);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtUsuario.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsuario.getText().equals("Usuário")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsuario.getText().isEmpty()) {
					txtUsuario.setForeground(Color.GRAY);
					txtUsuario.setText("Usuário");
				}
			}
		});

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Century Gothic", Font.BOLD, 18));
		txtSenha.setBounds(704, 321, 248, 48);
		contentPane.add(txtSenha);

		JLabel lblNewLabel = new JLabel("Desfalcados Software");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblNewLabel.setBounds(458, 632, 303, 24);
		contentPane.add(lblNewLabel);

		KButton btnEntrar = new KButton();
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginController controller = new LoginController();
				try {
					boolean autenticado = controller.Authenticated(txtUsuario.getText(), txtSenha.getText());
					if (autenticado) {
						dispose();
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		btnEntrar.setkHoverEndColor(new Color(0, 0, 0));
		btnEntrar.kHoverEndColor = new Color(0, 0, 0);
		btnEntrar.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnEntrar.setText("Entrar");
		btnEntrar.kEndColor = new Color(65, 105, 225);
		btnEntrar.setkEndColor(new Color(0, 191, 255));
		btnEntrar.setBounds(732, 405, 185, 45);
		contentPane.add(btnEntrar);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/clinica/img/logo.png")));
		lblNewLabel_1.setBounds(90, 36, 518, 487);
		contentPane.add(lblNewLabel_1);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblLogin.setForeground(new Color(30, 144, 255));
		lblLogin.setBounds(781, 157, 90, 48);
		contentPane.add(lblLogin);

	}
}
