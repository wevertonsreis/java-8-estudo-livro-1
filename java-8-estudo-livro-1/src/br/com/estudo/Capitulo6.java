package br.com.estudo;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Capitulo6 {
	
	public static void main(String[] args) {
		methodReferenceQueInvocaMetodo();
		referenciandoMetodosQueRecebemArgumentos();
		referenciandoConstrutores();
		outrosTiposDeReferencia();
	}
	
	/**
	 * 
	 */
	private static void methodReferenceQueInvocaMetodo() {
		Usuario usuario = new Usuario("Weverton Reis", 100);
		Runnable runnable = usuario::tornarModerador;
		runnable.run();
		
		System.out.println("Usuario moderador: " + usuario.isModerador());
		
		//Formas equivalentes
		Runnable bloco1 = usuario::tornarModerador;
		Runnable bloco2 = () -> usuario.tornarModerador();
		bloco1.run();
		bloco2.run();		
		
	}
	
	/**
	 * 6.5 REFERENCIANDO MÉTODOS QUE RECEBEM ARGUMENTOS
	 */
	private static void referenciandoMetodosQueRecebemArgumentos() {
		Usuario usuario1 = new Usuario("Pedro", 150);
		Usuario usuario2 = new Usuario("Carlos", 160);
		Usuario usuario3 = new Usuario("Antonio", 120);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		/*
		 * As duas formas a seguir são equivalentes
		 */
		usuarios.forEach(System.out::println);
		usuarios.forEach(u -> System.out.println(u));
		
	}
	
	/**
	 * 6.6 REFERENCIANDO CONSTRUTORES
	 */
	private static void referenciandoConstrutores() {
		// Criando a partir do construtor padrao
		Supplier<Usuario> criadorDeUsuarios1 = Usuario::new;
		Usuario novo = criadorDeUsuarios1.get();
		System.out.println("Usuario criado: " + novo);
		
		// Criando a partir de um construtor com um argumento
		Function<String, Usuario> criadorDeUsuarios2 = Usuario::new;
		Usuario usuario1 = criadorDeUsuarios2.apply("Pedro");
		Usuario usuario2 = criadorDeUsuarios2.apply("Carlos");
		Usuario usuario3 = criadorDeUsuarios2.apply("Antonio");
		System.out.println("Usuario1 criado: " + usuario1.getNome());
		System.out.println("Usuario2 criado: " + usuario2.getNome());
		System.out.println("Usuario3 criado: " + usuario3.getNome());
		
		// Criando a partir de um construtot com dois argumentos
		BiFunction<String, Integer, Usuario> criadorDeUsuarios3 = Usuario::new;
		Usuario usuario2argumentos = criadorDeUsuarios3.apply("Pedro", 150);
		System.out.println("Usuario criado: "+ usuario2argumentos.getNome() + " " + usuario2argumentos.getPontos());
	}
	
	/**
	 * 6.7 OUTROS TIPOS DE REFERÊNCIAS
	 */
	private static void outrosTiposDeReferencia() {
		int valor1 = Math.max(1, 5);
		System.out.println("valor 1: " + valor1);
		
		BiFunction<Integer, Integer, Integer> max2 = Math::max;
		Integer valor2 = max2.apply(2, 6);
		System.out.println("valor 2: " + valor2);
		
		
		
	}
	
}