package juba.iba.dp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import juba.iba.dp.model.Pessoa;
import juba.iba.dp.model.util.Licoes;

public class VisualizarPessoa extends JDialog {
	private static final long serialVersionUID = 5851901140281579633L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public VisualizarPessoa(Pessoa pessoa) {
		setResizable(false);
		setBounds(100, 100, 435, 402);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBounds(10, 11, 410, 100);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 20, 46, 14);
		panel.add(lblNome);
		
		JLabel nome = new JLabel(pessoa.getNome());
		nome.setBounds(66, 14, 336, 23);
		panel.add(nome);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 47, 46, 14);
		panel.add(lblBairro);
		
		JLabel bairro = new JLabel(pessoa.getBairro());
		bairro.setBounds(66, 47, 145, 14);
		panel.add(bairro);
		
		JLabel lblFaixaEtria = new JLabel("Faixa Et\u00E1ria:");
		lblFaixaEtria.setBounds(215, 47, 73, 14);
		panel.add(lblFaixaEtria);
		
		JLabel faixaEtaria = new JLabel(pessoa.getFaixaEtaria().getName());
		faixaEtaria.setFont(new Font("Tahoma", Font.BOLD, 12));
		faixaEtaria.setBounds(294, 47, 108, 14);
		panel.add(faixaEtaria);
		
		JLabel lblDupla = new JLabel("Dupla:");
		lblDupla.setBounds(10, 72, 46, 14);
		panel.add(lblDupla);
		
		JLabel dupla = new JLabel(pessoa.getDiscipuladoresString());
		dupla.setBounds(66, 72, 336, 14);
		panel.add(dupla);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 122, 410, 196);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLies = new JLabel("Li\u00E7\u00F5es:");
		lblLies.setBounds(10, 11, 53, 14);
		panel_1.add(lblLies);
		
		Licoes licoes = pessoa.getLicoes();
		
		JCheckBox ch1 = new JCheckBox("1");
		ch1.setSelected(licoes.isUm());
		ch1.setEnabled(false);
		ch1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ch1.setBounds(10, 32, 70, 23);
		panel_1.add(ch1);
		
		JCheckBox ch2 = new JCheckBox("2");
		ch2.setSelected(licoes.isDois());
		ch2.setEnabled(false);
		ch2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ch2.setBounds(10, 59, 70, 23);
		panel_1.add(ch2);
		
		JCheckBox ch3 = new JCheckBox("3");
		ch3.setSelected(licoes.isTres());
		ch3.setEnabled(false);
		ch3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ch3.setBounds(84, 32, 70, 23);
		panel_1.add(ch3);
		
		JCheckBox ch4 = new JCheckBox("4");
		ch4.setSelected(licoes.isQuatro());
		ch4.setEnabled(false);
		ch4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ch4.setBounds(84, 59, 70, 23);
		panel_1.add(ch4);
		
		JCheckBox ch5 = new JCheckBox("5");
		ch5.setSelected(licoes.isCinco());
		ch5.setEnabled(false);
		ch5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ch5.setBounds(158, 32, 70, 23);
		panel_1.add(ch5);
		
		JCheckBox ch6 = new JCheckBox("6");
		ch6.setSelected(licoes.isSeis());
		ch6.setEnabled(false);
		ch6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ch6.setBounds(158, 59, 70, 23);
		panel_1.add(ch6);
		
		JCheckBox ch7 = new JCheckBox("7");
		ch7.setSelected(licoes.isSete());
		ch7.setEnabled(false);
		ch7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ch7.setBounds(232, 32, 70, 23);
		panel_1.add(ch7);
		
		JLabel lblDiaParaEstudo = new JLabel("Dia Para Estudo:");
		lblDiaParaEstudo.setBounds(10, 119, 100, 14);
		panel_1.add(lblDiaParaEstudo);
		
		JLabel diaEstudo = new JLabel(pessoa.getDiaParaEstudo());
		diaEstudo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		diaEstudo.setBounds(114, 114, 286, 20);
		panel_1.add(diaEstudo);
		
		JLabel lblObs = new JLabel("OBS:");
		lblObs.setBounds(10, 144, 36, 14);
		panel_1.add(lblObs);
		
		JTextPane obs = new JTextPane();
		obs.setText(pessoa.getObservacoes());
		obs.setEditable(false);
		obs.setDropMode(DropMode.INSERT);
		obs.setBounds(47, 144, 353, 41);
		panel_1.add(obs);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 318, 409, 44);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(310, 11, 89, 23);
		panel_2.add(btnOk);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
