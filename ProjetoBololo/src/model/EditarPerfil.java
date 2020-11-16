package model;

public class EditarPerfil {
	
	private String novoEditado;
	private int idCliente;
	private String nome;
	private String sobrenome;
	private String email;
	private String cpf;
	private String senha;
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

	private String tipo;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EditarPerfil(int idCliente, String novoEditado, String cpf, String nome, String sobrenome, String email, String senha, String tipo) {
		super();
		this.novoEditado = novoEditado;
		this.idCliente = idCliente;
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.tipo = tipo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNovoEditado() {
		return novoEditado;
	}

	public void setNovoEditado(String novoEditado) {
		this.novoEditado = novoEditado;
	}

}
