package model;

public class ClientesCompleto {
	private int idCliente;
	private String cpf;
	private String nome;
	private String sobrenome;
	private String email;
	private String ddd;
	private String numero;
	private String rua;
	private String numeroCasa;
	private String cep;
	
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
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String toString() {
		return "ID: " + idCliente + " / Nome Completo: " + nome + " " + sobrenome + 
			   "E-mail: " + email +
			   "CPF: " + cpf +
			   "Telefone: " + "(" + ddd + ")" + " " + numero +
			   "Rua: " + rua + ", " + numeroCasa +
			   "CEP: " + cep;
			   
	}
	
}
