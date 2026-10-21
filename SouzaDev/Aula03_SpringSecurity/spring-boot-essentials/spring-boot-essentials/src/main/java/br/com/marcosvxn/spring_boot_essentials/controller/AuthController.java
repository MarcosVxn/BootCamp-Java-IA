package br.com.marcosvxn.spring_boot_essentials.controller;


import br.com.marcosvxn.spring_boot_essentials.dto.LoginRequestDTO;
import br.com.marcosvxn.spring_boot_essentials.dto.RegisterRequestDTO;
import br.com.marcosvxn.spring_boot_essentials.dto.TokenResponseDTO;
import br.com.marcosvxn.spring_boot_essentials.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO)throws Exception{
        authenticationService.requister(registerRequestDTO);
    }

    @PostMapping("/login")
    public TokenResponseDTO register(@RequestBody @Valid LoginRequestDTO loginRequestDTO)throws Exception{
        return authenticationService.login(loginRequestDTO);
    }
}
