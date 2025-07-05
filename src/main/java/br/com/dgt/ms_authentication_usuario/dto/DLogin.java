package br.com.dgt.ms_authentication_usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DLogin( @NotBlank @NotNull String email, @NotBlank @NotNull String senha ) {}