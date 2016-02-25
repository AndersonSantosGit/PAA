package Quest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

	private static final Object[] Nodo = null;

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int e,l;
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		boolean[] resultados = new boolean[5]; 
		int cont= 0;
		do{
			Scanner in = new Scanner(System.in);
			e = in.nextInt();
			l = in.nextInt();
			ArrayList<Nodo> nodos = new ArrayList<Nodo>();
			Nodo nodo;
			int i;
			for(i=1;i<=e;i++){
				nodo = new Nodo(i,e-1);
				nodos.add(nodo);
			}
			for(i=0;i<l;i++){
				int x = in.nextInt();
				int y = in.nextInt();
				nodos.get(x-1).liga(y);
				nodos.get(y-1).liga(x);
			}
			//Verificacao
			for(i=0;i< nodos.size();i++){
				int j;
				for(j=0;j<nodos.get(i).getLigacao().length;j++){
					if(nodos.get(i).getLigacao()[j] != 0){
						if(i==nodos.size()-1){
							result.add(cont, false);
						}
						break;
					}
					else{
						if(j==(nodos.get(i).getLigacao().length)-1){
								result.add(cont, true);
								i = nodos.size();
								break;
						}
					}
				}
			}
			cont++;
		}
		while(e!=0 && l!=0);
		int i;
		for(i=0;i<result.size();i++){
			if(result.get(i)==true){
				System.out.print("TESTE"+(i+1));
				System.out.println("\nFALHA\n");
			}
			else{
				System.out.print("TESTE"+(i+1));
				System.out.println("\nNORMAL\n");
			}
		}
	}

}
