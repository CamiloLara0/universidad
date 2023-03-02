package conversor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NuevaVentana extends JFrame implements ActionListener{
	private JPanel panel =new JPanel();
	private JComboBox<String> combo1,combo2,combo3;
	private String seleccionado=null;
	private Conversor calculo = new Conversor();
	private double cantidad=0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NuevaVentana() {
		setSize(400,400);
		setTitle("Convertidor");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		this.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel label =new JLabel("conversor de moneda y temperatura");
		label.setBounds(90,10,300,30);
		label.setVisible(true);
		panel.add(label);
		combo1();
		
		
	}
	private void combo1() {
		combo1=new JComboBox<String>();
		combo1.setLayout(null);
        combo1.setBounds(120,40,150,20);
        panel.add(combo1);
        combo1.addItem("--seleccione--");
        combo1.addItem("convertir moneda");
        combo1.addItem("convertir temperatura");
        combo1.addActionListener(this);
        combo1.setVisible(true);
	}
	private void combo2() {
		combo2=new JComboBox<String>();
		combo2.setLayout(null);
		combo2.setBounds(120,40,150,20);
        panel.add(combo2);
        combo2.addItem("--seleccione--");
        combo2.addItem("pesos a dolar");
        combo2.addItem("pesos a euro");
        combo2.addItem("pesos a libras");
        combo2.addItem("pesos a yen");
        combo2.addItem("pesos a won");
        combo2.addItem("dolar a pesos");
        combo2.addItem("euro a pesos");
        combo2.addItem("libras a pesos");
        combo2.addItem("yen a pesos");
        combo2.addItem("won a pesos"); 
        combo2.addActionListener(this);
        combo2.setVisible(true);
        
	}
	private void combo3() {
		combo3=new JComboBox<String>();
		combo3.setLayout(null);
        combo3.setBounds(120,40,150,20);
        panel.add(combo3);
        combo3.addItem("--seleccione--");
        combo3.addItem("Celsius a Fahrenheit");
        combo3.addItem("Celsius a Kelvin");
        combo3.addItem("Fahrenheit a celsius");
        combo3.addItem("Fahrenheit a Kelvin");
        combo3.addItem("Kelvin a Fahrenheit");
        combo3.addItem("Kelvin a Celsius");
        combo3.addActionListener(this);
        combo3.setVisible(true);
	}
	private void valorCambio() {
		boolean valido=false;
		do {
			try {
  		      cantidad=Double.parseDouble(JOptionPane.showInputDialog(null,"digite cantidad a convertir"));
  		      valido=true;
  		    } catch (NumberFormatException ex) {
  		    	JOptionPane.showMessageDialog(null,"debe ingresar un numero");
  		    	valido=false;
  		    }
		}while(valido==false);
	}
	private void temperatura() {
		valorCambio();
		  cantidad=calculo.convertirTemperatura(seleccionado, cantidad);
		  JOptionPane.showMessageDialog(null,"La cantidad convertida de "+seleccionado+" es:\n"+cantidad);
    	  cont();
	}
	private void moneda() {
		valorCambio();
		  cantidad=calculo.ConvertirMoneda(seleccionado, cantidad);
		  JOptionPane.showMessageDialog(null,"La cantidad convertida de "+seleccionado+" es:\n"+cantidad);
    	  cont();
	}
	
	private void cont() {
	    String [] botones = { " si", " no"};
	    Object [] boton = { " si", " no"};
	    int variable = JOptionPane.showOptionDialog (null, "¿desea continuar?", "volver", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, boton, botones[0]);
	    if(variable==0) {	
	    	continuar();
	    }else {
	    	System.exit(0);
	    }
	}
	
	private void continuar() {
		try {
		    panel.remove(combo2);
		    panel.add(combo1);
		}catch(RuntimeException ae) {
			panel.remove(combo3);
			panel.add(combo1);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==combo1) {
            seleccionado=(String)combo1.getSelectedItem();
            if(seleccionado=="convertir moneda"){
            	panel.remove(combo1);
            	combo2();
            }else if(seleccionado=="convertir temperatura") {
            	try {
            	panel.remove(combo1);
            	panel.remove(combo2);
            	combo3();
            	}catch(RuntimeException x ) {
            	panel.remove(combo1);
                combo3();
            	}
            }
        }if (e.getSource()==combo2) {
        	seleccionado=(String)combo2.getSelectedItem();
        	moneda();
        }if (e.getSource()==combo3) {
        	seleccionado=(String)combo3.getSelectedItem();
        	temperatura();
        }
	}
	
}
