package juba.iba.dp.model;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 5974260824055706870L;

	private String nome;
	private String login;
	private String passwd;
	
	public Admin(String nome, String login, String passwd) {
		this.nome = nome;
		this.login = login;
		this.passwd = passwd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
