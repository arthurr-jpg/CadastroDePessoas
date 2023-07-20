package com.CadastroPessoas;

import org.springframework.data.repository.CrudRepository;

public interface CadastroRepository extends CrudRepository<CadastroPessoas, String> {
    CadastroPessoas findByCodigo(long codigo);
}
