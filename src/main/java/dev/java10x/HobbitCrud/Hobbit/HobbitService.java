package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HobbitService {

    private HobbitRepository hobbitRepository;
    private HobbitMapper hobbitMapper;

    public HobbitService(HobbitRepository hobbitRepository, HobbitMapper hobbitMapper) {
        this.hobbitRepository = hobbitRepository;
        this.hobbitMapper = hobbitMapper;
    }

    public List<HobbitDTO> getAllHobbits() {
        List<HobbitModel> hobbits = hobbitRepository.findAll();
        return hobbits.stream()
                .map(hobbitMapper::map)
                .collect(Collectors.toList());
    }

    public HobbitDTO getHobbitById(Long id) {
        Optional<HobbitModel> hobbit = hobbitRepository.findById(id);
        return  hobbit.map(hobbitMapper::map).orElse(null);
    }

    public HobbitDTO createHobbit(HobbitDTO hobbitDTO) {
        HobbitModel hobbit = hobbitMapper.map(hobbitDTO);
        hobbit = hobbitRepository.save(hobbit);
        return hobbitMapper.map(hobbit);
    }

    public void deleteHobbitById(Long id) {
        hobbitRepository.deleteById(id);
    }

    public HobbitDTO updateHobbit(Long id, HobbitDTO hobbitDTO) {
        Optional<HobbitModel> foundHobbit = hobbitRepository.findById(id);
        if (foundHobbit.isPresent()) {
            HobbitModel updatedHobbit = hobbitMapper.map(hobbitDTO);
            updatedHobbit.setId(id);
            HobbitModel savedHobbit = hobbitRepository.save(updatedHobbit);
            return hobbitMapper.map(savedHobbit);
        }
        return null;
    }
}
