import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.awt.font.*;
import java.io.*;

class Ingreso extends JFrame implements ActionListener{

  /*
  El método actionPerformed nos sirve para capturar los eventos con 
  los objetos interactivos en un JFrame, para a su vez asignarles 
  acciones
  */
public void actionPerformed(ActionEvent e){
  if(e.getSource()==btnIngresar){
   facul.setNumeroEstudiantes(Integer.parseInt(nombre.getText()));
   for(int i=0;i<facul.getEstudiantes();i++){ 
      new VentanaCrearEstudiante(facul,i);
    }
   //if(facul.getAnt()==facul.getEstudiantes())/*{
      
   /* }else{
      int cre=facul.getEstudiantes()-facul.getAnt();
      for(int i=cre;i<facul.getEstudiantes();i++){
      new VentanaCrearEstudiante(facul,i);
       }
    }*/
   this.dispose();
  }else if(e.getSource()==btnSalir){
   this.dispose();
  }
}

//Creamos los arreglos con los ususarios y las contraseñas iniciales
private String [] facultad = {"ingenieria","ciencias","tecnologia","artes", "ambiente","admin"};
private String [] contraseñas = {"ingenieriacontraseña","cienciascontraseña","tecnologiacontraseña","artescontraseña", "ambientencontraseña","superadmincontraseña"}; 

//Creamos los elementos, botones, cajas de texto...
private JButton btnIngresar;
private JButton btnSalir;
private JTextField nombre = new JTextField();
private JTextField clave= new JTextField();
private String a="",b="";
private int x=25;
int na=0;
private Facultad facul;
public Ingreso(Facultad fc){
facul=fc;
facul.crearAleatorio();
this.setTitle("Ingresa el numero de estudiantes");
this.setSize(200,150);
this.getContentPane().setBackground(Color.BLACK);
this.setLocationRelativeTo(null);
this.setLayout(new BorderLayout());

btnIngresar =new JButton("ingresar");
btnIngresar.addActionListener(this);
btnIngresar.setBounds(150,50, 100,30);
btnSalir =new JButton("salir");
btnSalir.addActionListener(this);
btnSalir.setBounds(150,50, 100,30);
btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));

JPanel panelBotones = new JPanel();
panelBotones.setPreferredSize(new Dimension(400,65));
panelBotones.setBackground(Color.white);
panelBotones.setLayout(new FlowLayout());
panelBotones.add(btnIngresar);
panelBotones.add(btnSalir);


JPanel panelEncabezado = new JPanel();
panelEncabezado.setPreferredSize(new Dimension(400,50) );
panelEncabezado.setLayout(new GridLayout (2,0));
panelEncabezado.add(nombre);

//Añadimos los paneles 
this.add(panelBotones, BorderLayout.CENTER);
this.add(panelEncabezado, BorderLayout.NORTH);
this.setVisible(true);
}

public void setContraseña(int id, String a){
  contraseñas[id]=a;
}
}