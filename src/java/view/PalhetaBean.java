package view;

import dao.PalhetaDAO;
import java.io.Serializable;
import model.Palheta;

/**
 *
 * @author lber
 */
public class PalhetaBean implements Serializable {

    private PalhetaDAO pdao;
    
    public PalhetaDAO getDao() {
       if(pdao == null)
           pdao = new PalhetaDAO();
       return pdao;
    }

    public Palheta getNovaEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
