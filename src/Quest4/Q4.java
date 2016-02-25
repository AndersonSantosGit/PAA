package Quest4;

import java.util.ArrayList;
import java.util.Scanner;

import Quest1.Nodo;
import Quest3.ArestaPeso;

public class Q4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int e,l;		
		ArrayList<ArrayList<Integer>> VetorGeral = new ArrayList<ArrayList<Integer>>();
		
		Scanner in = new Scanner(System.in);
		e = in.nextInt();
		l = in.nextInt();
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		ArestaPeso arestas = new ArestaPeso(e+2);
		ArrayList<Integer> resultados = new ArrayList<Integer>();
		Nodo nodo;
		//instanciando pedrinho local
		nodo = new Nodo(-1,e+1);
		nodos.add(nodo);
		//instanciando pilares
		int i;
		for(i=1;i<=e;i++){
			nodo = new Nodo(i,e+1);
			nodos.add(nodo);
		}
		//instanciando o acampamento
		nodo = new Nodo(e+1,e+1);
		nodos.add(nodo);
		
		for(i=0;i<l;i++){
			int x = in.nextInt();
			int y = in.nextInt();
			int p = in.nextInt();

			if(x==0){
				nodos.get(y).liga(x-1);
				nodos.get(x).liga(y);
			}
			else if(y==0){
				nodos.get(y).liga(x);
				nodos.get(x).liga(y-1);
			}
			else{
				nodos.get(y).liga(x);
				nodos.get(x).liga(y);
			}
			arestas.setListaPeso(x,y,p);
			arestas.setListaPeso(y,x,p);
			//arestas.listaPeso[y-1][x-1] = p;		
		}
		/**
		//Calculo p/ REsulataDO
		int contador = 0;
		ArrayList<Integer> visitados = new ArrayList<Integer>();
		for(i=0;i< nodos.size();i++){
			visitados.add(-1);
			int j =0;
			int custo = Integer.MAX_VALUE;
			//int idAux=0;
			while((j<nodos.get(i).getLigacao().length)&&(nodos.get(i).getLigacao()[j]!=0)){
					if((!visitados.contains(nodos.get(i).getLigacao()[j]))&&(nodos.get(i).getLigacao()[j]!=nodo.getId())){
						int aux = arestas.custoAresta(nodos.get(0).getId(),nodos.get(0).getLigacao()[j]);
						if(custo>aux){
							contador+=aux;
							custo = aux;
							i=nodos.get(0).getLigacao()[j]-1;
							//idAux = nodos.get(i).getLigacao()[j];
							//visitados.add(nodos.get(i).getId());
						}
					}
					visitados.add(nodos.get(0).getId());
					j++;
			}
		}
		
		int custo = Integer.MAX_VALUE;
		*/
		ArrayList<Integer> visitados = new ArrayList<Integer>();
		System.out.println(arestas.calculoF(-1, nodos, arestas, Integer.MAX_VALUE,0,visitados));
	}
}