
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
        Usuario usuario = new Usuario(1, "lucas", "11111111111", "lucasbass", true);
        
        
       UsuarioDAO dao = new UsuarioDAO();
        dao.merge(usuario);
        
        dao.buscar(1);
        
        System.out.println("Salvou!!!" + usuario.getNome());
        
        //Palheta palheta = new Palheta(1);
        //PalhetaDAO pdao = new PalhetaDAO();
        //pdao.merge(palheta);
    }
}
