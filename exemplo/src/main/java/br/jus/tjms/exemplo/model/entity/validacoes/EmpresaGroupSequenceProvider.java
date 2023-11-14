package br.jus.tjms.exemplo.model.entity.validacoes;

import br.jus.tjms.exemplo.model.entity.Empresa;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class EmpresaGroupSequenceProvider implements DefaultGroupSequenceProvider<Empresa> {

    @Override
    public List<Class<?>> getValidationGroups(Empresa empresa) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(Empresa.class);

        if (empresa == null || empresa.getCpfOuCnpj() == null){
            return groups;
        }

        if (empresa.getCpfOuCnpj().length() == 14) {
            groups.add(CpnjGroup.class);
        } else {
            groups.add(CpfGroup.class);
        }

        return groups;
    }
}
