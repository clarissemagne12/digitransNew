package org.example.digitransnew.services.implementations;
import org.example.digitransnew.dtos.ClientsDto;
import org.example.digitransnew.entities.Clients;
import org.example.digitransnew.exceptions.ApiException;
import org.example.digitransnew.mappers.ClientsMapper;
import org.example.digitransnew.repositories.ClientsRepo;
import org.example.digitransnew.services.interfaces.ClientsInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientsService implements ClientsInterface {

    private final ClientsRepo clientsRepo;
    private final ClientsMapper clientsMapper;

    public ClientsService(ClientsRepo clientsRepo,
                          ClientsMapper clientsMapper) {
        this.clientsRepo = clientsRepo;
        this.clientsMapper = clientsMapper;
    }

    @Override
    public ClientsDto save(ClientsDto clientsDto) {

        if (clientsDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de client invalides");
        }

        Clients clients = clientsMapper.toEntity(clientsDto);

        return clientsMapper.toDto(
                clientsRepo.save(clients)
        );
    }

    @Override
    public ClientsDto update(Long id, ClientsDto clientsDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de client invalide");
        }
        if (!clientsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Client introuvable");
        }

        Clients clients = clientsMapper.toEntity(clientsDto);

        clients.setId(id);

        return clientsMapper.toDto(
                clientsRepo.save(clients)
        );
    }

    @Override
    public ClientsDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de client invalide");
        }

        return clientsRepo.findById(id)
                .map(clientsMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Client introuvable"));
    }

    @Override
    public List<ClientsDto> findAll() {

        return clientsRepo.findAll()
                .stream()
                .map(clientsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de client invalide");
        }
        if (!clientsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Client introuvable");
        }

        clientsRepo.deleteById(id);
    }
}