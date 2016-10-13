package view;


import dao.RegiaoDAO;
import java.io.Serializable;

/**
 *
 * @author lber
 */
public class RegiaoBean implements Serializable {

    private RegiaoDAO rdao;
    
    public RegiaoDAO getDao() {
        if(rdao == null)
            rdao = new RegiaoDAO();
        return rdao;
    }

    public RegiaoBean getNovaEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
//