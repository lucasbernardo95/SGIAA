package view;


import dao.RegiaoDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Regiao;
import util.ErroSistema;
import util.MessageUtil;

/**
 *
 * @author lber
 */
@ManagedBean
@SessionScoped
public class RegiaoBean implements Serializable, CrudBean {

    private RegiaoDAO rdao;
    private Regiao regiao;
    private List<Regiao> lista;
    
    public RegiaoDAO getDao() {
        if(rdao == null)
            rdao = new RegiaoDAO();
        return rdao;
    }

    @PostConstruct
    public void init(){
        //regiao = new Regiao();
        buscar();
    }
    
    @Override
    public void novo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscar() {
        try {
            lista = getDao().listar();
        } catch (ErroSistema ex) {
            MessageUtil.MensagemPerigo("Nenhuma região foi encontrada no banco.\nCausa: " + ex);
        }
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public List<Regiao> getLista() {
        return lista;
    }

    public void setLista(List<Regiao> lista) {
        this.lista = lista;
    }

}