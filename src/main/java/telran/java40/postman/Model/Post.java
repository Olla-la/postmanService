package telran.java40.postman.Model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of="id")

public class Post {
		String id;
		@Setter
		String title;
		@Setter
		String content;
		@Setter
		String author;
		@Setter
		LocalDateTime dateCreated;
		@Setter
		Set<String> tags;
		@Setter
		int likes;
		@Setter
		Set <Comment> comments= new HashSet<Comment>();
		
		public Post(String title, String content, String author, Set<String> tags) {
			this.title = title;
			this.content = content;
			this.author = author;
			this.tags = tags;
			this.dateCreated = LocalDateTime.now();
			this.likes = 0;
			
		}
		
		
		public Post(String id, String title, String content, String author, LocalDateTime dateCreated, Set<String> tags,
				int likes, Set<Comment> comments) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.author = author;
			this.dateCreated = dateCreated;
			this.tags = tags;
			this.likes = likes;
			this.comments = comments;
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
		public void addComment(Comment cm) {
			comments.add(cm);
			
		}


		public Post() {
			this.tags=new HashSet<>();
			this.dateCreated = LocalDateTime.now();
			this.likes = 0;
			this.comments=new HashSet<>();
		}
	}

