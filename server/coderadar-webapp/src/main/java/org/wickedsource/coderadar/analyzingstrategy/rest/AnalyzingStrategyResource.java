package org.wickedsource.coderadar.analyzingstrategy.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AnalyzingStrategyResource extends ResourceSupport {

    private Date fromDate;

    @NotNull
    private Boolean active;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean rescan;

    public AnalyzingStrategyResource() {

    }

    public AnalyzingStrategyResource(Date fromDate, boolean active) {
        this.fromDate = fromDate;
        this.active = active;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Careful! Can be null!
     */
    public Boolean isRescan() {
        return rescan;
    }

    public void setRescan(Boolean rescan) {
        this.rescan = rescan;
    }

    @JsonIgnore
    public boolean isRescanNullsafe() {
        return rescan != null && rescan;
    }
}
