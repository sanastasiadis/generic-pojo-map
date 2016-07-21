package org.stavros.converter.map;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.stavros.converter.BaseConverter;

public class Converter extends BaseConverter {
	
	public static <T> void getPojo(Map<String, Object> document, T obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		for (PropertyDescriptor pd : Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors()) {
			String name = pd.getName();
			Object value = document.get(name);
			
			if (pd.getWriteMethod() != null
					&& !"class".equals(name)
					&& value != null) {
				if (isSimpleType(pd.getPropertyType())) {
					// the entry to the map is a single key-value entry of the map
					pd.getWriteMethod().invoke(obj, value);
				}
				else {
					// the entry to the map is a key with the value being an object
					Map<String, Object> mapValue = new HashMap<>();
					getPojo(mapValue, value);
					pd.getWriteMethod().invoke(obj, mapValue);
				}
			}
		}
		System.out.println("object printout: " + obj);
	}

}
