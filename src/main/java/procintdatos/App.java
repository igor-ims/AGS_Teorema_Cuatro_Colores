package procintdatos;

public class App 
{
    public static void main( String[] args )
    {
        /*
         * En el Main, se selecciona la cantidad de individuos para
         * generar la población, el número de iteraciones (cruces) y
         * la espera, en milisegundos, para que el programa ejecute bien.
         * Todos las variables son enteras y pueden ser ayustadas.
         * 
         * Los siguientes valores son los que funcionan correctamente 
         * y presentan resultados aceptables:
         * -- cantidad de individuos = 100
         * -- iteraciones = 5
         * -- espera = 100 ms
         */

        int cantidadIndividuos = 100;
        int iteraciones = 5;
        int espera = 100;

        /*
         * El constructor recibe los tres argumentos arriba,
         * su código es mejor explicado en la clase AGS.
         * 
         * El método exibeMejorIndividuo muestra la solución optimizada 
         * y es xplicado en la clase AGS.
         */

        AGS algoritmoGeneticoSimple = new AGS(cantidadIndividuos, iteraciones, espera);
        
        algoritmoGeneticoSimple.exibeMejorIndividuo(); // Exibe la mejor solución.
    }
}
