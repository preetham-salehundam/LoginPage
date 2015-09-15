package com.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;//for using the getkey() and getValue() menthods

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyLogin")
public class MyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		
		 LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>();//linkedhashmap maintains insertion order

         hm.put("preetham","345p");                                    //doesnt allow duplicates usernames
          
         hm.put("abhi","123a");                                       //but can allow duplicates passwords

         hm.put("keshav","567k");                   

         hm.put("akash","789a");

         hm.put("bharath","098b");

         hm.put("ankita","321a");

         hm.put("manikanta","543m");

         hm.put("jhansi","765j");

         hm.put("arpitha","907a");

         hm.put("varun","645v");

         List<String> al=new ArrayList<String>();

         List<String> al1=new ArrayList<String>();

         for(Entry<String, String> s:hm.entrySet()){  //Entry is child interface of Map interface.

                al.add(s.getKey());          //creates a username array list      

                al1.add(s.getValue());      //creates a password array list    

         }

        

         int i=0; //index variable

         int j=0; //temp variable
         
         // it gives the index at which match has occured

         Iterator<String> it=al.iterator();
         
         while(it.hasNext()){
         

                if(uname.equals(it.next())){

                      i=j;        

                }else{

                      j++;

                }

         }

         String password=al1.get(i)   //retrieves the password for the corresponding username

         String username = al.get(i);

         if(uname.equals(username)){

                if(pwd.equals(password)){
                	out.print("<html><body><h2>");
                      out.print("Welcome "+ uname+"</h2></body></html>"); 

                }else{

                      out.print("<html><body><h2 style='color:red;'>Authentication failed</h1></body></html>"); 

                }

                }else{

                      out.print("<html><body><h2 style='color:green;'>invalid username</h2></body></html>");

                }

	}

}
