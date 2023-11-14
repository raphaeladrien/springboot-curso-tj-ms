package br.jus.tjms.exemplo.model.entity.validacoes;

import br.jus.tjms.exemplo.model.entity.Empresa;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Empresa> {

    @Override
    public List<Class<?>> getValidationGroups(Empresa empresa) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(Empresa.class);


        return groups;
    }
}
