/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UsuarioDAO;
import java.io.Serializable;
import model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.MessageUtil;

/**
 *
 * @author lber
 */
@ManagedBean
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioDAO> implements Serializable{

    private UsuarioDAO usuarioDAO;
    
    @Override
    public UsuarioDAO getDao() {
        if(usuarioDAO == null)
            usuarioDAO = new UsuarioDAO();
        return usuarioDAO;//Retorna para o CrudBean, assim ele saberá qual é o objeto que deverá instaciar
    }
    
}