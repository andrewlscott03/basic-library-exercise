package org.basiclibrary.db.repository;

import org.basiclibrary.db.hibernate.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, String> {

}
