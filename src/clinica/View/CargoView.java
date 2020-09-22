package clinica.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.Controller.CargoController;
import clinica.Model.Cargo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import keeptoo.KButton;
import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class CargoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCargo;
	private JTextField txtSalario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargoView frame = new CargoView();
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
	public CargoView() {
		setAlwaysOnTop(true);
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtCargo = new JTextField();
		txtCargo.setBounds(195, 147, 180, 22);
		contentPane.add(txtCargo);
		txtCargo.setColumns(10);

		txtSalario = new JTextField();
		txtSalario.setBounds(195, 216, 180, 22);
		contentPane.add(txtSalario);
		txtSalario.setColumns(10);

		JLabel lblCargo = new JLabel("Valor Salarial");
		lblCargo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCargo.setBounds(228, 198, 100, 16);
		contentPane.add(lblCargo);

		JLabel lblNewLabel = new JLabel("Cadastro de Cargo");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(195, 41, 198, 32);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setBounds(116, 85, 353, 258);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargoController controller = new CargoController();
				Cargo cargo = new Cargo();
				try {
					cargo.setCARGO(txtCargo.getText());
					cargo.setVL_SALARIO(Double.parseDouble(txtSalario.getText()));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valor de salário informado inválido");
					return;
				}

				if (controller.salvar(cargo)) {
					JOptionPane.showMessageDialog(null, "Cargo adicionado com sucesso!");
					txtCargo.setText("");
					txtSalario.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Falha ao adicionar cargo");
				}
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnNewButton.setBounds(108, 184, 130, 25);
		panel.add(btnNewButton);

		JLabel lblCargo_1 = new JLabel("CARGO");
		lblCargo_1.setBounds(134, 43, 63, 16);
		panel.add(lblCargo_1);
		lblCargo_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
	}
}
