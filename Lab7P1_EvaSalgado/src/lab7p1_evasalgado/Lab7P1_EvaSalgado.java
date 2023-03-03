
package lab7p1_evasalgado;

import java.util.Scanner;
import java.util.Random; 
import javax.swing.JOptionPane;

public class Lab7P1_EvaSalgado {

    static Scanner leer = new Scanner(System.in);
    static Random rand = new Random();
    
    public static void main(String[] args) {
      int resp = 1;
        
        do{
         int opcion = menu();
         switch (opcion){
          case 1:{
              int fila, columna;
              fila = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de filas: "));
              columna = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cantidad de columnas"));
              int[][] num = new int[fila][columna];
              num = llenar(fila,columna);
              JOptionPane.showMessageDialog(null, "Matriz generada:\n"+imprimir(num));
              
              int opcion_promedio = menu_promedio();
              if(opcion_promedio==1){
                  
                  JOptionPane.showMessageDialog(null, "Su promedio es"+imprimir_array(promedio_fila(num)));
              } else{
                  JOptionPane.showMessageDialog(null,"Su promedio es"+imprimir_array(promedio_columna(num)));
              }
                      
          }  break;
          case 2:{
              int fila, columna;
              fila = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de filas: "));
              columna = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cantidad de columnas"));
              int[][] num = new int[fila][columna];
              num = llenar(fila,columna);
              JOptionPane.showMessageDialog(null, "Matriz generada:\n"+imprimir(num));
              
              
              JOptionPane.showMessageDialog(null, imprimir(potrait(num)));
          } break; 
          
          case 3: {
            int fila, columna, tamaño;
            fila = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de filas: "));
            columna = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cantidad de columnas"));
            tamaño = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese tamaño de arreglo: "));
            int[][] num = new int[fila][columna];
            num = llenar2(fila,columna);
            int[] numtam = new int[tamaño];
            numtam = llenar3(tamaño);
            
            JOptionPane.showMessageDialog(null, "Matriz generada:\n"+imprimir(num));
            
            JOptionPane.showMessageDialog(null, "El arreglo: "+imprimir_array(numtam));
            boolean resultado = contains(num,numtam);
            
            if(resultado==true){
                JOptionPane.showMessageDialog(null, "Está contenida en la matriz");
            } else {
                JOptionPane.showMessageDialog(null, "No está contenida en la matriz");
            }
            
            
          } break; 
          case 4: {
              opcion = '4';
              break;
          }
        }
         
         resp = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea Ingresar otra opcion?:"));
        } while(resp==1);
    }
    
    public static int[][] llenar(int fila, int columna){
        int [][] temp = new int[fila][columna];
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){
                temp[i][j]=rand.nextInt(100);
            }
        } return temp;
    } 
    public static int[][] llenar2(int fila,int columna){
        int [][] temp = new int[fila][columna];
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){
                temp[i][j]=rand.nextInt(10);
            }
        } return temp;
    }
    public static int[] llenar3 (int tamaño){
        int [] temp = new int[tamaño];
            for(int i=0;i<tamaño;i++){
                temp[i]=rand.nextInt(10);
            }
        return temp;    
    }
    public static String imprimir(int [][] matriz){
        String acum = " ";
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                acum += "["+matriz[i][j]+"]"+ " ";
            }
            acum+="\n";
        } return acum;
    }
   
    public static String imprimir_array(int[] arreglo){
        String acum = " ";
        for(int i=0;i<arreglo.length;i++){
            acum += "[" + arreglo[i] + "]"+" ";
        } return acum;
    }
    public static int menu(){
         int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Promedios\n2. De landscape a potrait\n3. Higher-Order contain\n\nIngrese una opcion: "));
      
        
        return opcion;
    }
    public static int menu_promedio(){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Calcular promedio de\n1. fila\n2. Columna"));
        return opcion;        
    }
    public static int[] promedio_fila(int[][]suma){
        int acum =0;
        int []temp = new int[suma.length];
        for(int i=0;i<suma.length;i++){
            for (int j=0;j<suma.length;j++){
                acum += suma[i][j];   
           } 
           temp[i]/= acum; //al momento de sacarlo y de crear otro for me daba error.
        } 
             
           
       
        return temp;
    }
    public static int[] promedio_columna(int[][]suma){
        int acum =0;
        int temp [] = new int[suma[0].length];
        for(int i=0;i<suma.length;i++){
            for (int j=0;j<suma.length;j++){
                acum += suma[i][j];
                temp[j]/= acum;
           } 
        }
       return temp;
    }
    public static int[][] potrait(int[][]matriz){
        int[] acum = new int[matriz.length];
        int [][] temp = new int[matriz[0].length][matriz.length];
        for(int i = matriz.length-1;i>=0;i--){
            for(int j=matriz[i].length-1;j>=0;j--){
              //  acum[j] = matriz[i][j];
               // if(acum[j]==matriz[i][j]){
                    temp[j][i] = matriz[i][j]; 
               // }
            }
        } 
        return temp;
    }
    public static boolean contains (int[][]matriz, int[] tam){
        boolean con = false;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                tam[i] = matriz[i][j];
                if(tam[i]==matriz[i][j]){
                    con = true;
                } else if(tam[j]==matriz[i][j]){
                    con = true;
                } else {
                    con = false;
                }
            }
        }
       return con; 
    }
}
