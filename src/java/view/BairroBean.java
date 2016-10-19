package view;

import dao.BairroDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Bairro;
import util.ErroSistema;
import util.MessageUtil;

/**
 *
 * @author lber
 */
@ManagedBean
@ApplicationScoped
public class BairroBean implements Serializable, CrudBean {

    private BairroDAO bdao;
    private List<Bairro> lista;

    public BairroDAO getDao() {
        if (bdao == null) {
            bdao = new BairroDAO();
        }
        return bdao;
    }

    @PostConstruct
    public void init() {
        buscar();
    }

    public List<Bairro> getLista() {
        return lista;
    }

    public void setLista(List<Bairro> lista) {
        this.lista = lista;
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
            MessageUtil.MensagemPerigo("Erro ao preencher a tabela.");
        }
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
