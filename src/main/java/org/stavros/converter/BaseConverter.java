package org.stavros.converter;

public abstract class BaseConverter {
	
	protected final static boolean isSimpleType(Class<?> type) {
		return String.class.equals(type)
				|| Character.class.equals(type)
				|| Integer.class.equals(type)
				|| Long.class.equals(type)
				|| Float.class.equals(type)
				|| Double.class.equals(type)
				|| Boolean.class.equals(type)
				|| int.class.equals(type)
				|| long.class.equals(type)
				|| float.class.equals(type)
				|| double.class.equals(type)
				|| char.class.equals(type)
				|| boolean.class.equals(type);
	}

}
