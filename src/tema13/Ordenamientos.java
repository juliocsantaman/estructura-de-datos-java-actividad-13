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
public class Ordenamientos {
    
    private int movMerge=0;
    private int movQuick=0;
    private long tiempoMerge=0;
    private long tiempoQuick=0;
    
    //Getters y setters.
    public int getMovMerge() {
        return this.movMerge;
    }
    
    public int getMovQuick() {
        return this.movQuick;
    }
    
    public long getTiempoMerge() {
        return this.tiempoMerge;
    }
    
    public long getTiempoQuick() {
        return this.tiempoQuick;
    }
    
    public void setMovMerge(int movMerge) {
        this.movMerge = movMerge;
    }
    
    public void setMovQuick(int movQuick) {
        this.movQuick = movQuick;
    }
    
    public void setTiempoMerge(long tiempoMerge) {
        this.tiempoMerge = tiempoMerge;
    }
    
    public void setTiempoQuick(long tiempoQuick) {
        this.tiempoQuick = tiempoQuick;
    }
    
    //Método Merge
    public int[] ordMerge(int [] arr) {
        
        long tiempoInicio, tiempoFin, resTiempo;
        
        tiempoInicio = System.nanoTime();
        if(arr.length==1) {
            //Ya esta ordenado
        } else {
            int i, j, k;
        
            if(arr.length>1) {
                int nIzq = arr.length/2;
                int nDer = arr.length-nIzq;
                int [] arrIzq= new int[nIzq];
                int [] arrDer= new int[nDer];

                //Copiando los elementos de parte primera al arrIzq.
                for(i=0; i<nIzq; i++) {
                    arrIzq[i] = arr[i];
                }

                //Copiando los elementos de parte segunda al arrDer.
                for(i=nIzq; i<nIzq+nDer ; i++) {
                    arrDer[i-nIzq] = arr[i];
                }

                //Recursividad.
                arrIzq=ordMerge(arrIzq);
                arrDer=ordMerge(arrDer);

                i=0;
                j=0;
                k=0;

                while(arrIzq.length!=j && arrDer.length!=k) {   
                    if(arrIzq[j] < arrDer[k]) {
                        arr[i] = arrIzq[j];
                        i++;
                        j++;
                        this.movMerge++;
                    } else {
                        arr[i] = arrDer[k];
                        i++;
                        k++;
                        this.movMerge++;
                    }
                }
            
                //Arreglo final.
                while(arrIzq.length != j) {
                    arr[i] = arrIzq[j];
                    i++;
                    j++;
                }

                while(arrDer.length != k) {
                    arr[i] = arrDer[k];
                    i++;
                    k++;
                }
            } //Fin del if.
        }
        
        tiempoFin = System.nanoTime();
        resTiempo = tiempoFin - tiempoInicio;
        this.tiempoMerge+=resTiempo;
        
        
        
        
        return arr;
    }
    
    //Ordenamiento Quick.
    public void ordQuick(int [] arr, int primero, int ultimo) {
        long tiempoInicio, tiempoFin, resTiempo;
        int i, j, pivote, aux;
        i=primero;
        j=ultimo;
        pivote=arr[(primero+ultimo)/2];
        
        tiempoInicio = System.nanoTime();
        if(arr.length==1) {
            
            //Arreglo ya ordenado.
            
            
        } else {
            
            do {
            
            
            while(arr[i]<pivote) {
                i++;
            }
            
            while(arr[j]>pivote) {
                j--;
            }
            
            //Aquí hacemos el intercambio.
            if(i<=j) {
   
                aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
                i++;
                j--;
                this.movQuick++;
            }
            
            } while (i<=j);

            if(primero<j) {
                ordQuick(arr, primero, j);
            }

            if(i<ultimo) {
                ordQuick(arr, i, ultimo);
            }
            
        }
        
        tiempoFin = System.nanoTime();
        resTiempo = tiempoFin - tiempoInicio;
        this.tiempoQuick+=resTiempo;
        
        
        
        
    }
    
    //Método para imprimir un Arreglo.
    public void imprimir(int [] dato) {
        
        
        
        for(int i=0; i<dato.length; i++) {
            
            System.out.println("Valor " + (i+1) + " --> " + dato[i]);
        }
        
        System.out.println();
    }
    
    //Método para copiar los valores de un arreglo a otro.
    public void clonarArreglo(int [] nuevoArr, int [] arrOriginal) {

        for(int i=0; i<arrOriginal.length; i++) {
            
            nuevoArr[i] = arrOriginal[i];
        }
        
    }
    
}
