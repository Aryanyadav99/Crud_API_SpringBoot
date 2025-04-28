package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.engineeringdigest.journalApp.service.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerv2 {

    @Autowired
    private journalentryservice journalentryservice;

    @GetMapping
    public List<journalEntry> getAll() {
        return journalentryservice.getAll();
    }

    @PostMapping
    public journalEntry createEntry(@RequestBody journalEntry myentry) {
        myentry.setDate(LocalDateTime.now());
        journalentryservice.saveEntry(myentry);
        return myentry;
    }

    @GetMapping("id/{myid}")
    public journalEntry getjournalEntry(@PathVariable ObjectId myid) {
        return journalentryservice.findById(myid).orElse(null);
    }

    @DeleteMapping("id/{myid}")
    public boolean deletejournalEntry(@PathVariable ObjectId myid) {
        journalentryservice.deletebyid(myid);
        return true;
    }

    @PutMapping("id/{myid}")
    public journalEntry updatejournalEntry(@PathVariable ObjectId myid, @RequestBody journalEntry newentry)
    {
        journalEntry old=journalentryservice.findById(myid).orElse(null);
        if(old!=null){
            old.setTitle(newentry.getTitle()!=null && !newentry.getTitle().equals("")?newentry.getTitle() : old.getTitle());
            old.setContent(newentry.getContent()!=null && !newentry.getContent().equals("")?newentry.getContent() : old.getContent());
        }
        journalentryservice.saveEntry(old);
        return old;
    }
}
