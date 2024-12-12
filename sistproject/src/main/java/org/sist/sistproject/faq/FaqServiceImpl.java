package org.sist.sistproject.faq;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sist.sistproject.exception.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class FaqServiceImpl implements FaqService{

	private final FaqRepository faqRepository;
	
	
	//게시글 등록
	@Override
	public void register(String title, String content) {
		Faq faq = new Faq();
		faq.setTitle(title);
		faq.setContent(content);
		faq.setCreateDate(LocalDateTime.now());
		
		this.faqRepository.save(faq);
		
	}

	//페이징 된 목록 가져와
	@Override
	public Page<Faq> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));//정렬기준이 여러 개일 때가 있기 때문에 굳이 List로 만든 것
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		//현재 페이지 받아와서 10개씩 뿌려 direction이랑 property라는 parameter도 있으니 공부할 것
		return this.faqRepository.findAll(pageable); // 1번 페이지 끝
	}
	
	//상세보기
	@Override
	public Faq getFaq(Long id) {
		Optional<Faq> faq = this.faqRepository.findById(id);
        if(faq.isPresent()) {
        	this.faqRepository.updateViewCount(id);
            return faq.get();
        } else {
            throw new DataNotFoundException("@@@@@@faq가 업서요~!");
        }
	}
	
	//게시글 수정
	@Override
	public void modifyFaq(Faq faq, String title, String content) {
		faq.setTitle(title);
		faq.setContent(content);
		faq.setModifyDate(LocalDateTime.now());
		this.faqRepository.save(faq);
	}
	
	//게시글 삭제
	@Override
	public void delete(Faq faq) {
		this.faqRepository.delete(faq);
	}

	//싹 다 지워
	 public void deleteMultiple(List<Long> ids) {
	        faqRepository.deleteAllById(ids);
	    }

}
