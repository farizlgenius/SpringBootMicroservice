package com.micro.cards.controller;

import com.micro.cards.constant.CardsConstant;
import com.micro.cards.dto.CardsDto;
import com.micro.cards.dto.ErrorResponseDto;
import com.micro.cards.dto.ResponseDto;
import com.micro.cards.service.ICardService;
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
        name = "CRUD REST API for Cards",
        description = "CRUD REST APIs for Cards to CREATE,UPDATE,DELETE and FETCH Cards details"
)
@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CardController {

    private ICardService iCardService;

    @Autowired
    private void setICardService(ICardService iCardService){
        this.iCardService = iCardService;
    }

    @Operation(
            summary = "Create Card REST APIs",
            description = "REST API to create new Card details"
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
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits") String mobileNumber) {
        iCardService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(CardsConstant.STATUS_201, CardsConstant.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Card REST APIs",
            description = "REST API to fetch Card details"
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
    public ResponseEntity<CardsDto> fetchCard(@Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits") String mobileNumber) {
        CardsDto cardsDto = iCardService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }


    @Operation(
            summary = "Update Card REST APIs",
            description = "REST API to update Card details"
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
    public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardsDto cardsDto) {
        boolean isUpdate = iCardService.updateCard(cardsDto);
        if(isUpdate){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardsConstant.STATUS_200, CardsConstant.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(CardsConstant.STATUS_417, CardsConstant.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Card REST APIs",
            description = "REST API to delete Card details"
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
    public ResponseEntity<ResponseDto> deleteCard(@Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be 10 digits") String mobileNumber) {
        boolean isDelete = iCardService.deleteCard(mobileNumber);
        if(isDelete){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardsConstant.STATUS_200, CardsConstant.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(CardsConstant.STATUS_417, CardsConstant.MESSAGE_417_DELETE));
        }
    }
}
