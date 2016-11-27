/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.BairroDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.Bairro;
import util.ErroSistema;
/**
 *
 * @author lber
 */
@FacesConverter(value="areaConverter")
public class BairroConverte implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                //Recupera o objeto palhetabean para que seja possível ter acesso aos seus atributos e métodos
                PalhetaBean palheta = (PalhetaBean) fc.getExternalContext().getApplicationMap().get("palhetaBean");
                //do palhetabean pega a lista de bairros e retorna o bairro referente ao índice passado
                return palheta.getBairros().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    //Retorna o id do objeto convertido para string
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null) {
            return String.valueOf(((Bairro) o).getId());
        }
        else {
            return null;
        }
    }
    
}
