package br.com.geracaoelias.ekklesia_home.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.geracaoelias.ekklesia_home.model.Regra;
import br.com.geracaoelias.ekklesia_home.model.Usuario;
import br.com.geracaoelias.ekklesia_home.repository.UsuarioRepositorio;

@Component
public class AuthProviderService implements AuthenticationProvider {

    @Autowired
    private UsuarioRepositorio usuarioRepository;
    
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String senha = auth.getCredentials().toString();

        // Defina suas regras para realizar a autenticação
        
        Usuario user = usuarioRepository.findByUsername(username);
        if (user != null){
            if (user.getEnabled()) {
                return new UsernamePasswordAuthenticationToken(username, senha, getGrantedAuthorities(user.getRegras()));
            } else {
                throw new BadCredentialsException("Este usuário está desativado.");
            }
        }        

        throw new UsernameNotFoundException("Usuário e/ou Senha inválidos.");
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
    
    private List<GrantedAuthority> getGrantedAuthorities(Collection<Regra> regras) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Regra regra : regras) {
            authorities.add(new SimpleGrantedAuthority(regra.getNome()));
        }
        return authorities;
    }
}