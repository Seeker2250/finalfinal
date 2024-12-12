/*package org.sist.sistproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//모든 요청 url이 spring security의 제어를 받게 함,
//			SecurityFilterChain filter가 적용되어 활성화되게 만들어
public class SecurityConfig{
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
				.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		.csrf((csrf) -> csrf
                .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
		.headers((headers) -> headers
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)));
		
		return http.build();
	}
	
	/*http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
	 	.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
	//위는 spring legacy에서 <security:intercept-url pattern="/**" access="permitAll" /> 이거랑 같아	
	//로그인 안해도 모든 요청 허락
}//class*/