package org.stavros.converter;

public abstract class BaseConverter {
	
	protected final static boolean isSimpleType(Class<?> type) {
		return String.class.equals(type)
				|| Character.class.equals(type)
				|| Integer.class.equals(type)
				|| Long.class.equals(type)
				|| Float.class.equals(type)
				|| Double.class.equals(type)
				|| Boolean.class.equals(type);
	}

}
