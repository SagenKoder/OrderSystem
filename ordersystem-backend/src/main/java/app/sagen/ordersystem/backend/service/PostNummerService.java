package app.sagen.ordersystem.backend.service;

import app.sagen.ordersystem.backend.model.PostNummer;
import app.sagen.ordersystem.backend.repository.PostNummerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PostNummerService {

    private PostNummerRepository postNummerRepository;

    @Autowired
    public PostNummerService(PostNummerRepository postNummerRepository) {
        this.postNummerRepository = postNummerRepository;
    }

    public long count() {
        return postNummerRepository.count();
    }

    public List<PostNummer> findAll() {
        return postNummerRepository.findAll();
    }

    public Optional<PostNummer> find(String postNummer) {
        return postNummerRepository.findById(postNummer);
    }

    public List<PostNummer> saveAll(Collection<PostNummer> data) {
        return postNummerRepository.saveAll(data);
    }

    public PostNummer save(PostNummer postNummer) {
        return postNummerRepository.save(postNummer);
    }

}
