package com.theironyard.PersonalWebsite.repositories;

import com.theironyard.PersonalWebsite.entities.Experience;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Keith on 5/18/17.
 */
public interface PersonalWebsiteRepository extends PagingAndSortingRepository<Experience, Integer> {
}
