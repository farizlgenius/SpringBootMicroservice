package com.micro.loans.controller;

import com.micro.loans.constant.LoansContant;
import com.micro.loans.dto.ErrorResponseDto;
import com.micro.loans.dto.LoansDto;
import com.micro.loans.dto.ResponseDto;
import com.micro.loans.service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST API for Loans",
        description = "CRUD REST APIs for Loans to CREATE,UPDATE,DELETE and FETCH Loans details"
)
@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class LoanController {

    private ILoansService iLoansService;

    @Autowired
    private void setILoansService(ILoansService iLoansService){
        this.iLoansService = iLoansService;
    }

    @Operation(
            summary = "Create Loan REST APIs",
            description = "REST API to create new Loan details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status Created"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits") String mobileNumber){
        iLoansService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(LoansContant.STATUS_201,LoansContant.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Loan REST APIs",
            description = "REST API to fetch Loan details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits") String mobileNumber){
        LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }

    @Operation(
            summary = "Update Loan REST APIs",
            description = "REST API to update Loan details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Exception Fail"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoansDto loansDto){
        boolean isUpdated = iLoansService.updateLoan(loansDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansContant.STATUS_200,LoansContant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansContant.STATUS_417,  LoansContant.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Loan REST APIs",
            description = "REST API to delete Loan details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Exception Fail"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits") String mobileNumber){
        boolean isDeleted = iLoansService.deleteLoan(mobileNumber);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansContant.STATUS_200,LoansContant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansContant.STATUS_417,  LoansContant.MESSAGE_417_DELETE));
        }
    }


}
