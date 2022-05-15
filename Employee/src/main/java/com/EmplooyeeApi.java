package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.Emplooyee;

/**
 * Servlet implementation class EmplooyeeApi
 */
@WebServlet("/EmplooyeeApi")
public class EmplooyeeApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Emplooyee emplooyeeObj = new Emplooyee();  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = emplooyeeObj.insertEmplooyee(request.getParameter("emplooyeeName"),  
				request.getParameter("emplooyeeAddr"), 
				request.getParameter("emplooyeeNic"),
		        request.getParameter("emplooyeeAge"),
		        request.getParameter("emplooyeePhoneNo"),
		        request.getParameter("emplooyeeEmail")); 
				response.getWriter().write(output); 
	}

	// Convert request parameters to a Map
	private static Map<String, String> getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 { 

	 String[] p = param.split("="); 
	 map.put(p[0], p[1]); 
	 } 
	 } 
	catch (Exception e) 
	 { 
	 } 
	return map; 
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		 String output = emplooyeeObj.updateEmplooyee(paras.get("hidItemIDSave").toString(), 
		 paras.get("emplooyeeName").toString(), 
		paras.get("emplooyeeAddr").toString(), 
		paras.get("emplooyeeNic").toString(), 
		paras.get("emplooyeeAge").toString(),
		paras.get("emplooyeePhoneNo").toString(),
		paras.get("emplooyeeEmail").toString()); 
		response.getWriter().write(output); 
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<?, ?> paras = getParasMap(request); 
		 String output = emplooyeeObj.deleteEmplooyee(paras.get("emplooyeeID").toString()); 
		response.getWriter().write(output); 
	}

}
	
//	/**
//     * @see HttpServlet#HttpServlet()
//     */
//    public EmplooyeeApi() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
