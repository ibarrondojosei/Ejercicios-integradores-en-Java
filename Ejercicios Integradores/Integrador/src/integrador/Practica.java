package integrador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Practica {

    
//    La función recibirá un numero x y deberá determinar si es capicúa o no. 
//    Este deberá devolver verdadero(true) si es capicúa y falso(false) si no lo es. 
//    Además deberemos contemplar los siguientes escenarios: 
//    Contemplar que el numero que llega puede ser negativo. 
//    Contemplar que el numero que llega puede ser de un digito, si es así debe devolver true. 
//    Contemplar que el numero que llega puede ser null, si es así debe devolver false.
//    @param num
//    @return esPalindromo
     
    public Boolean numeroCapicua(Integer num) {
        boolean capicua = false;

        try { 
               //Elaboro una excepción del tipo CapicuaException para tratar el 
              //caso de que ingrese el número como null. 
              // Creo la Clase CapicuaException.
              //Para tratar de forma local la excepción utilizo Exception.

            if (num == null) {
                
                throw new Exception();

               // throw new CapicuaException();
            }
            // Paso el número a String.
            String numeroIngresado = String.valueOf(num);

            StringBuilder sb = new StringBuilder(numeroIngresado);
            
            //Utilizo un condicional if para determinar si el numero es negativo,
            //si es así, utilizo la erramienta delete de la Clase StringBuilder
            //instanciada anteriormente para borrar el signo negativo.
            if (numeroIngresado.substring(0, 1).equalsIgnoreCase("-")) {

                numeroIngresado = sb.delete(0, 1).toString();
            }
                      
           //Utilizo la herramienta reverse de la Clase StringBuilder para dar 
           //vuelta el número pasado a String.

            String numeroInvertido = sb.reverse().toString();
                       
            // Utilizo un condicional if para comparar el número ingresado con
            // el número dado vuelta, si son iguales, la variable capicua devuelve
            // true.

            if (numeroIngresado.equalsIgnoreCase(numeroInvertido)) {

                capicua = true;
            }
        } //catch (CapicuaException e) {
          catch (Exception e) { 

            System.out.println("Error el número ingresado es null");
            capicua = false;
        }

        return capicua;
        
    }

    
//    Estamos en caramelolandia, donde estan los peores ladrones de dulces. 
//    Una vez al mes, se sienta una n cantidad de presos en ronda, contemplando 
//    al preso que inicia la ronda, como el preso 0. 
//    A los presos se les da una m cantidad de caramelos, estos caramelos se repartirán de uno en uno a cada preso, 
//    contemplando que se comenzaran a repartir los caramelos desde el primer preso (inicio). 
//    Se repartirán los caramelos hasta que no queden más y el ultimo caramelo en repartirse estará podrido, 
//    determinar a que preso, según su posición en la ronda le tocara el caramelo podrido.
//     @param inicio
//     @param cantidadCaramelos
//     @param cantidadLadrones
//     @return ladronQueLeTocoElCarameloPodrido
     
    public int prisioneroDulce(int inicio, int cantidadCaramelos, int cantidadLadrones) {
        int contLadrones = inicio; //Contador de ladrones.
        int contCaramelos = cantidadCaramelos; //Contador de caramelos.
        
        // Elaboro un bucle Do-While para que gire en el mismo mientras queden 
        // caramelos por reparir. 
        do {
            // Condicional if para que cuando llegue al final de la ronda de ladrones 
            // vuelva a comenzar.
            if (contLadrones == cantidadLadrones) { 
                contLadrones = 0;
            }
            contCaramelos -= 1; //Contador que reparte los caramelos (disminuye la cantidad a 
                                //medida que se reparte en cada vuelta del bucle.
            
            //Condicional if para que mientras reparta caramelos sume al contador
            // de ladrones y determine en que posicion está repartiendo.
            if (contCaramelos != 0) {
                contLadrones += 1;
            }

           
        } while (contCaramelos != 0);

        int carameloPodrido = contLadrones;

        return carameloPodrido;
       
    }

//    En un universo paralelo, donde los habitantes son medias, existe un crucero de medias donde se sube una lista de medias. 
//    Esta lista de tripulantes del crucero es una Collection de letras. 
//    Lo que se deberá hacer, es filtrar la lista de medias que se suben al crucero y 
//    retornar una lista que contenga los grupos de medias que si tenían pares. 
//    Esta lista final de medias pares se mostraran ordenadas de menor a mayor.
//    A continuación un ejemplo: 
//    List de medias que llegan : A,B,A,B,C,A,F,Z,C,H. A,B y C tiene pares, mientras que F,Z y H no. 
//    Entonces la List que se debería retornar sería: A,B,C.
//   @param pasajeros
//   @return mediasAmigas
    
    public List<String> mediasAmigas(List<String> pasajeros) {
        //Ordeno alfabéticamente la lista pasajeros.
        Collections.sort(pasajeros, (a, b) -> a.compareTo(b));
        
        
        ArrayList<String> listaComparacion = new ArrayList();
        
        // Recorro la lista pasajeros y la guardo en una lista extra para poder 
        //hacer la comparación y encontar los pares.
        for (String aux : pasajeros) {
            listaComparacion.add(aux);
            
        }
        //Ordeno alfabéticamente la lista extra.
        Collections.sort(listaComparacion, (a, b) -> a.compareTo(b));
               
        // Recorro la lista pasajeros y la lista extra, si encuentra una igualdad,
        // suma uno al contador, cuando el contador es igual o mayor a 2, guarda 
        // la letra en un TreeSet (listaSetPares) para que los guarde ordenados 
        // y no haya repetición de letras.
        
        Set<String> listaSetPares = new TreeSet();
        
        for (int i = 0; i < pasajeros.size(); i++) {
            int cont = 0;
            for (int j = 0; j < pasajeros.size(); j++) {

                if (pasajeros.get(i).equals(listaComparacion.get(j))) {
                    cont = cont + 1;
                    
                    if (cont >= 2) {
                        listaSetPares.add(pasajeros.get(i));
                        cont = 0;
                    }
                }
            }
        }
        //Como el método devuelve una lista, debo pasar el contenido del TreeSet
        // a una lista.
        ArrayList<String> listaResultado = new ArrayList();

        listaSetPares.forEach((aux) -> {
            listaResultado.add(aux);
        });
        
        return listaResultado;
       
    }
}
