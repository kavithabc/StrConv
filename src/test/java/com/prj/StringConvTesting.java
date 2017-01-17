package com.prj;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StringConvTesting {

	private StringConversion sc;
	 
	@Before
	 public void initialize() {
		  sc = new StringConversion();
	 }
	 
	 @Test
		public void test1() {		
			String str = "  This is   the string provided ";
			str = sc.trimString(str);
			assertEquals("This is the string provided",str);
		}
		
	 
	 @Test
		public void test2() {
			String str = "ThisIsClassifyCase";
			str = sc.trimString(str);
			str = sc.readableFormat(str);
			assertEquals("This Is Classify Case",str);
		 	String cc = sc.camelCase(str);
		 	assertEquals("thisIsClassifyCase",cc);
		 	String dc = sc.dashCase(str);
		 	assertEquals("this-is-classify-case",dc);
		 	String clc = sc.classifyCase(str);
		 	assertEquals("ThisIsClassifyCase",clc);
		}
		
	 @Test
		public void test3() {
			String str = "thisIsCamelCase";
			str = sc.trimString(str);
			str = sc.readableFormat(str);
			assertEquals("this Is Camel Case",str);
		 	String cc = sc.camelCase(str);
		 	assertEquals("thisIsCamelCase",cc);
		 	String dc = sc.dashCase(str);
		 	assertEquals("this-is-camel-case",dc);
		 	String clc = sc.classifyCase(str);
		 	assertEquals("ThisIsCamelCase",clc);
		}
	 
	 @Test
	 public void test4() {
	 	String str = "This House Is Big ";
	 	str = sc.trimString(str);
	 	str = sc.readableFormat(str);
	 	assertEquals("This House Is Big",str);
	 	String cc = sc.camelCase(str);
	 	assertEquals("thisHouseIsBig",cc);
	 	String dc = sc.dashCase(str);
	 	assertEquals("this-house-is-big",dc);
	 	String clc = sc.classifyCase(str);
	 	assertEquals("ThisHouseIsBig",clc);
	 }
	 
	 @Test
	 public void test5() {
	 	String str = "this-is-dash-case";
	 	str = sc.trimString(str);
	 	str = sc.readableFormat(str);
	 	assertEquals("this is dash case",str);
	 	String cc = sc.camelCase(str);
	 	assertEquals("thisIsDashCase",cc);
	 	String dc = sc.dashCase(str);
	 	assertEquals("this-is-dash-case",dc);
	 	String clc = sc.classifyCase(str);
	 	assertEquals("ThisIsDashCase",clc);
	 }

	 @Test
	 public void test6() {
	 	String str = "null";
	 	str = sc.trimString(str);
	 	str = sc.readableFormat(str);
	 	assertEquals("null",str);
	 	String cc = sc.camelCase(str);
	 	assertEquals("null",cc);
	 	String dc = sc.dashCase(str);
	 	assertEquals("null",dc);
	 	String clc = sc.classifyCase(str);
	 	assertEquals("Null",clc);
	 }


}



