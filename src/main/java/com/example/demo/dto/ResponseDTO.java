package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    @JsonProperty("is_success")
    private boolean isSuccess;

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("odd_numbers")
    private List<String> oddNumbers;

    @JsonProperty("even_numbers")
    private List<String> evenNumbers;

    private List<String> alphabets;

    @JsonProperty("special_characters")
    private List<String> specialCharacters;

    private String sum;

    @JsonProperty("largest_number")
    private String largestNumber;

    @JsonProperty("smallest_number")
    private String smallestNumber;

    @JsonProperty("alphabet_count")
    private int alphabetCount;

    @JsonProperty("number_count")
    private int numberCount;

    @JsonProperty("special_character_count")
    private int specialCharacterCount;

    @JsonProperty("contains_duplicates")
    private boolean containsDuplicates;

    @JsonProperty("unique_element_count")
    private Integer uniqueElementCount;

    @JsonProperty("processing_time_ms")
    private long processingTimeMs;
}