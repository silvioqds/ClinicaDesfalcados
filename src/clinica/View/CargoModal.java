package clinica.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.Controller.CargoController;
import clinica.Model.Cargo;

import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargoModal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCargo;
	private JTextField txtSalario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CargoModal dialog = new CargoModal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CargoModal() {
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 640, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			panel.setBounds(133, 59, 353, 169);
			contentPanel.add(panel);
			{
				JLabel lblCargo_1 = new JLabel("CARGO");
				lblCargo_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
				lblCargo_1.setBounds(135, 45, 63, 16);
				panel.add(lblCargo_1);
			}
			{
				txtCargo = new JTextField();
				txtCargo.setBounds(76, 64, 180, 22);
				panel.add(txtCargo);
				txtCargo.setColumns(10);
			}
			{
				txtSalario = new JTextField();
				txtSalario.setBounds(76, 116, 180, 22);
				panel.add(txtSalario);
				txtSalario.setColumns(10);
			}
			{
				JLabel lblCargo_1 = new JLabel("Valor Salarial");
				lblCargo_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
				lblCargo_1.setBounds(122, 99, 102, 16);
				panel.add(lblCargo_1);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Cadastro de Cargo");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
			lblNewLabel.setBounds(213, 26, 198, 32);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Adicionar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CargoController controller = new CargoController();
						Cargo cargo = new Cargo();
						try {
							cargo.setCARGO(txtCargo.getText());
							cargo.setVL_SALARIO(Double.parseDouble(txtSalario.getText()));
						} catch (NumberFormatException ex) {
							JFrame jf = new JFrame();
							jf.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(jf, "Salário em formato inválido ou não informado");	
							return;
						}

						if (controller.salvar(cargo)) {
							JFrame jf = new JFrame();
							jf.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(jf, "Cargo adicionado com sucesso!");													
							txtCargo.setText("");
							txtSalario.setText("");
						} else {
							JFrame jf = new JFrame();
							jf.setAlwaysOnTop(true);							
							JOptionPane.showMessageDialog(jf, "Falha ao adicionar cargo");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
