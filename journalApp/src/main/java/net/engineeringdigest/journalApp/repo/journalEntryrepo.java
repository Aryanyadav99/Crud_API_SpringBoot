package net.engineeringdigest.journalApp.repo;
import net.engineeringdigest.journalApp.entity.journalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryrepo extends MongoRepository<journalEntry,String> {
}
