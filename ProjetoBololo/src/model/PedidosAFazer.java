package model;

public class PedidosAFazer {
	
	private int id;
	private int idCliente;
	private String nome;
	private String pedido;
	private Double preco;
	private int status;

	public PedidosAFazer(int id) {
		super();
		this.id = id;
	}
	
	public PedidosAFazer(int id, int idCliente, String nome, String pedido, double preco) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.nome = nome;
		this.pedido = pedido;
		this.preco = preco;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String toString() {
		return "ID: " + id + " -- Cliente: " + nome + " / Pedido: " + pedido + " / Total: R$" + preco;
	}
}
