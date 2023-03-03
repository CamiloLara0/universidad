  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JPanel;

public class VentanaAsignarDosis extends JFrame implements ActionListener {
  /*
  El método actionPerformed nos permite que los elementos de Java 
  Swing respondan a la interaccion
  @param ActionEvent e
  @return Nothing
  */
		public void actionPerformed(ActionEvent e){
  if(e.getSource()==btnOk){
    convertir();
    this.dispose();
  }else if(e.getSource()==btnSalir){
    this.dispose();
  }
}
	private JPanel pnlPrincipal;
	
	private JButton btnOk;
	private JButton btnSalir;
	private Universidad n;
	private JComboBox<String> cboxAsignarDosis;
	
	
	
	
	public VentanaAsignarDosis (Universidad a) {
    n=a;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(300, 300); //Establecer tamaño
		setTitle("Asignar Dosis"); //Agregar Titulo
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
		
		 cboxAsignarDosis= new JComboBox();
		 cboxAsignarDosis.setBounds(60, 90, 150, 20);
		 cboxAsignarDosis.addItem("Seleccione");
     cboxAsignarDosis.addItem("40");
		 cboxAsignarDosis.addItem("100");
		 cboxAsignarDosis.addItem("500");
		 cboxAsignarDosis.addItem("1000");
		 cboxAsignarDosis.setSelectedIndex(0);
		
		pnlPrincipal.add(btnOk);
		pnlPrincipal.add(btnSalir);
		pnlPrincipal.add(cboxAsignarDosis);
		add(pnlPrincipal);
		 this.setVisible(true);
		
	}

  /*
  El método convertir nos permite obtener un número entero ya que
  recibe un objeto del JComboBox
  @return Argumento para setDosisUniversidad
  */
	public void convertir(){
    int cambio = Integer.parseInt(cboxAsignarDosis.getSelectedItem().toString());
    n.setDosisUniversidad(cambio);
  }
	
}