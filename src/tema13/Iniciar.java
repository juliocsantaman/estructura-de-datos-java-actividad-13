/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema13;

/**
 *
 * @author Julio Cesar Santaman Cruz.
 */
public class Iniciar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
            Creamos objeto merge para el ordenamiento ordMerge.
        */
        
        Ordenamientos merge = new Ordenamientos();
        Ordenamientos quick = new Ordenamientos();
        
        //Creamos nuestro arreglo de calificaciones con 10 elementos enteros.
        int [] calificaciones = new int[10];
        int [] calificacionesCopia = new int[10];
        
        
        calificaciones[0] = 8;
        calificaciones[1] = 7;
        calificaciones[2] = 10;
        calificaciones[3] = 5;
        calificaciones[4] = 6;
        calificaciones[5] = 3;
        calificaciones[6] = 2;
        calificaciones[7] = 9;
        calificaciones[8] = 1;
        calificaciones[9] = 10;
        
        /*calificaciones[0] = 1;
        calificaciones[1] = 2;
        calificaciones[2] = 3;
        calificaciones[3] = 4;
        calificaciones[4] = 5;
        calificaciones[5] = 6;
        calificaciones[6] = 7;
        calificaciones[7] = 8;
        calificaciones[8] = 9;
        calificaciones[9] = 10;*/
        
        /*calificaciones[0] = 5;
        calificaciones[1] = 2;
        calificaciones[2] = 1;
        calificaciones[3] = 8;
        calificaciones[4] = 3;
        calificaciones[5] = 9;
        calificaciones[6] = 7;*/
        
        /*calificaciones[0] = 1;*/
        
        
        merge.clonarArreglo(calificacionesCopia, calificaciones);

        System.out.println("***** ORDENAMIENTO MERGE *****");
        merge.ordMerge(calificaciones);
        merge.imprimir(calificaciones);
        System.out.println("Ordenamiento Merge --> El tiempo de ordenamiento fue: " + merge.getTiempoMerge() + " nanosegundos.\n");
        merge.setTiempoMerge(0);
        System.out.println("Máximo de movimientos: " + merge.getMovMerge());
        merge.setMovMerge(0);
        merge.ordMerge(calificaciones);
        System.out.println("Mínimo de movimientos: " + merge.getMovMerge());
        
        
        
        System.out.println();
        
        System.out.println("***** ORDENAMIENTO QUICK *****");
        quick.ordQuick(calificacionesCopia, 0, calificacionesCopia.length-1);
        quick.imprimir(calificacionesCopia);
        System.out.println("Ordenamiento Quick --> El tiempo de ordenamiento fue: " + quick.getTiempoQuick() + " nanosegundos.\n");
        quick.setTiempoQuick(0);
        System.out.println("Máximo de movimientos: " + quick.getMovQuick());
        quick.setMovQuick(0);
        quick.ordQuick(calificacionesCopia, 0, calificacionesCopia.length-1);
        System.out.println("Mínimo de movimientos: " + quick.getMovQuick());
        
        System.out.println();
        
    }
    
}
