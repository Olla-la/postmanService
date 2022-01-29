package telran.java40.postman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.java40.postman.Dto.NewPostDto;
import telran.java40.postman.Dto.PostDto;
import telran.java40.postman.Dto.PostPeriodDto;
import telran.java40.postman.Dto.UpdatePostDto;
import telran.java40.postman.service.PostmanService;

@RestController
@RequestMapping("/forum")
public class PostmanController {
	PostmanService postmanService;

	@Autowired
	public PostmanController(PostmanService postmanService) {
		this.postmanService = postmanService;
	}
	
	@PostMapping("/post/{author}")
	public PostDto postRegister(@PathVariable String author, @RequestBody NewPostDto newPost) {
		return postmanService.addPost(author, newPost);
	};
	
	@GetMapping("/post/{id}")
	public PostDto findPost(@PathVariable String id){
		return postmanService.findById(id);
	}

	@PutMapping("/post/{id}/{like}")
	public void addLike(@PathVariable String id, @PathVariable String like) {
		postmanService.addLike(id, like);
	};
		
	@GetMapping("posts/author/{author}")
	public Iterable<PostDto> findByAuthor(@PathVariable String author){
		return postmanService.findByAuthor(author);
	};
	
	@PutMapping("/post/{id}/comment/{author}")
	public PostDto addComment(@PathVariable String id,@PathVariable String author, @RequestBody String message) {
		return postmanService.addComment(id, author, message);
	}
	
	@DeleteMapping("/post/{id}")
	public PostDto removePost(@PathVariable String id){
		return postmanService.removePost(id);
	}

	@PostMapping("/posts/tags")
	public Iterable <PostDto> findByTags(@RequestBody String ... tags){
		return postmanService.findByTags(tags);
	}
	
	@PostMapping("/posts/period")
	public Iterable <PostDto> findByTags(@RequestBody PostPeriodDto period){
		return postmanService.findByPeriod(period);
	}

	@PutMapping("/post/{id}")
	public PostDto updatePost(@PathVariable String id, @RequestBody UpdatePostDto updatePost) {
		return postmanService.updatePost(id, updatePost);
	};
}

