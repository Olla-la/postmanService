package telran.java40.postman.Dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostPeriodDto {
	LocalDateTime from;
	LocalDateTime to;
}
