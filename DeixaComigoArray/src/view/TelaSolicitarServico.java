package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controle.ControleServico;
import repositorio.GuardarSessao;
import repositorio.Servico;
import repositorio.Usuario;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class TelaSolicitarServico extends JFrame {

	private JPanel contentPane;
	private JTextField txtnomeserv;
	private JTextField txtValor;
	ControleServico controle = new ControleServico();
	private JTextField txtEndereco;
	private JTextField txtVagas;
	private JTextField txtDescricao;
	private JComboBox cbServico;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSolicitarServico frame = new TelaSolicitarServico();
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
	
	private DefaultComboBoxModel getModelo() {
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		File file = new File("servicos.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linhas;
	        StringBuffer sb = new StringBuffer();
	        while((linhas = br.readLine()) != null) {
	          System.out.println(linhas);
	          modelo.addElement(linhas);
	        }
//			List<String> arquivos = listaConteudo()
//			modelo.addElement("Escolha");
//			for (String arquivo : arquivos) {
//				
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelo;
	}
	public TelaSolicitarServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOferecerServio = new JLabel("Solicitar Servi\u00E7o");
		lblOferecerServio.setFont(new Font("Arial", Font.BOLD, 30));
		lblOferecerServio.setBounds(165, 11, 251, 36);
		contentPane.add(lblOferecerServio);
		
		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNomeDoServio.setBounds(10, 115, 170, 17);
		contentPane.add(lblNomeDoServio);
		
		txtnomeserv = new JTextField();
		txtnomeserv.setBounds(180, 112, 267, 20);
		contentPane.add(txtnomeserv);
		txtnomeserv.setColumns(10);
		
		JLabel lblTipoDoServio = new JLabel("Tipo do Servi\u00E7o:");
		lblTipoDoServio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipoDoServio.setBounds(10, 143, 153, 24);
		contentPane.add(lblTipoDoServio);
		
		JLabel lblValorDoServio = new JLabel("Valor do Servi\u00E7o:");
		lblValorDoServio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblValorDoServio.setBounds(10, 178, 153, 24);
		contentPane.add(lblValorDoServio);
		
		txtValor = new JTextField();
		txtValor.setBounds(180, 183, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblDescrioDoServio = new JLabel("Descri\u00E7\u00E3o do servi\u00E7o:");
		lblDescrioDoServio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDescrioDoServio.setBounds(10, 297, 208, 24);
		contentPane.add(lblDescrioDoServio);
		
		JButton btnOfertar = new JButton("Ofertar");
		btnOfertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoServico = cbServico.getSelectedItem().toString();
				Servico servico = new Servico(txtnomeserv.getText(), tipoServico, GuardarSessao.getLogado(), txtValor.getText(), txtEndereco.getText(), txtVagas.getText(), txtDescricao.getText());
				controle.CadastrarServico(servico);
				JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso.");
			}
		});
		btnOfertar.setBounds(358, 462, 89, 23);
		contentPane.add(btnOfertar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(205, 462, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereo.setBounds(10, 213, 153, 20);
		contentPane.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(180, 216, 267, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblVagas = new JLabel("Vagas:");
		lblVagas.setFont(new Font("Arial", Font.PLAIN, 20));
		lblVagas.setBounds(10, 244, 102, 22);
		contentPane.add(lblVagas);
		
		txtVagas = new JTextField();
		txtVagas.setBounds(180, 248, 86, 20);
		contentPane.add(txtVagas);
		txtVagas.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(208, 302, 239, 125);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		cbServico = new JComboBox();
		cbServico.setBounds(180, 143, 267, 22);
		cbServico.setModel(getModelo());
		contentPane.add(cbServico);
		
//		getModelo();
		
		
	}
}
