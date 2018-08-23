package br.com.estudo;

public class Capitulo3 {
	
	public static void main(String[] args) {
		
		Validador<String> validadorDeCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
		
		validadorDeCEP.valida("11718-050");
	}
	
}
