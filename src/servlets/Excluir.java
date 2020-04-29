package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

@WebServlet(name = "Excluir.do", urlPatterns = { "/Excluir.do" })
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Excluir() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNoticia = request.getParameter("id_noticia");
		
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		
		saida.print("<meta charset='UTF-8'>");
		if(idNoticia.equals("")) {
			saida.print("<p><a href='Listar.do'>Volte</a> e selecione uma notícia para excluir!</p>");
		}
		else {
			int idNoticiaInt = Integer.parseInt(idNoticia);
			NoticiaService ns = new NoticiaService();
			Noticia n = ns.consultar(idNoticiaInt);
			if(n.getIdNoticia() == 0) {
				saida.print("<p>Notícia não encontrada! <a href='GerenciarNoticias.do'>Volte</a> e selecione uma notícia para excluir!</p>");
			}
			else {
				ComentarioService cs = new ComentarioService();
				ArrayList<Comentario> lista = new ArrayList<>();
				lista = cs.listar(idNoticiaInt);
				lista.forEach(
					c -> {
						cs.excluir(c);
					}
				);
				ns.excluir(n);
				saida.print("<p>Notícia deletada!</p> <a href='GerenciarNoticias.do'>Voltar</a>");
			}
		}
	}
}
