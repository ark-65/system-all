package com.student.system.repository;

import com.student.system.domain.RewardAndPunishmentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        collectionResourceRel = "rap-information",
        path = "rap-information",
        itemResourceRel = "rap-information")
public interface RewardAndPunishmentInformationRepository extends JpaRepository<RewardAndPunishmentInformation, String> {
}
