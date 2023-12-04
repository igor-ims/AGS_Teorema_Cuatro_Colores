package procintdatos;

import java.util.LinkedList;

public class Estado {
    /*
     * Los atributos de la clase Estado son:
     * nombre, color y conexiones.
     * 
     * El atributo conexiones es una lista de los estados
     * geográficamente conectados con el estado objeto.
     */
    private String nombre;
    private String color;
    private LinkedList<Estado> conexiones;

    // Get y Set del atributo nombre
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /*
     * El método addConexion recibe como parámetro
     * otro Estado, que será añedido a la lista de
     * conexiones.
     */
    public void addConexion(Estado otro){
        // Checa si el Estado ya está en la lista
        // para evitar la duplicidad
        if(!this.conexiones.contains(otro)){
            // Las conexiones son simetricas, o sea,
            // la conexión se realiza en ambas listas.
            this.conexiones.add(otro);
            otro.conexiones.add(this);
        }
    }

    // Método para facilitar la exibición de cada Estado.
    public LinkedList<String> getNombreConexiones(){
        LinkedList<String> nombreCons = new LinkedList<String>();
        for (Estado n : this.conexiones){
            nombreCons.add(n.getNombre());
        }
        return nombreCons;
    }

    // Get y Set del atributo color.
    // se usa en la clase Mexico.
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }

    /*
     * El método constructor de Estado recibe solamente
     * el nombre, pues sus conexiones y su color solo
     * serán creados en la clase Mexico.
     */
    public Estado(String nombre){
        this.nombre = nombre;
        this.conexiones = new LinkedList<Estado>();
        this.color = null;
    }

    // Get de conexiones, para ser usado en la clase AGS.
    public LinkedList<Estado> getConexiones(){
        return this.conexiones;
    }
}
