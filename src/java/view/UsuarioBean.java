package view;

import dao.UsuarioDAO;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;
import util.ErroSistema;
import util.MessageUtil;
import util.SessionUtil;

/**
 *
 * @author lber
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable, CrudBean {

    private UsuarioDAO udao;
    private Usuario usuario;
    private Usuario logado;

    public UsuarioDAO getDao() {
        if (udao == null) {
            udao = new UsuarioDAO();
        }
        return udao;//Retorna para o CrudBean, assim ele saberá qual é o objeto que deverá instaciar
    }

    @PostConstruct
    public void init() {
        logado = (Usuario) SessionUtil.getParamSession("usuario-logado");
        usuario = new Usuario();
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

    @Override
    public void novo() {
        usuario = new Usuario();
    }

    @Override
    public void salvar() {
        try {
            if (!usuario.getNome().equals("") && !usuario.getLogin().equals("")
                    && !usuario.getSenha().equals("") && !usuario.getCpf().equals("")) {
                getDao().salvar(usuario);
                MessageUtil.MensagemSucesso("Salvo com sucesso!");
                novo();//sempre ao salvar instancia um novo objeto usuário para limpar todos os campos da view
            } else {
                MessageUtil.MensagemSucesso("Certifique-se de que todos os campos foram preenchidos corretamente!");
            }
        } catch (ErroSistema ex) {
            MessageUtil.MensagemErro("Erro: " + ex);
        }
    }

    @Override
    public void alterar() {
        try {
            if (!usuario.getNome().equals("") && !usuario.getLogin().equals("")
                    && !usuario.getSenha().equals("") && !usuario.getCpf().equals("")) {
                getDao().editar(usuario);
                MessageUtil.MensagemSucesso("Alterado com sucesso!");

            } else {
                MessageUtil.MensagemSucesso("Certifique-se de que todos os campos foram preenchidos corretamente!");
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir() {
        try {
            if (usuario != null) {
                getUdao().deletar(usuario);
                MessageUtil.MensagemSucesso("Excluído com sucesso!");
            } else {
                MessageUtil.MensagemErro("Erro ao tentar excluir");
            }
        } catch (ErroSistema ex) {
            MessageUtil.MensagemErro("Erro ao tentar excluir.\nCausa: " + ex);
        }
    }
    
    public void alteraMeusDados(){
        usuario = logado;
        alterar();
    }

    @Override
    public void buscar() {
        try {
            getDao().listar();
        } catch (ErroSistema ex) {
            MessageUtil.MensagemErro("Erro ao buscar os elementos no banco.");
        }
    }

    public Usuario getLogado() {
        return logado;
    }
    
    

}
