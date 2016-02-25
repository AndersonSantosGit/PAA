package Quest3;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Scanner;

import Quest1.Nodo;

public class Q3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int e,l;
		//int cont= 0;
		ArrayList<ArrayList<Integer>> VetorGeral = new ArrayList<ArrayList<Integer>>();
		do{
			Scanner in = new Scanner(System.in);
			e = in.nextInt();
			l = in.nextInt();
			ArrayList<Nodo> nodos = new ArrayList<Nodo>();
			ArestaPeso arestas = new ArestaPeso(e);
			ArrayList<Integer> resultados = new ArrayList<Integer>();
			Nodo nodo;
			int i;
			for(i=1;i<=e;i++){
				nodo = new Nodo(i,e-1);
				nodos.add(nodo);
			}
			for(i=0;i<l;i++){
				int x = in.nextInt();
				int y = in.nextInt();
				int p = in.nextInt();
				nodos.get(x-1).liga(y);
				nodos.get(y-1).liga(x);
				arestas.listaPeso[x-1][y-1] = p;
				arestas.listaPeso[y-1][x-1] = p;
			}
			//Calculo p/ REsulataDO
			for(i=0;i< nodos.size();i++){
				resultados.add(i+1);
				int j =0;
				int custo = Integer.MAX_VALUE;
				int idAux=0;
				while((j<nodos.get(i).getLigacao().length)&&(nodos.get(i).getLigacao()[j]!=0)){
					int aux = arestas.custoAresta(nodos.get(i).getId(),nodos.get(i).getLigacao()[j]);
					if(custo>aux){
						custo = aux;
						idAux = nodos.get(i).getLigacao()[j];
					}
					j++;
				}
			resultados.add(idAux);
			}
			//remover repetidos
			
			int k;
			for(k=0;k<resultados.size()-2;k+=2){
				int h =0;
				for(h=k+2;h<resultados.size()-1;h+=2){
					if(resultados.get(k)==resultados.get(h+1)){
						if((resultados.get(k)==resultados.get(h))||(resultados.get(k)==resultados.get(h+1))&&
						   (resultados.get(k+1)==resultados.get(h)||(resultados.get(k+1)==resultados.get(h+1)))){
							resultados.remove(h+1);   
							resultados.remove(h);
						}
					}
				}
			}
			//Ordena os vetor
			for(k=0;k<resultados.size()-1;k+=2){
				if(resultados.get(k+1)<resultados.get(k)){
					int aux = resultados.get(k);
					resultados.remove(k);
					resultados.add(k+1, aux);
				}
			}
			//PC
			for(k=0;k<resultados.size()-3;k+=2){
				if(resultados.get(k)==resultados.get(k+2)){
					if(resultados.get(k+1)>resultados.get(k+3)){
						int temp = resultados.get(k+1);
						resultados.set(k+1,resultados.get(k+3));
						resultados.set(k+3,temp);
					}
				}
			}
			if(e!=0)
				VetorGeral.add(resultados);
			
		}
		while(e!=0 && l!=0);
		//testando
		int i;
		for(i=0;i<VetorGeral.size();i++){
			int j;
			System.out.println("Teste "+(i+1));
			for(j=0;j<VetorGeral.get(i).size()-1;j+=2){
				System.out.println(VetorGeral.get(i).get(j)+" "+VetorGeral.get(i).get(j+1));
			}
		}
	}
}
