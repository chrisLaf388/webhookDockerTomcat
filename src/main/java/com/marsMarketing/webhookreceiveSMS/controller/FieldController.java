package com.marsMarketing.webhookreceiveSMS.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marsMarketing.webhookreceiveSMS.dto.FieldDto;
import com.marsMarketing.webhookreceiveSMS.service.FieldService;
import com.marsMarketing.webhookreceiveSMS.transformer.FieldDtoToCsvTransformer;


/**
 * Field controller
 *
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/")
public class FieldController {

    /** Field service */
    @Autowired
    private FieldService fieldService;

    /** FieldDto to CSV */
    @Autowired
    private FieldDtoToCsvTransformer fieldDtoToCsvTransformer;

    /**
     * Get all fields in CSV
     *
     * @return Get all fields in CSV
     */
    @GetMapping(value = "/getAllCSVFields")
    public @ResponseBody String getAllCSVFields() {
        return this.fieldDtoToCsvTransformer.fieldToCsv(this.fieldService.getFieldsDto());
    }

    /**
     * Get all fields
     *
     * @return Get all fields
     */
    @GetMapping(value = "/getAllFieldsList")
    public @ResponseBody List<FieldDto> getAllFieldsList() {
        return this.fieldService.getFieldsDto();
    }

    /**
     * Save the field DTO
     *
     * @param  fieldDto Field to save
     * @return  the field saved
     */
    @PostMapping(value = "/saveField")
    public @ResponseBody FieldDto saveField(@RequestBody final FieldDto fieldDto) {
        this.fieldService.addTofieldsDto(fieldDto);
        this.fieldService.writeToCsvFile(fieldDto);
        return fieldDto;
    }
    
}
