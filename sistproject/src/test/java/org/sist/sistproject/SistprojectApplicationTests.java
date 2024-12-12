package org.sist.sistproject;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.sist.sistproject.faq.Faq;
import org.sist.sistproject.faq.FaqRepository;
import org.sist.sistproject.faq.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SistprojectApplicationTests {

	@Autowired
	private FaqRepository faqRepository;
	
	@Autowired
	private FaqService faqService;
	/*
	@Test
	void testJpa() {
		//질문 등록 테스트
		Faq f1 = new Faq();
		
		
		f1.setTitle("faq 제목테스트");
		
		f1.setContent("faq 내용 테스트");
		
		f1.setCreateDate(LocalDateTime.now());
		this.faqRepository.save(f1);
		
		Faq f2 = new Faq();
		
		f2.setTitle("과연과연");
		f2.setContent("롸롸롸롸롸");
		f2.setCreateDate(LocalDateTime.now());
		this.faqRepository.save(f2);
	}*/
	@Test
	void testJpa() {
		for (int i = 0; i < 285; i++) {
			String title = "제목 테스트 " + i;
			String content = "내용 테스트 " + i;
			this.faqService.register(title, content);
		}//for
		
	}

}
