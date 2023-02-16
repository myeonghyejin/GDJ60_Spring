package com.mhj.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mhj.s1.util.Pager;

@Repository
public class BankbookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.mhj.s1.bankbook.BankbookDAO.";
	
	//상품 조회
	public List<BankbookDTO> getBankbookList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getBankbookList", pager);
	}
	
	//상세 정보 조회
	public BankbookDTO getBankbookDetail(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getBankbookDetail", bankbookDTO);
	}
	
	//상품 등록
	public int setBankbookAdd(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setBankbookAdd", bankbookDTO);
	}
	
	//상품 수정
	public int setBankbookUpdate(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setBankbookUpdate", bankbookDTO);
	}
	
	//상품 삭제
	public int setBankbookDelete(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setBankbookDelete", bankbookDTO);
	}
	
	//전체 상품 개수 계산
	public Long getBankbookCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getBankbookCount", pager);
	}

}