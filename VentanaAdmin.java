import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
import java.util.Objects;
import java.awt.*;

public class VentanaAdmin extends JFrame implements ActionListener {
  /*
  El método actionPerformed nos permite que los elementos de Java 
  Swing respondan a la interaccion
  @param ActionEvent e
  @return Nothing
  */
	public void actionPerformed(ActionEvent e){
  if(e.getSource()==btnImprimirVacunados){
    //fac2.crearPlan();
    //fac2.AsignarDosis();
    fac2.Listar();
    new VentanaImprimirVacunados(fac2);
    System.out.println(fac2.getNom());
  }else if(e.getSource()==btnContraseña){
    getIde();
    new VentanaCambiarContraseñasAdmins(univ,ide);
  }else if(e.getSource()==btnDistribuirDosis){
      System.out.println(fac2.getDosisFacultad());
      fac2.crearPlan();
      fac2.AsignarDosis();
  }else if(e.getSource()==btnCrearEstudiante){
      new Ingreso(fac2);
  }else if(e.getSource()==btnSalir){
    univ.guardarDatos();
   univ.setVisible(true);
   this.dispose();
  }
}
	private JPanel pnlPrincipal;
	
	private JButton btnDistribuirDosis;
	private JButton btnContraseña;
	private JButton btnCrearEstudiante;
	private JButton btnImprimirVacunados;
	private JButton btnSalir; 
	private Facultad fac2;
  private int ide;
  private String facultad;
	private VentanaIngreso univ;

  /*
  El método constructor recibira:
  @param String f 
  @param Facultad fc
  @param VentanaIngreso u
  */
 
	public VentanaAdmin(String f,Facultad fc,VentanaIngreso u) {
		fac2=fc;
    univ=u;
		setSize(500, 500); //Establecer tamaño
		setTitle("facultad de "+f); //Agregar Titulo
		setLocationRelativeTo(null);//salga en el centro
    setResizable(false);
		iniciarComponentes();

	
	}

  /*
  El metodo getIde nos permite obtener el numero correspondiente a la identificación de cada facultad
  @return Nothing
  */
  public void getIde(){
    if(Objects.equals("ingenieria",facultad)){
      ide=0;
    }if(Objects.equals("ciencias",facultad)){
      ide=1;
    }
    if(Objects.equals("tecnologia",facultad)){
      ide=2;
    }if(Objects.equals("artes",facultad)){
      ide=3;
    }if(Objects.equals("ambiente",facultad)){
      ide=4;
    }
  }
 
	/*El método iniciarComponentes, nos sirve para serparar los 
  componentes de la ventana principal
  @return Nothing
  */
	private void iniciarComponentes() {
		
			pnlPrincipal = new JPanel();
			pnlPrincipal.setLayout(null);
		
			btnDistribuirDosis = new JButton();
			btnDistribuirDosis.setText("<html><center>Distribuir dosis<html>");
			btnDistribuirDosis.setBounds(70, 30, 130, 60);
      btnDistribuirDosis.addActionListener(this);
      btnDistribuirDosis.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			btnContraseña = new JButton();
			btnContraseña.setText("<html><center>Contraseña<html>");
			btnContraseña.setBounds(270, 30, 130, 60);
      btnContraseña.addActionListener(this);
      btnContraseña.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			btnCrearEstudiante = new JButton();
			btnCrearEstudiante.setText("<html><center>Crear Estudiante<html>");
			btnCrearEstudiante.setBounds(70, 130, 130, 60);
			btnCrearEstudiante.addActionListener(this);
      btnCrearEstudiante.setCursor(new Cursor(Cursor.HAND_CURSOR));

			btnImprimirVacunados = new JButton();
			btnImprimirVacunados.setText("<html><center>Imprimir Vacunados<html>");
			btnImprimirVacunados.setBounds(270, 130, 130, 60);
      btnImprimirVacunados.addActionListener(this);
      btnImprimirVacunados.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			btnSalir = new JButton();
			btnSalir.setText("cerrar sesión");
			btnSalir.setBounds(170, 400, 130, 40);
      btnSalir.addActionListener(this);
      btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			pnlPrincipal.add(btnDistribuirDosis);	
			pnlPrincipal.add(btnContraseña);
			pnlPrincipal.add(btnCrearEstudiante);
			pnlPrincipal.add(btnImprimirVacunados);
			pnlPrincipal.add(btnSalir);
			add(pnlPrincipal);
      this.setVisible(true);
	}
  
}