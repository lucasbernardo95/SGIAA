
import dao.BairroDAO;
import java.util.List;
import model.Bairro;

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


        BairroDAO bdao = new BairroDAO();

        for (int i = 0; i < 23; i++){
            Bairro b = new Bairro("Bairro autom. 1", 20 + i, 30 + i, (float) (14.0 + i), 40 + i);
            bdao.salvar(b);
        }

    }
}
