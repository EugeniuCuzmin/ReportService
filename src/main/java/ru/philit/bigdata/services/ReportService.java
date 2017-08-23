package ru.philit.bigdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.philit.bigdata.domain.reports.Report;
import ru.philit.bigdata.domain.reports.ReportDTO;
import ru.philit.bigdata.domain.reports.ReportStatus;
import ru.philit.bigdata.repositories.ReportRepository;

/**
 * Created by gennady on 25/07/17.
 */
@Service
public class ReportService {
  @Autowired
  private ReportRepository reportRepository;

  public void save(ReportDTO reportDTO) {
    for(Long reportId : reportDTO.getReports()){
      Report report = new Report();
      report.setReportId(reportId);
      report.setDescription("full description");
      report.setOrderId(reportDTO.getOrderId());
      report.setBusinessId("businessId");
      report.setReportDate("report date");
      report.setStatus(ReportStatus.in_production);
      /*CONNECT TO CLUSTER AND CALCULATE REPORT, SAVE IT AS JSON*/
      reportRepository.save(report);
    }
  }

  public Iterable<Report> findByOrderId(String orderId) {
    return reportRepository.findByOrderId(orderId);
  }

//  reruns all reports for all orders on db. needs to return available types of reports
  public Iterable<Report> findAll(){
    return reportRepository.findAll();
  }

  public Report findByReportId(String orderId, Long reportId) {
    for (Report report : findByOrderId(orderId)) {
      if(report.getReportId().equals(reportId))
        return report;
    }
    return null;
  }
}
