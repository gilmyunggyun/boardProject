package com.example.boardproject.config;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
                )
                .formLogin(login -> login
                        .loginPage("/sign-in")// form 방식 로그인 사용
                        .defaultSuccessUrl("/", true)	// 성공 시 dashboard로
                        .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
                )
                .logout( logout -> logout.
                        logoutUrl("/logout").
                        logoutSuccessUrl("/login").
                        permitAll()
                       );	// 로그아웃은 기본설정으로 (/logout으로 인증해제)

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        /* @formatter:off */
//        http
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("*").hasAnyRole("ADMIN", "USER")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .permitAll());
//
//        return http.build();
//
//        /* @formatter:on */
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/static/js/**", "/static/image/**", "/static/css/**", "/static/scss/**").anyRequest();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        /* @formatter:off */
//        UserDetails user =
//                User.withUsername("user").username("user")
//                        .password("user")
//                        .roles("USER")
//                        .build();
//        /* @formatter:on */
//
//        return new InMemoryUserDetailsManager(user); // 메모리에 사용자 정보를 담는다.
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN","SUPERADMIN")
//                .and()
//                .withUser("user").password(passwordEncoder().encode("user123")).roles("USER")
//                .and()
//                .withUser("manager").password(passwordEncoder().encode("manager123")).roles("MANAGER","ADMIN");
//    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
