package com.lftechnology.sudip.htmljava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class JavatoHtml {

	/**
	 * @param args
	 */
	
	
		Field[] fields;
		String[] value;
		public void getEntity(Class Entity)
		{
			
			  fields = Entity.getFields();
			  
		        value = new String[fields.length];
		        for (int i = 0; i < fields.length; i++) {
		        	
		        	System.out.println(fields[i].getName().toString());
		            value[i] = fields[i].getName().toString();
		        }
		   		
		}
	    public void getConverted() throws IOException {
	        String str; 
	        StringBuilder sb = new StringBuilder();
	        sb.append("<html><head><title>Java to Html</title></head><body><table>");
	        try {   
	               File file = new File("JavatoHtml.html");
	               FileWriter writer = new FileWriter(file);
	                 BufferedWriter bufferwriter = new BufferedWriter(writer);
	                 int i;
	                 
	                for(i = 0; i < value.length; i ++ )
	                {
	                     str= value[i];
	                     sb.append("<tr><td>");
	                     sb.append(str);
	                  
	                     sb.append("</td><td><input type=\"text\" name=\""+str+"\"value=\"\"");
	                     sb.append("</td></tr>");
	                   
	                
	                   
	              }
	                sb.append("</table></body></html>"); 
//	               sb.append("</table></body>");  
	                
	                bufferwriter.write(sb.toString());
	                bufferwriter.close();
	                
	        }
	           catch (Exception ex) {
	                System.out.println(ex);
	            }
	        }
		public static void main(String[] args) throws ClassNotFoundException, IOException {
			// TODO Auto-generated method stub

			JavatoHtml object = new JavatoHtml();
			object.getEntity(Class.forName("com.lftechnology.sudip.htmljava.Entity"));
			object.getConverted();

		

	}

}
