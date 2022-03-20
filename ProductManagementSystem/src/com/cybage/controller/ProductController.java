package com.cybage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductServiceImpl;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher requestDispatcher = null;
	ProductService productservice = null;
	
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		productservice = new ProductServiceImpl();
		List<Product> productList=productservice.displayAll();
		
		request.setAttribute("list", productList);
		requestDispatcher = request.getRequestDispatcher("displayProduct.jsp");
		requestDispatcher.forward(request, response);
	}

}
