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
import org.primefaces.event.RowEditEvent;
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
        regiao = new Regiao();
        buscar();
    }
    
    @Override
    public void novo() {
       regiao= new Regiao();
    }

    @Override
    public void salvar() {
        try {
            if (regiao != null) {
                getDao().salvar(regiao);
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
            if (regiao != null) {
                getDao().editar(regiao);
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
            MessageUtil.MensagemPerigo("Nenhuma região foi encontrada no banco.\nCausa: " + ex);
        }
    }

    @Override
     public void excluir() {
        try {
            if (regiao != null) {
                getDao().deletar(regiao);
                MessageUtil.MensagemSucesso("Excluído com sucesso.");
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(PalhetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
     public void atualizar(RowEditEvent evento) throws ErroSistema {
        this.regiao = (Regiao) evento.getObject();//recupera o objeto vindo no evento
        alterar();
    }
     public void cancelar(RowEditEvent evento) {
        MessageUtil.MensagemErro("Edição cancelada!");
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