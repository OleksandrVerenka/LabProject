package labproject.demo.lab;

import labproject.demo.lab.entety.Item;
import labproject.demo.lab.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoService demoService;

    @GetMapping("/items")
    public List<Item> getItems() {
        boolean order = true;
        List<Item> items = demoRepository.findAll();
        Comparator<Item> comparator = null;

        if(order)
        comparator = Comparator.comparing(Item::getName);
        else {
            comparator = Comparator.comparing(Item::getName).reversed();
        }

        return items.stream().sorted(comparator).collect(Collectors.toList());
    }

    @GetMapping("/items/name={name}")
    public List<Item> getItems(@PathVariable("name") String name) {
        return demoService.getItemsByName(name);
    }

    @GetMapping("/item")
    public List<Item> getItem() {
        List<Item> items = demoRepository.findAll();
        return items;
    }

    @PostMapping("/item")
    public void addItem(@RequestBody() Item item) {
        demoRepository.save(item);
    }


    @GetMapping("/info")
    public String getInfo() {
        return "This site works with items.";
    }
}
