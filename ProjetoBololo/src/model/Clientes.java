package model;

public class Clientes {
	private int idCliente;
	private String cpf;
	private String nome;
	private String sobrenome;
	private String email;
	
	public Clientes() {
		super();
	}
	public Clientes(int idCliente, String cpf, String nome, String sobrenome, String email, String tipo) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public String toString() {
		return "ID: " + idCliente + " / Nome Completo: " + nome + " " + sobrenome + " / E-mail: " + email;
	}
	

}
