package vue;

import controleur.Controle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntreeJeu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIp;
	private Controle controle;

	
	
	/**
	*clic sur le bouton Start pour lancer le serveur
	**/
private void btnStart_clic(){
	controle.evenementVue(this,"serveur");
	
}
private void btnConnect_clic(){
	controle.evenementVue(this,txtIp.getText());
}
/**
 * clic sur le bouton exit pour quitter la fenetre
 */
private void btnExit_clic() {
System.exit(0);
}

	/**
	 * Create the frame.
	 * @param controle 
	 */
	public EntreeJeu(Controle controle) {
		
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("START");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			btnStart_clic();
			}
			
		});
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExit_clic();
			}
		});
		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConnect_clic();
			}
		});
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setBounds(265, 45, 159, 42);
		contentPane.add(btnStart);
		
		JLabel lblStartAServeur = new JLabel("Start a serveur:");
		lblStartAServeur.setBounds(37, 56, 180, 19);
		contentPane.add(lblStartAServeur);
		
		JLabel lblConnectAnExisting = new JLabel("Connect an existing serveur :");
		lblConnectAnExisting.setBounds(37, 120, 201, 23);
		contentPane.add(lblConnectAnExisting);
		
		
		btnConnect.setBounds(297, 120, 89, 23);
		contentPane.add(btnConnect);
		
		JLabel lblIdServeur = new JLabel("Id Serveur:");
		lblIdServeur.setBounds(37, 187, 63, 23);
		contentPane.add(lblIdServeur);
		
		txtIp = new JTextField();
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(110, 188, 86, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		
		btnExit.setBounds(297, 187, 89, 23);
		contentPane.add(btnExit);
		this.controle = controle;
	}
	public Controle getControle() {
		return controle;
	}
	public void setControle(Controle controle) {
		this.controle = controle;
	}
}
