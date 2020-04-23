package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

    private static final List<Character> ALFABETO = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

    private static final int CHAVE = 3;

    @Override
    public String criptografar(String texto) {

        String textoLower = texto.toLowerCase();

        if(textoLower.isEmpty() || textoLower == null) {
            throw new IllegalArgumentException("Esse campo não pode ser nulo");
        }

        String cifrado = "";

        for (int i = 0; i < textoLower.length(); i++) {
            Character letra = textoLower.charAt(i);
            cifrado += setaPuloCifra(letra);
        }

        return cifrado;
    }

    @Override
    public String descriptografar(String texto) {

        String textoLower = texto.toLowerCase();

        if(textoLower.isEmpty() || textoLower == null) {
            throw new IllegalArgumentException("Esse campo não pode ser nulo");
        }

        String decifrado = "";

        for (int i = 0; i < textoLower.length(); i++) {
            Character letra = textoLower.charAt(i);
            decifrado += setaPuloDecifra(letra);
        }

        return decifrado;
    }

    private Character setaPuloDecifra(Character letra) {
        Integer indexLetraAlfabeto = ALFABETO.indexOf(letra);

        if (indexLetraAlfabeto != -1 && (indexLetraAlfabeto - CHAVE) >= 0) {
            return ALFABETO.get(indexLetraAlfabeto - CHAVE);
        } else if (indexLetraAlfabeto == -1) {
            return letra;
        } else {
            int index = ALFABETO.size() - 1 - (CHAVE - 1 - indexLetraAlfabeto);
            return ALFABETO.get(index);
        }
    }

    private Character setaPuloCifra(Character letra) {
        Integer indexLetraAlfabeto = ALFABETO.indexOf(letra);

        if (indexLetraAlfabeto != -1 && (indexLetraAlfabeto + CHAVE) >= 0) {
            return ALFABETO.get(indexLetraAlfabeto + CHAVE);
        } else if (indexLetraAlfabeto == -1) {
            return letra;
        } else {
            int index = ALFABETO.size() + 1 + (CHAVE + 1 + indexLetraAlfabeto);
            return ALFABETO.get(index);
        }
    }
}
