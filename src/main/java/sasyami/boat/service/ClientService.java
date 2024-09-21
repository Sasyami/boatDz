package sasyami.boat.service;

import lombok.RequiredArgsConstructor;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements UserDetailsService {
    private final ClientRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findByLogin(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getLogin(),
                        user.getPassword(),
                        List.of()
                        )
                )
                .orElseThrow(() -> new UsernameNotFoundException("Юзер нот фаунд"));
    }
}
