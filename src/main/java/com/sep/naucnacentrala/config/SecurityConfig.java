package com.sep.naucnacentrala.config;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {// extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private Environment env;
//	
//	@Autowired
//	private UserSecurityService userSecurityService;
//	
//	private static final String SALT = "salt";	//Salt should be protected carefully
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
//	}
//
//	private static final String[] PUBLIC_MATCHERS = {
//			"/webjars/**",
//			"/css/**",
//			"/js/**",
//			"/images/**",
//			"/",
//			"/about/**",
//			"/contact/**",
//			"/error/**/*",
//			"/console/**",
//			"/signup"
//	};
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.csrf().disable().cors().disable()
//				.formLogin()
//				.loginPage("/login").permitAll()
//				.loginProcessingUrl("/login").permitAll()
//                .usernameParameter("username")
//                .successHandler((request, response, authentication) -> {
//                    response.setStatus(HttpServletResponse.SC_OK);
//                    response.sendRedirect("/userFront");
//                })
//                .failureHandler((request, response, exception) -> {
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                   
//                })
////				.failureUrl("/index?error")
////				.defaultSuccessUrl("/userFront").loginPage("/index").permitAll()
//				.and()
//				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index?logout").deleteCookies("remember-me").permitAll()
//				.and()
//				.rememberMe();
//	}
	
	//@Autowired
	//public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER"); // This is in-memory
		//auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
//	}

}
