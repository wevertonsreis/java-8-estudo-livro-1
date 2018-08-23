package br.com.estudo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Capitulo7 {
	
	public static void main(String[] args) {
		tornandoModeradoresOs10UsuariosComMaisPontos();
		tornandoModeradoresOsUsuariosComMaisDe100Pontos();
		comoObterDeVoltaUmaLista();
	}
	
	/**
	 * 7.1 TORNANDO MODERADORES OS 10 USUÁRIOS COM MAIS PONTOS
	 */
	private static void tornandoModeradoresOs10UsuariosComMaisPontos() {
		Usuario usuario1 = new Usuario("Pedro", 150);
		Usuario usuario2 = new Usuario("Carlos", 160);
		Usuario usuario3 = new Usuario("Antonio", 90);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
		
		usuarios.subList(0, 2).forEach(Usuario::tornarModerador);
	}
	
	/**
	 * 7.2 STREAMS: TORNANDO MODERADORES OS USUÁRIOS COM MAIS DE 100 PONTOS
	 */
	private static void tornandoModeradoresOsUsuariosComMaisDe100Pontos() {
		Usuario usuario1 = new Usuario("Pedro", 150);
		usuario1.tornarModerador();
		
		Usuario usuario2 = new Usuario("Carlos", 160);
		Usuario usuario3 = new Usuario("Antonio", 20);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		Stream<Usuario> usuariosFiltrados = usuarios.stream().filter(u -> u.getPontos() > 100);
		
		usuariosFiltrados.forEach(System.out::println);
		
		usuarios.stream().filter(Usuario::isModerador).forEach(System.out::println);
	}
	
	/**
	 * 7.3 COMO OBTER DE VOLTA UMA LISTA?
	 */
	private static void comoObterDeVoltaUmaLista() {
		
	}
	
}