package juba.iba.dp.model.util;

public enum Evento {
	CULTO("Culto"), FILME("Filme"), ESPETACULO("Espetáculo"),
	TEATRO_RUA("Teatro de Rua"), ATEND_SOCIAL("Atendimento Social"),
	CULTO_FEIRA("Culto na Feira"), INFANTIL("Infantil");
	
	private String nome;
	
	private Evento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
