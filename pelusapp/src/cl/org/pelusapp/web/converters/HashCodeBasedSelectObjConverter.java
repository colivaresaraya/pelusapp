package cl.org.pelusapp.web.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Para usar este Converter, el objeto en el cual se basa
 * DEBE tener implementado el metodo "hashCode" con una representacion
 * unica del objeto.
 * 
 * Solo debe usarse en un componente JSF que contenga un f:selectItems
 * @author asaavedr
 *
 */
@ManagedBean(name="hashCodeBasedSelectObjConverter")
@NoneScoped
public class HashCodeBasedSelectObjConverter implements Converter {

	@Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        return value != null ? String.valueOf(value.hashCode()) : null;
    }

	@SuppressWarnings("unchecked")
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(isNAN(value)){
			return null;
		}
		List<Object> listObject = new ArrayList<Object>();
		for (UIComponent item : component.getChildren()) {
			if(item instanceof UISelectItems){
				UISelectItems items = (UISelectItems) item;
				List<Object> appendObjects = (List<Object>) items.getValue();
				listObject.addAll(appendObjects);
			}
		}

		for (Object object : listObject) {
			if(object.hashCode() == Integer.valueOf(value)){
				return object;
			}
		}
		return null;
	}

	private boolean isNAN(String value) {
		if(value == null || value.isEmpty()){
			return true;
		}
		if(value.charAt(0) == '-'){
			value = value.substring(1);
		}
		for (int i = 0; i < value.length(); i++) {
			if(!Character.isDigit(value.charAt(i))){
				return true;
			}
		}
		return false;
	}
}
