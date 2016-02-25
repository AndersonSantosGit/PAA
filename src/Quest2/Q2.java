package Quest2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import Quest1.Nodo;

public class Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		ArrayList<Integer> vetorRes = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		Nodo nodo;
		int i;
		for(i=1;i<=n;i++){
			nodo = new Nodo(i,n-1);
			nodos.add(nodo);
		}
		for(i=1;i<n;i++){
			int x = in.nextInt();
			int y = in.nextInt();
			nodos.get(x-1).liga(y);
			nodos.get(y-1).liga(x);
		}
		
		Nodo comeco = null;
		int aux = 0;
		for(i=0;i<nodos.size();i++){
			int j;
			int aux2 = 0;
			for(j=0;j<n-1;j++){
				if(nodos.get(i).getLigacao()[j]==0){
					aux2++;
				}
			}
			if(aux2>aux){
				aux = aux2;
				comeco = (Nodo) nodos.get(i);
				
			}
		}
		vetorRes.add(comeco.getId());
		
		System.out.println(comeco.calcDis(nodos,vetorRes));

	}
}
