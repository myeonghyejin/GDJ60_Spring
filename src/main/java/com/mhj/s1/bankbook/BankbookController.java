package com.mhj.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankbookController {
	
	@Autowired
	private BankbookService bankbookService;

	//getBankbookList
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBankbookList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<BankbookDTO> ar = bankbookService.getBankbookList();
		modelAndView.setViewName("bankbook/bankbookList");
		modelAndView.addObject("list", ar);
		return modelAndView;
	}
	
	//getBankbookDetail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBankbookDetail(BankbookDTO bankbookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		bankbookDTO = bankbookService.getBankbookDetail(bankbookDTO);
		modelAndView.setViewName("bankbook/bankbookDetail");
		modelAndView.addObject("DTO", bankbookDTO);
		return modelAndView;
	}
	
	//add (입력 폼으로 이동)
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView setBankbookAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bankbook/bankbookAdd");
		return modelAndView;
	}
	
	//add (DB에 INSERT)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setBankbookAdd(BankbookDTO bankbookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = bankbookService.setBankbookAdd(bankbookDTO);
		modelAndView.setViewName("redirect:./list");
		return modelAndView;
	}
	
	//delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setBankbookDelete(BankbookDTO bankbookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = bankbookService.setBankbookDelete(bankbookDTO);
		modelAndView.setViewName("redirect:./list");
		return modelAndView;
	}
	
}	