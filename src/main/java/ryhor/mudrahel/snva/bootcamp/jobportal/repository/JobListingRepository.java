package ryhor.mudrahel.snva.bootcamp.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ryhor.mudrahel.snva.bootcamp.jobportal.model.JobListing;

@Repository
public interface JobListingRepository extends JpaRepository<JobListing, Long> {

}
