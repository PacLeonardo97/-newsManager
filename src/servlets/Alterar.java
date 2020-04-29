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

@WebServlet(name = "Alterar.do", urlPatterns = { "/Alterar.do" })
public class Alterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Alterar() {
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
		saida.print("<form method='post' action='Alterar.do'>");
		saida.print("<p class='texto'>" + 
						"ID da Notícia: <input type='number' name='id_noticia' onlyread='true' value='" + n.getIdNoticia() + "' readonly>" + 
					"</p>");
		saida.print("<p class='texto'>" + 
						"Título: <input type='text' name='titulo' value='" + n.getTitulo() + "'>" + 
					"</p>");
		saida.print("<p class='texto'>" + 
						"Descrição: <input type='text' name='descricao' value='" + n.getDescricao() + "'>" + 
					"</p>");
		saida.print("<p class='texto'>" + 
				"Texto: <textarea name='texto' rows='6' cols='60'>" + n.getTexto() + "</textarea>" + 
			"</p>");
		saida.print("<input class='botao' type='submit' value='Alterar'>");
		saida.print("<a class='botao' href='GerenciarNoticias.do'>Voltar</a>");
		saida.print("</form>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		NoticiaService ns = new NoticiaService();
		Noticia n = new Noticia();
		
		String idNoticia = request.getParameter("id_noticia");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String texto = request.getParameter("texto");
		
		if(titulo.equals("") || descricao.equals("") || texto.equals("")) {
			saida.print("<p><a href='Alterar.do?id_noticia=" + n.getIdNoticia() + "'>Volte</a> e informe todos os dados!</p>");
		}
		else {
			if(descricao.length() > 512 || titulo.length() > 126) {
				saida.print("<p><a href='Alterar.do?id_noticia=" + n.getIdNoticia() + "'>Volte</a> e preencha o título com no máximo 126 caracteres e a descrição com no máximo 512 caracteres!</p>");
			}
			else {
				int idNoticiaInt = Integer.parseInt(idNoticia);
				n.setIdNoticia(idNoticiaInt);
				n.setTitulo(titulo);
				n.setDescricao(descricao);
				n.setTexto(texto);
				ns.alterar(n);
				saida.print("<p>Notícia alterada!</p> <a href='GerenciarNoticias.do'>Voltar</a>");
			}
		}
	}
}
