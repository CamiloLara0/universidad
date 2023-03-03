import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class VentanaImprimirVacunados extends JFrame implements ActionListener{
	
	
	private JButton btnOk;
	private JButton btnSalir;
	
	private JLabel lblLista;
	
	private JTextArea txtArea;
	
	private JPanel pnlPrincipal;
  private JPanel pnlAreaImprimir;

	private String texto;

  private Facultad fact;

  private JTable tblImprimirVacunados;    
	
	

	public VentanaImprimirVacunados(Facultad f) {
    fact=f;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(500, 500); //Establecer tamaño
		setTitle("Vacunados"); //Agregar Titulo
		setLocationRelativeTo(null);//salga en el centro
    //add(new JScrollPane(tblImprimirVacunados), BorderLayout.CENTER);
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
		btnOk.setBounds(100, 400, 130, 40);
		btnOk.addActionListener(this);
    btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnSalir = new JButton();
		btnSalir.setText("Salir");
		btnSalir.setBounds(250, 400, 130, 40);
		btnSalir.addActionListener(this);
    btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblLista = new JLabel();
		lblLista.setText("Lista: ");
		lblLista.setBounds(50, 30, 50, 30);
		
		txtArea = new JTextArea();
		
    //acá iria el metodo de listar
	//	txtArea.setText(fact.Listar());

    JScrollPane scroll = new JScrollPane(txtArea);
    scroll.setBounds(50, 70, 400, 250);
		txtArea.setText(fact.Listar());


		
    //Toca agregar un scrooll pane
    //Intento de hacer una tabla en lugar de un txtArea:

     

     

      
     

		
		pnlPrincipal.add(btnOk);
		pnlPrincipal.add(btnSalir);
		pnlPrincipal.add(lblLista);
    pnlPrincipal.add(scroll);
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
		if(e.getSource()==btnSalir){
      this.dispose();
    }
    else if(e.getSource()==btnOk){
      this.dispose();
    }
	}
} 