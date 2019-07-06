package com.heliommsfilho.sistemafinanceiro.api.resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heliommsfilho.sistemafinanceiro.api.config.property.SistemaFinanceiroApiProperty;

@RestController
@RequestMapping("/tokens")
public class TokenResource {

	@Autowired
	private SistemaFinanceiroApiProperty properties;
	
	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest req, HttpServletResponse resp) {
		Cookie refreshTokenCookie = new Cookie("refreshToken", null);
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setSecure(properties.getSeguranca().isEnableHttps());
		refreshTokenCookie.setPath(req.getContextPath() + "/oauth/token");
		refreshTokenCookie.setMaxAge(0);
		
		resp.addCookie(refreshTokenCookie);
		resp.setStatus(HttpStatus.NO_CONTENT.value());
	}
}
