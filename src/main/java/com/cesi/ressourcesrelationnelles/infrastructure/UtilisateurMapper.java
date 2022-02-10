package com.cesi.ressourcesrelationnelles.infrastructure;

import com.cesi.ressourcesrelationnelles.domain.Utilisateur;

public class UtilisateurMapper {
    public UtilisateurDto toDto(Utilisateur user) {
        UtilisateurDto userDto = new UtilisateurDto();
        userDto.setId(user.getUTI_ID());
        userDto.setFirstName(user.getUTI_Prenom());
        userDto.setLastName(user.getUTI_Nom());
        return userDto;
    }
}
