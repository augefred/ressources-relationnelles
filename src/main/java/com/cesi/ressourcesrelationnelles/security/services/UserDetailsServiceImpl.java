package com.cesi.ressourcesrelationnelles.security.services;

import com.cesi.ressourcesrelationnelles.domain.Utilisateur;
import com.cesi.ressourcesrelationnelles.repository.UtilisateurRepository;
import com.cesi.ressourcesrelationnelles.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UtilisateurService userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Utilisateur user = userRepository.findByEmail(username);
    return UserDetailsImpl.build(user);
  }

}
