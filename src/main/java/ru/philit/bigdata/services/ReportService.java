package ru.philit.bigdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.kerberos.client.KerberosRestTemplate;
import org.springframework.stereotype.Service;
import ru.philit.bigdata.domain.reports.Order;
import ru.philit.bigdata.domain.reports.Report;
import ru.philit.bigdata.domain.reports.ReportStatus;
import ru.philit.bigdata.repositories.ReportRepository;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by gennady on 25/07/17.
 */
@Service
public class ReportService {
  @Autowired
  private ReportRepository reportRepository;
//  @Autowired
//  private RestTemplate restTemplate = new RestTemplate();
  private KerberosRestTemplate restTemplate = new KerberosRestTemplate("/etc/evkuzmin.keytab",
                                                                        "EvKuzmin@BEE.VIMPELCOM.RU");

  private String host = "hd-has014.vimpelcom.ru";
  private String port = "14000";
  private String path = "/apps/hive/warehouse/arstel.db/evkuzmin_dim_soc/report.json";

  public void save(Order order) {
    for(Long reportId : order.getReports()){
      Report report = new Report();
      report.setReportId(reportId);
      report.setDescription("full description");
      report.setOrderId(order.getOrderId());
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

  public String getReportJSON() throws URISyntaxException {
    URI uri = new URI("http" + "://" + host + ":" + port + "/webhdfs/v1" + path + "?op=OPEN");
    File workDir = new File("/etc/evkuzmin.keytab");
    if (!workDir.exists()) {
      System.out.println("Specified work directory does not exists: " + workDir.getAbsolutePath());
    }
    System.out.println(workDir.getAbsolutePath());
    String json = restTemplate.getForObject(uri, String.class);
    return json;
  }
}
