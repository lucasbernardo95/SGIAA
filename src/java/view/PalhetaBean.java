package view;

import dao.PalhetaDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Palheta;
import util.ErroSistema;
import util.MessageUtil;

/**
 *
 * @author lber
 */
@ManagedBean
@ApplicationScoped
public class PalhetaBean implements Serializable, CrudBean {

    private PalhetaDAO pdao;
    private Palheta palheta;
    public List<Palheta> lista;

    public PalhetaDAO getDao() {
        if (pdao == null) {
            pdao = new PalhetaDAO();
        }
        return pdao;
    }

    @PostConstruct
    public void init() {
        palheta = new Palheta();
        buscar();
    }

    @Override
    public void novo() {
        palheta = new Palheta();
    }

    @Override
    public void salvar() {
        try {
            if (palheta != null) {
                getDao().salvar(palheta);
                MessageUtil.MensagemSucesso("Salvo com sucesso.");
            } else {
                MessageUtil.MensagemErro("Erro ao tentar salvar!");
            }
        } catch (ErroSistema ex) {
            MessageUtil.MensagemErro("Erro ao tentar salvar.\nCausa: " + ex);
        }
    }

    @Override
    public void alterar() {
        try {
            if (palheta != null) {
                getDao().editar(palheta);
                MessageUtil.MensagemSucesso("Alterado com sucesso.");
            }
        } catch (ErroSistema ex) {
            MessageUtil.MensagemErro("Erro ao tentar alterar.\nCausa: " + ex);
        }
    }

    @Override
    public void buscar() {
        try {
            lista = getDao().listar();
        } catch (ErroSistema ex) {
            MessageUtil.MensagemPerigo("Nenhuma palheta encontrada no banco de dados.\nCausa: " + ex);
        }
    }

    @Override
    public void excluir() {
        try {
            if (palheta != null) {
                getDao().deletar(palheta);
                MessageUtil.MensagemSucesso("Excluído com sucesso.");
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(PalhetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Palheta getPalheta() {
        return palheta;
    }

    public void setPalheta(Palheta palheta) {
        this.palheta = palheta;
    }

    public List<Palheta> getLista() {
        return lista;
    }

    public void setLista(List<Palheta> lista) {
        this.lista = lista;
    }
}
