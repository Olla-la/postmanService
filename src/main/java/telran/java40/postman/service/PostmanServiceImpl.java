package telran.java40.postman.service;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.java40.postman.Dto.NewPostDto;
import telran.java40.postman.Dto.PostDto;
import telran.java40.postman.Dto.PostPeriodDto;
import telran.java40.postman.Dto.UpdatePostDto;
import telran.java40.postman.Model.Comment;
import telran.java40.postman.Model.Post;
import telran.java40.postman.exceptions.PostmanException;
import telran.java40.postman.repository.PostmanRepository;

@Service
public class PostmanServiceImpl implements PostmanService {
	PostmanRepository postmanRepository;
	ModelMapper modelMapper;
	
	@Autowired
	public PostmanServiceImpl(PostmanRepository postmanRepository, ModelMapper modelMapper) {
		this.postmanRepository = postmanRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PostDto addPost(String author, NewPostDto newPost) {
		//if(postmanRepository.existsById(id).orElseThrow(PostmanException::new);
		Post post = new Post(newPost.getTitle(), newPost.getContent(), author, newPost.getTags());
		String temp = post.getId();
		if(postmanRepository.existsById(temp)) {
			return null;
		}
		else {
		postmanRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}}

	@Override
	public PostDto findById(String id) {
		Post pd = postmanRepository.findById(id).orElseThrow(PostmanException::new);
		return modelMapper.map(pd, PostDto.class);
	}

	@Override
	public void addLike(String id, String like) {
		if(like.equals(like))
		{
			postmanRepository.findById(id).orElseThrow(PostmanException::new).addLikes();
		}
		else
			postmanRepository.findById(id).orElseThrow(PostmanException::new).reduceLikes();
	}

	@Override
	public Iterable<PostDto> findByAuthor(String author) {
		return postmanRepository.findByAuthorIgnoreCase(author)
				.map(s->modelMapper.map(s, PostDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public PostDto addComment(String id, String author, String message) {
		Post pd = postmanRepository.findById(id).orElseThrow(PostmanException::new);
		Comment cm = new Comment(author, message);
		pd.addComment(cm);
		postmanRepository.save(pd);
		return modelMapper.map(pd, PostDto.class);
	}

	@Override
	public PostDto removePost(String id) {
		Post pd = postmanRepository.findById(id).orElseThrow(PostmanException::new);
		postmanRepository.deleteById(id);
		return modelMapper.map(pd, PostDto.class);
	}

	@Override
	public Iterable<PostDto> findByTags(String[] tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PostDto> findByPeriod(PostPeriodDto postPeriodDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(String id, UpdatePostDto updatePost) {
		Post pd = postmanRepository.findById(id).orElseThrow(PostmanException::new);
		pd.setTitle(updatePost.getTitle());
		pd.setTags(updatePost.getTags());
		pd.setDateCreated();
		postmanRepository.save(pd);
		return  modelMapper.map(pd, PostDto.class);
	}

}
