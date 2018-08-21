package br.com.estudo;

import java.util.function.Consumer;

public class Mostrador implements Consumer<Usuario> {

	@Override
	public void accept(Usuario usuario) {
		System.out.println(usuario);
	}

}