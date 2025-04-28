package net.engineeringdigest.journalApp.service;
import net.engineeringdigest.journalApp.entity.journalEntry;
import net.engineeringdigest.journalApp.repo.journalEntryrepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalentryservice {
    //create entries
    @Autowired
    private journalEntryrepo journalentryrepo;
    public void saveEntry(journalEntry journalEntry){
        journalentryrepo.save(journalEntry);
    }
    public List<journalEntry> getAll(){
        return journalentryrepo.findAll();
    }
    public Optional<journalEntry>findById(ObjectId id){
        return journalentryrepo.findById(id);
    }
    public void deletebyid(ObjectId id){
        journalentryrepo.deleteById(id);
    }
}
