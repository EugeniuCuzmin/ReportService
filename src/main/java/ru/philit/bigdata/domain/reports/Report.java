package ru.philit.bigdata.domain.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by gennady on 25/07/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "reports")
public class Report {
  @Getter @Setter
  private Long reportId;
  @Getter @Setter
  private String description;
  @Getter @Setter
  private String orderId;
  @Getter @Setter
  private String businessId;
  @Getter @Setter
  private String reportDate;
  @Getter @Setter
  private ReportStatus status;
}
