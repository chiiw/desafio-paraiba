package juba.iba.dp.model.util;

public enum FaixaEtaria {
	CRIANCA("Criança", " < 12"),
	ADOLESCENTE("Adolescente", "12-17"),
	JOVEM("Jovem", "18-29"),
	JOVEM_CASADO("Jovem Casado", "18-29"),
	ADULTO("Adulto","30-64"),
	IDOSO("Idoso", " > 65");
	
	private String name;
	private String range;
	
	private FaixaEtaria(String name, String range) {
		this.name = name;
		this.range = range;
	}
	
	@Override
	public String toString() {
		return name + " [" + range + "]";
	}
	
	public String getName() {
		return name;
	}
}
