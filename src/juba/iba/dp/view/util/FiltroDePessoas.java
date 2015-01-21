package juba.iba.dp.view.util;

import juba.iba.dp.model.util.FaixaEtaria;

public class FiltroDePessoas {
	
	private boolean filtroIdade;
	private FaixaEtaria faixaEtaria;

	private boolean filtroFezLicao;
	private int licaoSim;

	private boolean filtroNaoFezLicao;
	private int licaoNao;
	
	public FiltroDePessoas(boolean idade, FaixaEtaria faixaEtaria,
			boolean fezLicao, int licaoSim, boolean naoFezLicao,
			int licaoNao) {
		this.filtroIdade = idade;
		this.faixaEtaria = faixaEtaria;
		this.filtroFezLicao = fezLicao;
		this.licaoSim = licaoSim;
		this.filtroNaoFezLicao = naoFezLicao;
		this.licaoNao = licaoNao;
	}

	public FiltroDePessoas() {
		// TODO Auto-generated constructor stub
	}

	public boolean isFiltroIdade() {
		return filtroIdade;
	}

	public void setFiltroIdade(boolean idade) {
		this.filtroIdade = idade;
	}

	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public boolean isFiltroFezLicao() {
		return filtroFezLicao;
	}

	public void setFiltroFezLicao(boolean fezLicao) {
		this.filtroFezLicao = fezLicao;
	}

	public int getLicaoSim() {
		return licaoSim;
	}

	public void setLicaoSim(int licaoSim) {
		this.licaoSim = licaoSim;
	}

	public boolean isFiltroNaoFezLicao() {
		return filtroNaoFezLicao;
	}

	public void setFiltroNaoFezLicao(boolean naoFezLicao) {
		this.filtroNaoFezLicao = naoFezLicao;
	}

	public int getLicaoNao() {
		return licaoNao;
	}

	public void setLicaoNao(int licaoNao) {
		this.licaoNao = licaoNao;
	}
	
	public boolean isAlgumFiltro() {
		return isFiltroIdade() || isFiltroFezLicao() || isFiltroNaoFezLicao();
	}
}
