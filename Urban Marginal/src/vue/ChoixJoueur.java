package vue;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import controleur.Global;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class ChoixJoueur extends JFrame implements Global {
	private int numPerso = 1;
	private JLabel lblPersonnage;

	private void affichePerso() {
		lblPersonnage.setIcon(new ImageIcon(PERSO + numPerso + MARCHE + 1 + "d" + DROITE + EXTIMAGE));
	}

	private void souris_normal() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	private void souris_doigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void lblPrecedent_clic() {
		numPerso = (numPerso + NBPERSO + 1) % NBPERSO + 1;
		affichePerso();
	}

	private void lblSuivant_clic() {
		numPerso = (numPerso) % NBPERSO + 1;
		affichePerso();
	}

	private void lblGo_clic() {
		if (txtPseudo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Veillez entrer un pseudo !");
			txtPseudo.requestFocus();
		}
	}

	private JPanel contentPane;
	private JTextField txtPseudo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChoixJoueur(Controle controle) {
		setTitle("Choice");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 416, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/**
				 * action clic btn precedent
				 */
				lblPrecedent_clic();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				souris_doigt();
			}

			public void mouseExited(MouseEvent e) {
				souris_normal();
			}
		});

		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}

			public void mouseEntered(MouseEvent arg0) {
				souris_doigt();
			}

			public void mouseExited(MouseEvent e) {
				souris_normal();
			}
		});
		lblSuivant.setBounds(288, 146, 46, 42);
		contentPane.add(lblSuivant);

		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				souris_normal();
			}
		});
		lblGo.setEnabled(false);
		lblGo.setBounds(312, 199, 65, 64);
		contentPane.add(lblGo);
		lblPrecedent.setBounds(60, 146, 46, 42);
		contentPane.add(lblPrecedent);

		txtPseudo = new JTextField();
		txtPseudo.setBounds(142, 248, 120, 15);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);

		lblPersonnage = new JLabel("");
		lblPersonnage.setBounds(181, 114, 120, 123);
		contentPane.add(lblPersonnage);

		JLabel LblFond = new JLabel("");
		LblFond.setBounds(0, 0, 400, 275);

		LblFond.setIcon(new ImageIcon(FONDCHOIX));
		contentPane.add(LblFond);
		affichePerso();

	}

}
