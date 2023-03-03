
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class VentanaModificarDosis extends JFrame implements ActionListener{
  /*
  El método actionPerformed nos permite que los elementos de Java 
  Swing respondan a la interaccion
  @param ActionEvent e
  @return Nothing
  */
		public void actionPerformed(ActionEvent e){
  if(e.getSource()==btnOk){
    this.dispose();
  }else if(e.getSource()==btnSalir){
    this.dispose();
  }
}
	private JPanel pnlPrincipal;
	
	private JButton btnOk;
	private JButton btnSalir;
	private int n;
	private JComboBox<String> cboxFacultades;
	
	private JLabel lblDosisModificadas;

	private JFormattedTextField ftxtModificarDosis;
	
  
	
	
	
	
	public VentanaModificarDosis (int a) {
    n=a;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(300, 300); //Establecer tamaño
		setTitle("Dosis por facultad"); //Agregar Titulo
		setLocationRelativeTo(null);//salga en el centro
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
		btnOk.setText("Ok");
		btnOk.setBounds(40, 170, 100, 30);
    btnOk.addActionListener(this);
    btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnSalir = new JButton();
		btnSalir.setText("Salir");
		btnSalir.setBounds(150, 170, 100, 30);
    btnSalir.addActionListener(this);
    btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		 cboxFacultades= new JComboBox();
		 cboxFacultades.setBounds(40, 50, 200, 20);
		 cboxFacultades.addItem("Facultades");
		 cboxFacultades.addItem("ASAB");
		 cboxFacultades.addItem("Ciencias y Educación");
		 cboxFacultades.addItem("Ingenieria");
		 cboxFacultades.addItem("Medio Ambiente y recursos Naturales");
		 cboxFacultades.addItem("Tecnológica");
		 cboxFacultades.setSelectedIndex(0);
     cboxFacultades.setVisible(false);

    lblDosisModificadas = new JLabel();

     lblDosisModificadas.setBounds(60, 120, 300, 20);
     lblDosisModificadas.setText("Cada facultad recibio: "+n/5+" dosis");
		
		 try {
			 MaskFormatter mascara = new MaskFormatter ("#####");
			 ftxtModificarDosis = new JFormattedTextField(mascara);
			 ftxtModificarDosis.setBounds(60, 120, 150, 20);
       ftxtModificarDosis.setVisible(false);
		 }catch(Exception ex) {}
		 
		 
		pnlPrincipal.add(btnOk);
		pnlPrincipal.add(btnSalir);
		pnlPrincipal.add(cboxFacultades);
    pnlPrincipal.add(lblDosisModificadas);
		//pnlPrincipal.add(ftxtModificarDosis);
		add(pnlPrincipal);
    
		
		 this.setVisible(true);
	}
}
