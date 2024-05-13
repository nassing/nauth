package fr.nassing.nauth.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import fr.nassing.nauth.entity.NauthUser;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface NauthRepository extends CrudRepository<NauthUser, String> {

}
