package sasyami.boat.service;

import lombok.RequiredArgsConstructor;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sasyami.boat.entities.Client;
import sasyami.boat.repository.ClientRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements UserDetailsService {
    private final ClientRepository repository;
    private final PasswordEncoder encoder;
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
    @Transactional
    public Client addClient(Client client){
        client.setPassword(encoder.encode(client.getPassword()));
        return repository.save(client);
    }
    @Transactional
    public void refreshBase(){

                repository
                        .findAll()
                        .stream()
                        .map((Function<Client, Object>) this::addClient)
                        .collect(Collectors.toList())
                        ;
    }
}
