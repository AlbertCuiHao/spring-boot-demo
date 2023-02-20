package com.albert.common.security.serivce;

import com.albert.common.security.entity.UserEntity;
import com.albert.common.security.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        if (StringUtils.hasText(userName)) {
            UserEntity entity = userRepository.findUserEntityByUsername(userName);
            if (Objects.isNull(entity)) {
                return new User(userName, "", Collections.emptyList());
            } else {
                List<Map<String, Object>> userRoleAndAuthorityList = userRepository.findUserRoleAndAuthorityByUsername(userName);
                List<GrantedAuthority> authorities = new ArrayList<>();
                userRoleAndAuthorityList.forEach(temp -> {
                    String role = String.valueOf(temp.getOrDefault("security_name", ""));
                    authorities.add(new SimpleGrantedAuthority(role));
                });
                return new User(userName, entity.getPassword(), authorities);
            }

        } else {
            throw new UsernameNotFoundException("Cannot pass null or empty values to userName");
        }
    }
}
