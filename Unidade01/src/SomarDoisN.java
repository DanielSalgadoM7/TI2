//Daniel Salgado Magalhães - 821429

import java.util.*;
class SomarDoisN {
public static Scanner sc = new Scanner(System.in);

public static void main (String args[]){
	//Declarar as variáveis
	int n1, n2, soma;
	
	//Ler os números
	System.out.println("Digite o 1° número: ");
	n1 = sc.nextInt();
	System.out.println("Digite o 2° número: ");
	n2 = sc.nextInt();
	
	//Soma dos números
	soma = n1 + n2;
	
	//Mostrar a soma na tela
	System.out.println("A soma do número " +n1+ " e do número "+n2+" é: " +soma);
	}
}
