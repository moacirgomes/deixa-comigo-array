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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.ControleUsuario;
import repositorio.GuardarSessao;
import repositorio.Usuario;

public class TelaEditarPerfil extends JFrame {

	private JPanel contentTelaEditarPerfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarPerfil frame = new TelaEditarPerfil();
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
	public TelaEditarPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 550);
		contentTelaEditarPerfil = new JPanel();
		contentTelaEditarPerfil.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentTelaEditarPerfil);
		contentTelaEditarPerfil.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Perfil");
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 30));
		lblNewLabel.setBounds(169, 11, 267, 41);
		contentTelaEditarPerfil.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(38, 85, 73, 24);
		contentTelaEditarPerfil.add(lblNewLabel_1);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblTelefone.setBounds(38, 128, 90, 24);
		contentTelaEditarPerfil.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblEmail.setBounds(38, 178, 90, 24);
		contentTelaEditarPerfil.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Caladea", Font.PLAIN, 20));
		lblSenha.setBounds(38, 235, 90, 24);
		contentTelaEditarPerfil.add(lblSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(GuardarSessao.logado.getTipo().equals("Prestador")) {
					new TelaPrestador().setVisible(true);
				}else {
					new TelaEmpresa().setVisible(true);
				}
			}
		});
		btnSalvar.setBounds(194, 359, 116, 35);
		contentTelaEditarPerfil.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(204, 405, 96, 23);
		contentTelaEditarPerfil.add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel(GuardarSessao.getLogado().getNome());
		lblNewLabel_2.setBounds(109, 94, 201, 14);
		contentTelaEditarPerfil.add(lblNewLabel_2);
		
		JLabel lbltel = new JLabel(GuardarSessao.getLogado().getTelefone());
		lbltel.setBounds(126, 137, 201, 14);
		contentTelaEditarPerfil.add(lbltel);
		
		JLabel lblemail = new JLabel(GuardarSessao.getLogado().getEmail());
		lblemail.setBounds(109, 187, 201, 14);
		contentTelaEditarPerfil.add(lblemail);
		
		JLabel label_2 = new JLabel("*****");
		label_2.setBounds(109, 244, 201, 14);
		contentTelaEditarPerfil.add(label_2);
		
		JButton btnEditarNome = new JButton("Editar");
		btnEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String novoNome = JOptionPane.showInputDialog("Novo nome: ");
				Usuario antigo = GuardarSessao.logado;
				ControleUsuario.remover(antigo);
				GuardarSessao.logado.setNome(novoNome);
				ControleUsuario.CadastrarUsuario(GuardarSessao.logado);
				dispose();
				new TelaEditarPerfil().setVisible(true);
			}
		});
		btnEditarNome.setBounds(379, 90, 89, 23);
		contentTelaEditarPerfil.add(btnEditarNome);
		
		JButton btnEditarTel = new JButton("Editar");
		btnEditarTel.setBounds(379, 133, 89, 23);
		contentTelaEditarPerfil.add(btnEditarTel);
		
		JButton btnEditarEmail = new JButton("Editar");
		btnEditarEmail.setBounds(379, 183, 89, 23);
		contentTelaEditarPerfil.add(btnEditarEmail);
		
		JButton btnEditarSenha = new JButton("Editar");
		btnEditarSenha.setBounds(379, 240, 89, 23);
		contentTelaEditarPerfil.add(btnEditarSenha);
	}
}
