package validation;

import dao.UsuarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Usuario;
import util.SessionUtil;
import util.ErroSistema;
import util.MessageUtil;

/**
 * @author lber
 */
@RequestScoped
@ManagedBean(name = "validador")
public class ValidadorAcesso implements Serializable {

    UsuarioDAO usuDAO;
    private String login;
    private String senha;
    private Boolean telaLogin, telaCadastro;
    

    /**
     * Esse método irá percorrer a lista com todos os usuários cadastrados no banco,
     * se houver algum usuário que corresponda ao login e senha digitados no form
     * do login, esse será setado na sessão e redirecionado para a página de controle 
     * do sistema, se não, é informada uma mensagem de erro e o mesmo permanecerá na
     * página de login.
     */
    public String autenticar() throws ErroSistema {

        /**
         * O método listar() retornará uma lista com todos os
         * usuários contidos no banco, então serão armazenado no objeto list,
         * chamado de usuarios e então haverá uma iteração com todos esses valores para
         * comparar os logins e senhas.
         */
        usuDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuDAO.listar();

        for (Usuario u : usuarios) {

            //Se o o login e senha forem válidos, ou seja, se há algum usuário com esse login e senha entra no laço
            if (senha.equals(u.getSenha()) && login.equals(u.getLogin())) {
                //Seta o usuário na sessão que corresponde ao login e sneha informados
                SessionUtil.setParamSession("usuario-logado", u);
                /*seta uma mensagem de boas vindas com o nome do usuário.*/
                MessageUtil.MensagemSucesso("Seja bem-vindo " + u.getNome());
                //redireciona o usuário para a url informada
                return "/logado/template.xhtml?faces-redirect=true";

            }
        }
        //Se percorrer todo o laço e não houver nenhum usuário com o login e senha passados informa uma mensagem de erro para o usuário e sai do método
        MessageUtil.MensagemErro("Usuário ou senha inválidos!");
        return null;
    }

    //Remove o usuário da sessão e o redireciona para a página de login
    public String logout() {
        SessionUtil.invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public void exibeTela(Boolean telaLogin, Boolean telaCadastro){
        this.telaLogin = telaLogin;
        this.telaCadastro = telaCadastro;
    }
    
    public void sair() {
        SessionUtil.invalidateSession();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getTelaLogin() {
        return telaLogin;
    }

    public void setTelaLogin(Boolean telaLogin) {
        this.telaLogin = telaLogin;
    }

    public Boolean getTelaCadastro() {
        return telaCadastro;
    }

    public void setTelaCadastro(Boolean telaCadastro) {
        this.telaCadastro = telaCadastro;
    }

}
