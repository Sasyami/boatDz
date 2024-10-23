package sasyami.boat.service;

import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sasyami.boat.dto.TextResponse;
import sasyami.boat.entities.Client;
import sasyami.boat.repository.ClientRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
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
    public Optional<Client> addOrUpdateClient(Client client){
        Pattern p = Pattern.compile("^\\{bcrypt\\}.*$");
        if (!p.matcher(client.getPassword()).matches()) {
            client.setPassword(encoder.encode(client.getPassword()));
        }
        return Optional.of(repository.save(client));
    }
    @Transactional
    public void refreshBase(){

                repository
                        .findAll()
                        .stream()
                        .map((Function<Client, Object>) this::addOrUpdateClient)
                        .collect(Collectors.toList())
                        ;
    }
    @Transactional
    public ResponseEntity<Void> deleteClient(Client client){
        try {
            repository.delete(client);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    public List<Client> getClients(){
        return repository.findAll();
    }





}
