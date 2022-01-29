package telran.java40.postman.Dto;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class CommentDto {
	String user;
	String message;
	@Setter
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime dateCreated;
	@Setter
	int likes;
	
	public CommentDto(String user, String message) {
		this.user = user;
		this.message = message;
		this.dateCreated = LocalDateTime.now();
		this.likes = 0;
	}
}
