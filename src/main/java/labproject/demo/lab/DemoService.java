package labproject.demo.lab;

import labproject.demo.lab.entety.Item;
import labproject.demo.lab.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Transactional
    public List<Item> getItemsByName(String name) {
        demoRepository.findById(1L);
        demoRepository.save(new Item("ASD"));
        demoRepository.save(new Item("ASD123123"));
        List<Item> items = demoRepository.findByName(name);

        return items;
    }
}
