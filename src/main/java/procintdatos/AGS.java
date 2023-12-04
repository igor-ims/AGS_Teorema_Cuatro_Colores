package procintdatos;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class AGS {
    /*
     * Esta es la clase clave para la solución del problema.
     * 
     * Sus atributos son:
     * 
     * -- poblacion: lista de "Méxicos" para hacer los cruces.
     * Su cantidad es definida en el constructor.
     * -- mejorIndividuo: México con el mayor fitness de la lista.
     * -- espera: número entero, que representa la pausa que toma 
     * el programa para ejecutarse correctamente (en milisegundos)
     */
    private LinkedList<Mexico> poblacion;

    private Mexico mejorIndividuo;

    private int espera;
 
    /*
     * El constructor que recibe como parámetros:
     * - cantidadIndividuos: cantidad de "Méxicos" que serán cruzados.
     * - iteraciones: cantidad de veces que serán repetidos los cruces.
     * - espera: atributo de la clase para un buen funcionamiento.
     */
    public AGS(int cantidadIndividuos, int iteraciones, int espera){
        this.espera = espera;
        this.poblacion = this.poblacionInicial(cantidadIndividuos);
        this.ags(iteraciones, cantidadIndividuos);
    }
    
    // Genera la población inicial del problema.
    public LinkedList<Mexico> poblacionInicial(int cantidad){
        // primero checa si la cantidad es par, para cruces más sencillos.
        if(cantidad % 2 == 1) cantidad++;

        LinkedList<Mexico> pobInicial = new LinkedList<Mexico>();

        /*
         * En el bucle se generan vários individuos, de acuerdo 
         * con la cantidad deseada.
         * El bucle usa la espera para que la memoria sea limpia.
         */
        for(int i = 0; i < cantidad; i++){
            Mexico m = new Mexico();
            pobInicial.add(m);
            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        return pobInicial;
    }

    // Método que regresa el mejor individuo de la población,
    // de acuerdo con el mayor fitness.
    public void calculaMejorIndividuo(){
        this.mejorIndividuo = this.poblacion.getFirst();

        for (Mexico individuo : poblacion) {
            if (individuo.getFitness() > this.mejorIndividuo.getFitness()) {
                this.mejorIndividuo = individuo;
            }
        }
    }

    /*
     * Este método realiza el cruce en un punto (aleatório)
     * entre dos "Méxicos". Son usados objetos de auxílio
     * para adicionar "Méxicos" nuevos, generados a partir
     * del cruzamiento, en la población.
     * 
     * El argumento tamanoIncial garantiza que la población
     * no aumente ni disminuya.
     * 
     * Este método usa la espera, para un nuen funcionamiento.
     * 
     * Al final del método, la población debe tener la misma
     * cantidad de individuos inicial.
     */
    private void cruceUnPunto(int tamanoInicial){
        Random random = new Random();
        Mexico m1 = new Mexico();
        Mexico m2 = new Mexico();
        Mexico auxMexico1 = new Mexico();
        Mexico auxMexico2 = new Mexico();
        Estado auxEstado1 = new Estado(null);
        Estado auxEstado2 = new Estado(null);

        // El punto de cruce va de 1 al final - 1, 
        // pues si el cruce se produce en los extremos, no hay cambio.
        int puntoCruce = random.nextInt(1, this.poblacion.getFirst().getNumeroEstados() - 1);
        int posicion;

        /*
         * Este es un medidor auxiliar de tamaño de población,
         * reducido en 2 al final de cada repetición en el bucle.
         * El tamaño es reducido en 2 pues se usan 2 padres para
         * producir 2 hijos en el cruce.
         */
        int tam = this.poblacion.size();

        // El bucle tiene su condicional en el tamaño inicial / 4,
        // pues solo se usa la mejor mitad de la población, y se agarran en pares.
        for(int i = 0; i < tamanoInicial/4; i++){

            posicion = random.nextInt(1, tam);
            m2 = this.poblacion.get(posicion);
            m1 = this.poblacion.getFirst();

            // Este otro bucle usa el numero de estados de un objeto, pues es estándar.
            // Se cruzan los individuos, de acuerdo con el corte definido en el bucle de repeticiones.
            for(int j = 0; j < m1.getNumeroEstados(); j++){
                auxMexico1 = new Mexico();
                auxMexico2 = new Mexico();
                /*
                 * Aquí, esta condicional verifica si está antes o después del punto de corte.
                 */
                if(j < puntoCruce){
                    auxEstado1 = m1.removeEstado();
                    auxEstado2 = m2.removeEstado();
                    auxMexico1.addEstado(auxEstado1);
                    auxMexico2.addEstado(auxEstado2);
                }
                else{
                    auxEstado1 = m2.removeEstado();
                    auxEstado2 = m1.removeEstado();
                    auxMexico2.addEstado(auxEstado1);
                    auxMexico1.addEstado(auxEstado2);
                }
            }
            // Son adicionados los hijos a la población.
            this.poblacion.add(auxMexico1);
            this.poblacion.add(auxMexico2);

            // Quita el par de padres.
            tam -= 2;

            // Espera.
            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    
    /*
     * Este es el método principal, que gestiona el algoritmo genético simple.
     * 
     * Primero, se pone en orden creciente de individuos, para remover la peor mitad.
     * Después se realiza el cruce, regresando la población a su cantidad incial.
     * Al final, se calcula el mejor individuo y pausa para un buen funcionamiento.
     */
    public void ags(int iteraciones, int tamanoInicial){
        for(int i = 0; i < iteraciones; i++){
            Collections.sort(this.poblacion, Comparator.comparing(Mexico::getFitness));
            this.poblacion = new LinkedList<>(this.poblacion.subList(this.poblacion.size()/2, this.poblacion.size()));
            this.cruceUnPunto(tamanoInicial);
            this.calculaMejorIndividuo();
            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    // Exibe el mejor individuo, en el formato del método exibeMexico, implementado en la clase Mexico.
    public void exibeMejorIndividuo(){
        this.mejorIndividuo.exibeMexico();
    }

    // Get y set de la lista de individuos
    public LinkedList<Mexico> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(LinkedList<Mexico> poblacion) {
        this.poblacion = poblacion;
    }

    // Get y set del mejor individuo, pero sin calcular.
    public Mexico getMejorIndividuo() {
        return mejorIndividuo;
    }

    public void setMejorIndividuo(Mexico mejorIndividuo) {
        this.mejorIndividuo = mejorIndividuo;
    }

    // Get y set del tiempo de espera.
    public int getEspera() {
        return espera;
    }

    public void setEspera(int espera) {
        this.espera = espera;
    }
}
