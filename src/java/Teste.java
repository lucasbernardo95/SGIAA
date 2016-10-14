
import dao.PalhetaDAO;
import dao.RegiaoDAO;
import dao.UsuarioDAO;
import model.Palheta;
import model.Regiao;
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
//        Usuario usuario = new Usuario("Lucas Bernardo","lucas", "11111111111", "lucas");
//        
//        UsuarioBean ubean = new UsuarioBean();
//        
//        ubean.setEntidade(usuario);
//        
//       ubean.salvar();
//        
//        
//        System.out.println("Salvou!!!" + usuario.getNome());
//        
        //Palheta palheta = new Palheta(1);
        //PalhetaDAO pdao = new PalhetaDAO();
        //pdao.merge(palheta);
        
//        Palheta palheta = new Palheta(1221, 212, 1212, 123, 112.9, 11212.7);
//        PalhetaDAO pdao= new PalhetaDAO();
//        pdao.salvar(palheta);

        Regiao r = new Regiao( "duda", 123);
        RegiaoDAO rd = new  RegiaoDAO();
        rd.salvar(r);

    }
}
