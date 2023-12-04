package procintdatos;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Mexico {
    /*
     * Esta clase es una implementación de un grafo, haciendo referencia
     * al mapa de los Estados Unidos Mexicanos.
     * 
     * Sus atributos son:
     * -- listaEstados: Lista de estados de México, que son estándar.
     * -- fitness: número entero para calcular la aptitud del algoritmo
     * genético simple, implementado en la clase AGS.
     * -- colores: los cuatro colores posibles para resolución del
     * teorema de los cuatro colores.
     */
    private LinkedList<Estado> listaEstados;
    private int fitness;
    private final String[] colores = {"Amarillo", "Verde", "Rojo", "Azul"};

    /*
     * El método constructor no necesita ningún parámetro, pues
     * los estados de México son inmutables.
     * Al final, se asignan colores aleatorios a los estados, que
     * serán gestionadas en la clase AGS,
     * y se calcula el fitness, de acuerdo con la explicación
     * en el método calculaFitness en esta misma clase.
     */
    public Mexico(){
        this.listaEstados = new LinkedList<Estado>();

        Estado aguascalientes = new Estado("Aguascalientes");
        Estado bajaCalifornia = new Estado("Baja California");
        Estado bajaCaliforniaSur = new Estado("Baja California Sur");
        Estado campeche = new Estado("Campeche");
        Estado chiapas = new Estado("Chiapas");
        Estado chihuahua = new Estado("Chihuahua");
        Estado coahuila = new Estado("Coahuila");
        Estado colima = new Estado("Colima");
        Estado cdmx = new Estado("Ciudad de México");
        Estado durango = new Estado("Durango");
        Estado estadoDeMexico = new Estado("Estado de México");
        Estado guanajuato = new Estado("Guanajuato");
        Estado guerrero = new Estado("Guerrero");
        Estado hidalgo = new Estado("Hidalgo");
        Estado jalisco = new Estado("Jalisco");
        Estado michoacan = new Estado("Michoacán");
        Estado morelos = new Estado("Morelos");
        Estado nayarit = new Estado("Nayarit");
        Estado nuevoLeon = new Estado("Nuevo León");
        Estado oaxaca = new Estado("Oaxaca");
        Estado puebla = new Estado("Puebla");
        Estado queretaro = new Estado("Querétaro");
        Estado quintanaRoo = new Estado("Quintana Roo");
        Estado sanLuisPotosi = new Estado("San Luís Potosí");
        Estado sinaloa = new Estado("Sinaloa");
        Estado sonora = new Estado("Sonora");
        Estado tabasco = new Estado("Tabasco");
        Estado tamaulipas = new Estado("Tamaulipas");
        Estado tlaxcala = new Estado("Tlaxcala");
        Estado veracruz = new Estado("Veracruz");
        Estado yucatan = new Estado("Yucatán");
        Estado zacatecas = new Estado("Zacatecas");

        bajaCalifornia.addConexion(bajaCaliforniaSur);
        bajaCalifornia.addConexion(sonora);
        sonora.addConexion(sinaloa);
        sonora.addConexion(chihuahua);
        chihuahua.addConexion(sinaloa);
        chihuahua.addConexion(durango);
        chihuahua.addConexion(coahuila);
        coahuila.addConexion(nuevoLeon);
        coahuila.addConexion(durango);
        coahuila.addConexion(zacatecas);
        coahuila.addConexion(sanLuisPotosi);
        nuevoLeon.addConexion(tamaulipas);
        nuevoLeon.addConexion(sanLuisPotosi);
        tamaulipas.addConexion(sanLuisPotosi);
        tamaulipas.addConexion(veracruz);
        sinaloa.addConexion(durango);
        sinaloa.addConexion(nayarit);
        durango.addConexion(zacatecas);
        durango.addConexion(nayarit);
        durango.addConexion(jalisco);
        zacatecas.addConexion(aguascalientes);
        zacatecas.addConexion(nayarit);
        zacatecas.addConexion(sanLuisPotosi);
        sanLuisPotosi.addConexion(guanajuato);
        sanLuisPotosi.addConexion(queretaro);
        sanLuisPotosi.addConexion(veracruz);
        sanLuisPotosi.addConexion(hidalgo);
        jalisco.addConexion(aguascalientes);
        jalisco.addConexion(colima);
        jalisco.addConexion(michoacan);
        jalisco.addConexion(guanajuato);
        jalisco.addConexion(nayarit);
        jalisco.addConexion(zacatecas);
        jalisco.addConexion(sanLuisPotosi);
        guanajuato.addConexion(queretaro);
        guanajuato.addConexion(michoacan);
        guerrero.addConexion(puebla);
        queretaro.addConexion(hidalgo);
        queretaro.addConexion(michoacan);
        queretaro.addConexion(estadoDeMexico);
        hidalgo.addConexion(estadoDeMexico);
        hidalgo.addConexion(tlaxcala);
        hidalgo.addConexion(puebla);
        hidalgo.addConexion(veracruz);
        colima.addConexion(michoacan);
        michoacan.addConexion(guerrero);
        michoacan.addConexion(estadoDeMexico);
        estadoDeMexico.addConexion(cdmx);
        estadoDeMexico.addConexion(tlaxcala);
        estadoDeMexico.addConexion(morelos);
        estadoDeMexico.addConexion(guerrero);
        estadoDeMexico.addConexion(puebla);
        morelos.addConexion(cdmx);
        morelos.addConexion(puebla);
        morelos.addConexion(guerrero);
        oaxaca.addConexion(guerrero);
        oaxaca.addConexion(puebla);
        oaxaca.addConexion(veracruz);
        oaxaca.addConexion(chiapas);
        chiapas.addConexion(tabasco);
        chiapas.addConexion(veracruz);
        tabasco.addConexion(campeche);
        tabasco.addConexion(veracruz);
        campeche.addConexion(yucatan);
        campeche.addConexion(quintanaRoo);
        puebla.addConexion(veracruz);
        puebla.addConexion(tlaxcala);
        yucatan.addConexion(quintanaRoo);

        this.addEstado(aguascalientes);
        this.addEstado(bajaCalifornia);
        this.addEstado(bajaCaliforniaSur);
        this.addEstado(campeche);
        this.addEstado(chiapas);
        this.addEstado(chihuahua);
        this.addEstado(coahuila);
        this.addEstado(colima);
        this.addEstado(cdmx);
        this.addEstado(durango);
        this.addEstado(estadoDeMexico);
        this.addEstado(guanajuato);
        this.addEstado(guerrero);
        this.addEstado(hidalgo);
        this.addEstado(jalisco);
        this.addEstado(michoacan);
        this.addEstado(morelos);
        this.addEstado(nayarit);
        this.addEstado(nuevoLeon);
        this.addEstado(oaxaca);
        this.addEstado(puebla);
        this.addEstado(queretaro);
        this.addEstado(quintanaRoo);
        this.addEstado(sanLuisPotosi);
        this.addEstado(sinaloa);
        this.addEstado(sonora);
        this.addEstado(tabasco);
        this.addEstado(tamaulipas);
        this.addEstado(tlaxcala);
        this.addEstado(veracruz);
        this.addEstado(yucatan);
        this.addEstado(zacatecas);

        this.coloresAleatorias();

        this.calculaFitness();
    }

    // Adiciona un estado a la lista de estados de México.
    public void addEstado(Estado Estado){
        // Antes de adicionar, checa si el estado
        // ya está en la lista, para evitar la duplicidad.
        if(!this.listaEstados.contains(Estado)){
            this.listaEstados.add(Estado);
        }
    }

    /*
     * Método que exibe en la consola los estados de México,
     * sus colores y las conexiones en el formato:
     * 
     * México:
     * Estados, colores y sus conexiones:
     * 
     * Estado 1, Color: [ conexión 1, conexión 2 ... conexión N ]
     * Estado 2, Color: [ conexión 1, conexión 2 ... conexión N ]
     * ...
     * Estado N, Color: [ conexión 1, conexión 2 ... conexión N ]
     */
    public void exibeMexico() {
        System.out.println("Mexico:\nEstados, colores y sus conexiones:\n");
        for (Estado estado : this.listaEstados) {
            System.out.print(estado.getNombre() + ", "+ estado.getColor() +":\t[ ");
            List<String> conexiones = estado.getNombreConexiones();
            for (int i = 0; i < conexiones.size(); i++) {
                System.out.print(conexiones.get(i));
                if (i < conexiones.size() - 1) {
                    System.out.print(", ");
                }
            }
        System.out.print(" ]\n");
        }
    }

    // Get lista de estados, usado en la clase AGS
    public LinkedList<Estado> getListaEstados() {
        return listaEstados;
    }

    // Get y set de fitness
    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    /*
     * Este método genera una color aleatória para
     * cada estado, respetando el arreglo de colores
     * definido en los atributos de la clase.
     */
    public void coloresAleatorias(){
        // Usa un generador de números aleatórios
        // Para escojer un color de acuerdo con el
        // índice del arreglo de colores.
        Random random = new Random();
        int color;

        // El bucle genera un color para cada estado en la lista.
        for(Estado e : this.listaEstados){
            color = random.nextInt(0, this.colores.length);
            e.setColor(this.colores[color]);
        }
    }

    /*
     * Este método calcula la aptitud de los colores de cada estado.
     * Así es calculada la aptitud:
     * Si el color del estado evaluado es diferente del color del estado
     * en su lista de conexiones, se suma 1 al fitness.
     * La evaluación se lleva a cabo en todos los estados y todas sus conexiones,
     * y cuanto mayor sea el fitness, más próximo de la mejor solución están los colores.
     */
    public void calculaFitness(){
        int count = 0;
        for(Estado n : this.listaEstados){
            for(Estado m : n.getConexiones()){
                if(!n.getColor().equals(m.getColor())){
                    count++;
                }
            }
        }
        this.fitness = count;
    }

    // Get numero de estados para hacer las operaciones del AGS.
    public int getNumeroEstados(){
        return this.listaEstados.size();
    }

    // Remove un estado de la lista y lo regresa como resultado.
    public Estado removeEstado(){
        // Primero checa si la lista de estados no está vacia.
        if (!this.listaEstados.isEmpty()) {
        Estado e = this.listaEstados.removeFirst();
        return e;
        } 
        else {
        throw new NoSuchElementException("La lista de estados está vacia.");
        }
    }
}
