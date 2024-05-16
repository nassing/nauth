package fr.nassing.nauth.repository;

import fr.nassing.nauth.entity.NauthData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NauthDataRepository extends CrudRepository<NauthData, String> {

}
