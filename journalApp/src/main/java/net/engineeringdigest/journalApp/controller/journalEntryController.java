package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.controller.entity.journalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class journalEntryController {
    private HashMap<Long, journalEntry> journalentries=new HashMap<>();

    @GetMapping
    public List<journalEntry> getAll(){
        return new ArrayList<>(journalentries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody journalEntry myentry){
        journalentries.put(myentry.getId(), myentry);
        return true;
    }

    @GetMapping("id/{myid}")
    public journalEntry getjournalEntry(@PathVariable Long myid){
        return journalentries.get(myid);
    }

    @DeleteMapping("id/{myid}")
    public journalEntry deletejournalEntry(@PathVariable Long myid){
        return journalentries.remove(myid);
    }

    @PutMapping("id/{myid}")
    public journalEntry updatejournalEntry(@PathVariable Long myid,@RequestBody journalEntry myentry){
        return journalentries.put(myid,myentry);
    }
}
