package view;

import model.ArvoreBB;

public class ABBVisao {

	public static void main(String[] args) {

		ArvoreBB abb = new ArvoreBB();
		abb.insert(32);
		abb.insert(13);
		abb.insert(5);
		abb.insert(41);
		abb.insert(20);
		abb.insert(60);

		System.out.println("Pre - Ordem: ");
		abb.preOrder();
		System.out.println("\nOrdem Simetrica: ");
		abb.inOrder();
		System.out.println("\nFuncoes: ");
		System.out.println(abb.getElementInOrder(1));
		System.out.println(abb.getPositionInOrder(5));
		System.out.println(abb.getMedian());
		System.out.println(abb.getMean(32));
		System.out.println("ALTURA: " + abb.root.getHeight());
		System.out.println(abb.root.getSizeLeft());
		System.out.println(abb.root.getSizeRight());
		System.out.println("Eh COMPLETA?" + abb.isComplete());
		System.out.println("EH CHEIA????????????" + abb.isFull());

		abb.printArvore();

		abb.remove(10);

		abb.printArvore();
		System.out.println("\nOrdem Simetrica: ");
		abb.inOrder();
		System.out.println("ALTURA: " + abb.root.getHeight());
		System.out.println(abb.root.getSizeLeft());
		System.out.println(abb.root.getSizeRight());
		System.out.println("Eh COMPLETA?" + abb.isComplete());
		System.out.println("EH CHEIA????????????" + abb.isFull());
		System.out.println(abb.getMedian());
		System.out.println(abb.getMean(32));
	}
}
