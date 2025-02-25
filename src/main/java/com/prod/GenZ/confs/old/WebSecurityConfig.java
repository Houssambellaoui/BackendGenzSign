package com.prod.GenZ.confs.old;//package com.pfa.restapi.confs;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig implements WebSecurityConfigurer {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .add("/public/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll();
//    }
//
//    @Override
//    public void init(SecurityBuilder builder) throws Exception {
//
//    }
//
//    @Override
//    public void configure(SecurityBuilder builder) throws Exception {
//
//    }
//}
////@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
////public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////
////    @Autowired
////    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
////
////    @Autowired
////    private UserDetailsService jwtUserDetailsService;
////
////    @Autowired
////    private JwtRequestFilter jwtRequestFilter;
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        // configure AuthenticationManager so that it knows from where to load
////        // user for matching credentials
////        // Use BCryptPasswordEncoder
////        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    @Override
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
////
////    @Override
////    protected void configure(HttpSecurity httpSecurity) throws Exception {
////        // We don't need CSRF for this example
////        httpSecurity.csrf().disable()
////                // dont authenticate this particular request
////                .authorizeRequests().antMatchers("/authenticate").permitAll().
////                // all other requests need to be authenticated
////                        anyRequest().authenticated().and().
////                // make sure we use stateless session; session won't be used to
////                // store user's state.
////                        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////
////        // Add a filter to validate the tokens with every request
////        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
////    }
////}