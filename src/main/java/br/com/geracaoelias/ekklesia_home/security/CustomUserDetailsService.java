package br.com.geracaoelias.ekklesia_home.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.geracaoelias.ekklesia_home.model.Regra;
import br.com.geracaoelias.ekklesia_home.model.Usuario;
import br.com.geracaoelias.ekklesia_home.repository.UsuarioRepositorio;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
    private final UsuarioRepositorio usuarioRepository;

    @Autowired
    public CustomUserDetailsService(UsuarioRepositorio userRepository)
    {
        this.usuarioRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Usuario user = usuarioRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        } else {
             return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.getEnabled(), true, true, 
                true, getGrantedAuthorities(user.getRegras())); 
                
        }
    }
 
 
    private List<GrantedAuthority> getGrantedAuthorities(Collection<Regra> regras) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Regra regra : regras) {
            authorities.add(new SimpleGrantedAuthority(regra.getNome()));
        }
        return authorities;
    }

}
