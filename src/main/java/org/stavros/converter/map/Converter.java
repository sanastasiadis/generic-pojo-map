package org.stavros.converter.map;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Converter {
	
	public static <T> void getPojo(Map<String, Object> document, T obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		for (PropertyDescriptor pd : Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors()) {
			String name = pd.getName();
			Object value = document.get(name);
			
			if (pd.getWriteMethod() != null
					&& !"class".equals(name)
					&& value != null) {
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		System.out.println("object printout: " + obj);
	}

}
