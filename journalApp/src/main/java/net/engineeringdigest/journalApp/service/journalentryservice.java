package net.engineeringdigest.journalApp.service;
import net.engineeringdigest.journalApp.entity.journalEntry;
import net.engineeringdigest.journalApp.repo.journalEntryrepo;
import org.springframework.beans.factory.annotation.Autowired;

public class journalentryservice {
    //create entries
    @Autowired
    private journalEntryrepo journalentryrepo;
    public void saveEntry(journalEntry journalEntry){
        journalentryrepo.save(journalEntry);
    }
}
//controller --> service --> repositiory -->