package telran.java40.postman.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.java40.postman.Model.Post;

public interface PostmanRepository extends MongoRepository<Post, String> {
	Stream <Post> findBy();
	
	@Query("{ 'author' : ?0 }")
	Stream<Post> findByAuthorIgnoreCase(String author);
	
	@Query("{ 'tag' : {'$in': [tags]} }")
	Stream<Post> findByTagsContaining(List<String> tags);
	
	@Query("{'period' : { $gte: ?0, $lte: ?1 } }") 
	Stream<Post> findByPeriod(LocalDateTime from, LocalDateTime to);
	

}
