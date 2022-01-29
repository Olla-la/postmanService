package telran.java40.postman.Model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Comment {
	String user;
	String message;
	@Setter
	LocalDateTime dateCreated;
	@Setter
	int likes;
	
	public Comment(String user, String message, LocalDateTime dateCreated, int likes) {
		this.user = user;
		this.message = message;
		this.dateCreated = dateCreated;
		this.likes = likes;
	}
	
	public Comment(String user, String message) {
		this.user = user;
		this.message = message;
		this.dateCreated = LocalDateTime.now();
		this.likes = 0;
	}
	
	public void addLikes() {
		likes++;
	}

	public void reduceLikes() {
		likes--;
		
	}
	public void setDateCreated() {
		this.dateCreated = LocalDateTime.now();			
	}

}
