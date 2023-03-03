/**
* Desarrollamos un un programa que permite la asignacion
*de cupos para administrar las vacunas a los estudiantes
*y profesores de la facultad, este programa debe permitir ingresar
* los datos demográficos y de riesgo edpidemiológico
* de los estudiantes y de sus familiares, así como el de 
* los profesores. Con esta información, el programa debe generar
* un plan de vacunacion priorizando los estudiantes y profesores 
* con mayor riesgo de contagio, incluyendo el seguimiento para 
* la segundas dosis.
*
* @author Emmanuel Guerrero 
* @author Camilo Lara
* @author Jhonatan Moreno
* @author David Nieto
*
* @version 1.0
* @since   2021-09-21 
*/
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/*En la clase principal, se llama la ventana de Ingreso, la cual
*Es la fundamental y la principal
*/
class Main{
  private static VentanaIngreso a; 
  public static void main(String[] args){
   a = new VentanaIngreso();
   a.recuperarDatos();
   a.ventana(a);
  }

}
