package view;

import dao.BairroDAO;
import dao.PalhetaDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import model.Bairro;
import model.Palheta;
import org.primefaces.event.RowEditEvent;
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
    private Bairro bairro;
    private List<Bairro> lista;
    private List<Palheta> palhetas;
    private PalhetaDAO pdao;
    
    public BairroDAO getDao() {
        if (bdao == null) {
            bdao = new BairroDAO();
        }
        return bdao;
    }

    @PostConstruct
    public void init() {
        bairro = new Bairro();
        buscar();
        pdao = new PalhetaDAO();
    }

    public List<Bairro> getLista() {
        return lista;
    }

    public void setLista(List<Bairro> lista) {
        this.lista = lista;
    }

    public List<Palheta> getPalhetas() {
        return palhetas;
    }

    public void setPalhetas(List<Palheta> palhetas) {
        this.palhetas = palhetas;
    }

    @Override
    public void novo() {
       bairro=new Bairro();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
     public void salvar() {
        try {
            if (bairro != null) {
                getDao().salvar(bairro);
                MessageUtil.MensagemSucesso("Salvo com sucesso.");
                buscar();
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
            if (bairro != null) {
                getDao().editar(bairro);
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
            MessageUtil.MensagemPerigo("Nenhum bairro encontrado no banco de dados.\nCausa: " + ex);
        }
    }
    @Override
    public void excluir() {
        try {
            if (bairro != null) {
                getDao().deletar(bairro);
                buscar();
                MessageUtil.MensagemSucesso("Excluído com sucesso.");
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(PalhetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void atualizar(RowEditEvent evento) throws ErroSistema {
        this.bairro = (Bairro) evento.getObject();//recupera o objeto vindo no evento
        alterar();
    }
    public void cancelar(RowEditEvent evento) {
        MessageUtil.MensagemErro("Edição cancelada!");
    }

    public BairroDAO getBdao() {
        return bdao;
    }

    public void setBdao(BairroDAO bdao) {
        this.bdao = bdao;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
    
    public void carregaPalhetasBairroEscolhido(ActionEvent evento){
        Bairro b = (Bairro) evento.getComponent().getAttributes().get("bairroEscolhido");
        palhetas = pdao.buscarPalhetaPorBairro(b.getId());//busca todas as palhetas do bairro
    }
    
}
