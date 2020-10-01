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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.ControleUsuario;
import repositorio.GuardarSessao;

public class TelaInicial extends JFrame {

	private JPanel contentTelainicialLogin;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	ControleUsuario controle = new ControleUsuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 550);
		contentTelainicialLogin = new JPanel();
		contentTelainicialLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentTelainicialLogin);
		contentTelainicialLogin.setLayout(null);
		
		JLabel lblDeixaComigo = new JLabel("Deixa comigo");
		lblDeixaComigo.setFont(new Font("Caladea", Font.BOLD, 30));
		lblDeixaComigo.setBounds(160, 11, 199, 44);
		contentTelainicialLogin.add(lblDeixaComigo);
		
		JLabel lblBemVindo = new JLabel("Bem vindo ao melhor programa de freelance");
		lblBemVindo.setFont(new Font("Caladea", Font.PLAIN, 14));
		lblBemVindo.setBounds(112, 55, 300, 25);
		contentTelainicialLogin.add(lblBemVindo);
		
		JLabel lblNewLogin = new JLabel("Login\r\n:");
		lblNewLogin.setFont(new Font("Caladea", Font.PLAIN, 16));
		lblNewLogin.setBounds(82, 332, 46, 34);
		contentTelainicialLogin.add(lblNewLogin);
		
		JLabel lblNewSenha = new JLabel("Senha:");
		lblNewSenha.setFont(new Font("Caladea", Font.PLAIN, 16));
		lblNewSenha.setBounds(82, 377, 57, 25);
		contentTelainicialLogin.add(lblNewSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean logar = controle.checarLogin(txtLogin.getText(), txtSenha.getText());
				System.out.println(logar);
				if(logar == true) {
					JOptionPane.showMessageDialog(null, "Logado Com sucesso");
					dispose();
					if(GuardarSessao.getLogado().getTipo().equals("Prestador")){
						new TelaPrestador().setVisible(true);
					}else {
						new TelaEmpresa().setVisible(true);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Usuário os senha incorretos");
				}
			}
		});
		btnEntrar.setBounds(160, 412, 168, 23);
		contentTelainicialLogin.add(btnEntrar);
		
		JButton btnCadastreSe = new JButton("Cadastre - se");
		btnCadastreSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCadastro().setVisible(true);
			}
		});
		btnCadastreSe.setBounds(160, 446, 168, 23);
		contentTelainicialLogin.add(btnCadastreSe);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(138, 341, 240, 20);
		contentTelainicialLogin.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(138, 382, 240, 20);
		contentTelainicialLogin.add(txtSenha);
	}

}
