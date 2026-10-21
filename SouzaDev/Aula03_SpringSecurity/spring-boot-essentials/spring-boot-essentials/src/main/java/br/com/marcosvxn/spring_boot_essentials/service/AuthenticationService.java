package br.com.marcosvxn.spring_boot_essentials.service;

import br.com.marcosvxn.spring_boot_essentials.config.TokenProvider;
import br.com.marcosvxn.spring_boot_essentials.database.model.AlunosEntity;
import br.com.marcosvxn.spring_boot_essentials.database.model.RolesEntity;
import br.com.marcosvxn.spring_boot_essentials.database.repository.IAlunosRepository;
import br.com.marcosvxn.spring_boot_essentials.database.repository.IRolesRepository;
import br.com.marcosvxn.spring_boot_essentials.dto.AlunoDTO;
import br.com.marcosvxn.spring_boot_essentials.dto.LoginRequestDTO;
import br.com.marcosvxn.spring_boot_essentials.dto.RegisterRequestDTO;
import br.com.marcosvxn.spring_boot_essentials.dto.TokenResponseDTO;
import br.com.marcosvxn.spring_boot_essentials.enums.RoleTypeEnum;
import br.com.marcosvxn.spring_boot_essentials.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IAlunosRepository alunosRepository;
    private final IRolesRepository RolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Value("${jwt.expiration}")
    private long expirationTime;
    private final TokenProvider tokenProvider;

    public void requister(RegisterRequestDTO registerRequestDto) throws BadRequestException {
        AlunosEntity aluno = alunosRepository.findByEmail(registerRequestDto.getEmail())
                .orElse(null);

        if (aluno != null){
            throw new BadRequestException("Aluno já cadastrado");
        }

        RolesEntity role = RolesRepository.findByName(RoleTypeEnum.ALUNO.name())
                .orElseGet(() -> RolesRepository.save(
                        RolesEntity.builder()
                                .name(RoleTypeEnum.ALUNO.name())
                                .build()
                ));

        alunosRepository.save(AlunosEntity.builder()
                .nome(registerRequestDto.getNome())
                .email(registerRequestDto.getEmail())
                        .roles(Set.of(role))
                        .senha(passwordEncoder.encode(registerRequestDto.getSenha()))
                .build());
    }

    public TokenResponseDTO login(LoginRequestDTO loginRequestDTO) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getSenha())
            );

            String token = tokenProvider.gerarToken(authentication);
            return new TokenResponseDTO(token, expirationTime);
        }catch (BadCredentialsException e){
            throw new BadRequestException("Credenciais inválidas");
        } catch (Exception e) {
            throw e;
        }
    }

}
