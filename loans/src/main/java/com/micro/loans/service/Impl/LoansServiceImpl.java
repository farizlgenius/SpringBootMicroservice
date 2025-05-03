package com.micro.loans.service.Impl;

import com.micro.loans.constant.LoansContant;
import com.micro.loans.dto.LoansDto;
import com.micro.loans.entity.Loans;
import com.micro.loans.exception.LoanAlreadyExistsException;
import com.micro.loans.exception.ResourceNotFoundException;
import com.micro.loans.mapper.LoanMapper;
import com.micro.loans.repository.LoansRepository;
import com.micro.loans.service.ILoansService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    public LoansServiceImpl(LoansRepository loansRepository){
        this.loansRepository = loansRepository;
    }

    /**
     *
     * @param mobileNumber
     */
    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByLoanNumber(mobileNumber);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber " + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    /**
     *
     * @param mobileNumber
     * @return the new loan details
     */
    private Loans createNewLoan(String mobileNumber)
    {
        Loans loans = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        loans.setLoanNumber(String.valueOf(randomLoanNumber));
        loans.setMobileNumber(mobileNumber);
        loans.setLoanType(LoansContant.HOME_LOAN);
        loans.setTotalLoan(LoansContant.NEW_LOAN_LIMIT);
        loans.setAmountPaid(0);
        loans.setOutstandingAmount(LoansContant.NEW_LOAN_LIMIT);
        return loans;
    }

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Loan Details based on a given mobileNumber
     */
    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Loan","mobileNumber",mobileNumber)
        );
        return LoanMapper.mapToLoansDto(loans,new LoansDto());
    }

    /**
     *
     * @param loansDto - LoansDto Object
     * @return boolean indicating if the update loan detail is successful or not
     */
    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                ()->new ResourceNotFoundException("Loan","loanNumber",loansDto.getLoanNumber())
        );
        LoanMapper.mapToLoans(loansDto,loans);
        loansRepository.save(loans);
        return true;
    }

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicate if the delete loan detail is successful or not
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }
}
