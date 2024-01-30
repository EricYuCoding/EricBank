package com.eazybytes.springsecuritybasic.config;

import com.eazybytes.springsecuritybasic.model.Customer;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import net.sf.jsqlparser.statement.grant.Grant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EricBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = (String) authentication.getCredentials();
        List<Customer> customers = customerRepository.findByEmail(username);
        if (customers.size() > 0) {
            if(passwordEncoder.matches(pwd, customers.get(0).getPwd())){
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            }else {
                throw new BadCredentialsException("Invalid password");
            }
        }else {
            throw new BadCredentialsException("Invalid Username");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
