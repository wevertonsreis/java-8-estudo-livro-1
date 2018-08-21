package br.com.estudo;

class Usuario {

	private String nome;
	private int pontos;
	private boolean moderador;

	public Usuario(String nome, int pontos) {
		super();
		this.nome = nome;
		this.pontos = pontos;
		this.moderador = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void tornarModerador() {
		this.moderador = true;
	}

	public boolean isModerador() {
		return moderador;
	}

}

public class Capitulo2 {
	
	public static void main(String[] args) {
		
		
		
	}
	
}
