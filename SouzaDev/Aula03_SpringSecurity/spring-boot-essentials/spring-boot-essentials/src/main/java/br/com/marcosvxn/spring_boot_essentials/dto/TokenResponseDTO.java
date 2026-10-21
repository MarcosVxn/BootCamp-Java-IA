package br.com.marcosvxn.spring_boot_essentials.dto;



public record TokenResponseDTO (String token, long expiresIn) {
}
