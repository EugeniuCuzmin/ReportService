package ru.philit.bigdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.philit.bigdata.domain.reports.Report;
import ru.philit.bigdata.domain.reports.ReportDTO;
import ru.philit.bigdata.services.ReportService;

/**
 * Created by gennady on 24/07/17.
 */
@RestController
@RequestMapping(path = "/audpro/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

  /*POST*/
  @RequestMapping(value = "", method = RequestMethod.POST,
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity generateReports(@RequestBody ReportDTO reportDTO){
    reportService.save(reportDTO);
    return new ResponseEntity(HttpStatus.ACCEPTED);
  }

  /*GET*/
  @RequestMapping(value = "", method = RequestMethod.GET,
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<Report>> getReportsForOrder(){
    return new ResponseEntity<Iterable<Report>>(reportService.findAll(), HttpStatus.OK);
  }

  @RequestMapping(value = "/{businessId}/{orderId}", method = RequestMethod.GET,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<Report>> getOrder(@PathVariable("businessId") String businessId,
                                          @PathVariable("orderId") String orderId){
    return new ResponseEntity<Iterable<Report>>(reportService.findByOrderId(orderId), HttpStatus.OK);
  }

  @RequestMapping(value = "/{businessId}/{orderId}/{reportId}", method = RequestMethod.GET,
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Report>  getReport(@PathVariable("businessId") String businessId,
                                           @PathVariable("orderId") String orderId,
                                           @PathVariable("reportId") Long reportId){
      return new ResponseEntity<Report>(reportService.findByReportId(orderId, reportId), HttpStatus.OK);
  }

  @RequestMapping(value = "/health", method = RequestMethod.GET,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity  getReportHealth(){
    return new ResponseEntity(HttpStatus.OK);
  }
}
