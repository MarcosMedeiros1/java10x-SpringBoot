package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HobbitService {

    private HobbitRepository hobbitRepository;

    public HobbitService(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    public List<HobbitModel> getAllHobbits() {
        return hobbitRepository.findAll();
    }
}
