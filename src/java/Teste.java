
import dao.BairroDAO;
import dao.PalhetaDAO;
import dao.UsuarioDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import model.Bairro;
import model.Palheta;
import model.Usuario;

import util.ErroSistema;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.DenseInstance;
import weka.core.Instance;

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
    public static void main(String[] args) throws ErroSistema, InstantiationException, IllegalAccessException, FileNotFoundException, IOException, ClassNotFoundException, Exception {

        /*caastra 23 bairros*/
        BairroDAO bdao = new BairroDAO();
        for (int i = 0; i < 23; i++){
            Bairro b = new Bairro("Bairro Nº" + i, 20 + i, 30 + i, (float) (14.0 + i + 0.2));
            bdao.salvar(b);
        }

            /*cadastra os usuários*/
        Usuario lucas = new Usuario("Lucas Bernardo", "lucas", "12345678941", "123");
        Usuario sueliton = new Usuario("Suéliton Santos", "susu", "78945612301", "123");
        Usuario elidiel = new Usuario("Elidiel Dantas", "elidiel", "74185296301", "123");
        UsuarioDAO udao = new UsuarioDAO();
        udao.salvar(lucas);
        udao.salvar(sueliton);
        udao.salvar(elidiel);
            
        //obs: de preferência cadastrar apenas os usuários e bairros automaticamente, cadastrar as palhetas manual para que a rede mlp classifique todas as palhetas
//        /*busca todos os bairros cadastrados e cadastra as palhetas de cada bairro*/
//        BairroDAO bdao = new BairroDAO();
//        List<Bairro> listab = bdao.listar();
//        /*para cada bairro cadastra 15 palhetas*/
//        PalhetaDAO pdao = new PalhetaDAO();
//        for (Bairro bairro : listab) {
//            
//            for (int i = 0; i < 15; i++){
//                Palheta p = new Palheta(1000 + i, 1511+i, 90 + i, 10 + i, 10.5, 11.6, bairro);
//                pdao.salvar(p);
//            }
//        }
            
    }
}
