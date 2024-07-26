package com.rafael.projectmongodb.business;

import com.rafael.projectmongodb.api.converter.UserConverter;
import com.rafael.projectmongodb.api.converter.UserMapper;
import com.rafael.projectmongodb.api.request.UserRequestDTO;
import com.rafael.projectmongodb.api.response.UserResponseDTO;
import com.rafael.projectmongodb.infrastructure.entity.Address;
import com.rafael.projectmongodb.infrastructure.entity.User;
import com.rafael.projectmongodb.infrastructure.exceptions.BusinessException;
import com.rafael.projectmongodb.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final UserMapper userMapper;
    private final AddressService addressService;


    public User saveUser(User usuarioEntity) {
        return userRepository.save(usuarioEntity);
    }

    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        try {
            notNull(userRequestDTO, "Os dados do usuário são obrigatórios");
            User user = saveUser(userConverter.toUserEntity(userRequestDTO));
            Address address = addressService.saveAddress(
                    userConverter.toAddressEntity(userRequestDTO.getAddress(), user.getId()));
            return userMapper.toUserResponseDTO(user, address);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }
    }


    public UserResponseDTO getUserData(String email) {
        try {
            User entity = userRepository.findByEmail(email);
            notNull(entity, "Usuário não encontrado");
            Address address = addressService.findByUserId(entity.getId());

            return userMapper.toUserResponseDTO(entity, address);
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar dados de usuário", e);
        }
    }

    @Transactional
    public void deleteUser(String email) {
        User entity = userRepository.findByEmail(email);
        userRepository.deleteByEmail(email);
        addressService.deleteByUserId(entity.getId());
    }

}
