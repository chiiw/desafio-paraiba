package juba.iba.dp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import juba.iba.dp.model.util.Evento;
import juba.iba.dp.model.util.FaixaEtaria;
import juba.iba.dp.model.util.Licoes;

public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1033226352931958257L;

	private String nome;
	private FaixaEtaria faixaEtaria;
	private String endereco;
	private String numero;
	private String bairro;
	private String pontoReferencia;
	private String email;
	private String telefone1;
	private String telefone2;
	
	private boolean evangelismo;
	private boolean biblia;
	private List<Evento> eventos;
	private String igreja;
	private List<String> filhosNoInfantil = new ArrayList<String>();
	private Licoes licoes;
	private String diaParaEstudo;
	private String dataOracaoConversao;
	private List<String> discipuladores = new ArrayList<String>();
	private String pedidosOracao;
	private String observacoes;
	
	private Admin responsavel;
	
	public Pessoa(String nome) throws Exception {
		if (nome == null || nome.length() < 3) {
			throw new Exception("O nome precisa ter pelo menos 3 caracteres");
		}
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public boolean isEvangelismo() {
		return evangelismo;
	}
	public void setEvangelismo(boolean evangelismo) {
		this.evangelismo = evangelismo;
	}
	public boolean isBiblia() {
		return biblia;
	}
	public void setBiblia(boolean biblia) {
		this.biblia = biblia;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public String getIgreja() {
		return igreja;
	}
	public void setIgreja(String igreja) {
		this.igreja = igreja;
	}
	public List<String> getFilhosNoInfantil() {
		return filhosNoInfantil;
	}
	public void setFilhosNoInfantil(String[] filhos) {
		filhosNoInfantil.clear();
		for (String filho : filhos)
			if (filho != null && (!filho.trim().equals("")))
				this.filhosNoInfantil.add(filho);
	}
	public Licoes getLicoes() {
		return licoes;
	}
	public void setLicoes(Licoes licoes) {
		this.licoes = licoes;
	}
	public String getDiaParaEstudo() {
		return diaParaEstudo;
	}
	public void setDiaParaEstudo(String diaParaEstudo) {
		this.diaParaEstudo = diaParaEstudo;
	}
	public String getDataOracaoConversao() {
		return dataOracaoConversao;
	}
	public void setDataOracaoConversao(String dataOracaoConversao) {
		this.dataOracaoConversao = dataOracaoConversao;
	}
	public String getPedidosOracao() {
		return pedidosOracao;
	}
	public void setPedidosOracao(String pedidosOracao) {
		this.pedidosOracao = pedidosOracao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getNomeArquivo() {
		return nome.replace(" ", "_");
	}
	public List<String> getDiscipuladores() {
		return discipuladores;
	}
	public void setDiscipuladores(String[] nomes) {
		discipuladores.clear();
		for (String nome : nomes)
			if (nome != null && (!nome.trim().equals("")))
				discipuladores.add(nome);
	}
	public Admin getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Admin responsavel) {
		this.responsavel = responsavel;
	}

	public String toStringCompleto() {
		return "Pessoa [nome=" + nome + ", faixaEtaria=" + faixaEtaria
				+ ", endereco=" + endereco + ", numero=" + numero + ", bairro="
				+ bairro + ", pontoReferencia=" + pontoReferencia + ", email="
				+ email + ", telefone1=" + telefone1 + ", telefone2="
				+ telefone2 + ", evangelismo=" + evangelismo + ", biblia="
				+ biblia + ", eventos=" + eventos + ", igreja=" + igreja
				+ ", filhosNoInfantil=" + filhosNoInfantil + ", licoes="
				+ licoes + ", diaParaEstudo=" + diaParaEstudo
				+ ", dataOracaoConversao=" + dataOracaoConversao
				+ ", discipuladores=" + discipuladores + ", pedidosOracao="
				+ pedidosOracao + ", observacoes=" + observacoes
				+ ", responsavel=" + responsavel + "]";
	}
	
	@Override
	public String toString() {
		return nome + " [" + faixaEtaria.getName() + "] " + endereco;
	}

	public String getDiscipuladoresString() {
		StringBuffer sb = new StringBuffer();
		for (String d : discipuladores) {
			sb.append(d).append(", ");
		}
		try {
			return sb.substring(0, sb.length() - 2);
		} catch (Exception e) {
			return "";
		}
	}
}
