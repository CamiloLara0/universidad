import java.io.*;
import javax.swing.*;
import java.awt.*;

class Universidad implements Serializable{

  //Tamvien tenenmos las contraseñas pero de cada facultad
  private String[] contraseñas={"ingenieriacontraseña","cienciascontraseña","tecnologiacontraseña","artescontraseña", "ambientencontraseña","superadmincontraseña"}; 
  private String nombre="super admin";
  private int totaldosis=0;
  private Facultad a= new Facultad("ingenieria");
  private Facultad b= new Facultad("ciencias");
  private Facultad c= new Facultad("tecnologia");
  private Facultad d= new Facultad("artes");
  private Facultad e= new Facultad("medio ambiente");
  private Facultad actual;
  private Facultad actualdos[];

  /*
  El método validar nos sirve para verificar si el usuario ingresado coincide con la contraseña asignada
  @param x
  @return Nothing
  */
public void validar(int x){
if(x==0){
actual=a;
}if(x==1){
actual=b;
}if(x==2){
actual=c;
}if(x==3){
actual=d;
}if(x==4){
actual=e;
}if(x==5){
actualdos = new Facultad[5];
actualdos[0]=a;
actualdos[1]=b;
actualdos[2]=c;
actualdos[3]=d;
actualdos[4]=e;
}
}

/*
El método mst nos sirve para comprobar en consola, a que facultad 
ingresamos
@return Nothing
*/
public void mst(){
  System.out.println(actual.getNom());
}

/*
El método getContraseña nos permite obtener la contraseña de x 
posicion del arreglo
@return String contraseñas
*/

public String[] getContraseña(){
  return contraseñas;
}

/*
El método setContraseña nos permite establecer la contraseña "a" 
en la posicion "id"
@param id
@param actual
@return Nothing
*/
public void setContraseña(int id, String a){
  contraseñas[id]=a;
}

/*
El método añadir nos permite añadir dosis, dependiendo de la facultad "x"
@param Facultad x
*/
public void Añadir(Facultad x){
      int nnd=0;
      String nd=JOptionPane.showInputDialog(null,"digite cantidad de dosis a añadir");
      nnd=Integer.parseInt(nd);
      x.setDosisFacultad(nnd);
}

/*
Este método nos permite saber en que facultad estamos trabajando
@return Facultad actual
*/
public Facultad getFacultad(){
  return actual;
}
/*
Este método nos permite saber en que facultad estamos trabajando
@return Facultad actualdos
*/
public Facultad[] getCadena(){
  return actualdos;
}
/*
El método setDosisUniversidad nos permite dar las dosis a la 
Universidad 
@param int a
@return Nothing
*/
public void setDosisUniversidad(int a){
  totaldosis=a;
}
/*
El método getDosisUniversidad nos permite saber las dosis de la Universidad
@return int totaldosis
*/
public int getDosisUniversidad(){
  return totaldosis;
}

}

