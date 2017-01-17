package com.prj;

import java.util.Scanner;


public class StringConversion {
		//Camel case
		public String camelCase(String str){
			String st = "";
			str = str.toLowerCase();
			String[] var = str.split(" ");
			if (var.length >1){
				for (int i=1; i<var.length; i++){
					StringBuilder sb = new StringBuilder(var[i]);			
					if(Character.isLowerCase(sb.charAt(0))){
						sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
					}
					var[i] = sb.toString();
				}
				st = joinmethod("", var);
				return st;
			}
			else return str;
		}
		
		//Dash case
		public String dashCase(String str){
			str = str.toLowerCase();
			str = str.replace(" ", "-");
			return str;
		}
		
		//Classify case
		public String classifyCase(String str){
			str = str.toLowerCase();
			String st = "";
			String[] var = str.split(" ");
			if (var.length >1){
				for (int i=0; i<var.length; i++){
					StringBuilder sb = new StringBuilder(var[i]);			
					if(Character.isLowerCase(sb.charAt(0))){
						sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
					}
					var[i] = sb.toString();
				}
				st = joinmethod("", var);
				return st;
			}
			else {
				StringBuilder sb = new StringBuilder(str);			
				if(Character.isLowerCase(sb.charAt(0))){
					sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
				}
				str = sb.toString();
				return str;
			}
		}
		
		//Readable format
		public String readableFormat(String str){
			if(str.matches("(.*?)\\s(.*?)")){
				System.out.println("Input is Readable format");
				return str;
			}
			else{
				if(str.matches("^(([a-z]+)\\-([a-z]+)).*")){
					String[] st = str.split("-");
					str= joinmethod(" ", st);
					System.out.println("Input is Kebab case");
				}
				else if(Character.isUpperCase(str.charAt(0)) && str.matches("^[A-Z]+(|[a-z])+([A-Z]+)[a-zA-Z]+$")){
					str = splitClassify(str);
					System.out.println("Input is Classify case");
				}
				else if (Character.isLowerCase(str.charAt(0)) && str.matches("^[a-z]+([A-Z]+)[a-zA-Z]+$")){
					String st[] = str.split("(?=\\p{Upper})");
					System.out.println("Input is Camel case");
					str= joinmethod(" ", st);
				}	
				return str;
			}
		}
		
		//Join method
		public static String joinmethod(String sep, String[] str){
			if(str.length == 0) return "";
			else if(str.length == 1) return str[0];
			else {
				StringBuilder sb = new StringBuilder();
				sb.append(str[0]);
				for (int i=1; i<str.length; i++){
					sb.append(sep);
					sb.append(str[i]);
				}
				return sb.toString();
			}
		}
		
		//Split for Classify case
		public static String splitClassify(String str){
			StringBuilder sb = new StringBuilder();
			sb.append(str.charAt(0));
			for(int i=1;i<str.length();i++){
				if(Character.isUpperCase(str.charAt(i))){
					sb.append(" ");
					sb.append(str.charAt(i));
				}
				else sb.append(str.charAt(i));
			}
			return sb.toString();
		}
		
		//Trim
		public String trimString(String str){
			str = str.trim().replaceAll("( )+", " ");
			return str;
		}
		
		//Main method
		public static void main(String[] args) {
			StringConversion s = new StringConversion();
			Scanner in= new Scanner(System.in);
			System.out.print("Enter string : ");
			String str = in.nextLine();
			
			try{
				str = str.trim().replaceAll("( )+", " ");
				in.close();
				if(str.equals("")){
					throw new MyException("String cannot be null");
				}
				if(str.matches("\\d+")){
					throw new MyException("Numbers are not allowed");
				}
				if(!(str.matches("^([A-Za-z ]+)$") || str.matches("^([a-z]+)((-)([a-z]+))+$"))){
					throw new MyException("Invalid string format");
				}
				System.out.println("Input : "+str);
				str= s.trimString(str);
				str= s.readableFormat(str); 
				System.out.println("Readable Format : "+str);
				System.out.println("Camel case 	: "+ s.camelCase(str));
				System.out.println("Kebab case 	: "+ s.dashCase(str));
				System.out.println("Classify case 	: "+ s.classifyCase(str));
				
			}
			catch(MyException ex){
				System.out.println(ex);
			}
		}
	}

