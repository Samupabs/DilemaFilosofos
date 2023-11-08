public class Filosofo extends Thread{
    protected String nombreFil;
    protected Palillo palilloDerecho;
    protected Palillo palilloIzquierdo;

    public Filosofo(String nombreFil) {
        this.nombreFil = nombreFil;
    }

    @Override
    public String toString() {
        return
                "nombreFil='" + nombreFil + '\'' +
                ", palilloDerecho=" + palilloDerecho +
                ", palilloIzquierdo=" + palilloIzquierdo +
                '}';
    }

    @Override
    public void run() {
        int boton = 1;

       while(boton < 2){

            pensar();

            hambriento();

            comer();

            terminaComer();

       }
    }

    public void pensar (){

        System.out.println("El cientifico " + this.nombreFil + " está pensando.");

        try {
            sleep(aleatorio());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void hambriento (){

        System.err.println("El cientifico " + this.nombreFil + " tiene hambre.");

    }

    // Comprueba si los palillos estan disponibles, si lo estan come y los inutiliza para que nadie los use
    // si no, espera un segundo (porque si no peta) y vuelve a intentar comer infinitamente hasta que estén disponibles
    // Cuando termina de comer los vuelve a dejar disponibles
    synchronized void comer (){

        if (this.palilloDerecho.disponible && this.palilloIzquierdo.disponible) {

        this.palilloDerecho.disponible = false;
        this.palilloIzquierdo.disponible = false;

        System.out.println("El cientifico " + this.nombreFil + " está comiendo.");

        try {
            sleep(aleatorio());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.palilloDerecho.disponible = true;
        this.palilloIzquierdo.disponible = true;

        } else {
            try {
                sleep(1000);
                comer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void terminaComer(){

        System.out.println("El cientifico " + this.nombreFil + " ha terminado de comer.");

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // Crea un numero aleatorio del 1-11
    public static int aleatorio() {
        int min = 0;
        int max = 15;

        double random = Math.random();

        int randomNumber = (int) (min + (random * (max - min + 1)));

        return randomNumber*1000;
    }

    public String getNombreFil() {
        return nombreFil;
    }

    public void setNombreFil(String nombreFil) {
        this.nombreFil = nombreFil;
    }

    public Palillo getPalilloDerecho() {
        return palilloDerecho;
    }

    public void setPalilloDerecho(Palillo palilloDerecho) {
        this.palilloDerecho = palilloDerecho;
    }

    public Palillo getPalilloIzquierdo() {
        return palilloIzquierdo;
    }

    public void setPalilloIzquierdo(Palillo palilloIzquierdo) {
        this.palilloIzquierdo = palilloIzquierdo;
    }
}
