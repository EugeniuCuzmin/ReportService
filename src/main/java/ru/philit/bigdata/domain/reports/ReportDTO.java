package ru.philit.bigdata.domain.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * Created by gennady on 25/07/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDTO {
  @Getter @Setter
  private String orderId;
  @Getter @Setter
  private Iterable<Long> reports;
  @Getter @Setter
  private String detailedReportUri;
}
