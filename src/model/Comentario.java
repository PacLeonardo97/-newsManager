package model;

public class Comentario implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idComentario;
	private String nome;
	private String texto;
	private int idNoticia;
	
	public Comentario(int idComentario, String nome, String texto, int idNoticia) {
		super();
		this.idComentario = idComentario;
		this.nome = nome;
		this.texto = texto;
		this.idNoticia = idNoticia;
	}
	
	public Comentario(String nome, String texto, int idNoticia) {
		super();
		this.nome = nome;
		this.texto = texto;
		this.idNoticia = idNoticia;
	}
	
	public Comentario() {
	}
	
	public int getIdComentario() {
		return this.idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTexto() {
		return this.texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getIdNoticia() {
		return this.idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
}
