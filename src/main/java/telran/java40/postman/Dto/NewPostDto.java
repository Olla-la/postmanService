package telran.java40.postman.Dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewPostDto {
	String id;
	String title;
	String content;
	Set<String> tags;
	
	public NewPostDto(String title, String content, Set<String> tags) {
		super();
		this.title = title;
		this.content = content;
		this.tags = tags;
	}

	public NewPostDto(String title, String content) {
		this.title = title;
		this.content = content;
		this.tags = new HashSet<>();
	}
	
	

}
