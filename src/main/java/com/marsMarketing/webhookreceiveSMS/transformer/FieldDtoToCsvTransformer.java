package com.marsMarketing.webhookreceiveSMS.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.marsMarketing.webhookreceiveSMS.dto.FieldDto;


@Component
public class FieldDtoToCsvTransformer {
    private static String separator = ";";

    public String fieldToCsv(final FieldDto fieldDto) {
        return new StringBuilder()
                .append(fieldDto.getFrom())
                .append(FieldDtoToCsvTransformer.separator)
                .append(fieldDto.getTo())
                .append(FieldDtoToCsvTransformer.separator)
                .append(fieldDto.getCoding())
                .append(FieldDtoToCsvTransformer.separator)
                .append(fieldDto.getPriority())
                .append(FieldDtoToCsvTransformer.separator)
                .append(fieldDto.getContent())
                .toString();
    }

    public String fieldToCsv(final List<FieldDto> fieldsDto) {
        final List<FieldDto> fieldsDtoNotNull = fieldsDto == null ? new ArrayList<>() : fieldsDto;
        return fieldsDtoNotNull.stream()
                .map(this::fieldToCsv)
                .collect(Collectors.joining("\n"));
    }

//    public List<String> fieldToCsvList(final List<FieldDto> fieldsDto) {
//        final List<FieldDto> fieldsDtoNotNull = fieldsDto == null ? new ArrayList<>() : fieldsDto;
//        return fieldsDtoNotNull.stream()
//                .map(this::fieldToCsv)
//                .collect(Collectors.toList());
//    }
}
