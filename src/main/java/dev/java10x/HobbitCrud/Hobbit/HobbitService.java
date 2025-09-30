package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HobbitService {

    private HobbitRepository hobbitRepository;
    private HobbitMapper hobbitMapper;

    public HobbitService(HobbitRepository hobbitRepository, HobbitMapper hobbitMapper) {
        this.hobbitRepository = hobbitRepository;
        this.hobbitMapper = hobbitMapper;
    }

    public List<HobbitModel> getAllHobbits() {
        return hobbitRepository.findAll();
    }

    public HobbitModel getHobbitById(Long id) {
        Optional<HobbitModel> hobbit = hobbitRepository.findById(id);
        return  hobbit.orElse(null);
    }

    public HobbitDTO createHobbit(HobbitDTO hobbitDTO) {
        HobbitModel hobbit = hobbitMapper.map(hobbitDTO);
        hobbit = hobbitRepository.save(hobbit);
        return hobbitMapper.map(hobbit);
    }

    public void deleteHobbitById(Long id) {
        hobbitRepository.deleteById(id);
    }

    public HobbitModel updateHobbit(Long id, HobbitModel hobbit) {
        if (hobbitRepository.existsById(id)) {
            hobbit.setId(id);
            return hobbitRepository.save(hobbit);
        }
        return null;
    }
}
