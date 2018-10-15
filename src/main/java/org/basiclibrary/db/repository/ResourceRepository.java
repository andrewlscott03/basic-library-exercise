package org.basiclibrary.db.repository;

import org.basiclibrary.db.hibernate.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, String> {

}
