package br.senac.rn.gerenciador.web;


import br.senac.rn.gerenciador.dao.UsuarioDAO;
import br.senac.rn.gerenciador.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/novoUsuario")
public class CadastrarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        String email = requisicao.getParameter("email");
        String senha = requisicao.getParameter("senha");
        Usuario usuario = new Usuario(email,senha);
        new UsuarioDAO().adiciona(usuario);
        requisicao.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = requisicao.getRequestDispatcher("/WEB-INF/sucesso.jsp");
        dispatcher.forward(requisicao, resposta);
    }
    
}
