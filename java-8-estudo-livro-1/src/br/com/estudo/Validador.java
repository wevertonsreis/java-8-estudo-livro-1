package br.com.estudo;

/*
 * Essa anotação é opcional, mas se a mesma estiver presente o compilador não 
 * vai permitir que seja adicionado mais que um método na interface
 */
@FunctionalInterface
public interface Validador<T> {
	
	boolean valida(T t);
	
}