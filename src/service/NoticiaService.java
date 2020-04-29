package service;

import java.util.ArrayList;

import dao.NoticiaDAO;
import model.Noticia;

public class NoticiaService {
	private NoticiaDAO noticiaDao;
	
	public NoticiaService() {
		this.noticiaDao = new NoticiaDAO();
	}
	
	public void cadastrar(Noticia noticia) {
		this.noticiaDao.cadastrar(noticia);
	}
	
	public void alterar(Noticia noticia) {
		this.noticiaDao.alterar(noticia);
	}
	
	public void excluir(Noticia noticia) {
		this.noticiaDao.excluir(noticia);
	}
	
	public Noticia consultar(int id) {
		return this.noticiaDao.consultar(id);
	}
	
	public ArrayList<Noticia> listar() {
		return this.noticiaDao.listar();
	}
}
