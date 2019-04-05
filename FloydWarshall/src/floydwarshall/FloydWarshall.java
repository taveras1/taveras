/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floydwarshall;

import static jdk.nashorn.internal.objects.Global.print;

/**
 *
 * @author taveras
 */
public class FloydWarshall {

    /**
     * @param args the command line arguments
     */
    static void floydWarshall(int grafo[][]){
        int n= grafo.length;
    int distancia[][]=getMatriz(0,grafo);
    int caminos[][]=getMatriz(1,grafo);
    int tmp;
    print("Matriz de distancias inicial: ", distancia);
    print("Matriz de caminos inicial", caminos);
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp=distancia[i][k]+ distancia[k][j];
                    if (tmp<distancia[i][j]) {
                        distancia[i][j]=tmp;
                        caminos[i][j]=k;
                        
                    }
                }
            }
    
        }
        print("Matriz de distancias final: ", distancia);
        print("Matriz de caminos final", caminos);
    }
    
    
    static int[][] getMatriz(int tipo,int grafo[][]){
    int n= grafo.length;
    int M[][]= new int [n][n];
        if (tipo==1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    M[i][j]=j;
                    
                }
            }
        }else{
        int INF=9999;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i!=j && grafo[i][j]==0) {
                        M[i][j]=INF;
                        
                    }else{
                    M[i][j]=grafo[i][j];
                    }
                }
            }
        }
        return M;
    }
    public static void main(String[] args) {
        int grafo[][]=
        {
              {0,2,0,2,0},
              {3,0,0,2,0},
              {8,0,0,2,1},
              {8,7,0,0,0},
              {0,3,0,2,0},
        };
    }
    
}
