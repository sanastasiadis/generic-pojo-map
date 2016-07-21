package org.stavros.converter.pojo;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.stavros.converter.BaseConverter;

public class Converter extends BaseConverter {
	
	public static <T> Map<String,Object> getMap(T obj) throws InvocationTargetException, IntrospectionException, IllegalAccessException, IllegalArgumentException {
		Map<String,Object> map = new HashMap<>();
		for (PropertyDescriptor pd : Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors()) {
			Object value = pd.getReadMethod().invoke(obj);
			if (pd.getReadMethod() != null
					&& !"class".equals(pd.getName())
					&& value != null) {
				if (isSimpleType(pd.getPropertyType())) {
					map.put(pd.getName(), value);
				}
				else {
					map.put(pd.getName(), getMap(value));
				}
			}
		}
		System.out.println("document printout: " + map);
		return map;
	}

}
