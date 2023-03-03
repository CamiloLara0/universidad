import javax.swing.*;

//La clase estudiante nos sirve para crear y almacenar los estudiantes

class Estudiante implements java.io.Serializable{


  private String nombre,genero,carrera,ubicacion,facultad,fecha1,fecha2;
  private int edad, ide,corm,cormf, dosis=0;
  
  /**El método constructor va a recibir 
 @param id - identificación
 @param nom - nombre
 @param cor - cormobilidades
 @param ed - edad
 @param d - dosis
 @param ub - ubicación
*/
  public Estudiante(int id,String nom, int cor,int corf,String gener, int ed, int d,String ub){
   nombre=nom;
   corm=cor;
   cormf=corf;
   genero=gener;
   edad=ed;
   dosis=d;
   ide= id;
   ubicacion=ub;
  }

/*El método toString nos servirá para organizar los datos
  @return String - Atributos del estudiante
*/
  public String toString(){
     String aux="";
        aux+="Nombre: "+nombre+"\n";
        aux+="carrera: "+carrera+" | edad: "+edad+"dosis ";
        return aux;
  }
  
  /*
  El método setFechas nos servirá para dar fechas especificas
  @param f - fecha1
  @param ff - fecha2
  */
  public void setFechas(String f,String ff){
    fecha1= f;
    fecha2= ff;
  }
  /*
  El método getIde nos da la identificación
  @return int ide
  */
  public int getIde(){
   return this.ide;
 }
   /*
  El método setIde nos permite dar una identificación
  @return Nothing
  */
  public void setIde(){
   ide= this.getIde();
 }
   /*
  El método getNombre nos permite establecer un nombre
  @return String Nombre
  */
  public String getNombre(){
    return nombre;
  }
    /*
  El método setNombre nos permite establecer un nombre
  @return Nothing
  */
  public void setNombre(){
    nombre= this.getNombre();
  }
    /*
  El método getDosis nos da las dosis
  @return int dosis
  */
  public int getDosis(){
   return dosis;
 }
   /*
  El método setDosis nos permite darle las dosis
  @return nothing
  */
  public void setDosis(int x){
   //dosis= x;
   dosis= Math.min(2, dosis+x);
  }
  /*
  El método getCormobilidad nos permite obtener las cormobilidades
  @return String corm
  */
  public int getCormobilidad(){
    return corm;
  }
    /*
  El método setCormobilidad nos permite adicionarle cormobilidades
  @return Nothing
  */
  public void setCormobilidad(){
    corm= this.getCormobilidad();
  }
   /*
  El método getCormobilidadf nos permite obtener las cormobilidades
  familiares
  @return String cormf
  */
  public int getCormobilidadf(){
    return cormf;
  }
  /*
  El método setCormobilidadf nos permite adicionarle cormobilidades
  familiares
  @return Nothing
  */
  public void setCormobilidadf(){
    cormf=this.getCormobilidadf();
  }
  /*
  El método getUbicacion nos permite saber la localidad donde vive 
  el estudiante
  @return String ubicacion
  */
  public String getUbicacion(){
    return ubicacion;
  }
   /*
  El método setUbicacion nos permite darle una localidad donde vive 
  el estudiante
  @return Nothing
  */
  public void setUbicacion(){
    ubicacion = this.getUbicacion();
  }

  /*
  El método getGenero nos permite saber el genero del estudiante
  @return String genero
  */
  public String getGenero(){
    return genero;
  }
  /*
  El método getUbicacion nos permite establecer el género del 
  estudiante
  @return Nothing
  */
  public void setGenero(){
    genero = this.getGenero();
  }

  /*
  El método getUbicacion nos permite obtener la edad del estudiante
  @return int edad
  */
  public int getEdad(){
    return edad;
  }

   /*
  El método getUbicacion nos permite establecer la edad del
  estudiante
  @return Nothing
  */
  public void setEdad(){
    edad = this.getEdad();
  }
  
}