package Quest3;

import java.util.ArrayList;

import Quest1.Nodo;

public class ArestaPeso {
	
	int[][] listaPeso;
	
	public ArestaPeso(int numeroMaximo) {
		this.listaPeso = new int[numeroMaximo][numeroMaximo];
	}
	public int custoAresta(int id1,int id2){
		if(id1==-1||id2==-1){
			if(id1==-1){
				if(listaPeso[0][id2-1]==0){
					return Integer.MAX_VALUE;
				}
				else{
					return listaPeso[0][id2-1];
				}
			}
			if(id2==-1){
				if(listaPeso[id1-1][0]==0){
					return Integer.MAX_VALUE;
				}
				else{
					return listaPeso[id1-1][0];
				}
			}
		}
		else{
			if(listaPeso[id1-1][id2-1]==0){
				return Integer.MAX_VALUE;
			}
			else{
				return listaPeso[id1-1][id2-1];
			}
		}
		return Integer.MAX_VALUE;
	}
	public int custoAresta2(int id1,int id2){
		if(id1==-1||id2==-1){
			if(id1==-1){
				if(listaPeso[0][id2-1]==0){
					return Integer.MAX_VALUE;
				}
				else{
					return listaPeso[0][id2-1];
				}
			}
			if(id2==-1){
				if(listaPeso[id1-1][0]==0){
					return Integer.MAX_VALUE;
				}
				else{
					return listaPeso[id1-1][0];
				}
			}
		}
		else{
			if(listaPeso[id1-1][id2-1]==0){
				return Integer.MAX_VALUE;
			}
			else{
				return listaPeso[id1-1][id2-1];
			}
		}
		return Integer.MAX_VALUE;
	}
	public int[][] getListaPeso() {
		return listaPeso;
	}
	public void setListaPeso(int x,int y,int p) {
		this.listaPeso[x][y] = p;
	}
	
	
	
	
	
	
	 
	//int contador = 0;
	public int calculoF(int id,ArrayList<Nodo> nodos,ArestaPeso arestas,int custo,int contador,ArrayList<Integer> visitados){
		int i = id;
		if(id==nodos.get(nodos.size()-1).getId()){
			return 0;
		}
		else{
			int j =0;
			if(i==-1)
				i=0;
			visitados.add(nodos.get(i).getId());
			while((j<nodos.get(i).getLigacao().length)&&(nodos.get(i).getLigacao()[j]!=0)){	
				if((!visitados.contains(nodos.get(i).getLigacao()[j]))){
					int aux = arestas.custoAresta(nodos.get(i).getId(),nodos.get(i).getLigacao()[j]);
					int aux2 = calculoF(nodos.get(nodos.get(i).getLigacao()[j]).getId(),nodos,arestas,aux,contador,visitados);
					if(custo>aux2 && aux2 != 0){
						contador+=aux2;
						custo = aux2;
						//i=nodos.get(i).getLigacao()[j]-1;
					}
				}
				j++;
			}
			return contador;
		}
		//return contador;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
