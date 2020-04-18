package model;
import model.News;

public class Comments implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String texto ;
	private News news;
	
	public Comments() {}
	
	public Comments(int id, String nome, String texto, News news) {
		super();
		this.id = id;
		this.nome = nome;
		this.texto = texto;
		this.news = news;
	}
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
}
