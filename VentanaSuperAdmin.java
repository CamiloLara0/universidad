import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;
import java.util.Objects;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class VentanaSuperAdmin extends JFrame implements ActionListener {
  /*
  El método actionPerformed nos permite que los elementos de Java 
  Swing respondan a la interaccion
  @param ActionEvent e
  @return Nothing
  */
public void actionPerformed(ActionEvent e){
    cambiar();
  if(e.getSource()==btnModificarDosis){
    
    new VentanaModificarDosis(unica.getDosisUniversidad());
    int ds = unica.getDosisUniversidad();
    dt= ds/5;
    dosis(dt);
    System.out.println(fac2[0].getDosisFacultad());
    System.out.println(fac2[1].getDosisFacultad());
    System.out.println(fac2[2].getDosisFacultad());
    System.out.println(fac2[3].getDosisFacultad());
    System.out.println(fac2[4].getDosisFacultad());
  }else if(e.getSource()==btnAsignarDosis){
    new VentanaAsignarDosis(unica);
  }else if(e.getSource()==btnAsignarAdmin){
    new VentanaCambiarContraseñasAdmins(vin,ide);
  }else if(e.getSource()==btnContraseña){
    new VentanaContraseñaSuperAdmin();
  } else if (e.getSource()==btnCrearEstudiante){
    new Ingreso(actual);
    if(actual.getAnt()==actual.getEstudiantes()){
      for(int i=0;i<actual.getEstudiantes();i++){
      new VentanaCrearEstudiante(actual,i);
       }
    }else{
      int cre=actual.getAnt()-actual.getEstudiantes();
      for(int i=cre;i<actual.getEstudiantes();i++){
      new VentanaCrearEstudiante(actual,i);
       }
    }
    
  } else if (e.getSource()==btnContraseña){
    
  }else if(e.getSource()==btnSalir){
    vin.guardarDatos();
    vin.setVisible(true);
    this.dispose();
  }else if(e.getSource()==btnRetirar){
   unica.setDosisUniversidad(0);
   retirar();
  }
 
}
 private JButton btnRetirar;
	private JButton btnAsignarDosis;
	private JButton btnModificarDosis;
	private JButton btnCrearEstudiante;
	private JButton btnAsignarAdmin;
	private JButton btnContraseña;
	private JButton btnSalir;
	private Facultad fac2[];
  private Facultad actual;
  private int ide,dt;
  private Universidad unica;
  private VentanaIngreso vin;
  private JComboBox<String> cboxFacultades;
  public void cambiar(){

    /*
    Aqui se da el cambio de Objeto a String, con el fin de leer la 
    facultad con mayor facilidad
    */
    String cambio = ((String) cboxFacultades.getSelectedItem());
    if(Objects.equals(cambio,fac2[0].getNom())){
      actual=fac2[0];
      ide=0;
    }
    else if(Objects.equals(cambio,fac2[1].getNom())){
      actual=fac2[1];
      ide=1;
    }else if(Objects.equals(cambio,fac2[2].getNom())){
      actual=fac2[2];
      ide=2;
    }
    else if(Objects.equals(cambio,fac2[3].getNom())){
      actual=fac2[3];
      ide=3;
    }
    else if(Objects.equals(cambio,fac2[4].getNom())){
      actual=fac2[4];
      ide=4;
    }
  }

  /*
  El método dosis nos sirve para establecer las dosis a cada 
  facultad
  @param int x
  @return Nothing
  */
public void dosis(int x){
 fac2[0].setDosisFacultad(x);
 fac2[1].setDosisFacultad(x);
 fac2[2].setDosisFacultad(x);
 fac2[3].setDosisFacultad(x);
 fac2[4].setDosisFacultad(x);
}

/*
El método retirar nos sirve para retirarle en su totalidad las 
dosis asignadas a toda la universidad
@return Nothing
*/
public void retirar(){
 fac2[0].setDosisFacultad(0);
 fac2[1].setDosisFacultad(0);
 fac2[2].setDosisFacultad(0);
 fac2[3].setDosisFacultad(0);
 fac2[4].setDosisFacultad(0);
}

/*
El método constructor VentanaSuperAdmin va a recibir la facultad, 
un Objeto de Universidad y una ventana Ingreso
@param Facultad []a
@param Universidad f
@param ventana ingreso z
*/
	public VentanaSuperAdmin(Facultad[] a,Universidad f,VentanaIngreso z) {
		fac2 = new Facultad[5];
    fac2=a;
    unica=f;
    vin = z;
		setSize(500, 500); //Establecer tamaño
		setTitle("Super Admin"); //Agregar Titulo
		setLocationRelativeTo(null);//salga en el centro
    setResizable(false);
		iniciarComponentes();

	
	}

  
	/*El método iniciarComponentes, nos sirve para serparar los 
  componentes de la ventana principal
  @return Nothing
  */
	private void iniciarComponentes() {
		setLayout(null);

    cboxFacultades = new JComboBox();
    cboxFacultades.setBounds(40, 50, 200, 20);
		cboxFacultades.addItem("Facultades");
		cboxFacultades.addItem("ingenieria");
		cboxFacultades.addItem("ciencias");
		cboxFacultades.addItem("tecnologia");
		cboxFacultades.addItem("artes");
		cboxFacultades.addItem("ambiente");
		cboxFacultades.setSelectedIndex(0);
		cboxFacultades.addActionListener(this);


    	btnSalir = new JButton();
			btnSalir.setText("cerrar sesión");
			btnSalir.setBounds(170, 400, 130, 40);
      btnSalir.addActionListener(this);
      btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));

      btnRetirar = new JButton();
			btnRetirar.setText("retirar dosis");
			btnRetirar.setBounds(70,270, 130, 50);
      btnRetirar.addActionListener(this);
      btnRetirar.setCursor(new Cursor(Cursor.HAND_CURSOR));

			btnAsignarDosis = new JButton();
			btnAsignarDosis.setText("<html><center>Asignar dosis<html>");
			btnAsignarDosis.setBounds(70, 80, 130, 50);
      btnAsignarDosis.addActionListener(this);
      btnAsignarDosis.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			btnModificarDosis = new JButton();
			btnModificarDosis.setText("<html><center>Modificar dosis<html>");
			btnModificarDosis.setBounds(270, 80, 130, 50);
			btnModificarDosis.addActionListener(this);
      btnModificarDosis.setCursor(new Cursor(Cursor.HAND_CURSOR));

			btnCrearEstudiante = new JButton();
			btnCrearEstudiante.setText("<html><center>Crear estudiantes<html>");
			btnCrearEstudiante.setBounds(70, 180, 130, 50);
			btnCrearEstudiante.addActionListener(this);
      





			btnAsignarAdmin = new JButton();
			btnAsignarAdmin.setText("<html><center>Asignar Admin<html>");
			btnAsignarAdmin.setBounds(270, 180, 130, 50);
			btnAsignarAdmin.addActionListener(this);
      btnAsignarAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			btnContraseña = new JButton();
			btnContraseña.setText("<html><center>Contraseña<html>");
			btnContraseña.setBounds(270, 270, 130, 50);
			btnContraseña.addActionListener(this);
      btnContraseña.setCursor(new Cursor(Cursor.HAND_CURSOR));


			
			
			add(btnAsignarDosis);	
			add(btnModificarDosis);
			add(btnCrearEstudiante);
			add(btnAsignarAdmin);
			add(btnContraseña);
      add(cboxFacultades);
      add(btnSalir);
      add(btnRetirar);
      this.setVisible(true);
	}
	

	
	
	
}