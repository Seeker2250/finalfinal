package org.sist.sistproject.faq;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

public interface FaqService {
	public void register(String title, String content);
	public Page<Faq> getList(int page);
	public Faq getFaq(Long id);
	public void modifyFaq(Faq faq, String title, String content);
	public void delete(Faq faq);
	public void deleteMultiple(List<Long> ids);
}
