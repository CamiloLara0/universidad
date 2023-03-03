import javax.swing.*;
import java.util.Objects;
import java.awt.*;
class Facultad implements java.io.Serializable{
    private String nombre,fecha1,fecha2;
    private Estudiante estudiante[];
    private int nd=0;
    private int nes=0,ant=0;

    /*
    El método constructor de Facultad recibira un parametro n, el 
    cual será el identificador de todas las facultades (5)
    @param n-nombre
    */

    public Facultad(String n){
        nombre=n;
        estudiante = new Estudiante[nes];
    }

    /*
    El método setNumeroEstudiantes nos permitira saber cuantos 
    estudiantes va a tener la facultad, para que a su vez los 
    podamos almacenar dentro de un arreglo
    @param n
    */
    public void setNumeroEstudiantes(int n){
        nes+=n;
        ant=n;

    }
    //i=2(nes-ant)     i<5   i++ ant=3
   /* int cre=nes-ant;
    for(int i=cre;i<nes; i++){
      [i+1]
    }*/

    /*
    El método getAnt nos permite saber cuantos estudiante hay 
    acutalmente creados
    @return int ant
    */
    public int getAnt(){
      return ant;
    }

    /*
    El método setFechas nos permite establecer las fechas para las 
    vacunaciones
    @param f1- fecha1
    @param f2- fecha2
    @return Nothing
    */
    public void setFechas(String f1, String f2){
        fecha1=f1;
        fecha2=f2;
    }

  /*
  El metodo getDosisFacultad nos permite saber cuantas dosis tiene 
  cada facultad
  @return int nd - número de dosis
  */

    public int getDosisFacultad(){
        return nd;
    }

    /*
    El método setDosisFacultad nos permite adicionar dosis a cada 
    facultad
    @param d - dosis
    @return Nothing
    */
    public void setDosisFacultad(int d){
        nd = d;
    }

    /*
    El método dosisfaltantes nos permite saber cuantas dosis 
    faltan para completar el esquema de vacunación de cada 
    estudiante
    @return Nothing
    */
    public void dosisfaltantes(){
        int df=nes*2-nd;
        if (df>0){
            //faltan dosis
            JOptionPane.showMessageDialog(null,"Dosis faltantes: "+df);
        }else{
            //no faltan
            JOptionPane.showMessageDialog(null,"Dosis completas");
        }
    }

/*
El método crearAleatorio nos permite crear n estudiantes con 
informacion aleatoria, con el fin de probar la funcionalidad del 
programa
@return Nothing          
*/
    public void crearAleatorio(){
      for(int i=0;i<nes;i++){
            Estudiante a;
            String nombre ="estudiante"+i;
            String genero = (Math.random()>.5)?"masculino" : "femenino";
            String ubicacion ="n/n";
            int edad=0,cormobilidad=0,cormobilidadf=0,dosis=0;
            a = new Estudiante(i,nombre,cormobilidad,cormobilidadf,genero,edad, dosis,ubicacion);
            estudiante[i]=a;
            }
            
    }

/*
El método asignar recibe el estudiante con sus respectivos atributos, y un número que va a ser el que nos ayude a establecerlo dentro del arreglo de estudiantes
@param Estudiante a
@param int b
@return Nothing
*/
    public void asignar(Estudiante a, int b){
        estudiante[b]=a;
    }

    /*
    El método crearPlan nos ayudara a crear el plan de vacunación 
    dependiendo de las cormobilidades, tanto del estudiante, como 
    las cormobilidades familiares
    @return Nothing
    */
    public void crearPlan(){
        Estudiante aux;
        for(int i=0;i<(nes-1);i++){
            for(int j=0;j<(nes-1);j++){
                int ct=estudiante[j].getCormobilidad()+estudiante[j].getCormobilidadf();
                int ct2=estudiante[j+1].getCormobilidad()+estudiante[j+1].getCormobilidadf();
                if(ct>ct2){
                    aux=estudiante[j];
                    estudiante[j]=estudiante[j+1];
                    estudiante[j+1]=aux;
                }
            }
        }
    }

    /*
    El método AsignarDosis, una vez tengamos el plan de vacunación,
     lo que hara es asignar las dosis, dependiendo de la cantidad 
    de dosis que la universidad asigno
    @return Nothing
    */
    public void AsignarDosis(){
        if(nd>=nes){
            if(nd>=(2*nes)){
                for(int i=0;i<nes;i++){
                    estudiante[i].setDosis(2);
                }
            }else{
                int a=(nd-nes);
                for(int i=(nes-1);i>=0;i--){
                  System.out.println("primer else asignarDosis");
                    estudiante[i].setDosis(1);
                }
                for(int i=(nes-1);i>=a;i--){
                  System.out.println("primer else asignarDosis");
                    estudiante[i].setDosis(1);
                }
            }
        }else{
          if(nd>0){
             for(int i=(nes-1);i>=nd;i--){
                estudiante[i].setDosis(1);
            }
             System.out.println("segundo else asignarDosis");
          }
        }

    }

    /*
    El método Listar nos permitirá saber de manera ordenada, los 
    atributos de los estudiantes, y si ya fueron vacunados o no.
    @return String respuesta
    */
    public String Listar(){
        System.out.print("Lista de estudiantes: \n\n");
        String respuesta="";
        for(int i=0;i<nes;i++){
          respuesta+="Nombre: "+estudiante[i].getNombre()+"|| Dosis: "+estudiante[i].getDosis()+"|| Edad: "+estudiante[i].getEdad()+"|| Genero: "+estudiante[i].getGenero()+"|| Ubicación: "+estudiante[i].getUbicacion()+"|| cormobilidad: "+(estudiante[i].getCormobilidad()+estudiante[i].getCormobilidadf())+"\n\n";
          
        }
        return respuesta;
    }

/*
el método getNom nos permite saber el nombre
@return String nombre
*/
    public String getNom(){
        return nombre;
    }

/*
el método getEstudiantes nos permite saber la cantidad de 
estudiantes
@return int nes - número de estudiantes
*/
    public int getEstudiantes(){
        return nes;
    }

/*
el método cambiarContraseña nos permite cambiar la contraseña dependiendo de la facultad
@return Nothing
*/
    public void cambiarContraseña(){

    }

/*
El método de ModificarDosis nos permite distribuir las dosis a los estudiantes
@param ide
@param v

*/
    public void ModificarDosis(int ide, int v){
        estudiante[ide-1].setDosis(v);
    }
    /*public void rellenar(int nnd){
        int a=nnd;
        for(int i=0;i<nes;i++){
            if(estudiante[i].getDosis()==1 ||estudiante[i].getDosis()==0){
                estudiante[i].setDosis(1);
                a=a-1;
                if(a==0){
                    break;
                }
            }
        }
    }*/

    /*
    El método fechaUno nos permite establecer la primera fecha de 
    vacunacion a los estudiantes
    @param int i
    @return String vacio
    */
    public String fechaUno(int i){
        if(estudiante[i].getDosis()>=1){
            return fecha1;
        }else{
            String vacio="";
            return vacio;
        }
    }
     /*
    El método fechaDos nos permite saber la segunda fecha de 
    vacunacion a los estudiantes
    @param int i
    @return String vacio
    */
    public String fechaDos(int i){
        if(estudiante[i].getDosis()==2){
            return fecha2;
        }else{
            String vacio="";
            return vacio;
        }
    }
}