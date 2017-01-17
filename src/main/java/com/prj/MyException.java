package com.prj;

public class MyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String ex;
	public MyException(String str) {
		ex = str;
	}
	
	public String toString(){
		return ("Exception : "+ ex);
	}
}
