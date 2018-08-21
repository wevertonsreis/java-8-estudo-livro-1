package br.com.estudo;

import java.util.Arrays;
import java.util.List;

public class Capitulo2 {
	
	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario("Usuario 1", 150);
		Usuario usuario2 = new Usuario("Usuario 2", 160);
		Usuario usuario3 = new Usuario("Usuario 3", 120);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		Mostrador mostrador = new Mostrador();
		usuarios.forEach(mostrador);
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		usuarios.forEach(u -> u.tornarModerador());
		
	}
	
}