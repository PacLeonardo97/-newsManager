package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet(
		name = "Pesquisar.do", 
		urlPatterns = { 
				"/Pesquisar.do" 
		})
public class Pesquisar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Pesquisar() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		String idNoticia = request.getParameter("id_noticia");
		
		if(idNoticia.equals("")) {
			saida.print("<p><a href='pesquisar.html'>Volte</a> e informe um ID!</p>");
		}
		else {
			int idNoticiaInt = Integer.parseInt(idNoticia);
			NoticiaService ns = new NoticiaService();
			Noticia n = new Noticia();
			n = ns.consultar(idNoticiaInt);
			if(n.getIdNoticia() == 0) {
				saida.print("<p>Notícia não encontrada!</p> <a href='pesquisar.html'>Voltar</a>");
			}
			else {
				saida.print("<p class='logo'>RealNews</p>");
				saida.print("<p>Notícia encontrada! <a href='pesquisar.html'>Voltar</a> </p>");
				saida.print("<meta charset='UTF-8'>");
				saida.print("<link rel='stylesheet' type='text/css' href='estilo.css'>");
				saida.print("<p class='titulo'>" + n.getTitulo() + "</p>");
				saida.print("<p class='descricao'>" + n.getDescricao() + "</p>");
				saida.print("<p class='noticia'>" + n.getTexto() + "</p>");
			}
		}
	}
}
