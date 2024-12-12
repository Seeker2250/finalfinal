package org.sist.sistproject.faq;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaqForm {
	@NotBlank(message = "제목은 필수항목입니다.")
	@Size(max = 200)
	private String title;
	
	@NotBlank(message = "내용은 필수항목입니다.")
	private String content;
	
	/*
	@NotBlank
	private LocalDateTime createDate;
	
	 * @NotBlank private String writer; 
	 *
	 
	 * 
	 * @Email private String email;
	 */
}