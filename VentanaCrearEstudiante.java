
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;



public class VentanaCrearEstudiante extends JFrame implements ActionListener, KeyListener{
	
	private JLabel lblNombre;
	private JLabel lblLocalidad;
	private JLabel lblEdad;
	private JLabel lblGenero;
	private JLabel lblCormobilidades;
	private JLabel lblCormobilidadesFamiliares;
	
	
	private JTextField txtNombre;
	private JFormattedTextField ftxtEdad;
	
	private JComboBox<String> cboxGenero;
	private JComboBox<String> cboxLocalidad;
	
	private JPanel pnlPrincipal;
	private JPanel pnlCormobilidades;
	private JPanel pnlCormobilidadesFamiliares;
	
	private JCheckBox checkCormobilidad1; //Vale 1 Punto
	private JCheckBox checkCormobilidad2; //Vale 1 Punto
	private JCheckBox checkCormobilidad3; //Vale 1 Punto
	private JCheckBox checkCormobilidad4; //Vale 2 Puntos
	private JCheckBox checkCormobilidad5; //Vale 2 Puntos
	private JCheckBox checkCormobilidad6; //Vale 2 Puntos
	private JCheckBox checkCormobilidad7; //Vale 3 Puntos
	private JCheckBox checkCormobilidad8; //Vale 3 Puntos
	private JCheckBox checkCormobilidad9; //Vale 0 Puntos
	
	private JCheckBox checkCormobilidad12; //Vale 1 Punto
	private JCheckBox checkCormobilidad22; //Vale 1 Punto
	private JCheckBox checkCormobilidad32; //Vale 1 Punto
	private JCheckBox checkCormobilidad42; //Vale 2 Puntos
	private JCheckBox checkCormobilidad52; //Vale 2 Puntos
	private JCheckBox checkCormobilidad62; //Vale 2 Puntos
	private JCheckBox checkCormobilidad72; //Vale 3 Puntos
	private JCheckBox checkCormobilidad82; //Vale 3 Puntos
	private JCheckBox checkCormobilidad92; //Vale 0 Puntos
	
	private JButton btnOk;
	private JButton btnSalir;
	private Facultad nf;
  private Estudiante est;
  private int ide,corm=0,cormf=0;
  
  /*
El metodo crear, recibe los datos del JFRame para convertirlos en Strings, int...
@return Nothing
  */
	public void crear(){
    int dosis=0;
    String nom=txtNombre.getText();
    int edad=Integer.parseInt(ftxtEdad.getText());
    String genero=((String)cboxGenero.getSelectedItem());
    String ubicacion=((String) cboxLocalidad.getSelectedItem());
    est = new Estudiante(ide,nom,corm,cormf,genero,edad,dosis,ubicacion);
  } 
	/*
  El método constructor recibe la facultad y la identificacion en 
  el arreglo

 @param facultad fc
 @param int id
  */
	public VentanaCrearEstudiante (Facultad fc, int id) {
    nf = fc;
    ide=id;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(500, 600); //Establecer tamaño
		setTitle("Crear Estudiante"); //Agregar Titulo
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
		
		lblNombre = new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setBounds(15, 15, 90, 15);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(15, 35, 150, 25);
    txtNombre.addKeyListener(this);
		
		lblLocalidad = new JLabel();
		lblLocalidad.setText("Localidad");
		lblLocalidad.setBounds(300, 15, 150, 15);
		
		cboxLocalidad = new JComboBox();
		cboxLocalidad.setBounds(300, 35, 150, 25);
		cboxLocalidad.addItem("Seleccione");
		cboxLocalidad.addItem("01-Usaquen");
		cboxLocalidad.addItem("02-Chapinero");
		cboxLocalidad.addItem("03-Santa fe");
		cboxLocalidad.addItem("04-San Cristobal");
		cboxLocalidad.addItem("05-Usme");
		cboxLocalidad.addItem("06-Tunjuelito");
		cboxLocalidad.addItem("07-Bosa");
		cboxLocalidad.addItem("08-Kenndy");
		cboxLocalidad.addItem("09-Fontibón");
		cboxLocalidad.addItem("10-Engativá");
		cboxLocalidad.addItem("11-Suba");
		cboxLocalidad.addItem("12-Barrios Unidos");
		cboxLocalidad.addItem("13-Teusaquillo");
		cboxLocalidad.addItem("14-Los Mártires");
		cboxLocalidad.addItem("15-Antonio Nariño");
		cboxLocalidad.addItem("16-Puente Aranda");
		cboxLocalidad.addItem("17-La Candelaria");
		cboxLocalidad.addItem("18-Rafael Uribe Uribe");
		cboxLocalidad.addItem("19-Ciudad Bolivar");
		cboxLocalidad.addItem("20-Sumapaz");
		cboxLocalidad.addItem("21-Fuera de Bogotá");
		cboxLocalidad.setSelectedIndex(0);
		
		
		lblEdad = new JLabel();
		lblEdad.setText("Edad");
		lblEdad.setBounds(15, 95, 50, 15);
		
		
		
		 try {
			 MaskFormatter mascara = new MaskFormatter ("##");
			 ftxtEdad = new JFormattedTextField(mascara);
			 ftxtEdad.setBounds(15, 115, 150, 25);
       ftxtEdad.addKeyListener(this);
		 }catch(Exception ex) {}
		 
		
		lblGenero = new JLabel();
		lblGenero.setText("Genero");
		lblGenero.setBounds(300, 95, 90, 15);
		
		cboxGenero = new JComboBox();
		cboxGenero.setBounds(300, 115, 150, 25);
		cboxGenero.addItem("Seleccione");
		cboxGenero.addItem("Masculino");
		cboxGenero.addItem("Femenino");
		cboxGenero.addItem("Otr@");
		cboxGenero.setSelectedIndex(0);
		
		lblCormobilidades = new JLabel();
		lblCormobilidades.setText("Cormobilidades estudiante");
		lblCormobilidades.setBounds(20, 160, 210, 35);
		lblCormobilidades.setVisible(true);
		
		checkCormobilidad1 = new JCheckBox();
		checkCormobilidad1.setText("Hipertensión");
		checkCormobilidad1.setBounds(20, 190, 120, 35);
		checkCormobilidad1.setVisible(true);
		checkCormobilidad1.addActionListener(this);
		
		checkCormobilidad2 = new JCheckBox();
		checkCormobilidad2.setText("Diabetes");
		checkCormobilidad2.setBounds(20, 200+20, 90, 35);
		checkCormobilidad2.setVisible(true);
		checkCormobilidad2.addActionListener(this);
		
		checkCormobilidad3 = new JCheckBox();
		checkCormobilidad3.setText("Obesidad");
		checkCormobilidad3.setBounds(20, 230+20, 110, 35);
		checkCormobilidad3.setVisible(true);
		checkCormobilidad3.addActionListener(this);
		
		checkCormobilidad4 = new JCheckBox();
		checkCormobilidad4.setText("Insf. Cardiaca");
		checkCormobilidad4.setBounds(150, 190, 130, 35);
		checkCormobilidad4.setVisible(true);
		checkCormobilidad4.addActionListener(this);
		
		checkCormobilidad5 = new JCheckBox();
		checkCormobilidad5.setText("Asma");
		checkCormobilidad5.setBounds(150, 200+20, 90, 35);
		checkCormobilidad5.setVisible(true);
		checkCormobilidad5.addActionListener(this);
		
		checkCormobilidad6 = new JCheckBox();
		checkCormobilidad6.setText("Vih");
		checkCormobilidad6.setBounds(150, 230+20, 90, 35);
		checkCormobilidad6.setVisible(true);
		checkCormobilidad6.addActionListener(this);
		
		checkCormobilidad7 = new JCheckBox();
		checkCormobilidad7.setText("Autismo");
		checkCormobilidad7.setBounds(280, 170+20, 90, 35);
		checkCormobilidad7.setVisible(true);
		checkCormobilidad7.addActionListener(this);
		
		checkCormobilidad8 = new JCheckBox();
		checkCormobilidad8.setText("Enf. Pulmonar");
		checkCormobilidad8.setBounds(280, 200+20, 190, 35);
		checkCormobilidad8.setVisible(true);
		checkCormobilidad8.addActionListener(this);
		
		checkCormobilidad9 = new JCheckBox("Ninguna", true);
		checkCormobilidad9.setBounds(280, 230+20, 90, 35);
		checkCormobilidad9.setVisible(true);
		checkCormobilidad9.addActionListener(this);
		
		
		///////////////////////////////////////////////////////////////
		
		lblCormobilidadesFamiliares = new JLabel();
		lblCormobilidadesFamiliares.setText("Cormobilidades Familiares");
		lblCormobilidadesFamiliares.setBounds(20, 240+60, 190, 35);
		
		checkCormobilidad12 = new JCheckBox();
		checkCormobilidad12.setText("Hipertensión");
		checkCormobilidad12.setBounds(20, 270+60, 120, 35);
		checkCormobilidad12.setVisible(true);
		checkCormobilidad12.addActionListener(this);
		
		checkCormobilidad22 = new JCheckBox();
		checkCormobilidad22.setText("Diabetes");
		checkCormobilidad22.setBounds(20, 300+60, 90, 35);
		checkCormobilidad22.setVisible(true);
		checkCormobilidad22.addActionListener(this);
		
		checkCormobilidad32 = new JCheckBox();
		checkCormobilidad32.setText("Obesidad");
		checkCormobilidad32.setBounds(20, 390, 110, 35);
		checkCormobilidad32.setVisible(true);
		checkCormobilidad32.addActionListener(this);
		
		checkCormobilidad42 = new JCheckBox();
		checkCormobilidad42.setText("Insf. Cardiaca");
		checkCormobilidad42.setBounds(150, 330, 130, 35);
		checkCormobilidad42.setVisible(true);
		checkCormobilidad42.addActionListener(this);
		
		checkCormobilidad52 = new JCheckBox();
		checkCormobilidad52.setText("Asma");
		checkCormobilidad52.setBounds(150, 300+60, 90, 35);
		checkCormobilidad52.setVisible(true);
		checkCormobilidad52.addActionListener(this);
		
		checkCormobilidad62 = new JCheckBox();
		checkCormobilidad62.setText("Vih");
		checkCormobilidad62.setBounds(150, 330+60, 90, 35);
		checkCormobilidad62.setVisible(true);
		checkCormobilidad62.addActionListener(this);
		
		checkCormobilidad72 = new JCheckBox();
		checkCormobilidad72.setText("Autismo");
		checkCormobilidad72.setBounds(280, 270+60, 90, 35);
		checkCormobilidad72.setVisible(true);
		checkCormobilidad72.addActionListener(this);
		
		checkCormobilidad82 = new JCheckBox();
		checkCormobilidad82.setText("Enf. Pulmonar");
		checkCormobilidad82.setBounds(280, 300+60, 190, 35);
		checkCormobilidad82.setVisible(true);
		checkCormobilidad82.addActionListener(this);
		
		checkCormobilidad92 = new JCheckBox("Ninguna", true);
		checkCormobilidad92.setBounds(280, 330+60, 90, 35);
		checkCormobilidad92.setVisible(true);
		checkCormobilidad92.addActionListener(this);
		
		
		btnOk = new JButton();
		btnOk.setText("Ok");
		btnOk.setBounds(80, 500, 130, 30 );
    btnOk.setEnabled(false);
    btnOk.addActionListener(this);
    btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnSalir = new JButton();
		btnSalir.setText("Salir");
		btnSalir.setBounds(280, 500, 130, 30 );
		btnSalir.addActionListener(this);
    btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		pnlCormobilidades = new JPanel();
		pnlCormobilidades.setLayout(null);
		pnlCormobilidades.setBounds(10, 170, 400, 100);
//		pnlCormobilidades.setBackground(Color.DARK_GRAY);
		pnlCormobilidades.add(checkCormobilidad1);
		pnlCormobilidades.setVisible(true);
		pnlCormobilidades.add(lblCormobilidades);
		
		pnlPrincipal.add(lblNombre);
		pnlPrincipal.add(txtNombre);
		pnlPrincipal.add(lblLocalidad);
		pnlPrincipal.add(cboxLocalidad);
		pnlPrincipal.add(ftxtEdad);
		pnlPrincipal.add(lblEdad);
		pnlPrincipal.add(lblGenero);
		pnlPrincipal.add(cboxGenero);
		//pnlPrincipal.add(pnlCormobilidades);
		pnlPrincipal.add(checkCormobilidad1);
		pnlPrincipal.add(checkCormobilidad2);
		pnlPrincipal.add(checkCormobilidad3);
		pnlPrincipal.add(checkCormobilidad4);
		pnlPrincipal.add(checkCormobilidad5);
		pnlPrincipal.add(checkCormobilidad6);
		pnlPrincipal.add(checkCormobilidad7);
		pnlPrincipal.add(checkCormobilidad8);
		pnlPrincipal.add(checkCormobilidad9);
		pnlPrincipal.add(checkCormobilidad12);
		pnlPrincipal.add(checkCormobilidad22);
		pnlPrincipal.add(checkCormobilidad32);
		pnlPrincipal.add(checkCormobilidad42);
		pnlPrincipal.add(checkCormobilidad52);
		pnlPrincipal.add(checkCormobilidad62);
		pnlPrincipal.add(checkCormobilidad72);
		pnlPrincipal.add(checkCormobilidad82);
		pnlPrincipal.add(checkCormobilidad92);
		pnlPrincipal.add(lblCormobilidadesFamiliares);
		pnlPrincipal.add(lblCormobilidades);
		pnlPrincipal.add(btnOk);
		pnlPrincipal.add(btnSalir);
		
		
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
  //seccion cormobilidad estudiante 
	public void actionPerformed(ActionEvent e) {
	
    
   if(e.getSource()==checkCormobilidad1) {
      corm+=1;
			checkCormobilidad9.setSelected(false); 	
		}
		else if (e.getSource()==checkCormobilidad2) {
      corm+=1;
			checkCormobilidad9.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad3) {
      corm+=1;
			checkCormobilidad9.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad4) {
      corm+=2;
			checkCormobilidad9.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad5) {
    corm+=2;
			checkCormobilidad9.setSelected(false); 
		}	
		else if(e.getSource()==checkCormobilidad6) {
      corm+=2;
			checkCormobilidad9.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad7) {
      corm+=3;
			checkCormobilidad9.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad8) {
      corm+=3;
			checkCormobilidad9.setSelected(false); 
		}
    else if(e.getSource()==checkCormobilidad9){
      
      checkCormobilidad1.setSelected(false);
      checkCormobilidad2.setSelected(false);
      checkCormobilidad3.setSelected(false);
      checkCormobilidad4.setSelected(false);
      checkCormobilidad5.setSelected(false);
      checkCormobilidad6.setSelected(false);
      checkCormobilidad7.setSelected(false);
      checkCormobilidad8.setSelected(false);
    }
	//seccion de cormobilidad familiares
		else if(e.getSource()==checkCormobilidad12) {
      cormf+=1;
			checkCormobilidad92.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad22) {
      cormf+=1;
			checkCormobilidad92.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad32) {
      cormf+=1;
			checkCormobilidad92.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad42) {
      cormf+=2;
			checkCormobilidad92.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad52) {
      cormf+=2;
			checkCormobilidad92.setSelected(false); 
		}	
		else if(e.getSource()==checkCormobilidad62) {
      cormf+=2;
			checkCormobilidad92.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad72) {
      cormf+=3;
			checkCormobilidad92.setSelected(false); 
		}
		else if(e.getSource()==checkCormobilidad82) {
      cormf+=3;
			checkCormobilidad92.setSelected(false); 
		}
    else if(e.getSource()==checkCormobilidad92){
      
      checkCormobilidad12.setSelected(false);
      checkCormobilidad22.setSelected(false);
      checkCormobilidad32.setSelected(false);
      checkCormobilidad42.setSelected(false);
      checkCormobilidad52.setSelected(false);
      checkCormobilidad62.setSelected(false);
      checkCormobilidad72.setSelected(false);
      checkCormobilidad82.setSelected(false);
    }
    else if(e.getSource()==btnSalir){
      this.dispose();
    }else if(e.getSource()==btnOk){
      crear();
      nf.asignar(est,ide);
      this.dispose();
    }
	}

  //Método para habilitar el botón y hacer el llamado en los KeyListener
  public void HabilitarBoton() {
		if (!txtNombre.getText().isEmpty() && !ftxtEdad.getText().isEmpty()){
			btnOk.setEnabled(true);
	     }
		else {
			btnOk.setEnabled(false);
		}
	}
/*
  El método keyPressed, keyReleased y keyTyped nos permite que los 
  elementos de Java 
  Swing respondan a la interaccion de teclado
  @param KeyEvent e
  @return Nothing
  */
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()==txtNombre) {
			HabilitarBoton();
		}
		else if(e.getSource()==ftxtEdad) {
			HabilitarBoton();
		}
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}

	






