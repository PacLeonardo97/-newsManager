package model;

public class Noticia implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idNoticia;
	private String descricao;
	private String titulo;
	private String texto;
	
	public Noticia(int idNoticia, String descricao, String titulo, String texto) {
		super();
		this.idNoticia = idNoticia;
		this.descricao = descricao;
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public Noticia(String descricao, String titulo, String texto) {
		super();
		this.descricao = descricao;
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public Noticia() {
	}

	public int getIdNoticia() {
		return this.idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return this.texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
