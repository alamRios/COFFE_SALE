package com.coffeSale.controller.appcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogInController {
	@RequestMapping("/login")
	public String login(@RequestParam(
			value="error", required=false, defaultValue="Credencial incorrecta") String error,
			Model model){
		model.addAttribute("error", error);
		return "login";
	}
}
