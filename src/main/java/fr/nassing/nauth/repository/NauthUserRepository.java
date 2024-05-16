package fr.nassing.nauth.repository;

import fr.nassing.nauth.entity.NauthUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NauthUserRepository extends CrudRepository<NauthUser, String> {

}
