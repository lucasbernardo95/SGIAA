
import dao.UsuarioDAO;
import model.Usuario;

import util.ErroSistema;
import view.UsuarioBean;

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
    public static void main(String[] args) throws ErroSistema, InstantiationException, IllegalAccessException {
        Usuario usuario = new Usuario("elidiel","elidiel", "12345678978", "elidielpegador");
        
        UsuarioBean ubean = new UsuarioBean();
        
        ubean.setEntidade(usuario);
        
       ubean.salvar();
        
        
        System.out.println("Salvou!!!" + usuario.getNome());
//        
        //Palheta palheta = new Palheta(1);
        //PalhetaDAO pdao = new PalhetaDAO();
        //pdao.merge(palheta);
    }
}
