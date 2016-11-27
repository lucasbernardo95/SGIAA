package view;

import dao.BairroDAO;
import dao.PalhetaDAO;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Bairro;
import model.Palheta;
import org.primefaces.event.RowEditEvent;
import util.ErroSistema;
import util.MessageUtil;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;

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
    private List<Bairro> bairros;
    private Bairro bairro;
    
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
        try {
            //carrega a lista de bairros a ser exibido no menu de cadastro 
            BairroDAO bdao = new BairroDAO();
            bairros = bdao.listar();
        } catch (ErroSistema ex) {
            Logger.getLogger(PalhetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public void novo() {
        palheta = new Palheta();
    }

    @Override
    public void salvar() {
        try {
            if (palheta != null && bairro != null ){
                //o arquivo nn - segment .set deve ricar na raíz do projeto
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/lber/Documents/NetBeansProjects/SGIAA/nn - segment .ser"));
		MultilayerPerceptron mlp = (MultilayerPerceptron) ois.readObject();
		ois.close();
		// Create empty instance with 4 attribute values 
		Instance inst = new DenseInstance(4); 
                
		// Set instance's values for the attributes 0, 1 e 2
		inst.setValue(0, palheta.getOvos_palheta()); 
		inst.setValue(1, palheta.getIpo()); 
		inst.setValue(2, palheta.getIdo());
		
		 // Classificamos esta instancia .
		 int classe = (int )( mlp. classifyInstance ( inst ));
		
		Attribute a = inst.attribute(3);
		String riscoCalculado = a.value((int) classe);
		palheta.setRisco(riscoCalculado);//passa o risco que a rede calculou para a palheta
                
                palheta.setBairro(bairro);//seta o bairro que foi escolhido
                
                getDao().salvar(palheta);
                MessageUtil.MensagemSucesso("Salvo com sucesso.");
                buscar();
            } else {
                MessageUtil.MensagemErro("Erro ao tentar salvar!");
            }
        } catch (ErroSistema ex) {
            MessageUtil.MensagemErro("Erro ao tentar salvar.\nCausa: " + ex);
        } catch (Exception ex) {
            Logger.getLogger(PalhetaBean.class.getName()).log(Level.SEVERE, null, ex);
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
                buscar();
                MessageUtil.MensagemSucesso("Excluído com sucesso.");
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(PalhetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(RowEditEvent evento) throws ErroSistema {
        this.palheta = (Palheta) evento.getObject();//recupera o objeto vindo no evento
        alterar();
    }

    public void cancelar(RowEditEvent evento) {
        MessageUtil.MensagemErro("Edição cancelada!");
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
