package com.CadastroPessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastroController {

	@Autowired
	private CadastroRepository cr;

	@RequestMapping(value = "/cadastroPessoas", method = RequestMethod.GET)
	public String form() {
		return "cadastro/formCadastro";

	}

	@RequestMapping(value = "/cadastroPessoas", method = RequestMethod.POST)
	public String form(CadastroPessoas cadastroPessoas) {

		cr.save(cadastroPessoas);

		return "redirect:/cadastroPessoas";
	}
	
	@RequestMapping("/cadastros")
	public ModelAndView ListaCadastro() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<CadastroPessoas> cadastroPessoas = cr.findAll();
		mv.addObject("cadastros",cadastroPessoas);
		return mv;
	}
   @RequestMapping("/{codigo}") 	
   public ModelAndView detalhesCadastro(@PathVariable("codigo")long codigo) {
       CadastroPessoas cadastroPessoas = cr.findByCodigo(codigo);
       ModelAndView mv = new ModelAndView("cadastro/detalhesCadastro");
       mv.addObject("cadastros",cadastroPessoas);
       System.out.println("cadastros"+cadastroPessoas);
       return mv;
	   
   }
   
}