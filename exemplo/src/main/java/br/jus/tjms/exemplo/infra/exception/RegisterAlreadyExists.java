package br.jus.tjms.exemplo.infra.exception;

public class RegisterAlreadyExists extends RuntimeException {
    public RegisterAlreadyExists(String message) {
        super(message);
    }
}
