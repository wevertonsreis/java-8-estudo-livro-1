package br.com.estudo;

/*
 * Essa anota��o � opcional, mas se a mesma estiver presente o compilador n�o 
 * vai permitir que seja adicionado mais que um m�todo na interface
 */
@FunctionalInterface
public interface Validador<T> {
	
	boolean valida(T t);
	
}