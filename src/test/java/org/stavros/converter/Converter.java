package org.stavros.converter;

import static org.junit.Assert.*;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.junit.Test;

public class Converter {
	
	@Test
	public void test() {
		
		Pojo pojo = new Pojo();
		
		pojo.setA(1);
		pojo.setB(2L);
		pojo.setC(3.0f);
		pojo.setD(4.0);
		pojo.setE('A');
		pojo.setString("test");
		
		Nested nested = new Nested();
		nested.setA(100);
		nested.setStr("nested");
		
		pojo.setNested(nested);
		
		try {
			Map<String,Object> map = org.stavros.converter.pojo.Converter.getMap(pojo);
			
			System.out.println(map);
			
			assertEquals(pojo.getA(), map.get("a"));
			assertEquals(pojo.getB(), map.get("b"));
			assertEquals(pojo.getC(), map.get("c"));
			assertEquals(pojo.getD(), map.get("d"));
			assertEquals(pojo.getE(), map.get("e"));
			assertEquals(pojo.getString(), map.get("string"));
			
			Map<String,Object> mapObj = (Map<String,Object>)map.get("nested");
			assertEquals(pojo.getNested().getA(), mapObj.get("a"));
			assertEquals(pojo.getNested().getStr(), mapObj.get("str"));
		} catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException
				| IntrospectionException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
