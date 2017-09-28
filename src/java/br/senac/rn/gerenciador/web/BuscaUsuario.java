package br.senac.rn.gerenciador.web;


import br.senac.rn.gerenciador.dao.UsuarioDAO;
import br.senac.rn.gerenciador.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/buscaUsuario")
public class BuscaUsuario extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        PrintWriter writer = resposta.getWriter();
        writer.println("<html><body>");
        String filtro = requisicao.getParameter("filtro");
        writer.println("Buscar por usuario");
        writer.println("<ul>");
        Collection<Usuario> usuarios = new UsuarioDAO().buscaPorSimilaridade(filtro);
        for (Usuario usuario : usuarios){
            writer.println("<li>");
            writer.println(usuario.getEmail());
            writer.println("</li>");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }
    
    
}
