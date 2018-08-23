package br.com.estudo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo4 {
	
	public static void main(String[] args) {
		Usuario usuario1 = new Usuario("Usuario 1", 150);
		Usuario usuario2 = new Usuario("Usuario 2", 160);
		Usuario usuario3 = new Usuario("Usuario 3", 120);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		Consumer<Usuario> mostrarMensagem = u -> System.out.println("antes de imprimir os nomes");
		
		Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome()); 
		
		usuarios.forEach(mostrarMensagem.andThen(imprimeNome));
		
	}
	
}
