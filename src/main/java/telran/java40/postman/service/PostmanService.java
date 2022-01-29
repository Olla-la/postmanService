package telran.java40.postman.service;


import telran.java40.postman.Dto.NewPostDto;
import telran.java40.postman.Dto.PostDto;
import telran.java40.postman.Dto.PostPeriodDto;
import telran.java40.postman.Dto.UpdatePostDto;

public interface PostmanService {
	
	PostDto addPost(String author, NewPostDto newPost);
	PostDto findById(String id);
	void addLike(String id, String like);
	Iterable<PostDto> findByAuthor(String author);
	PostDto addComment(String id, String author, String message);
	PostDto removePost(String id);
	Iterable <PostDto> findByTags(String[] tags);
	Iterable <PostDto> findByPeriod(PostPeriodDto postPeriodDto);
	PostDto updatePost(String id, UpdatePostDto updatePost);	

}
