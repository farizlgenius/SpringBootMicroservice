package com.micro.loans.service;

import com.micro.loans.dto.LoansDto;

public interface ILoansService {

    /**
     * @param mobileNumber
     */
    void createLoan(String mobileNumber);

    /**
     * @param mobileNumber
     * @return Loans Details based on a given mobileNumber
     */
    LoansDto fetchLoan(String mobileNumber);

    /**
     * @param loansDto
     * @return boolean indicate if the update loan detail is successful or not
     */
    boolean updateLoan(LoansDto loansDto);

    /**
     * @param mobileNumber
     * @return boolean indicate if the delete loan detail is successful or not
     */
    boolean deleteLoan(String mobileNumber);
}
