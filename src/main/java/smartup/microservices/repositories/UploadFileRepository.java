package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.UploadFile;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile, Long>{

}
