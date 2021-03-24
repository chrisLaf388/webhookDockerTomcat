package com.marsMarketing.webhookreceiveSMS.service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.springframework.stereotype.Service;

import com.marsMarketing.webhookreceiveSMS.dto.FieldDto;


/**
 * Field service
 *
 * @version 1.0
 *
 */
@Service
@RolesAllowed("ROLE_ADMIN")
public class FieldService {
	private List<FieldDto> fieldsDto = new ArrayList<>();

	public void addTofieldsDto(final FieldDto fieldDto) {
		this.fieldsDto.add(fieldDto);
	}

	/**
	 * @return the fieldsDto
	 */
	public List<FieldDto> getFieldsDto() {
		return this.fieldsDto;
	}

	/**
	 * @param fieldsDto the fieldsDto to set
	 */
	public void setFieldsDto(final List<FieldDto> fieldsDto) {
		this.fieldsDto = fieldsDto;
	}

	public void writeToCsvFile(final FieldDto fieldDto) {
		try {
			if (!new File("./requetePost/").exists()) {
				// Créer le dossier avec tous ses parents
				new File("./requetePost/").mkdirs();
			}
			// Recevoir le fichier
			File f = new File("./requetePost/example.txt");
			// Créer un nouveau fichier
			// Vérifier s'il n'existe pas
			if (f.createNewFile()) {
				System.out.println("File created");
				FileWriter fichier = new FileWriter("./requetePost/example.txt");
				fichier.write("From");
				fichier.write(";");
				fichier.write("To");
				fichier.write(";");
				fichier.write("Coding");
				fichier.write(";");
				fichier.write("Priority");
				fichier.write(";");
				fichier.write("Content");
				fichier.write("\n");
				fichier.close();
			} else
				System.out.println("File already exists");
		
			FileWriter fichier = new FileWriter("./requetePost/example.txt", true);

			fichier.write(fieldDto.getFrom());
			fichier.write(";");
			fichier.write(fieldDto.getTo());
			fichier.write(";");
			fichier.write(fieldDto.getCoding());
			fichier.write(";");
			fichier.write(fieldDto.getPriority());
			fichier.write(";");
			fichier.write(fieldDto.getContent());
			fichier.write("\n");

			fichier.close();

		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
