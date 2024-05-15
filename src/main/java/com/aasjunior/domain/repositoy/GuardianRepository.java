package com.aasjunior.domain.repositoy;

import com.aasjunior.domain.model.guardian.Guardian;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuardianRepository extends MongoRepository<Guardian, String> {
}
