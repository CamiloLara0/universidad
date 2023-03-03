import java.util.ArrayList;
import javax.swing.*;
import java.util.Objects;
import java.awt.Image;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.io.*;


class VentanaIngreso extends JFrame implements ActionListener{
  /*
  El método actionPerformed nos permite que los elementos de Java 
  Swing respondan a la interaccion
  @param ActionEvent e
  @return Nothing
  */
  @Override
public void actionPerformed(ActionEvent e){
  uni=new Universidad();
   rec.recuperarDatos();
  contraseñas = uni.getContraseña();
  if(e.getSource()==btnIngreso){
  b=ftxtContraseña.getText();
   if(confirmar()==true){
    JOptionPane.showMessageDialog(null,"ha ingresado");
    
    uni.validar(x);
    Facultad fact=uni.getFacultad();
    if(Objects.equals("admin",facultad[x])){
    //Facultad facultades[]=;
    System.out.println("entró");
    new VentanaSuperAdmin(uni.getCadena(),uni,rec);
    this.setVisible(false);//
    }else{
      int ds = uni.getDosisUniversidad();
      int dt= ds/5;
      fact.setDosisFacultad(dt);
      uni.mst();
      new VentanaAdmin(facultad[x],fact,rec);
      System.out.println(fact.getDosisFacultad());
      this.setVisible(false);
    }
    
   }else{
     JOptionPane.showMessageDialog(null,"nombre o contraseña incorrectos");
   }
  }else if(e.getSource()==btnSalir){
    rec.guardarDatos();
    System.exit(0);
  }
  else if(e.getSource()==tbtnVerContraseña){
    if(tbtnVerContraseña.isSelected()==true){
      	ImageIcon imagen4 = new ImageIcon("img/ojoAbierto.png");
					Icon icono4 = new ImageIcon(imagen4.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
					tbtnVerContraseña.setIcon(icono4);

          txtContraseña.setText(ftxtContraseña.getText());
          ftxtContraseña.setText(txtContraseña.getText());
          txtContraseña.setVisible(true);
          ftxtContraseña.setVisible(false);
    }else{
      ImageIcon imagen3 = new ImageIcon("img/ojoCerrado.png");
					Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
					tbtnVerContraseña.setIcon(icono3);

          if(txtContraseña.getText().isEmpty()){
              
          }else{
            ftxtContraseña.setText(txtContraseña.getText());
          }
          txtContraseña.setVisible(false);
          ftxtContraseña.setVisible(true);
    }
  }
}
private String [] facultad = {"ingenieria","ciencias","tecnologia","artes", "ambiente","admin"};
private Universidad uni;
private String [] contraseñas;
	private JPanel pnlPrincipal;
	private JPanel pnlNombre;
	private JPanel pnlContraseña;
  private VentanaIngreso rec;
	private JLabel lblNombre;
	private JLabel lblContraseña;

  private JLabel lblIcono;
  private JLabel lblUser;
	
	private JButton btnIngreso;
	private JButton btnSalir;
	
	private JTextField txtNombre;

	private JTextField txtContraseña;

  private JPasswordField ftxtContraseña;

  private JToggleButton tbtnVerContraseña;
	
	private String a="",b="";
  private int x=25;
	
	public VentanaIngreso  () {
		setSize(500, 500); //Establecer tamaño
		setTitle("Ingreso"); //Agregar Titulo;
		setLocationRelativeTo(null);//salga en el centro
		iniciarComponentes();
    setResizable(false);
	}
  public void ventana(VentanaIngreso a){
   rec=a;
  }
  /*El método iniciarComponentes, nos sirve para serparar los 
  componentes de la ventana principal
  @return Nothing
  */
	public void iniciarComponentes() {
		
		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(null);
		
    lblIcono = new JLabel();
    lblIcono.setBounds(0,0, 110, 110);
    lblIcono.setLayout(null);

    ImageIcon imagenUD = new ImageIcon("img/Icono.png");
    Icon iconoUD = new ImageIcon(imagenUD.getImage().getScaledInstance(lblIcono.getWidth(),lblIcono.getHeight(), Image.SCALE_DEFAULT));
    lblIcono.setIcon(iconoUD);

    lblUser = new JLabel();
    lblUser.setBounds(190,15, 110, 110);
    lblUser.setLayout(null);

    ImageIcon imagenUser = new ImageIcon("img/User.png");
    Icon iconoUser = new ImageIcon(imagenUser.getImage().getScaledInstance(lblUser.getWidth(),lblUser.getHeight(), Image.SCALE_DEFAULT));
    lblUser.setIcon(iconoUser);
		
		lblNombre = new JLabel();
		lblNombre.setText("Nombre: ");
		lblNombre.setLayout(null);
		lblNombre.setBounds(120, 0, 150, 50);
    
		
		lblContraseña = new JLabel();
		lblContraseña.setLayout(null);
		lblContraseña.setText("Contraseña:");
		lblContraseña.setBounds(120, 0, 150, 50);
    lblContraseña.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		txtNombre = new JTextField();
		txtNombre.setLayout(null);
		txtNombre.setBounds(50, 60, 200, 30);

    ftxtContraseña = new JPasswordField();
    ftxtContraseña.setLayout(null);
    ftxtContraseña.setBounds(50, 60, 200, 30);
    ftxtContraseña.setVisible(true);

    	tbtnVerContraseña = new JToggleButton();
			tbtnVerContraseña.setBounds(250, 60, 30, 30);
			tbtnVerContraseña.addActionListener(this);

	ImageIcon imagen3 = new ImageIcon("img/ojoCerrado.png");
			Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(tbtnVerContraseña.getWidth(), tbtnVerContraseña.getHeight(), Image.SCALE_DEFAULT));
			tbtnVerContraseña.setIcon(icono3);

		txtContraseña = new JTextField();
		txtContraseña.setLayout(null);
		txtContraseña.setBounds(50, 60, 200, 30);
    txtContraseña.setVisible(false);

		pnlNombre = new JPanel();
		pnlNombre.setLayout(null);
		pnlNombre.setBounds(100, 140, 300, 100);
		pnlNombre.setBackground(Color.LIGHT_GRAY);
		pnlNombre.add(lblNombre);
		pnlNombre.add(txtNombre);
		
		
		pnlContraseña = new JPanel();
		pnlContraseña.setLayout(null);
		pnlContraseña.setBounds(100, 270, 300, 100);
		pnlContraseña.setBackground(Color.LIGHT_GRAY);
		pnlContraseña.add(lblContraseña);
		pnlContraseña.add(txtContraseña);
    pnlContraseña.add(ftxtContraseña);
    pnlContraseña.add(tbtnVerContraseña);
   
		
		btnIngreso = new JButton();
		btnIngreso.setText("Ingreso");
		btnIngreso.setBounds(100, 390, 130, 30 );
		btnIngreso.addActionListener(this);
    btnIngreso.setCursor(new Cursor(Cursor.HAND_CURSOR));



		btnSalir = new JButton();
		btnSalir.setText("salir");
		btnSalir.setBounds(280, 390, 130, 30 );
    btnSalir.addActionListener(this);
    btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
    pnlPrincipal.add(lblIcono);
     pnlPrincipal.add(lblUser);
		pnlPrincipal.add(pnlNombre);
		pnlPrincipal.add(pnlContraseña);
		pnlPrincipal.add(btnIngreso);
		pnlPrincipal.add(btnSalir);
   
    

		add(pnlPrincipal);
		this.setVisible(true);
	}


public boolean confirmar(){
  a=txtNombre.getText();
  b=ftxtContraseña.getText();
  
  //b=txtContraseña.getText(); 
  for(int i=0;i<6;i++){
    if(Objects.equals(a,facultad[i])){
      x=i;
    }
  }if(x>=0 && x<=5){
   if(Objects.equals(b,contraseñas[x])){
     return true;
   }else{
     return false;
   }
  }else{
    return false;
  }
  
}
   public void guardarDatos(){
      try{
      //1. abrir el archivo
      FileOutputStream archivo = new FileOutputStream("./data/uni.data");
      //2. configura el flujo de datos de salida(escritor)
      ObjectOutputStream escritor = new ObjectOutputStream(archivo);
      //3. guardar datos
      escritor.writeObject(uni);
      //4. cerrar flujo de datos
      escritor.close();
      archivo.close();
      System.out.println("datos guardados");
    }catch(IOException e){
    //JOptionPane.showMessageDialog(null,"error de escritura: "+ e);
    e.printStackTrace();
    }
    }
  public void recuperarDatos(){
       //1. abrir el archivo
     try{
      FileInputStream archivo = new FileInputStream("./data/uni.data");
      //2. configura el flujo de datos de entrada(lector)
      ObjectInputStream lector = new ObjectInputStream(archivo);
      //3. guardar datos
      uni = (Universidad)lector.readObject();
      //4. cerrar flujo de datos
      
      lector.close();
      archivo.close();
      System.out.println("datos recuperados");
    }catch(Exception e){
    //JOptionPane.showMessageDialog(null,"error de lectura: "+ e);
    }

}
public int getFac(){
return x;
}

public void setContraseña(int id, String a){
  uni.setContraseña(id,a);
}

}