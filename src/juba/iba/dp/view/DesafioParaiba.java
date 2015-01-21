package juba.iba.dp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import juba.iba.dp.model.Admin;

public class DesafioParaiba {

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField pwdSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesafioParaiba window = new DesafioParaiba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DesafioParaiba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 671, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(342, 53, 242, 80);
		panel.add(panel_1);
		panel_1.setBorder(null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 0;
		panel_1.add(lblLogin, gbc_lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtLogin = new GridBagConstraints();
		gbc_txtLogin.insets = new Insets(0, 0, 5, 0);
		gbc_txtLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLogin.gridx = 1;
		gbc_txtLogin.gridy = 0;
		panel_1.add(txtLogin, gbc_txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 1;
		panel_1.add(lblSenha, gbc_lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_pwdSenha = new GridBagConstraints();
		gbc_pwdSenha.insets = new Insets(0, 0, 5, 0);
		gbc_pwdSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdSenha.gridx = 1;
		gbc_pwdSenha.gridy = 1;
		panel_1.add(pwdSenha, gbc_pwdSenha);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtLogin.setText("");
				pwdSenha.setText("");
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(0, 0, 94, 23);
		panel_3.add(btnCancelar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pwdSenha.selectAll();
				if (txtLogin.getText().equals("admin") && pwdSenha.getSelectedText().equals("admin")) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JanelaLogado frame = new JanelaLogado();
								frame.setVisible(true);
								frame.setResponsavel(new Admin("Desafio Paraíba Pocinhos 2015", "admin", "admin"));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					frame.setVisible(false);					
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEntrar.setBounds(0, 0, 94, 23);
		panel_4.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DesafioParaiba.class.getResource("/icons/dp.jpg")));
		lblNewLabel.setBounds(10, 11, 634, 384);
		panel.add(lblNewLabel);
	}
}
