package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.ControleUsuario;
import repositorio.Usuario;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPFCNPJ;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JPasswordField passwordSenha;
	private JPasswordField passwordConfSenha;
	ControleUsuario controle = new ControleUsuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Cliente");
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 30));
		lblNewLabel.setBounds(123, 11, 282, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(23, 84, 73, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblTelefone.setBounds(23, 204, 90, 24);
		contentPane.add(lblTelefone);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ:");
		lblCpfcnpj.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCpfcnpj.setBounds(23, 143, 105, 24);
		contentPane.add(lblCpfcnpj);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblEmail.setBounds(23, 259, 90, 24);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblSenha.setBounds(23, 316, 90, 24);
		contentPane.add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblConfirmarSenha.setBounds(23, 374, 155, 24);
		contentPane.add(lblConfirmarSenha);
		
		JRadioButton rdbtnPrestador = new JRadioButton("Prestador\r\n");
		rdbtnPrestador.setFont(new Font("Caladea", Font.BOLD | Font.ITALIC, 20));
		rdbtnPrestador.setBounds(123, 434, 124, 23);
		contentPane.add(rdbtnPrestador);
		
		txtNome = new JTextField();
		txtNome.setBounds(138, 88, 311, 24);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPFCNPJ = new JTextField();
		txtCPFCNPJ.setColumns(10);
		txtCPFCNPJ.setBounds(138, 143, 311, 24);
		contentPane.add(txtCPFCNPJ);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(138, 208, 311, 24);
		contentPane.add(txtTelefone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(138, 263, 311, 24);
		contentPane.add(txtEmail);
		
		JRadioButton rdbtnEmpresa = new JRadioButton("Empresa");
		rdbtnEmpresa.setFont(new Font("Caladea", Font.BOLD | Font.ITALIC, 20));
		rdbtnEmpresa.setBounds(294, 434, 124, 23);
		contentPane.add(rdbtnEmpresa);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtCPFCNPJ.getText().length() == 0 ||
						txtNome.getText().length() == 0 ||
						txtTelefone.getText().length() == 0 ||
						txtEmail.getText().length() == 0 ||
						passwordSenha.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Preencha todo os dados");
				}else if(!(passwordSenha.getText().equals(passwordConfSenha.getText()))) {
					JOptionPane.showMessageDialog(null, "Senhas não Conferem");
				}else {
	
					String tipo="";
					if(rdbtnPrestador.isSelected() == true) {
						tipo = "Prestador";
					}else {
						tipo = "Empresa";
					}
					Usuario usuario = new Usuario(txtCPFCNPJ.getText(), txtNome.getText(), txtTelefone.getText(), txtEmail.getText(), passwordSenha.getText(), tipo);
					controle.CadastrarUsuario(usuario);
					JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso");
					dispose();
					new TelaInicial().setVisible(true);;
				}
			}
		});
		btnCadastrar.setBounds(209, 464, 105, 25);
		contentPane.add(btnCadastrar);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(138, 322, 311, 20);
		contentPane.add(passwordSenha);
		
		passwordConfSenha = new JPasswordField();
		passwordConfSenha.setBounds(188, 380, 261, 20);
		contentPane.add(passwordConfSenha);
	}

}
