package com.heliommsfilho.sistemafinanceiro.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private final int UM_DIA = 3600 * 24;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("angular").secret("@ngul@r0")
								  .scopes("read", "write")
								  .authorizedGrantTypes("password", "refresh_token")
								  .accessTokenValiditySeconds(1800)
								  .refreshTokenValiditySeconds(UM_DIA)
			.and().withClient("mobile").secret("m0b1l30")
			  .scopes("read")
			  .authorizedGrantTypes("password", "refresh_token")
			  .accessTokenValiditySeconds(1800)
			  .refreshTokenValiditySeconds(UM_DIA);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
				 .accessTokenConverter(accessTokenConverter())
				 .reuseRefreshTokens(false) // Renova o Refresh Token a cada acesso
				 .authenticationManager(authManager);
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("sistema-financeiro");
		
		return accessTokenConverter;
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
}
