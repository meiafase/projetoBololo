package model;

public class BoloSimples {
	
	private int id;
	private String tipoBoloSimples;
	private Double precoBoloSimples;
	private String nome;
	
	public BoloSimples() {

	}
	public BoloSimples(int id) {
		super();
		this.id = id;
	}
	
	public BoloSimples(String tipoBoloSimples, Double precoBoloSimples, String nome) {
		super();
		this.tipoBoloSimples = tipoBoloSimples;
		this.precoBoloSimples = precoBoloSimples;
		this.nome = nome;
	}
	public BoloSimples(int id, String tipoBoloSimples, Double precoBoloSimples, String nome) {
		super();
		this.id = id;
		this.tipoBoloSimples = tipoBoloSimples;
		this.precoBoloSimples = precoBoloSimples;
		this.nome = nome;
	}
	public BoloSimples(int id, String tipoBoloSimples, Double precoBoloSimples) {
		super();
		this.id = id;
		this.tipoBoloSimples = tipoBoloSimples;
		this.precoBoloSimples = precoBoloSimples;
	}
	
	public String getTipoBoloSimples() {
		return tipoBoloSimples;
	}
	public void setTipoBoloSimples(String tipoBoloSimples) {
		this.tipoBoloSimples = tipoBoloSimples;
	}
	public Double getPrecoBoloSimples() {
		return precoBoloSimples;
	}
	public void setPrecoBoloSimples(Double precoBoloSimples) {
		this.precoBoloSimples = precoBoloSimples;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "ID: " + id + " Bolo: " + tipoBoloSimples + " Preço: R$" + precoBoloSimples;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
