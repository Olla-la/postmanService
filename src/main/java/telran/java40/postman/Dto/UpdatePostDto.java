package telran.java40.postman.Dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostDto {
	String title;
	LocalDateTime dateCreated;
	Set<String> tags;
	}
