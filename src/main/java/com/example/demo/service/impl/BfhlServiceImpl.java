package com.example.demo.service.impl;

import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.BfhlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDTO process(RequestDTO request, String requestId) {

        long start = System.currentTimeMillis();

        ResponseDTO response = new ResponseDTO();

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        Set<String> uniqueValues = new LinkedHashSet<>();

        boolean containsDuplicates = false;

        double sum = 0;
        Double largest = null;
        Double smallest = null;

        int alphabetCount = 0;
        int numberCount = 0;
        int specialCharacterCount = 0;

        for (String item : request.getData()) {

            if (item == null || item.trim().isEmpty()) {
                continue;
            }

            if (!uniqueValues.add(item)) {
                containsDuplicates = true;
            }
        }

        for (String item : uniqueValues) {

            item = item.trim();

            // Pure Number
            if (item.matches("-?\\d+(\\.\\d+)?")) {

                double value = Double.parseDouble(item);

                sum += value;
                numberCount++;

                if (largest == null || value > largest) {
                    largest = value;
                }

                if (smallest == null || value < smallest) {
                    smallest = value;
                }

                // Odd / Even only for integers
                if (!item.contains(".")) {

                    long n = Long.parseLong(item);

                    if (n % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                }
            }

            // Pure Alphabets
            else if (item.matches("[A-Za-z]+")) {

                String upper = item.toUpperCase();

                for (char c : upper.toCharArray()) {
                    alphabets.add(String.valueOf(c));
                    alphabetCount++;
                }
            }

            // Alphanumeric
            else if (item.matches(".*[A-Za-z].*\\d.*|.*\\d.*[A-Za-z].*")) {

                String lettersOnly =
                        item.replaceAll("[^A-Za-z]", "")
                                .toUpperCase();

                for (char c : lettersOnly.toCharArray()) {
                    alphabets.add(String.valueOf(c));
                    alphabetCount++;
                }
            }

            // Special Character
            else {

                specialCharacters.add(item);
                specialCharacterCount++;
            }
        }

        response.setSuccess(true);
        response.setRequestId(requestId);

        response.setOddNumbers(oddNumbers);
        response.setEvenNumbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecialCharacters(specialCharacters);

        response.setSum(removeTrailingZero(sum));

        response.setLargestNumber(
                largest == null ? null : removeTrailingZero(largest)
        );

        response.setSmallestNumber(
                smallest == null ? null : removeTrailingZero(smallest)
        );

        response.setAlphabetCount(alphabetCount);
        response.setNumberCount(numberCount);
        response.setSpecialCharacterCount(specialCharacterCount);

        response.setContainsDuplicates(containsDuplicates);

        if (containsDuplicates) {
            response.setUniqueElementCount(uniqueValues.size());
        }

        response.setProcessingTimeMs(
                System.currentTimeMillis() - start
        );

        return response;
    }

    private String removeTrailingZero(double value) {

        if (value == (long) value) {
            return String.valueOf((long) value);
        }

        return String.valueOf(value);
    }
}