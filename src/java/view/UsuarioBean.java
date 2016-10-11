package view;

import dao.UsuarioDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;
import util.ErroSistema;
import util.MessageUtil;

/**
 *
 * @author lber
 */
@ManagedBean
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioDAO> implements Serializable{

    private UsuarioDAO udao;
    private Usuario usuario;
    
    @Override
    public UsuarioDAO getDao() {
        if(udao == null)
            udao = new UsuarioDAO();
        return udao;//Retorna para o CrudBean, assim ele saberá qual é o objeto que deverá instaciar
    }
    
    public void crianovo(){
        this.usuario = new Usuario();
    }
    
    public void cadastrar() throws ErroSistema{
        getDao().salvar(usuario);
        MessageUtil.MensagemSucesso("Salvou o cagão");
    }

    public UsuarioDAO getUdao() {
        return udao;
    }

    public void setUdao(UsuarioDAO udao) {
        this.udao = udao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}