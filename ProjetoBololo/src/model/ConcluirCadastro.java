package model;

public class ConcluirCadastro {
	
	private int idCliente;
	private int idBoloSimples;
	private String rua;
	private String numero;
	private String cep;
	private String ddd;
	private String numeroCelular;
	private String nome;
	private String sobrenome;
	private String email;
	private String cpf;
	
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

	private String senha;
	private String tipo;
	

	public ConcluirCadastro(int idCliente, String rua, String numero, String cep, String ddd, String numeroCelular, int idBoloSimples, String cpf, String nome, String sobrenome, String email, String senha, String tipo) {
		super();
		this.idCliente = idCliente;
		this.idBoloSimples = idBoloSimples;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.ddd = ddd;
		this.numeroCelular = numeroCelular;
		
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}


	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public int getIdBoloSimples() {
		return idBoloSimples;
	}

	public void setIdBoloSimples(int idBoloSimples) {
		this.idBoloSimples = idBoloSimples;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
