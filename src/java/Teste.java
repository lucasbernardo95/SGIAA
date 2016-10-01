
import dao.GenericDAO;
import dao.UsuarioDAO;
import model.Usuario;
import util.ErroSistema;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lber
 */
public class Teste {
    public static void main(String[] args) throws ErroSistema {
        Usuario usuario = new Usuario(1, "lucas", "lucas", "lucasbernardo95@gmail.com", "lucasbass", "administrador");
        
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.merge(usuario);
        
        dao.buscar(1);
        
        System.out.println("Salvou!!!" + usuario.getNome());
    }
}
