package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet(name = "GerenciarNoticias.do", urlPatterns = { "/GerenciarNoticias.do" })
public class GerenciarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GerenciarNoticias() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
		
		NoticiaService ns = new NoticiaService();
		ArrayList<Noticia> lista = new ArrayList<>();
		lista = ns.listar();
		
		saida.print("<meta charset='UTF-8'>");
		saida.print("<link rel='stylesheet' type='text/css' href='estilo.css'>");
		saida.print("<p class='logo'>RealNews</p>");
		lista.forEach(
			n -> {
				saida.print("<a class='texto'>" + n.getTitulo() + "</a> | ");
				saida.print("<a class='texto' href='Alterar.do?id_noticia=" + n.getIdNoticia() + "'>Alterar</a> | ");
				saida.print("<a class='texto' href='Excluir.do?id_noticia=" + n.getIdNoticia() + "'>Excluir</a>");
				saida.print("<hr/>");
			}
		);
		saida.print("<br><br><a class='botao' href='index.html'>Voltar</a>");
	}
}
