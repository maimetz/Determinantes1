/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Metztoamm
 */
public class Matriz {
    Integer orden;
    Integer[][] datos;
    
    public Matriz(Integer orden, Integer[][] tablero){
        this.orden = orden;
        this.datos = tablero;
    }

    public Integer getOrden() {
        return orden;
    }
    
    public Integer[][] getDatos(){
        return datos;
    }
    
    public Integer Resolver(){

        if(this.getOrden() == 1)return datos[0][0];
        
        Matriz adjunta;
        Integer factor;

        Integer result = 0;

        for(int i=0;i<this.orden; i++){
            
            if(this.getOrden()==2){//la adjunta no sera una matriz
                factor = (i==0)?datos[1][1]:datos[0][1];
            }else{
                factor = this.getAdjunta(orden, datos, i).Resolver();//i es la columna
            }

            //si es >=2 se puede obtener la adjunta, si es igual a 2
            if(i%2==0){//si es 0, 2, 4 + --- > TODOS en el primer renglon, el renglon 0
                result += datos[i][0] * factor;
            }else{ //si es 1,3, 5, ... debe restar
                result -= datos[i][0] * factor;
            }

        }
        return result;
    }
    
    public Matriz getAdjunta(Integer orden, Integer data[][], Integer column){ //itera sobre las x's del primer renglon 
//        System.out.println("Funcion getAdjunta ");
        Integer[][] valores = new Integer[orden-1][orden-1];
        
        int columna = 0;
        int fila = 0;
       
        for(int i=1;i<orden;i++){ //para recorrer toda la matriz
//            System.out.println("Dentro del ciclo para iterar en las filas "+i+" < "+orden);
            columna = 0;
            
            for(int j=0; j<orden; j++){
//                System.out.println("Dentro del ciclo para iterar en las columnas "+j+" < "+orden);
                
                if(j!= column){
//                    System.out.println("Subindices para los valores a agregar: "+columna+" , "+fila);
//                    System.out.println("Se agrego el valor: "+ data[j][i]);
                    valores[columna][fila] = data[j][i];
                    columna++;
                }
                
            }
            
            fila++;
        }
        Matriz adjunta = new Matriz(orden-1, valores);
        return adjunta;
    }
    
    public void printMatriz(){
        System.out.println("Funcion print Matriz");
        for(int i=0; i<this.orden; i++){
            for(int j=0; j<this.orden; j++){
                System.out.print("   "+ datos[j][i]);//se debe imprimir
            }
            System.out.println();
        }
    }
}
