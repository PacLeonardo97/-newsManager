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

@WebServlet(
		name = "DetalheNoticia.do", 
		urlPatterns = { 
				"/DetalheNoticia.do" 
		})
public class DetalheNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetalheNoticia() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idNoticia = Integer.parseInt(request.getParameter("id_noticia"));
		NoticiaService ns = new NoticiaService();
		Noticia n = ns.consultar(idNoticia);
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		
		saida.print("<meta charset='UTF-8'>");
		saida.print("<link rel='stylesheet' type='text/css' href='estilo.css'>");
		saida.print("<p class='logo'>RealNews</p>");
		saida.print("<p class='titulo'>" + n.getTitulo() + "</p>");
		saida.print("<p class='descricao'>" + n.getDescricao() + "</p>");
		saida.print("<p class='noticia'>" + n.getTexto() + "</p>");
		saida.print("<hr/>");
		saida.print("<p class='logo'>Comentários</p>");
		ComentarioService cs = new ComentarioService();
		ArrayList<Comentario> lista = new ArrayList<>();
		lista = cs.listar(idNoticia);
		lista.forEach(
			c -> {
				saida.print("<p class='nome'>" + c.getNome() + "</p>");
				saida.print("<p class='comentario'>" + c.getTexto() + "</p>");
				saida.print("<hr/>");
			}
		);
		
		saida.print("<form method='post' action='DetalheNoticia.do'>");
		saida.print("<p>" + 
						"Nome: <input type='text' name='nome'>" + 
					"</p>");
		saida.print("<p>" + 
						"Comentário: <textarea name='comentario' rows='4' cols='50'></textarea>" + 
					"</p>");
		saida.print("<input type='hidden' name='id_noticia' value='" + idNoticia + "' >");
		saida.print("<input class='botao' type='submit' value='Comentar'>");
		saida.print("<a class='botao' href='ListarNoticias.do?id_noticia=" + idNoticia + "'>Voltar</a>");
		saida.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		String nome = request.getParameter("nome");
		String comentario = request.getParameter("comentario");
		int idNoticia = Integer.parseInt(request.getParameter("id_noticia"));
		
		if(nome.equals("") || comentario.equals("")) {
			saida.print("<p><a href='DetalheNoticia.do?id_noticia=" + idNoticia + "'>Volte</a> e preencha o nome e o comentario!</p>");
		}
		else {
			if(nome.length() > 126 || comentario.length() > 512) {
				saida.print("<p><a href='DetalheNoticia.do?id_noticia=" + idNoticia + "'>Volte</a> e preencha um nome com no máximo 126 caracteres e um comentário com no máximo 512 caracteres!</p>");
			}
			else {
				ComentarioService cs = new ComentarioService();
				Comentario c = new Comentario(nome, comentario, idNoticia);
				cs.cadastrar(c);
				saida.print("<p>Comentado!</p> <a href='DetalheNoticia.do?id_noticia=" + idNoticia + "'>Voltar</a>");
			}
		}
	}
}
