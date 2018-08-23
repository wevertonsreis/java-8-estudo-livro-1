package br.com.estudo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Capitulo5 {
	
	public static void main(String[] args) {
		Usuario usuario1 = new Usuario("Pedro", 150);
		Usuario usuario2 = new Usuario("Carlos", 160);
		Usuario usuario3 = new Usuario("Antonio", 120);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		Comparator<Usuario> camparadorSemLambda = new Comparator<Usuario>() {
			@Override
			public int compare(Usuario o1, Usuario o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		};
		Collections.sort(usuarios, camparadorSemLambda);
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		Comparator<Usuario> camparadorComLambda = (u1, u2) -> u1.getNome().compareTo(u2.getNome());
		Collections.sort(usuarios, camparadorComLambda);
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
		
		Comparator<Usuario> comparadorDeUsuario = Comparator.comparing(u -> u.getNome());
		usuarios.sort(comparadorDeUsuario);
		
		usuarios.sort(Comparator.comparing(u -> u.getNome()));
		usuarios.sort(Comparator.comparing(u -> u.getPontos()));
		
		usuarios.forEach(u -> System.out.println(u.getNome() + " " + u.getPontos()));
		
		Function<Usuario, Integer> func = u -> u.getPontos();
		usuarios.sort(Comparator.comparing(func));
	
		ToIntFunction<Usuario> intFunc = u -> u.getPontos();
		usuarios.sort(Comparator.comparingInt(intFunc));
		
		usuarios.forEach(Usuario::tornarModerador);
		usuarios.sort(Comparator.comparing(Usuario::getPontos));
		
		Function<Usuario, String> byName = Usuario::getNome;
		usuarios.sort(Comparator.comparing(byName));
		
		usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
		
		usuarios.forEach(System.out::println);
		
	}
	
}