package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.ArvoreBB;

public class ABBVisaoArquivo {

	public static void main(String[] args) {
		ArvoreBB abb = new ArvoreBB();
		String path = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");
		
		File arquivoEntrada = new File(path + sep + args[0]);
		Scanner scanEntrada = null;
		Scanner scanComandos = null;
		try {
			scanEntrada = new Scanner(arquivoEntrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		File arquivoComandos = new File(path + sep + args[1]);
		try {
			scanComandos = new Scanner(arquivoComandos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String comando, valor;

		while (scanEntrada.hasNext()) {
			valor = scanEntrada.next();
			abb.insert(Integer.parseInt(valor));
		}
		int sum_before = 0;
		int sum_after = 0;

		while (scanComandos.hasNext()) {
			comando = scanComandos.next();

			switch (comando) {
			case "CHEIA":
				if (abb.isFull()) {
					System.out.println("A arvore  eh cheia");
				} else {
					System.out.println("A arvore nao eh cheia");
				}
				break;
			case "COMPLETA":
				if (abb.isComplete()) {
					System.out.println("A arvore  eh completa");
				} else {
					System.out.println("A arvore nao eh completa");
				}
				break;
			case "ENESIMO":
				valor = scanComandos.next();
				int element = abb.getElementInOrder(Integer.parseInt(valor));
				if (element != -1) {
					System.out.println(element);
				}

				break;
			case "INSIRA":
				valor = scanComandos.next();
				sum_before = abb.root.getSumOfKeysSubtree();
				abb.insert(Integer.parseInt(valor));
				sum_after = abb.root.getSumOfKeysSubtree();
				if (sum_after == sum_before) {
					System.out.println(valor + " ja esta na arvore, nao pode ser adicionado");
				} else {
					System.out.println(valor + " adicionado");
				}

				break;
			case "PREORDEM":
				abb.preOrder();
				System.out.println();
				break;
			case "IMPRIMA":
				valor = scanComandos.next();
				if (valor.equals("1")) {
					abb.printArvoreLevels();
				} else if (valor.equals("2")) {
					abb.printArvoreParentese();
				}
				System.out.println();
				break;
			case "REMOVA":
				valor = scanComandos.next();
				sum_before = abb.root.getSumOfKeysSubtree();
				abb.remove(Integer.parseInt(valor));
				sum_after = abb.root.getSumOfKeysSubtree();
				if (sum_after == sum_before) {
					System.out.println(valor + " nao esta na arvore, nao pode ser removido");
				} else {
					System.out.println(valor + " removido");
				}
				break;
			case "POSICAO":
				valor = scanComandos.next();
				if (abb.getPositionInOrder(Integer.parseInt(valor)) == -1) {
					System.out.println("Elemento nao encontrado");
				} else {
					System.out.println(abb.getPositionInOrder(Integer.parseInt(valor)));
				}

				break;
			case "MEDIANA":
				System.out.println(abb.getMedian());
				break;
			case "MEDIA":
				valor = scanComandos.next();
				System.out.println(abb.getMean(Integer.parseInt(valor)));
				break;
			case "BUSCAR":
				valor = scanComandos.next();
				if (abb.searchNodeByKey(Integer.parseInt(valor))) {
					System.out.println("Chave encontrada");
				} else {
					System.out.println("Chave nao encontrada");
				}
				break;
			}

		}

	}
}
