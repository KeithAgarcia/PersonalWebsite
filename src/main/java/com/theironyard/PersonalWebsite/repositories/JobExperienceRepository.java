package com.theironyard.PersonalWebsite.repositories;

import com.theironyard.PersonalWebsite.entities.JobExperience;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Keith on 5/18/17.
 */
public interface JobExperienceRepository extends PagingAndSortingRepository<JobExperience, Integer> {
    JobExperience findFirstByOrderByDateDesc();
}
