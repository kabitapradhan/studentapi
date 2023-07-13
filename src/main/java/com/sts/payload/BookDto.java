package com.sts.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
	
	@NotEmpty
	@NotNull
	private String book_name;
	@NotEmpty
	@NotNull
	private String book_authorname;
}
