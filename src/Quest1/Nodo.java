package Quest1;

import java.util.ArrayList;
import java.util.Arrays;

import sun.security.util.Length;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Nodo {

	private int id = 0;
	private int[] ligacao;
	private int cont =0;
	
	public Nodo(int i,int quantLiga){
		ligacao = new int[quantLiga];
		this.id = i;
	}
	public Nodo(int i){
		this.id = i;
	}
	
	public int getId() {
		return id;
	}
	
	public int[] getLigacao() {
		return ligacao;
	}
	public void liga(int id){
		ligacao[cont] = id;
		cont++;
	}
	
	public void liga2(int id){
	
	}
	public boolean verifica(ArrayList<Nodo> nodos){
		int i=0;
		for(i=0;i<nodos.size();i++){
			if(nodos.get(i).getLigacao().length == 0){
				return false;
			}
		}
		return true;
	}
	
	
	public int calcDis(ArrayList<Nodo> nodos,ArrayList<Integer> vetorRes){
		for(int i=0;i<nodos.size();i++){
			int j;
			Nodo noAux = nodos.get(i);
			for(j=0;j<noAux.getLigacao().length;j++){
				if((noAux.getLigacao()[j]!=0)&& !(vetorRes.contains(noAux.getLigacao()[j]))){
					if(noAux.getLigacao()[j+1]==0){
						vetorRes.add(noAux.getLigacao()[j]);
						break;
					}
					else{
						int aux = j;
						int nodoEscolhido = 0;
						int nodo2;
						int proximo=0;
						while(noAux.getLigacao()[aux]!=0){
							nodo2 = calDis2(nodos, vetorRes, noAux.getLigacao()[aux]);	
							if(nodo2>= nodoEscolhido){
								nodoEscolhido = nodo2;
								i = noAux.getLigacao()[aux]-2;
								proximo = noAux.getLigacao()[aux];
							}
							aux++;
						}
 						vetorRes.add(proximo);
						break;
					}
				}
			}
		}
		return vetorRes.size()-1;
	}
	public int calDis2(ArrayList<Nodo> nodos,ArrayList<Integer> vetorRes,int id){
		int contador= 0;
		int j;
		Nodo noAux = nodos.get(id-1);
			for(j=0;j<noAux.getLigacao().length;j++){
				if((noAux.getLigacao()[j]!=0)&&!(vetorRes.contains(noAux.getLigacao()[j]))){
					contador++;
				}
			}
		return contador;
	}
	
}
