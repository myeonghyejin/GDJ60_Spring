package com.mhj.s1.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//getProductList
	@RequestMapping(value="list")
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
		//ModelAndView mv = new ModelAndView();
		
		List<ProductDTO> ar = productService.getProductList();
		
		System.out.println(ar.size()>0);
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		return mv;
	}
	
	//getProductDetail
	@RequestMapping(value="detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		//파라미터의 이름과 setter의 이름과 같아야 함
		
		System.out.println("Product Detail");
		//String num = request.getParameter("num");
		
		//ProductDTO productDTO = new ProductDTO();
		//productDTO.setProductNum(num);
		productDTO = productService.getProductDetail(productDTO);
		
		System.out.println(productDTO != null);
		
		model.addAttribute("DTO", productDTO);
		
		return "product/productDetail";
	}
	
	//productAdd
	@RequestMapping(value="productAdd", method = RequestMethod.GET)
	public void productAdd() {
		
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String productAdd(ProductDTO productDTO) throws Exception {
		int result = productService.setProductAdd(productDTO, null);
		System.out.println(result == 1);
		return "redirect:./list";
	}
	
	//update
	@RequestMapping(value = "update")
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
	
}