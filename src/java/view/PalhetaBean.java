package view;

import dao.PalhetaDAO;
import java.io.Serializable;
import model.Palheta;

/**
 *
 * @author lber
 */
public class PalhetaBean extends CrudBean<Palheta, PalhetaDAO> implements Serializable {

    private PalhetaDAO pdao;
    
    @Override
    public PalhetaDAO getDao() {
       if(pdao == null)
           pdao = new PalhetaDAO();
       return pdao;
    }
    
}
