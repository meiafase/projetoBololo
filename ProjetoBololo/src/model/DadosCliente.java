package model;

public class DadosCliente {
	
	private String cpf;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String tipo;
	
	
	public DadosCliente(String cpf, String nome, String sobrenome, String email, String senha, String tipo) {
		// TODO Auto-generated constructor stub
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "CPF: " + cpf +
			   "Nome:  " + nome + 
			   "Sobrenome:  " + sobrenome +
			   "E-mail:  " + email +
			   "Senha:  " + senha + 
			   "Tipo:  " + tipo;
	}



}
