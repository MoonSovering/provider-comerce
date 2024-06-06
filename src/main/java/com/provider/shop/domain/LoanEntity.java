package com.provider.shop.domain;

import com.provider.shop.shared.enums.LibraryStatus;

import java.util.Objects;

public class LoanEntity {
    public String readerId;
    public LibraryStatus status;
    public String observation;
    public Integer loanDays;

    public LoanEntity(String readerId, Integer loanDays) {
        this.readerId = readerId;
        this.status = LibraryStatus.REQUEST;
        this.observation = null;
        this.loanDays = loanDays;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public LibraryStatus getStatus() {
        return status;
    }

    public void setStatus(LibraryStatus status) {
        this.status = status;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Integer getLoanDays() {
        return loanDays;
    }

    public void setLoanDays(Integer loanDays) {
        this.loanDays = loanDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanEntity loanEntity = (LoanEntity) o;

        if (!Objects.equals(loanDays, loanEntity.loanDays)) return false;
        if (!Objects.equals(observation, loanEntity.observation)) return false;
        if (!Objects.equals(readerId, loanEntity.readerId)) return false;
        return status == loanEntity.status;
    }

    @Override
    public int hashCode() {
        int result = loanDays != null ? loanDays.hashCode() : 0;
        result = 31 * result + (observation != null ? observation.hashCode() : 0);
        result = 31 * result + (readerId != null ? readerId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
