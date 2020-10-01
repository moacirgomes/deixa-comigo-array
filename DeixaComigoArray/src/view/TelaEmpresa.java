package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import repositorio.GuardarSessao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class TelaEmpresa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmpresa frame = new TelaEmpresa();
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
	public TelaEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSair = new JMenu("Menu\n");
		menuBar.add(mnSair);
		
		JMenuItem mntmEditarPerfil = new JMenuItem("Editar Perfil");
		mntmEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaEditarPerfil().setVisible(true);
			}
		});
		mnSair.add(mntmEditarPerfil);
		
		JMenuItem mntmSolicitarServio = new JMenuItem("Solicitar Servi\u00E7o");
		mntmSolicitarServio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaSolicitarServico().setVisible(true);
			}
		});
		mnSair.add(mntmSolicitarServio);
		
		JMenuItem mntmSar = new JMenuItem("Sair");
		mntmSar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaInicial().setVisible(true);
			}
		});
		mnSair.add(mntmSar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOfertaDeVagas = new JLabel("Deixa Comigo");
		lblOfertaDeVagas.setFont(new Font("Arial", Font.BOLD, 30));
		lblOfertaDeVagas.setBounds(145, 12, 253, 44);
		contentPane.add(lblOfertaDeVagas);
		
		JLabel lblSejaBemVindo = new JLabel("Seja Bem vindo");
		lblSejaBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSejaBemVindo.setBounds(175, 61, 120, 15);
		contentPane.add(lblSejaBemVindo);
		
		JLabel label = new JLabel(GuardarSessao.getLogado().getNome());
		label.setFont(new Font("Dialog", Font.ITALIC, 16));
		label.setBounds(298, 54, 155, 27);
		contentPane.add(label);
		

	}
}
