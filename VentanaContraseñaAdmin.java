import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class VentanaContraseñaAdmin extends JFrame implements ActionListener {
	
	
	private JPanel pnlPrincipal;

	private JButton btnOk;
	private JButton btnSalir;

	private JTextField txtContraseñaAnterior;
	private JTextField txtContraseñaNueva;
	
	private JPasswordField ftxtContraseñaAnterior;
	private JPasswordField ftxtContraseñaNueva;
	
	private JToggleButton tbtnVerContraseña;
	
	private JLabel lblContraseñaAnterior;
	private JLabel lblContraseñaNueva;
	

//Cambiar contraseña solo para Admin
	public VentanaContraseñaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300); // Establecer tamaño
		setTitle("Contraseña Admin"); // Agregar Titulo
		setLocationRelativeTo(null);// salga en el centro
    setResizable(false);
		iniciarComponentes();
	}

/*El método iniciarComponentes, nos sirve para serparar los 
  componentes de la ventana principal
  @return Nothing
  */
	public void iniciarComponentes() {
		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(null);

		btnOk = new JButton();
		btnOk.setText("Guardar");
		btnOk.addActionListener(this);
		btnOk.setBounds(40, 170, 100, 30);
    btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnSalir = new JButton();
		btnSalir.setText("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(150, 170, 100, 30);
    btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));

		txtContraseñaAnterior = new JTextField();
		txtContraseñaAnterior.setBounds(60, 50, 150, 20);
		txtContraseñaAnterior.addActionListener(this);
		txtContraseñaAnterior.setVisible(false);
		
		ftxtContraseñaAnterior = new JPasswordField();
		ftxtContraseñaAnterior.setBounds(60, 50, 150, 20);
		ftxtContraseñaAnterior.setVisible(true);
		
		txtContraseñaNueva = new JTextField();
		txtContraseñaNueva.setBounds(60, 120, 150, 20);
		txtContraseñaNueva.setVisible(false);
		
		ftxtContraseñaNueva = new JPasswordField();
		ftxtContraseñaNueva.setBounds(60, 120, 150, 20);
		ftxtContraseñaNueva.setVisible(true);
		
		
		
		tbtnVerContraseña = new JToggleButton();
		tbtnVerContraseña.setBounds(230, 80, 30, 30);
		tbtnVerContraseña.addActionListener(this);
		
		lblContraseñaAnterior = new JLabel();
		lblContraseñaAnterior.setText("Contraseña Anterior: ");
		lblContraseñaAnterior.setBounds(60, 30, 150, 20);
		
		lblContraseñaNueva = new JLabel();
		lblContraseñaNueva.setText("Contraseña Nueva: ");
		lblContraseñaNueva.setBounds(60, 100, 150, 20);
		
		
		
		ImageIcon imagen1 = new ImageIcon("img/ojoCerrado.png");
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
		tbtnVerContraseña.setIcon(icono1);
		

		pnlPrincipal.add(btnOk);
		pnlPrincipal.add(btnSalir);
		pnlPrincipal.add(txtContraseñaAnterior);
		pnlPrincipal.add(txtContraseñaNueva);
		pnlPrincipal.add(ftxtContraseñaAnterior);
		pnlPrincipal.add(ftxtContraseñaNueva);
		pnlPrincipal.add(tbtnVerContraseña);
		pnlPrincipal.add(lblContraseñaAnterior);
		pnlPrincipal.add(lblContraseñaNueva);
		add(pnlPrincipal);

		this.setVisible(true);
	
	}
	/*
  El método actionPerformed nos permite que los elementos de Java 
  Swing respondan a la interaccion
  @param ActionEvent e
  @return Nothing
  */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==tbtnVerContraseña) {
			if(tbtnVerContraseña.isSelected()==true) {
				ImageIcon imagen2 = new ImageIcon("img/ojoAbierto.png");
				Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
				tbtnVerContraseña.setIcon(icono2);
				
				txtContraseñaNueva.setText(ftxtContraseñaNueva.getText());
				txtContraseñaNueva.setVisible(true);
				
				txtContraseñaAnterior.setText(ftxtContraseñaAnterior.getText());
				txtContraseñaAnterior.setVisible(true);
			}
			else {
				ImageIcon imagen1 = new ImageIcon("img/ojoCerrado.png");
				Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
				tbtnVerContraseña.setIcon(icono1);
				
        ftxtContraseñaAnterior.setText(txtContraseñaAnterior.getText());

        
        ftxtContraseñaNueva.setText(txtContraseñaNueva.getText());
				txtContraseñaNueva.setVisible(false);
				txtContraseñaAnterior.setVisible(false);
				
			}
			
		}
		else if(e.getSource()==btnOk) {
      
			this.dispose();
		}
    else if(e.getSource()==btnSalir) {
			this.dispose();
		}

	}
	
	
}