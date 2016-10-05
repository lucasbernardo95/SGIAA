package view;

import dao.UsuarioDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;

/**
 *
 * @author lber
 */
@ManagedBean
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioDAO> implements Serializable{

    private UsuarioDAO udao;
    
    @Override
    public UsuarioDAO getDao() {
        if(udao == null)
            udao = new UsuarioDAO();
        return udao;//Retorna para o CrudBean, assim ele saberá qual é o objeto que deverá instaciar
    }
      
}