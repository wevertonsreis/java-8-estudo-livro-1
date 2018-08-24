package br.com.estudo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Capitulo7 {
	
	public static void main(String[] args) {
		tornandoModeradoresOs10UsuariosComMaisPontos();
		tornandoModeradoresOsUsuariosComMaisDe100Pontos();
		comoObterDeVoltaUmaLista();
		collectors();
		listeApenasOsPontosDeTodosOsUsuariosComOMap();
		intstreamEAFamiliaDeStreams();
		oOptionalEmJavaUtil();
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
		Usuario usuario1 = new Usuario("Pedro", 150);
		Usuario usuario2 = new Usuario("Carlos", 160);
		Usuario usuario3 = new Usuario("Antonio", 20);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		List<Usuario> usuariosMais100Pontos = new ArrayList<>();
		
		usuarios.stream()
			.filter(u -> u.getPontos() > 100)
			.forEach(usuariosMais100Pontos::add);
	}
	
	/**
	 * 7.4 COLLECTORS
	 */
	private static void collectors() {
		System.out.println("chamando o metodo collectors");
		
		Usuario usuario1 = new Usuario("Pedro", 150);
		Usuario usuario2 = new Usuario("Carlos", 160);
		Usuario usuario3 = new Usuario("Antonio", 110);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
		BiConsumer<ArrayList<Usuario>, Usuario> accumulator = ArrayList::add;
		BiConsumer<ArrayList<Usuario>, ArrayList<Usuario>> combiner = ArrayList::addAll;
		
		List<Usuario> maisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100).collect(supplier, accumulator, combiner);
		maisQue100.forEach(System.out::println);
		
		maisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		maisQue100.forEach(System.out::println);
		
		maisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100).collect(Collectors.toList());
		maisQue100.forEach(System.out::println);
	}
	
	/**
	 * 7.6 LISTE APENAS OS PONTOS DE TODOS OS USUÁRIOS COM O MAP
	 */
	private static void listeApenasOsPontosDeTodosOsUsuariosComOMap() {
		System.out.println("chamando o metodo listeApenasOsPontosDeTodosOsUsuariosComOMap");
		
		Usuario usuario1 = new Usuario("Pedro", 150);
		Usuario usuario2 = new Usuario("Carlos", 160);
		Usuario usuario3 = new Usuario("Antonio", 110);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		List<Integer> pontos = usuarios.stream().map(Usuario::getPontos).collect(Collectors.toList());
		pontos.forEach(System.out::println);
	}
	
	/**
	 * 7.7 INTSTREAM E A FAMÍLIA DE STREAMS
	 */
	private static void intstreamEAFamiliaDeStreams() {
		System.out.println("chamando o metodo intstreamEAFamiliaDeStreams");
		
		Usuario usuario1 = new Usuario("Pedro", 150);
		Usuario usuario2 = new Usuario("Carlos", 160);
		Usuario usuario3 = new Usuario("Antonio", 110);
		
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);
		
		double pontuacaoMedia = usuarios.stream().mapToInt(Usuario::getPontos).average().getAsDouble();
		
		System.out.println("media: " + pontuacaoMedia);	
	}
	
	/**
	 * 7.8 O OPTIONAL EM JAVA.UTIL
	 */
	private static void oOptionalEmJavaUtil() {
		System.out.println("chamando o metodo oOptionalEmJavaUtil");
		
		List<Usuario> usuarios = new ArrayList<>();
		
		double media1 = usuarios.stream().mapToInt(Usuario::getPontos).average().orElse(0.0);
		System.out.println(media1);
		
		try {
			double media2 = usuarios.stream().mapToInt(Usuario::getPontos).average().orElseThrow(IllegalStateException::new);
			System.out.println(media2);
		} catch (Exception e) {
			System.out.println("erro esperado para teste: " + e);
		}
		
	}
	
}