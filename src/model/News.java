package model;

public class News implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descricao;
	private String titulo ;
	private String texto ;

	public News() {}
	
	public News(int id, String descricao, String titulo, String texto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo= titulo;
	}
	
	
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto= texto;
	}
}	
