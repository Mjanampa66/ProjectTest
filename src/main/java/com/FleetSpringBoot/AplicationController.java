package com.FleetSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AplicationController {
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
	@GetMapping("/hr")
	public String widget() {
		return "/hr/index";
	}	
	
	@GetMapping("/fleet")
	public String fleet() {
		return "/fleet/index";
	}	
	
	@GetMapping("/help")
	public String help() {
		return "/helpdesk/index";
	}	
	
	@GetMapping("/parameters")
	public String parameters() {
		return "/parameters/index";
	}	
	
	@GetMapping("/payroll")
	public String payroll() {
		return "/payroll/index";
	}	
	
	@GetMapping("/accounts")
	public String accounts() {
		return "/accounts/index";
	}
	
	@GetMapping("/reports")
	public String reports() {
		return "/reports/index";
	}
	
	@GetMapping("/security")
	public String security() {
		return "/security/index";
	}
	

}
