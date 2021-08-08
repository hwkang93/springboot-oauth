package hwkang.oauth.config.auth;

import hwkang.oauth.login.data.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final OAuth2UserService customOAuthUserService;

    private final static String[] PERMIT_ALL_PATTERNS = {"/", "/css/**", "/images/**", "/js/**", "/h2-console/**"};
    private final static String[] USER_ROLE_PATTERNS = {"/api/v1/**"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers(PERMIT_ALL_PATTERNS).permitAll()
                    .antMatchers(USER_ROLE_PATTERNS).hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuthUserService);
    }
}
