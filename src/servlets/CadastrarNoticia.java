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
		name = "CadastrarNoticia.do", 
		urlPatterns = { 
				"/CadastrarNoticia.do" 
		})
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrarNoticia() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		String descricao = request.getParameter("descricao");
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		
		if(descricao.equals("") || titulo.equals("") || texto.equals("")) {
			saida.print("<p><a href='cadastrar.html'>Volte</a> e preencha todos os campos!</p>");
		}
		else {
			if(descricao.length() > 512 || titulo.length() > 126) {
				saida.print("<p><a href='cadastrar.html'>Volte</a> e preencha o título com no máximo 126 caracteres e a descrição com no máximo 512 caracteres!</p>");
			}
			else {
				NoticiaService ns = new NoticiaService();
				Noticia n = new Noticia(descricao, titulo, texto);
				ns.cadastrar(n);
				saida.print("<p>Notícia cadastrada!</p> <a href='cadastrar.html'>Voltar</a>");
			}
		}
	}
}
