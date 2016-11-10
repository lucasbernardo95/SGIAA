
import dao.BairroDAO;
import dao.PalhetaDAO;
import dao.RegiaoDAO;
import dao.UsuarioDAO;
import java.util.List;
import model.Bairro;
import model.Palheta;
import model.Regiao;
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
/*
        PalhetaDAO pdao = new PalhetaDAO();
        for (int i = 0; i < 23; i++){
            Palheta p = new Palheta(1000 + i, 1511+i, 90 + i, 10 + i, 10.5, 11.6);
            pdao.salvar(p);
        }
*/
/*


        BairroDAO bdao = new BairroDAO();

        for (int i = 0; i < 23; i++){
            Bairro b = new Bairro("Bairro autom. 1", 20 + i, 30 + i, (float) (14.0 + i), 40 + i);
            bdao.salvar(b);
        }
*//*
        RegiaoDAO rdao = new RegiaoDAO();
        Regiao r ;
        for (int i = 0; i < 10; i++){
            if(i <= 3 )
                 r = new Regiao("Região " + i, i);
            else 
                 r = new Regiao("Região " + i, i);
            
            rdao.salvar(r);
        }*/

        Usuario lucas = new Usuario("Lucas Bernardo", "lucas", "12345678941", "123");
        Usuario sueliton = new Usuario("Suéliton Santos", "susu", "78945612301", "123");
        UsuarioDAO udao = new UsuarioDAO();
        udao.salvar(lucas);
        udao.salvar(sueliton);



    }
}
