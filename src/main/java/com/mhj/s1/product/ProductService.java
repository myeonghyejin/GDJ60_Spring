package com.mhj.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	//getProductList
	public List<ProductDTO> getProductList() throws Exception{
		return productDAO.getProductList();
	}

	//getProductDetail
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getProductDetail(productDTO);
	}
	
	//setProductAdd
	public int setProductAdd(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception{
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setProductAdd(productDTO);
		
		if(ar != null) {
			for(ProductOptionDTO productOptionDTO:ar) {
				productOptionDTO.setProductNum(productNum);
				result = productDAO.setProductOptionAdd(productOptionDTO);
			}
		}	
		return result;	
	}

}