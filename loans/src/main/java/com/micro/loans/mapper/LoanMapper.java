package com.micro.loans.mapper;

import com.micro.loans.dto.LoansDto;
import com.micro.loans.entity.Loans;

public class LoanMapper {

    public static Loans mapToLoans(LoansDto loansDto,Loans loans) {
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        loans.setMobileNumber(loansDto.getMobileNumber());
        return loans;
    }

    public static LoansDto mapToLoansDto(Loans loans,LoansDto loansDto) {
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        loansDto.setMobileNumber(loans.getMobileNumber());
        return loansDto;
    }

}
