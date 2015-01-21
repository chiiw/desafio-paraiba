package juba.iba.dp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import juba.iba.dp.model.Admin;
import juba.iba.dp.model.Pessoa;
import juba.iba.dp.model.db.DBService;
import juba.iba.dp.model.util.Evento;
import juba.iba.dp.model.util.FaixaEtaria;
import juba.iba.dp.model.util.Licoes;
import juba.iba.dp.view.util.FiltroDePessoas;
import juba.iba.dp.view.util.ListaDePessoas;

public class JanelaLogado extends JFrame {

	private static final long serialVersionUID = 6885581399536773869L;
	
	private Admin responsavel;
	private boolean editando = false;
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtNum;
	private JTextField txtBairro;
	private JTextField txtPontoReferencia;
	private JTextField txtEmail;
	private JTextField txtTelefone1;
	private JTextField txtTelefone2;
	private JTextField txtIgreja;
	private JTextField txtFilhos;
	private JTextField txtDiaEstudo;
	private JTextField txtDataOracao;
	private JTextField txtDupla;
	private JRadioButton rdbtnEvNao;
	private JRadioButton rdbtnBibNao;
	private JRadioButton rdbtnOracaoNao;
	private JCheckBox chckbxCulto;
	private JCheckBox chckbxFilme;
	private JCheckBox chckbxEspetculo;
	private JCheckBox chckbxTeatroDeRua;
	private JCheckBox chckbxCultoNaFeira;
	private JCheckBox chckbxInfantil;
	private JCheckBox chckbxAtendimentoSocial;
	private JLabel lblFrequentaAlgumaIgreja;
	private JCheckBox chckbxIgrejaSim;
	private JCheckBox checkBoxInfantilSim;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private JCheckBox checkBox_5;
	private JCheckBox checkBox_6;
	private JCheckBox checkBox_7;
	private JTextPane txtPedidosOracao;
	private JTextPane txtObservacoes;
	private JLabel lblMensagem;

	private JComboBox<FaixaEtaria> comboBoxFaixaEtaria;
	private JPanel tabListar;
	private JList<Pessoa> listaCadastros;

	private JButton btnLimpar;

	private JPanel tabNovo;

	private JButton btnEditarCadastro;

	private JButton btnExcluirCadastro;

	private JTabbedPane tabbedPane;

	private JRadioButton rdbtnEvSim;

	private JRadioButton rdbtnBibSim;

	private JRadioButton rdbtnOracaoSim;
	private JPanel panel_4;

	private JComboBox<FaixaEtaria> fComboBoxIdade;

	private JCheckBox fChckbxIdade;

	private JCheckBox fChckbxFezLicao;

	private JComboBox<Integer> fComboBoxFezLicao;

	private JCheckBox fChckbxNaoFezLicao;

	private JComboBox<Integer> fComboBoxNaoFezLicao;

	private JButton fBtnAplicarFiltros;
	private JPanel panel_6;
	private JButton btnVisualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogado frame = new JanelaLogado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Admin getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Admin responsavel) {
		this.responsavel = responsavel;
	}

	/**
	 * Create the frame.
	 */
	public JanelaLogado() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabNovo = new JPanel();
		tabNovo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tabNovo.updateUI();
			}
		});
		tabbedPane.addTab("Novo Cadastro", new ImageIcon(JanelaLogado.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")), tabNovo, null);
		tabbedPane.setEnabledAt(0, true);
		tabNovo.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados de Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 699, 134);
		tabNovo.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 22, 68, 16);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(76, 20, 357, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 49, 68, 16);
		panel.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(76, 47, 357, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNum = new JLabel("N\u00BA");
		lblNum.setBounds(443, 50, 20, 14);
		panel.add(lblNum);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(509, 50, 49, 14);
		panel.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(560, 47, 129, 20);
		panel.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblPontoDeReferncia = new JLabel("Ponto de Refer\u00EAncia:");
		lblPontoDeReferncia.setBounds(10, 76, 129, 14);
		panel.add(lblPontoDeReferncia);
		
		txtPontoReferencia = new JTextField();
		txtPontoReferencia.setBounds(135, 73, 554, 20);
		panel.add(txtPontoReferencia);
		txtPontoReferencia.setColumns(10);
		
		JLabel lblFaixaEtria = new JLabel("Faixa Et\u00E1ria:");
		lblFaixaEtria.setBounds(443, 23, 85, 14);
		panel.add(lblFaixaEtria);
		
		comboBoxFaixaEtaria = new JComboBox<FaixaEtaria>();
		comboBoxFaixaEtaria.setModel(new DefaultComboBoxModel<FaixaEtaria>(FaixaEtaria.values()));
		comboBoxFaixaEtaria.setBounds(528, 20, 161, 20);
		panel.add(comboBoxFaixaEtaria);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 104, 49, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(76, 101, 265, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefones = new JLabel("Telefones:");
		lblTelefones.setBounds(351, 104, 74, 14);
		panel.add(lblTelefones);
		
		txtTelefone1 = new JTextField();
		txtTelefone1.setBounds(421, 101, 129, 20);
		panel.add(txtTelefone1);
		txtTelefone1.setColumns(10);
		
		txtTelefone2 = new JTextField();
		txtTelefone2.setBounds(560, 101, 129, 20);
		panel.add(txtTelefone2);
		txtTelefone2.setColumns(10);
		
		txtNum = new JTextField();
		txtNum.setBounds(464, 47, 35, 20);
		panel.add(txtNum);
		txtNum.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informa\u00E7\u00F5es Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 157, 697, 296);
		tabNovo.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEvangelismo = new JLabel("Foi alcan\u00E7ado pelo evangelismo em casa?");
		lblEvangelismo.setBounds(12, 23, 261, 16);
		panel_1.add(lblEvangelismo);
		
		ButtonGroup grupoEvangelismo = new ButtonGroup();
		rdbtnEvSim = new JRadioButton("Sim");
		rdbtnEvSim.setBounds(22, 37, 67, 24);
		panel_1.add(rdbtnEvSim);
		grupoEvangelismo.add(rdbtnEvSim);
		
		rdbtnEvNao = new JRadioButton("N\u00E3o");
		rdbtnEvNao.setSelected(true);
		rdbtnEvNao.setBounds(22, 55, 92, 24);
		panel_1.add(rdbtnEvNao);
		grupoEvangelismo.add(rdbtnEvNao);
		
		JLabel lblPossuiBblia = new JLabel("Possui B\u00EDblia?");
		lblPossuiBblia.setBounds(12, 83, 109, 16);
		panel_1.add(lblPossuiBblia);
		
		ButtonGroup grupoBiblia = new ButtonGroup();
		rdbtnBibSim = new JRadioButton("Sim");
		rdbtnBibSim.setBounds(22, 98, 67, 24);
		panel_1.add(rdbtnBibSim);
		grupoBiblia.add(rdbtnBibSim);
		
		rdbtnBibNao = new JRadioButton("N\u00E3o");
		rdbtnBibNao.setSelected(true);
		rdbtnBibNao.setBounds(22, 116, 92, 24);
		panel_1.add(rdbtnBibNao);
		grupoBiblia.add(rdbtnBibNao);
		
		JLabel lblFoiEmAlgum = new JLabel("Foi em algum evento?");
		lblFoiEmAlgum.setBounds(12, 144, 152, 16);
		panel_1.add(lblFoiEmAlgum);
		
		chckbxCulto = new JCheckBox("Culto");
		chckbxCulto.setBounds(12, 158, 109, 24);
		panel_1.add(chckbxCulto);
		
		chckbxFilme = new JCheckBox("Filme");
		chckbxFilme.setBounds(12, 178, 109, 24);
		panel_1.add(chckbxFilme);
		
		chckbxEspetculo = new JCheckBox("Espet\u00E1culo");
		chckbxEspetculo.setBounds(12, 197, 109, 24);
		panel_1.add(chckbxEspetculo);
		
		chckbxTeatroDeRua = new JCheckBox("Teatro de Rua");
		chckbxTeatroDeRua.setBounds(153, 158, 120, 24);
		panel_1.add(chckbxTeatroDeRua);
		
		chckbxCultoNaFeira = new JCheckBox("Culto na Feira");
		chckbxCultoNaFeira.setBounds(153, 178, 120, 24);
		panel_1.add(chckbxCultoNaFeira);
		
		chckbxInfantil = new JCheckBox("Infantil");
		chckbxInfantil.setBounds(153, 197, 120, 24);
		panel_1.add(chckbxInfantil);
		
		chckbxAtendimentoSocial = new JCheckBox("Atendimento Social");
		chckbxAtendimentoSocial.setBounds(12, 216, 173, 24);
		panel_1.add(chckbxAtendimentoSocial);
		
		lblFrequentaAlgumaIgreja = new JLabel("Frequenta alguma igreja?");
		lblFrequentaAlgumaIgreja.setBounds(12, 244, 173, 16);
		panel_1.add(lblFrequentaAlgumaIgreja);
		
		chckbxIgrejaSim = new JCheckBox("Sim");
		chckbxIgrejaSim.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtIgreja.setEnabled(chckbxIgrejaSim.isSelected());
			}
		});
		chckbxIgrejaSim.setBounds(12, 259, 60, 24);
		panel_1.add(chckbxIgrejaSim);
		
		txtIgreja = new JTextField();
		txtIgreja.setEnabled(chckbxIgrejaSim.isSelected());
		txtIgreja.setToolTipText("Qual?");
		txtIgreja.setBounds(75, 261, 198, 20);
		panel_1.add(txtIgreja);
		txtIgreja.setColumns(10);
		
		JLabel lblFihosFrequentaramO = new JLabel("Fihos frequentaram o infantil?");
		lblFihosFrequentaramO.setBounds(305, 23, 209, 16);
		panel_1.add(lblFihosFrequentaramO);
		
		checkBoxInfantilSim = new JCheckBox("Sim");
		checkBoxInfantilSim.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtFilhos.setEnabled(checkBoxInfantilSim.isSelected());
			}
		});
		checkBoxInfantilSim.setBounds(305, 37, 60, 24);
		panel_1.add(checkBoxInfantilSim);
		
		txtFilhos = new JTextField();
		txtFilhos.setToolTipText("Nomes separados por v\u00EDrgula");
		txtFilhos.setEnabled(checkBoxInfantilSim.isSelected());
		txtFilhos.setColumns(10);
		txtFilhos.setBounds(368, 39, 317, 20);
		panel_1.add(txtFilhos);
		
		JLabel lblLiesDeEstudo = new JLabel("Li\u00E7\u00F5es de estudo b\u00EDblico realizadas:");
		lblLiesDeEstudo.setBounds(305, 65, 234, 16);
		panel_1.add(lblLiesDeEstudo);
		
		checkBox_1 = new JCheckBox("1");
		checkBox_1.setBounds(305, 82, 67, 24);
		panel_1.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("2");
		checkBox_2.setBounds(305, 100, 67, 24);
		panel_1.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("3");
		checkBox_3.setBounds(375, 82, 67, 24);
		panel_1.add(checkBox_3);
		
		checkBox_4 = new JCheckBox("4");
		checkBox_4.setBounds(375, 100, 67, 24);
		panel_1.add(checkBox_4);
		
		checkBox_5 = new JCheckBox("5");
		checkBox_5.setBounds(442, 82, 67, 24);
		panel_1.add(checkBox_5);
		
		checkBox_6 = new JCheckBox("6");
		checkBox_6.setBounds(442, 100, 67, 24);
		panel_1.add(checkBox_6);
		
		checkBox_7 = new JCheckBox("7");
		checkBox_7.setBounds(513, 82, 67, 24);
		panel_1.add(checkBox_7);
		
		JLabel lblMelhorDiaE = new JLabel("Melhor dia e hor\u00E1rio para continuar o estudo b\u00EDblico:");
		lblMelhorDiaE.setBounds(305, 130, 362, 16);
		panel_1.add(lblMelhorDiaE);
		
		txtDiaEstudo = new JTextField();
		txtDiaEstudo.setBounds(305, 148, 380, 20);
		panel_1.add(txtDiaEstudo);
		txtDiaEstudo.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(291, 23, 2, 260);
		panel_1.add(separator);
		
		JLabel lblRealizouOraoDe = new JLabel("Realizou ora\u00E7\u00E3o de convers\u00E3o?");
		lblRealizouOraoDe.setBounds(305, 178, 234, 16);
		panel_1.add(lblRealizouOraoDe);
		
		ButtonGroup grupoOracao = new ButtonGroup();
		rdbtnOracaoSim = new JRadioButton("Sim");
		rdbtnOracaoSim.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtDataOracao.setEnabled(rdbtnOracaoSim.isSelected());
			}
		});
		rdbtnOracaoSim.setBounds(305, 193, 76, 24);
		panel_1.add(rdbtnOracaoSim);
		grupoOracao.add(rdbtnOracaoSim);
		
		rdbtnOracaoNao = new JRadioButton("N\u00E3o");
		rdbtnOracaoNao.setSelected(true);
		rdbtnOracaoNao.setBounds(305, 211, 76, 24);
		panel_1.add(rdbtnOracaoNao);
		grupoOracao.add(rdbtnOracaoNao);
		
		JLabel lblQuando = new JLabel("Quando?");
		lblQuando.setBounds(387, 197, 67, 16);
		panel_1.add(lblQuando);
		
		txtDataOracao = new JTextField();
		txtDataOracao.setEnabled(rdbtnOracaoSim.isSelected());
		txtDataOracao.setBounds(459, 194, 226, 20);
		panel_1.add(txtDataOracao);
		txtDataOracao.setColumns(10);
		
		JLabel lblDuplaQueRealizou = new JLabel("Dupla que realizou o acompanhamento:");
		lblDuplaQueRealizou.setBounds(305, 243, 275, 16);
		panel_1.add(lblDuplaQueRealizou);
		
		txtDupla = new JTextField();
		txtDupla.setToolTipText("Nomes separados por v\u00EDrgula");
		txtDupla.setBounds(305, 261, 380, 20);
		panel_1.add(txtDupla);
		txtDupla.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Observa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(721, 11, 306, 367);
		tabNovo.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPedidosDeOrao = new JLabel("Pedidos de ora\u00E7\u00E3o:");
		lblPedidosDeOrao.setBounds(12, 22, 154, 16);
		panel_2.add(lblPedidosDeOrao);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(12, 193, 120, 16);
		panel_2.add(lblObservaes);
		
		txtPedidosOracao = new JTextPane();
		txtPedidosOracao.setDropMode(DropMode.INSERT);
		txtPedidosOracao.setBounds(12, 41, 280, 140);
		panel_2.add(txtPedidosOracao);
		
		txtObservacoes = new JTextPane();
		txtObservacoes.setDropMode(DropMode.INSERT);
		txtObservacoes.setBounds(12, 211, 280, 140);
		panel_2.add(txtObservacoes);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNome.getText().length() < 3) {
					lblMensagem.setForeground(Color.RED);
					lblMensagem.setText("O nome precisa ter pelo menos 3 caracteres");
				} else {
					try {
						salvarDados();
						lblMensagem.setForeground(Color.BLUE);
						lblMensagem.setText("Cadastro salvo com sucesso!");
						limparCampos();
						btnLimpar.setText("Limpar");
						editando = false;
						listaCadastros.setModel(getListaDePessoas());
					} catch (Exception e) {
						lblMensagem.setForeground(Color.RED);
						lblMensagem.setText(e.getMessage());
					}
				}
			}
		});
		btnSalvar.setBounds(880, 423, 147, 26);
		tabNovo.add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
				lblMensagem.setText("");
				btnLimpar.setText("Limpar");
				editando = false;
			}
		});
		btnLimpar.setBounds(721, 423, 147, 26);
		tabNovo.add(btnLimpar);
		
		lblMensagem = new JLabel("");
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setBounds(721, 390, 306, 16);
		tabNovo.add(lblMensagem);
		
		tabListar = new JPanel();
		tabListar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				listaCadastros.setModel(getListaDePessoas());
				tabListar.updateUI();
			}
		});
		tabbedPane.addTab("Listar Cadastros", null, tabListar, null);
		tabListar.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Pessoas Cadastradas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 12, 726, 437);
		tabListar.add(panel_3);
		panel_3.setLayout(null);
		
		listaCadastros = new JList<Pessoa>();
		listaCadastros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaCadastros.setModel(new ListaDePessoas(new FiltroDePessoas()));
		listaCadastros.setBounds(12, 22, 759, 403);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(702, 403);
		scrollPane.setLocation(12, 22);
		scrollPane.setViewportView(listaCadastros);
		panel_3.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(750, 12, 275, 197);
		tabListar.add(panel_5);
		panel_5.setLayout(null);
		
		fComboBoxIdade = new JComboBox<FaixaEtaria>();
		fComboBoxIdade.setEnabled(false);
		fComboBoxIdade.setModel(new DefaultComboBoxModel<FaixaEtaria>(FaixaEtaria.values()));
		fComboBoxIdade.setBounds(99, 31, 155, 25);
		panel_5.add(fComboBoxIdade);
		
		fChckbxIdade = new JCheckBox("Idade:");
		fChckbxIdade.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				fComboBoxIdade.setEnabled(fChckbxIdade.isSelected());
			}
		});
		fChckbxIdade.setBounds(18, 31, 73, 24);
		panel_5.add(fChckbxIdade);
		
		fChckbxFezLicao = new JCheckBox("Fez a li\u00E7\u00E3o:");
		fChckbxFezLicao.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				fComboBoxFezLicao.setEnabled(fChckbxFezLicao.isSelected());
			}
		});
		fChckbxFezLicao.setBounds(18, 68, 133, 24);
		panel_5.add(fChckbxFezLicao);
		
		fComboBoxFezLicao = new JComboBox<Integer>();
		fComboBoxFezLicao.setEnabled(false);
		fComboBoxFezLicao.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6, 7}));
		fComboBoxFezLicao.setBounds(159, 68, 95, 25);
		panel_5.add(fComboBoxFezLicao);
		
		fChckbxNaoFezLicao = new JCheckBox("N\u00E3o fez a li\u00E7\u00E3o:");
		fChckbxNaoFezLicao.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				fComboBoxNaoFezLicao.setEnabled(fChckbxNaoFezLicao.isSelected());
			}
		});
		fChckbxNaoFezLicao.setBounds(18, 105, 133, 24);
		panel_5.add(fChckbxNaoFezLicao);
		
		fComboBoxNaoFezLicao = new JComboBox<Integer>();
		fComboBoxNaoFezLicao.setEnabled(false);
		fComboBoxNaoFezLicao.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6, 7}));
		fComboBoxNaoFezLicao.setBounds(159, 105, 95, 25);
		panel_5.add(fComboBoxNaoFezLicao);
		
		fBtnAplicarFiltros = new JButton("Aplicar Filtros");
		fBtnAplicarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaCadastros.setModel(getListaDePessoas());
			}
		});
		fBtnAplicarFiltros.setBounds(18, 151, 236, 26);
		panel_5.add(fBtnAplicarFiltros);
		
		panel_4 = new JPanel();
		panel_4.setBounds(750, 361, 275, 88);
		tabListar.add(panel_4);
		panel_4.setLayout(null);
		
		btnEditarCadastro = new JButton("Editar Cadastro");
		btnEditarCadastro.setBounds(12, 12, 251, 26);
		panel_4.add(btnEditarCadastro);
		
		btnExcluirCadastro = new JButton("Excluir Cadastro Selecionado");
		btnExcluirCadastro.setBounds(12, 50, 251, 26);
		panel_4.add(btnExcluirCadastro);
		
		panel_6 = new JPanel();
		panel_6.setBounds(750, 221, 275, 53);
		tabListar.add(panel_6);
		panel_6.setLayout(null);
		
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!listaCadastros.isSelectionEmpty()) {
					new VisualizarPessoa(listaCadastros.getSelectedValue());
					lblMensagem.setText("");
				}
			}
		});
		btnVisualizar.setBounds(12, 12, 251, 26);
		panel_6.add(btnVisualizar);
		btnExcluirCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listaCadastros.isSelectionEmpty()) {
					DBService.excluir(listaCadastros.getSelectedValue());
					listaCadastros.setModel(getListaDePessoas());
					tabListar.updateUI();
					lblMensagem.setText("");
				}
			}
		});
		btnEditarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listaCadastros.isSelectionEmpty()) {
					limparCampos();
					btnLimpar.setText("Cancelar");
					editando = true;
					prepararParaEditar(listaCadastros.getSelectedValue());
				}
			}
		});
		
		JPanel tabHome = new JPanel();
		tabbedPane.addTab("Home", new ImageIcon(JanelaLogado.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")), tabHome, null);
		tabHome.setLayout(null);
		tabbedPane.setEnabledAt(2, false);
	}

	private ListModel<Pessoa> getListaDePessoas() {
		return new ListaDePessoas(
				new FiltroDePessoas(fChckbxIdade.isSelected(), fComboBoxIdade.getItemAt(fComboBoxIdade.getSelectedIndex()), 
						fChckbxFezLicao.isSelected(), fComboBoxFezLicao.getItemAt(fComboBoxFezLicao.getSelectedIndex()), 
						fChckbxNaoFezLicao.isSelected(), fComboBoxNaoFezLicao.getItemAt(fComboBoxNaoFezLicao.getSelectedIndex())));
	}

	private void salvarDados() throws Exception {
		Pessoa pessoa = new Pessoa(txtNome.getText());
		
		pessoa.setEndereco(txtEndereco.getText());
		pessoa.setNumero(txtNum.getText());
		pessoa.setBairro(txtBairro.getText());
		pessoa.setPontoReferencia(txtPontoReferencia.getText());
		pessoa.setEmail(txtEmail.getText());
		pessoa.setTelefone1(txtTelefone1.getText());
		pessoa.setTelefone2(txtTelefone2.getText());
		
		if (chckbxIgrejaSim.isSelected())
			pessoa.setIgreja(txtIgreja.getText());
		if (checkBoxInfantilSim.isSelected())
			pessoa.setFilhosNoInfantil(txtFilhos.getText().split(", "));
		if (rdbtnOracaoSim.isSelected())
			pessoa.setDataOracaoConversao(txtDataOracao.getText());
		
		pessoa.setDiaParaEstudo(txtDiaEstudo.getText());
		pessoa.setDiscipuladores(txtDupla.getText().split(", "));
		pessoa.setPedidosOracao(txtPedidosOracao.getText());
		pessoa.setObservacoes(txtObservacoes.getText());
		
		pessoa.setEvangelismo(rdbtnEvSim.isSelected());
		pessoa.setBiblia(rdbtnBibSim.isSelected());
		
		pessoa.setFaixaEtaria(comboBoxFaixaEtaria.getItemAt(comboBoxFaixaEtaria.getSelectedIndex()));
		
		List<Evento> eventos = new ArrayList<Evento>();
		if (chckbxAtendimentoSocial.isSelected())
			eventos.add(Evento.ATEND_SOCIAL);
		if (chckbxCulto.isSelected())
			eventos.add(Evento.CULTO);
		if (chckbxCultoNaFeira.isSelected())
			eventos.add(Evento.CULTO_FEIRA);
		if (chckbxEspetculo.isSelected())
			eventos.add(Evento.ESPETACULO);
		if (chckbxFilme.isSelected())
			eventos.add(Evento.FILME);
		if (chckbxInfantil.isSelected())
			eventos.add(Evento.INFANTIL);
		if (chckbxTeatroDeRua.isSelected())
			eventos.add(Evento.TEATRO_RUA);
		pessoa.setEventos(eventos);

		Licoes licoes = new Licoes();
		licoes.setUm(checkBox_1.isSelected());
		licoes.setDois(checkBox_2.isSelected());
		licoes.setTres(checkBox_3.isSelected());
		licoes.setQuatro(checkBox_4.isSelected());
		licoes.setCinco(checkBox_5.isSelected());
		licoes.setSeis(checkBox_6.isSelected());
		licoes.setSete(checkBox_7.isSelected());
		pessoa.setLicoes(licoes);
		
		pessoa.setResponsavel(responsavel);
		
		DBService.persist(pessoa, editando);
	}

	private void limparCampos() {
		txtNome.setText("");
		txtEndereco.setText("");
		txtNum.setText("");
		txtBairro.setText("");
		txtPontoReferencia.setText("");
		txtEmail.setText("");
		txtTelefone1.setText("");
		txtTelefone2.setText("");
		
		txtIgreja.setText("");
		txtFilhos.setText("");
		txtDiaEstudo.setText("");
		txtDataOracao.setText("");
		txtDupla.setText("");
		txtPedidosOracao.setText("");
		txtObservacoes.setText("");
		
		rdbtnEvNao.setSelected(true);
		rdbtnBibNao.setSelected(true);
		rdbtnOracaoNao.setSelected(true);
		
		chckbxAtendimentoSocial.setSelected(false);
		chckbxCulto.setSelected(false);
		chckbxCultoNaFeira.setSelected(false);
		chckbxEspetculo.setSelected(false);
		chckbxFilme.setSelected(false);
		chckbxIgrejaSim.setSelected(false);
		chckbxInfantil.setSelected(false);
		chckbxTeatroDeRua.setSelected(false);
		checkBoxInfantilSim.setSelected(false);
		checkBox_1.setSelected(false);
		checkBox_2.setSelected(false);
		checkBox_3.setSelected(false);
		checkBox_4.setSelected(false);
		checkBox_5.setSelected(false);
		checkBox_6.setSelected(false);
		checkBox_7.setSelected(false);
	}

	private void prepararParaEditar(Pessoa pessoa) {
		lblMensagem.setText("");
		txtNome.setText(pessoa.getNome());
		txtEndereco.setText(pessoa.getEndereco());
		txtNum.setText(pessoa.getNumero());
		txtBairro.setText(pessoa.getBairro());
		txtPontoReferencia.setText(pessoa.getPontoReferencia());
		txtEmail.setText(pessoa.getEmail());
		txtTelefone1.setText(pessoa.getTelefone1());
		txtTelefone2.setText(pessoa.getTelefone2());
		
		txtIgreja.setText(pessoa.getIgreja());
		txtDiaEstudo.setText(pessoa.getDiaParaEstudo());
		txtDataOracao.setText(pessoa.getDataOracaoConversao());
		txtPedidosOracao.setText(pessoa.getPedidosOracao());
		txtObservacoes.setText(pessoa.getObservacoes());
		
		comboBoxFaixaEtaria.setSelectedItem(pessoa.getFaixaEtaria());
		
		String filhos = "";
		for (String filho : pessoa.getFilhosNoInfantil())
			filhos += filho + ", ";
		if (filhos.length() >= 2)
			filhos = filhos.substring(0, filhos.length() - 2);
		txtFilhos.setText(filhos);
		
		txtDupla.setText(pessoa.getDiscipuladoresString());
		
		if (pessoa.isEvangelismo())
			rdbtnEvSim.doClick();
		if (pessoa.isBiblia())
			rdbtnBibSim.doClick();
		if (pessoa.getDataOracaoConversao() != null && (!pessoa.getDataOracaoConversao().trim().isEmpty()))
			rdbtnOracaoSim.doClick();
		
		chckbxIgrejaSim.setSelected(pessoa.getIgreja() != null && (!pessoa.getIgreja().isEmpty()));
		checkBoxInfantilSim.setSelected(pessoa.getFilhosNoInfantil() != null && (!pessoa.getFilhosNoInfantil().isEmpty()));
		
		for (Evento e : pessoa.getEventos()) {
			switch (e) {
			case ATEND_SOCIAL:
				chckbxAtendimentoSocial.setSelected(true);
				break;
			case CULTO:
				chckbxCulto.setSelected(true);
				break;
			case CULTO_FEIRA:
				chckbxCultoNaFeira.setSelected(true);
				break;
			case ESPETACULO:
				chckbxEspetculo.setSelected(true);
				break;
			case FILME:
				chckbxFilme.setSelected(true);
				break;
			case INFANTIL:
				chckbxInfantil.setSelected(true);
				break;
			case TEATRO_RUA:
				chckbxTeatroDeRua.setSelected(true);
				break;
			default:
				break;
			}
		}
		
		Licoes licoes = pessoa.getLicoes();
		checkBox_1.setSelected(licoes.isUm());
		checkBox_2.setSelected(licoes.isDois());
		checkBox_3.setSelected(licoes.isTres());
		checkBox_4.setSelected(licoes.isQuatro());
		checkBox_5.setSelected(licoes.isCinco());
		checkBox_6.setSelected(licoes.isSeis());
		checkBox_7.setSelected(licoes.isSete());
		
		tabListar.setVisible(false);
		tabNovo.updateUI();
		tabNovo.setVisible(true);
		tabbedPane.setSelectedIndex(0);
	}

	public boolean isEditando() {
		return editando;
	}

	public void setEditando(boolean editando) {
		this.editando = editando;
	}
}
