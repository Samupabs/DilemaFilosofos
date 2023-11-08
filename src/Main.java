import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList <Palillo> listaDePalillos = crearPalillos(7);
        ArrayList <Filosofo> listaDeFilosofos = crearFilosofos(listaDePalillos);

        for (Filosofo fil : listaDeFilosofos) {
            fil.start();
        }

    }

    public static ArrayList crearPalillos (int cantidad){

        ArrayList<Palillo> listaDePalillos = new ArrayList<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            String nombre = "Palillo"+(i+1);
            Palillo pal = new Palillo(nombre);
            listaDePalillos.add(pal);
        }

        return listaDePalillos;
    }

   public static ArrayList crearFilosofos (ArrayList listaDePalillos){

        int cantidad = listaDePalillos.size();
       ArrayList<Filosofo> listaDeFilosofos = new ArrayList<>(cantidad);

       for (int i = 0; i < cantidad; i++) {
           String nombre = (i + 1) + "_Filosofo";
           // Aquí asignamos dos palillos al filósofo, uno a su izquierda y otro a su derecha.
           int indicePalilloIzquierda = i;
           int indicePalilloDerecha = (i + 1) % cantidad; // Para manejar el último filósofo
           Palillo palilloIzquierda = (Palillo) listaDePalillos.get(indicePalilloIzquierda);
           Palillo palilloDerecha = (Palillo) listaDePalillos.get(indicePalilloDerecha);

           Filosofo fil = new Filosofo(nombre);
           fil.setPalilloDerecho(palilloIzquierda);
           fil.setPalilloIzquierdo(palilloDerecha);
           listaDeFilosofos.add(fil);
       }

       return listaDeFilosofos;
    }

}