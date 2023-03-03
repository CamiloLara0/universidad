
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;



public class VentanaCambiarContraseñasAdmins extends JFrame implements ActionListener{

	private JPanel pnlPrincipal;

	private JButton btnOk;
	private JButton btnSalir;

	private JComboBox<String> cboxFacultades;

	private JTextField txtContraseñaNueva;
	private JPasswordField ftxtContraseñaNueva;
	
	private JToggleButton tbtnVerContraseña;
	
	private JLabel lblContraseñaAbierta;
	private JLabel lblContraseñaCerrada;
	private VentanaIngreso nueva;
  int id;
//Cambiar contraseñas desde Admin a facultades
	public VentanaCambiarContraseñasAdmins(VentanaIngreso z,int ide) {
    nueva=z;
    id=ide;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(300, 300); // Establecer tamaño
		setTitle("Cambiar Contraseña Admins"); // Agregar Titulo
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
		btnOk.setBounds(40, 170, 100, 30);
    btnOk.addActionListener(this);
    btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnSalir = new JButton();
		btnSalir.setText("Salir");
		btnSalir.setBounds(150, 170, 100, 30);
    btnSalir.addActionListener(this);
    btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));

		cboxFacultades = new JComboBox<String>();
		cboxFacultades.setBounds(40, 50, 200, 20);
		cboxFacultades.addItem("Facultades");
		cboxFacultades.addItem("ASAB");
		cboxFacultades.addItem("Ciencias y Educación");
		cboxFacultades.addItem("Ingenieria");
		cboxFacultades.addItem("Medio Ambiente y recursos Naturales");
		cboxFacultades.addItem("Tecnológica");
		cboxFacultades.setSelectedIndex(0);
    cboxFacultades.setVisible(false);
		
		txtContraseñaNueva = new JTextField();
		txtContraseñaNueva.setBounds(60, 120, 150, 20);
		txtContraseñaNueva.setVisible(false);
		
		ftxtContraseñaNueva = new JPasswordField();
		ftxtContraseñaNueva.setBounds(60, 120, 150, 20);
		ftxtContraseñaNueva.setVisible(true);
		
		tbtnVerContraseña = new JToggleButton();
		tbtnVerContraseña.setBounds(230, 110, 30, 30);
    tbtnVerContraseña.addActionListener(this);
		
		ImageIcon imagen1 = new ImageIcon("img/ojoCerrado.png");
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
		tbtnVerContraseña.setIcon(icono1);
		

		pnlPrincipal.add(btnOk);
		pnlPrincipal.add(btnSalir);
		pnlPrincipal.add(cboxFacultades);
		pnlPrincipal.add(txtContraseñaNueva);
		pnlPrincipal.add(ftxtContraseñaNueva);
		pnlPrincipal.add(tbtnVerContraseña);
		add(pnlPrincipal);
    this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
    /*
  El método actionPerformed nos permite que los elementos de Java 
  Swing respondan a la interaccion
  @param ActionEvent e
  @return Nothing
  */
		if (e.getSource()==tbtnVerContraseña) {
			if(tbtnVerContraseña.isSelected()==true) {
				ImageIcon imagen2 = new ImageIcon("img/ojoAbierto.png");
				Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
				tbtnVerContraseña.setIcon(icono2);

        txtContraseñaNueva.setText(ftxtContraseñaNueva.getText());
          ftxtContraseñaNueva.setText(txtContraseñaNueva.getText());
          txtContraseñaNueva.setVisible(true);
          ftxtContraseñaNueva.setVisible(false);
			    
      }
      else{
        
    	ImageIcon imagen1 = new ImageIcon("img/ojoCerrado.png");
		  Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
		  tbtnVerContraseña.setIcon(icono1);

          if(txtContraseñaNueva.getText().isEmpty()){
              txtContraseñaNueva.setText(ftxtContraseñaNueva.getText());
          }else{
            ftxtContraseñaNueva.setText(txtContraseñaNueva.getText());
          }

          txtContraseñaNueva.setVisible(false);
          ftxtContraseñaNueva.setVisible(true);
    }
    }
    
		else if(e.getSource()==btnOk) {
      ftxtContraseñaNueva.setText(txtContraseñaNueva.getText());
      String ncon=ftxtContraseñaNueva.getText();
      nueva.setContraseña(id,ncon);
      nueva.guardarDatos();
		this.dispose();
		}
    else if(e.getSource()==btnSalir){
      this.dispose();
    }
	}
 
}