package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import model.Comentario;

public class ComentarioService {
private ComentarioDAO comentarioDao;
	
	public ComentarioService() {
		this.comentarioDao = new ComentarioDAO();
	}
	
	public void cadastrar(Comentario comentario) {
		this.comentarioDao.cadastrar(comentario);
	}
	
	public ArrayList<Comentario> listar(int idNoticia) {
		return this.comentarioDao.listar(idNoticia);
	}
	
	public void excluir(Comentario comentario) {
		this.comentarioDao.excluir(comentario);
	}
}
