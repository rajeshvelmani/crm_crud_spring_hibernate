package com.crm.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entity.Customer;
import com.crm.services.CustomerService;
import com.crm.utils.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model, @RequestParam(required=false) String sort) { 
		// get customers from the service
		List<Customer> theCustomers = null;
		
		// check for sort field
		if (sort != null) {
			int theSortField = Integer.parseInt(sort);
			theCustomers = customerService.getCustomers(theSortField);			
		}
		else {
			// no sort field provided ... default to sorting by last name
			theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
		}
		
		// add the customers to the model
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/search")
	public String searchCustomer(Model model, @RequestParam("searchvalue")String value) {
		model.addAttribute("customers", customerService.getCustomers(value));
		return "list-customers";
	}
	
	@GetMapping("/showCustomerForm")
	public String showCustomerForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		return "show-customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		return "redirect:list";
	}
	
	@GetMapping("/update")
	public String updateCustomerViaParam(Model model, @RequestParam("id")int id) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "show-customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomerViaParam(Model model, @RequestParam("id")int id) {
//		Customer customer = customerService.getCustomer(id);
//		customerService.deteleCustomer(customer);
		customerService.deteleCustomer(id);
		return "redirect:list";
	}
	
	
	@GetMapping("/update/{id}")
	public String updateCustomerViaPathVariable(Model model, @PathVariable("id")int id) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "show-customer-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCustomerViaPathVariable(Model model, @PathVariable("id")int id) {
		customerService.deteleCustomer(id);
		return "redirect:list";
	}
	
	@RequestMapping("/list.json")
	public void listCustomer(HttpServletResponse response) throws IOException { 		
		response.getWriter().print(customerService.getCustomers( SortUtils.LAST_NAME));
	}
}
