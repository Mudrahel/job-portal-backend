package ryhor.mudrahel.snva.bootcamp.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ryhor.mudrahel.snva.bootcamp.jobportal.exception.ResourceNotFoundException;
import ryhor.mudrahel.snva.bootcamp.jobportal.model.JobListing;
import ryhor.mudrahel.snva.bootcamp.jobportal.repository.JobListingRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/job_listings")
@CrossOrigin(origins = "${my.allowed.origins}")
public class JobListingController {

    @Autowired
    private JobListingRepository jobListingRepository;

    /* Request example, Post to http://localhost:8080/api/v1/job_listings
    with body json
        {
      "title": "Software Engineer",
      "description": "Exciting software engineering position",
      "userId":1
      }
     */
    @PostMapping
    public JobListing createJobListing(@RequestBody JobListing jobListing) {
        return jobListingRepository.save(jobListing);
    }

    /* Request example, Get to http://localhost:8080/api/v1/job_listings
     */
    @GetMapping
    public List<JobListing> getAll() {
        return jobListingRepository.findAll();
    }

    /* Request example, Get to http://localhost:8080/api/v1/job_listings/1
     */
    @GetMapping("/{id}")
    public ResponseEntity<JobListing> getJobListingById(@PathVariable long id) {
        JobListing jobListing = jobListingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" Job listing doesn't exist with id:" + id));
        return ResponseEntity.ok(jobListing);
    }
}
