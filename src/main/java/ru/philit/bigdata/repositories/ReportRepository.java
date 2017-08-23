package ru.philit.bigdata.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.philit.bigdata.domain.reports.Report;

import java.util.List;

/**
 * Created by EvKuzmin on 18.08.2017.
 */
@Repository
public interface ReportRepository extends CrudRepository<Report, String>{
  List<Report> findByOrderId(String orderId);
}
